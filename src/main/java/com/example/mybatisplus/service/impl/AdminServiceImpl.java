package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.mapper.AdminMapper;
import com.example.mybatisplus.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2021-06-17
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminmapper;

    @Override
    public Admin login(Admin admin){
        LambdaQueryWrapper<Admin> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getLoginName,admin.getLoginName()).eq(Admin::getPassword,admin.getPassword());
        Admin one=adminmapper.selectOne(wrapper);
        return one;
    }

}
