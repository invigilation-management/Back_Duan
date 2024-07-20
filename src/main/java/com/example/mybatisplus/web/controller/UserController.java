package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.model.domain.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.Jar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.UserService;
import com.example.mybatisplus.model.domain.User;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2024-07-17
 * @version v1.0
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger( UserController.class );

    @Autowired
    private UserService userService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        User  user =  userService.getById(id);
        return JsonResponse.success(user);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        userService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateUser(User  user) throws Exception {
        userService.updateById(user);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建User
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(@RequestBody User  user) throws Exception {
        userService.save(user);
        return JsonResponse.success(null);
    }


    // 获取当前登录用户信息的接口
    @RequestMapping(value = "me", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getCurrentUserInfo() {
        // 从Session中获取当前登录用户信息
        User currentUser = SessionUtils.getCurrentUserInfo();
        // 返回当前用户信息，包括userId等其他信息
        return JsonResponse.success(currentUser);
    }




    @GetMapping("login")
    @ResponseBody
    public JsonResponse login(HttpSession session, @Param("userId")Long userId, @Param("password")String password){
        //login有值表示数据库有这个人，没值表示没这个人
        User user = new User().setUserId(userId).setPassword(password);
        User login=userService.login(user);
        SessionUtils.saveCurrentUserInfo(login);
        return JsonResponse.success(login);
    }

    @GetMapping("logout")
    @ResponseBody
    public JsonResponse logout(){
        SessionUtils.clearCurUser();
        return JsonResponse.success(true);
    }



    @RequestMapping(value = "/getAllGirl", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAllGirl(){
        List<User> users = userService.girlList();
        return JsonResponse.success(users);
    }

    @RequestMapping(value = "/getPage", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getPage(@Param("pageNo")Long pageNo){
        Page<User> userPage = userService.getPage(pageNo);
        return JsonResponse.success(userPage);
    }

}

