package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.model.domain.Faculty;
import com.example.mybatisplus.model.domain.Registration;
import com.example.mybatisplus.mapper.RegistrationMapper;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.service.RegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
    public Page<Registration> getManagementPageALL(Long userId, PageDTO pageDTO) {
        // 创建分页对象
        Page<Registration> registrationPage = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());

        return registrationMapper.selectManagePageALL(registrationPage, userId);
    }


}
