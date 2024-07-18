package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.mapper.AdminMapper;
import com.example.mybatisplus.model.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.AdminService;
import com.example.mybatisplus.model.domain.Admin;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/api/admin")
public class AdminController {

    private AdminMapper adminMapper;
    private AdminService adminService;

    //在springboot的默认情况之下,controller里的所有方法都会返回一个视图
    //现在是在做前后端分离开发,前端页面不在这,只需要返回数据,不需要返回页面
    //如果要返回数据,加注解


    //给方法加映射路径
    @RequestMapping("xxx")
    @ResponseBody//这个注解表示这个方法不再返回页面,而是返回数据
    public Admin hh(){
        //写一个id查询用户
        Admin admin=adminMapper.selectById(88);
        return admin;
    }


    //发请求的同时要发参数,三种:
    //1.get典型传参     url?x=y&a=b
    // 直接用参数列表接, 前段怎么传,后端怎么接,要求方法内的参数名与键名一致
    //2.get典型传参     url?x=y&a=b
    //对象接,要求方法的属性名和前端传的键名一致
    @GetMapping("GetById1")
    @ResponseBody
    public Admin qq(Long id){
        return adminMapper.selectById(id);
    }



    @GetMapping("GetById2")
    @ResponseBody
    public Admin qq1(Admin admin){
        return adminMapper.selectById(admin.getId());
    }




    //统一返回一个:必须返回一个统一的Json数据{x:y,a:b}
    @GetMapping("GetById3")
    @ResponseBody
    public Map getById(Admin admin, Student s){
        Map<String,Object> map=new HashMap<>();
        Admin admin1=adminMapper.selectById(admin.getId());
        map.put("value",admin1);
        return map;
    }


    //直接返回Json
    @GetMapping("GetById4")
    @ResponseBody
    public JsonResponse getByIdJson(Admin admin, Student s){
        Admin admin1=adminMapper.selectById(admin.getId());
        return JsonResponse.success(admin1);
//        Map<String,Object> map=new HashMap<>();
//        map.put("value",admin1);
//        return map;
    }


    @GetMapping("Login")
    @ResponseBody
    public JsonResponse login(Admin admin){
        //login有值表示数据库有这个人，没值表示没这个人
        Admin login=adminService.login(admin);
        return JsonResponse.success(login);
    }







}

