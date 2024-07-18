package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lxp
 * @since 2024-07-17
 */
public interface UserMapper extends BaseMapper<User> {


    void selectBaby(int i);

    User selectLogin(Long userId, String password);
}
