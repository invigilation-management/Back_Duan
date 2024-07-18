package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatisplus.mapper.AdminMapper;
import com.example.mybatisplus.model.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2021-06-17
 */
public interface AdminService extends IService<Admin> {

    Admin login(Admin admin);
}
