package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Batch;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.domain.Registration;
import com.example.mybatisplus.model.dto.PageDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2024-07-19
 */
public interface BatchService extends IService<Batch> {
    Page<Batch> getAppointAndFeesPageALL(Long userId, PageDTO pageDTO);

    Page<Batch> getManagementPageALL(Long userId, PageDTO pageDTO);

}
