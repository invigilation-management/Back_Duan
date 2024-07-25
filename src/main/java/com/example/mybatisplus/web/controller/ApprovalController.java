package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Faculty;
import com.example.mybatisplus.model.dto.PageDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ApprovalService;
import com.example.mybatisplus.model.domain.Approval;


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
@RequestMapping("/api/approval")
public class ApprovalController {

    private final Logger logger = LoggerFactory.getLogger( ApprovalController.class );

    @Autowired
    private ApprovalService approvalService;



    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Approval  approval =  approvalService.getById(id);
        return JsonResponse.success(approval);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        approvalService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateApproval(Approval  approval) throws Exception {
        approvalService.updateById(approval);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Approval
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Approval  approval) throws Exception {
        approvalService.save(approval);
        return JsonResponse.success(null);
    }


    @RequestMapping(value = "historyCard", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse historyCard(String trueFacultyName,String batchName){

        System.out.println(trueFacultyName);

        PageDTO pageDTO=new PageDTO();
        Page<Approval> registrationPages=approvalService.historyCard(pageDTO,trueFacultyName,batchName);
        return JsonResponse.success(registrationPages);
    }
}

