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

        // 执行查询
//        registrationMapper.selectWaitingPage(registrationPage, userId);

        return registrationMapper.selectWaitingPage(registrationPage, userId);
    }
}
