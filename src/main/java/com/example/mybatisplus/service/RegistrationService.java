package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Registration;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.dto.PageDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2024-07-17
 */
public interface RegistrationService extends IService<Registration> {

    Page<Registration> getWaitingToBeApproval(Long UserId, PageDTO pageDTO);

    Page<Registration> getWaitingUnclearFindByWorkNum(Long userId, PageDTO pageDTO,Long worknum);

    Page<Registration> getWaitingUnclearFindByName(Long userId, PageDTO pageDTO, String name);

    Page<Registration> getAlreadyAgree(Long userId, PageDTO pageDTO);

    Page<Registration> getAlreadyDisagree(Long userId, PageDTO pageDTO);

    Page<Registration> getAgreeUnclearFindByWorkNum(Long userId, PageDTO pageDTO, Long worknum);

    Page<Registration> getAgreeUnclearFindByName(Long userId, PageDTO pageDTO, String name);

    Page<Registration> getDisagreeUnclearFindByWorkNum(Long userId, PageDTO pageDTO, Long worknum);

    Page<Registration> getDisagreeUnclearFindByName(Long userId, PageDTO pageDTO, String name);

    Page<Registration> getWaitingToBeApprovalALL(Long userId, PageDTO pageDTO);

    Page<Registration> getAlreadyAgreeALL(Long userId, PageDTO pageDTO);

    Page<Registration> getAlreadyDisagreeALL(Long userId, PageDTO pageDTO);


    Page<Registration> getWaitingUnclearALLByString(Long userId, String trueFacultyName, PageDTO pageDTO);

    Page<Registration> getWaitingUnclearALLWorknum(Long userId, Long trueFacultyId, PageDTO pageDTO);

    Boolean afterApproval(Long userId, Long trueFacultyId, String batchName, String targetCampus);

    Boolean afterDisapproval(Long userId, Long trueFacultyId, String batchName);

    Page<Registration> getAgreeUnclearALLByString(Long userId, String trueFacultyName, PageDTO pageDTO);

    Page<Registration> getDisagreeUnclearALLByString(Long userId, String trueFacultyName, PageDTO pageDTO);

    Page<Registration> teachersSeeTheirRegistrations(Long userId, PageDTO pageDTO);
}
