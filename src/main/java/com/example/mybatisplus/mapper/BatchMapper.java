package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Batch;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.domain.Registration;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2024-07-19
 */
public interface BatchMapper extends BaseMapper<Batch> {

    Page<Batch> selectAppointAndFeesPageALL(Page<Batch> registrationPage, Long userId);

}
