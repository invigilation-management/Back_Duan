package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Registration;
import com.example.mybatisplus.model.dto.BatchDTO;
import com.example.mybatisplus.model.dto.PageDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.BatchService;
import com.example.mybatisplus.model.domain.Batch;


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
@RequestMapping("/api/batch")
public class BatchController {

    private final Logger logger = LoggerFactory.getLogger( BatchController.class );


    @Autowired
    private BatchService batchService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Batch  batch =  batchService.getById(id);
        return JsonResponse.success(batch);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        batchService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateBatch(Batch  batch) throws Exception {
        batchService.updateById(batch);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Batch
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Batch  batch) throws Exception {
        batchService.save(batch);
        return JsonResponse.success(null);
    }


    @RequestMapping(value = "getAppointAndFeesPageALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAppointAndFeesPageALL(Long userId){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Batch> registrationPages=batchService.getAppointAndFeesPageALL(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "getManagementPageALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getManagementPage(Long userId){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Batch> batchPages=batchService.getManagementPageALL(userId,pageDTO);
        return JsonResponse.success(batchPages);
    }

    @RequestMapping(value = "getManagementPageUnclearFindALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getManagementPageUnclearFindALL(String batchName){

        System.out.println(batchName);

        PageDTO pageDTO=new PageDTO();
        Page<Batch> batchPages=batchService.getManagementPageUnclearFindALL(batchName,pageDTO);
        return JsonResponse.success(batchPages);
    }



    @RequestMapping(value = "getConfirmPageALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getConfirmPageALL(Long userId){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Batch> batchPages=batchService.getConfirmPageALL(userId,pageDTO);
        return JsonResponse.success(batchPages);
    }


    @RequestMapping(value = "getConfirmPageUnClearALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getConfirmPageUnClearALL(String batchName){

        System.out.println(batchName);

        PageDTO pageDTO=new PageDTO();
        Page<Batch> batchPages=batchService.getConfirmPageUnClearALL(batchName,pageDTO);
        return JsonResponse.success(batchPages);
    }


    @RequestMapping(value = "getBatchDetailsPageALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getBatchDetailsPageALL(String batchName){

        System.out.println(batchName);

        PageDTO pageDTO=new PageDTO();
        Page<Batch> batchPages=batchService.getBatchDetailsPageALL(batchName,pageDTO);
        return JsonResponse.success(batchPages);
    }


    @RequestMapping(value = "addBatch",method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<Boolean> addBatch(@RequestBody BatchDTO batchDTO) {
        boolean isAdded = batchService.addBatch(batchDTO);
        if (isAdded) {
            return JsonResponse.success(true,"添加成功");
        } else {
            return JsonResponse.success(false, "Batch already exists");
        }
    }




    @RequestMapping(value = "getManageVice",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getManageVice(String batchName){

        System.out.println(batchName);

        PageDTO pageDTO=new PageDTO();
        Page<Batch> batchPages=batchService.getManageVice(batchName,pageDTO);
        return JsonResponse.success(batchPages);
    }





}

