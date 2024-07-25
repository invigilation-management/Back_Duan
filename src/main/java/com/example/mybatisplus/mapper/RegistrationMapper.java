package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Registration;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2024-07-17
 */
public interface RegistrationMapper extends BaseMapper<Registration> {

    Page<Registration> selectWaitingPage(Page<Registration> registrationPage, Long userId);

    Page<Registration> getWaitingUnclearFindByWorkNum(Page<Registration> registrationFindPage, Long userId,Long worknum);

    Page<Registration> getWaitingUnclearFindByName(Page<Registration> registrationFindPage, Long userId, String name);

    Page<Registration> selectAgreePage(Page<Registration> registrationPage, Long userId);

    Page<Registration> selectDissgreePage(Page<Registration> registrationPage, Long userId);

    Page<Registration> getAgreeUnclearFindByWorkNum(Page<Registration> registrationFindPage, Long userId, Long worknum);

    Page<Registration> getAgreeUnclearFindByName(Page<Registration> registrationFindPage, Long userId, String name);

    Page<Registration> getDisagreeUnclearFindByWorkNum(Page<Registration> registrationFindPage, Long userId, Long worknum);

    Page<Registration> getDisagreeUnclearFindByName(Page<Registration> registrationFindPage, Long userId, String name);

    Page<Registration> selectWaitingPageALL(Page<Registration> registrationPage, Long userId);

    Page<Registration> selectAgreePageALL(Page<Registration> registrationPage, Long userId);

    Page<Registration> selectDisagreePageALL(Page<Registration> registrationPage, Long userId);


    Page<Registration> getWaitingUnclearALLByString(Page<Registration> registrationFindPage, Long userId, String trueFacultyName);

    Page<Registration> getWaitingUnclearALLWorknum(Page<Registration> registrationFindPage, Long userId, Long trueFacultyId);

    Boolean afterApprovalUpdate(Long userId, Long trueFacultyId, String batchName, String targetCampus, String classroom);

    Boolean afterApprovalAdd(Long userId, Long trueFacultyId, String batchName);

    Boolean afterDisapprovalUpdate(Long userId, Long trueFacultyId, String batchName);

    Boolean afterDisapprovalAdd(Long userId, Long trueFacultyId, String batchName);

    Page<Registration> getAgreeUnclearALLByString(Page<Registration> registrationFindPage, Long userId, String trueFacultyName);

    Page<Registration> getDisagreeUnclearALLByString(Page<Registration> registrationFindPage, Long userId, String trueFacultyName);

    Page<Registration> teachersSeeTheirRegistrations(Page<Registration> registrationFindPage, Long userId);


    int countByTrueFacultyId(Integer trueFacultyId, Integer batchBatchId);

    void insertRegistration(Registration registration);
//    void insertRegistration(Registration registration);

    Boolean afterApprovalOfficeUpdate(Long userId, Long trueFacultyId, String batchName, String targetCampus);

    Boolean afterApprovalOfficeAdd(Long userId, Long trueFacultyId, String batchName, String targetCampus);

    Boolean afterDisapprovalOfficeUpdate(Long userId, Long trueFacultyId, String batchName);

    Boolean afterDisapprovalOfficeAdd(Long userId, Long trueFacultyId, String batchName);

    Page<Registration> seeDetailsOfOffice(Page<Registration> registrationFindPage, Long userId, Long trueFacultyId, String batchName);

    Integer selectCountByBatchNameAndTargetCampus(String batchName, String targetCampus);

    Page<Registration> JianKaoXiangXiMingDan(Page<Registration> registrationFindPage, Long userId, String batchName);

    Page<Registration> ManageVice(Page<Registration> registrationFindPage, String batchName);

    Page<Registration> planVice(Page<Registration> registrationFindPage, String batchName);

    Page<Registration> infoConfirmVice(Page<Registration> registrationFindPage, String batchName);

    Page<Registration> feesVice(Page<Registration> registrationFindPage, String batchName);

    Page<Registration> teachersSeeTheirRegistrationsFind(Page<Registration> registrationFindPage, Long userId, String batchName);

    Page<Registration> ManageViceSearch(Page<Registration> registrationFindPage, String facultyName, String batchName);

    Page<Registration> PlanViceSearch(Page<Registration> registrationFindPage, String facultyName, String batchName);

    Page<Registration> NotationViceSearch(Page<Registration> registrationFindPage, String facultyName, String batchName);

    Page<Registration> FeesViceSearch(Page<Registration> registrationFindPage, String facultyName, String batchName);

    Page<Registration> nothing(Page<Registration> registrationFindPage, Integer userId);

    Boolean print(Long userId, String batchName);

    Page<Registration> findUnclearBatchDetails(Page<Registration> registrationPage, Integer userId, String batchName, String trueFacultyName);
}
