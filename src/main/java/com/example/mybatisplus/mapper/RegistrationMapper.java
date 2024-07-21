package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Registration;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}
