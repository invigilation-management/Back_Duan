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
}
