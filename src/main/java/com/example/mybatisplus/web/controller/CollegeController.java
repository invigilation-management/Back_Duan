package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Batch;
import com.example.mybatisplus.model.dto.PageDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.CollegeService;
import com.example.mybatisplus.model.domain.College;


/**
 *
 *  前端控制器
 *
 *
 * @author lxp
 * @since 2024-07-19
 * @version v1.0
 */
@Controller
@RequestMapping("/api/college")
public class CollegeController {

    private final Logger logger = LoggerFactory.getLogger( CollegeController.class );

    @Autowired
    private CollegeService collegeService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        College  college =  collegeService.getById(id);
        return JsonResponse.success(college);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        collegeService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateCollege(College  college) throws Exception {
        collegeService.updateById(college);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建College
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(College  college) throws Exception {
        collegeService.save(college);
        return JsonResponse.success(null);
    }


    @RequestMapping(value = "getRoleAndCollegeALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getRoleAndCollegeALL(Long userId){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<College> registrationPages=collegeService.getRoleAndCollegeALL(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }





}

