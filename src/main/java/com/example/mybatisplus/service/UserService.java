package com.example.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxp
 * @since 2024-07-17
 */
public interface UserService extends IService<User> {


    User login(User user);

    List<User> girlList();

    Page<User> getPage(Long page);
}
