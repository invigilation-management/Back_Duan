package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.BatchMapper;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.model.domain.Registration;
import com.example.mybatisplus.mapper.RegistrationMapper;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.service.RegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2024-07-17
 */
@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements RegistrationService {

    @Autowired
    private RegistrationMapper registrationMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BatchMapper batchMapper;

    @Override
    public Page<Registration> getWaitingToBeApproval(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return registrationMapper.selectWaitingPage(registrationPage, userId);
    }

    @Override
    public Page<Registration> getWaitingUnclearFindByWorkNum(Long userId, PageDTO pageDTO,Long worknum) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.getWaitingUnclearFindByWorkNum(registrationFindPage, userId,worknum);
    }

    @Override
    public Page<Registration> getWaitingUnclearFindByName(Long userId, PageDTO pageDTO, String name) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.getWaitingUnclearFindByName(registrationFindPage, userId,name);
    }

    @Override
    public Page<Registration> getAlreadyAgree(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return registrationMapper.selectAgreePage(registrationPage, userId);
    }

    @Override
    public Page<Registration> getAlreadyDisagree(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return registrationMapper.selectDissgreePage(registrationPage, userId);
    }

    @Override
    public Page<Registration> getAgreeUnclearFindByWorkNum(Long userId, PageDTO pageDTO, Long worknum) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.getAgreeUnclearFindByWorkNum(registrationFindPage, userId,worknum);
    }

    @Override
    public Page<Registration> getAgreeUnclearFindByName(Long userId, PageDTO pageDTO, String name) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.getAgreeUnclearFindByName(registrationFindPage, userId,name);
    }

    @Override
    public Page<Registration> getDisagreeUnclearFindByWorkNum(Long userId, PageDTO pageDTO, Long worknum) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.getDisagreeUnclearFindByWorkNum(registrationFindPage, userId,worknum);
    }

    @Override
    public Page<Registration> getDisagreeUnclearFindByName(Long userId, PageDTO pageDTO, String name) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.getDisagreeUnclearFindByName(registrationFindPage, userId,name);
    }

    @Override
    public Page<Registration> getWaitingToBeApprovalALL(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return registrationMapper.selectWaitingPageALL(registrationPage, userId);
    }

    @Override
    public Page<Registration> getAlreadyAgreeALL(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return registrationMapper.selectAgreePageALL(registrationPage, userId);
    }

    @Override
    public Page<Registration> getAlreadyDisagreeALL(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return registrationMapper.selectDisagreePageALL(registrationPage, userId);
    }

    @Override
    public Page<Registration> getWaitingUnclearALLByString(Long userId, String trueFacultyName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.getWaitingUnclearALLByString(registrationFindPage, userId,trueFacultyName);
    }

    @Override
    public Page<Registration> getWaitingUnclearALLWorknum(Long userId, Long trueFacultyId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.getWaitingUnclearALLWorknum(registrationFindPage, userId,trueFacultyId);
    }

    @Override
    public Boolean afterApproval(Long userId, Long trueFacultyId, String batchName, String targetCampus) {
        Integer count=registrationMapper.selectCountByBatchNameAndTargetCampus(batchName, targetCampus);
        Integer totalNumInTargetCampus = batchMapper.searchTotalNumByBatchNameAndTargetCampus(batchName, targetCampus);
        if (count < totalNumInTargetCampus){
            String classroom = batchMapper.searchAvailableClassroom(batchName, targetCampus);
            Boolean update=registrationMapper.afterApprovalUpdate( userId,  trueFacultyId,  batchName,  targetCampus, classroom);
            Boolean add=registrationMapper.afterApprovalAdd( userId,  trueFacultyId,  batchName);
            return (update && add);
        } else {
            if (targetCampus.equals("兴庆校区")){
                String classroom = batchMapper.searchAvailableClassroom(batchName, "创新港");
                Boolean update=registrationMapper.afterApprovalUpdate( userId,  trueFacultyId,  batchName,  "创新港", classroom);
                Boolean add=registrationMapper.afterApprovalAdd( userId,  trueFacultyId,  batchName);
                return (update && add);
            }else{
                String classroom = batchMapper.searchAvailableClassroom(batchName, "兴庆校区");
                Boolean update=registrationMapper.afterApprovalUpdate( userId,  trueFacultyId,  batchName,  "兴庆校区", classroom);
                Boolean add=registrationMapper.afterApprovalAdd( userId,  trueFacultyId,  batchName);
                return (update && add);
            }
        }
    }

    @Override
    public Boolean afterDisapproval(Long userId, Long trueFacultyId, String batchName) {
        Boolean update=registrationMapper.afterDisapprovalUpdate( userId,  trueFacultyId,  batchName);
        Boolean add=registrationMapper.afterDisapprovalAdd( userId,  trueFacultyId,  batchName);
        return (update && add);
    }

    @Override
    public Page<Registration> getAgreeUnclearALLByString(Long userId, String trueFacultyName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.getAgreeUnclearALLByString(registrationFindPage, userId,trueFacultyName);
    }

    @Override
    public Page<Registration> getDisagreeUnclearALLByString(Long userId, String trueFacultyName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.getDisagreeUnclearALLByString(registrationFindPage, userId,trueFacultyName);
    }

    @Override
    public Page<Registration> teachersSeeTheirRegistrations(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.teachersSeeTheirRegistrations(registrationFindPage, userId);
    }

    @Transactional
    public boolean registerNew(Registration registration) {
        int count = registrationMapper.countByTrueFacultyId(registration.getTrueFacultyId(), registration.getBatchBatchId());
        if (count > 0) {
            return false;  // 已经报名过
        }
        System.out.println(registration);
        registrationMapper.insertRegistration(registration);
        return true;
    }

    @Override
    public Boolean afterApprovalOffice(Long userId, Long trueFacultyId, String batchName, String targetCampus) {
        Boolean update=registrationMapper.afterApprovalOfficeUpdate( userId,  trueFacultyId,  batchName,  targetCampus);
        Boolean add=registrationMapper.afterApprovalOfficeAdd( userId,  trueFacultyId,  batchName,  targetCampus);
        return (update && add);
    }

    @Override
    public Boolean afterDisapprovalOffice(Long userId, Long trueFacultyId, String batchName) {
        Boolean update=registrationMapper.afterDisapprovalOfficeUpdate( userId,  trueFacultyId,  batchName);
        Boolean add=registrationMapper.afterDisapprovalOfficeAdd( userId,  trueFacultyId,  batchName);
        return (update && add);
    }

    @Override
    public Page<Registration> JianKaoXiangXiMingDan(Long userId, String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.JianKaoXiangXiMingDan(registrationFindPage, userId,batchName);
    }

    @Override
    public Page<Registration> ManageVice(String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.ManageVice(registrationFindPage,batchName);
    }

    @Override
    public Page<Registration> planVice(String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.planVice(registrationFindPage,batchName);
    }

    @Override
    public Page<Registration> infoConfirmVice(String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.infoConfirmVice(registrationFindPage,batchName);
    }

    @Override
    public Page<Registration> feesVice(String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.feesVice(registrationFindPage,batchName);
    }

    @Override
    public Page<Registration> teachersSeeTheirRegistrationsFind(Long userId, String batchName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.teachersSeeTheirRegistrationsFind(registrationFindPage,userId,batchName);
    }

    @Override
    public Page<Registration> ManageViceSearch(String batchName, String facultyName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.ManageViceSearch(registrationFindPage,facultyName,batchName);
    }

    @Override
    public Page<Registration> PlanViceSearch(String batchName, String facultyName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.PlanViceSearch(registrationFindPage,facultyName,batchName);
    }

    @Override
    public Page<Registration> NotationViceSearch(String batchName, String facultyName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.NotationViceSearch(registrationFindPage,facultyName,batchName);
    }

    @Override
    public Page<Registration> FeesViceSearch(String batchName, String facultyName, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationFindPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return registrationMapper.FeesViceSearch(registrationFindPage,facultyName,batchName);
    }

}
