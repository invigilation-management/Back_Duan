package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Admin;
import com.example.mybatisplus.model.domain.Faculty;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxp
 * @since 2024-07-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user){
//        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<>();
//        wrapper.eq(User::getUserId,user.getUserId()).eq(User::getPassword,user.getPassword());
//        User one=userMapper.selectOne(wrapper);
        User one2 = userMapper.selectLogin(user.getUserId(), user.getPassword());
        return one2;
    }

    @Override
    public List<User> girlList() {
        Wrapper<User> wrapper = new QueryWrapper<User>().gt("user_id", 1010L);
        List<User> users = userMapper.selectList(wrapper);
        return users;
    }

    @Override
    public Page<User> getPage(Long pageNo) {
        //定义分页参数,实际应该有前端传入
        Integer pageSize=10;

        //定义分页器,设置分页参数
        Page<User> page=new Page<>();
        page.setCurrent(pageNo).setSize(pageSize);
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        Page<User> page1=userMapper.selectPage(page, wrapper);
        return page1;
    }

}
