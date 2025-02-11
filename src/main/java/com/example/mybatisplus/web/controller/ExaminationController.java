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
import com.example.mybatisplus.service.ExaminationService;
import com.example.mybatisplus.model.domain.Examination;


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
@RequestMapping("/api/examination")
public class ExaminationController {

    private final Logger logger = LoggerFactory.getLogger( ExaminationController.class );

    @Autowired
    private ExaminationService examinationService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Examination  examination =  examinationService.getById(id);
        return JsonResponse.success(examination);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        examinationService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateExamination(Examination  examination) throws Exception {
        examinationService.updateById(examination);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Examination
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Examination  examination) throws Exception {
        examinationService.save(examination);
        return JsonResponse.success(null);
    }


    @RequestMapping(value = "teacherSeeBatch",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse teacherSeeBatch(String batchName,Integer pageSize,Integer pageNo){

        System.out.println(batchName);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Examination> batchPages=examinationService.teacherSeeBatch(batchName,pageDTO);
        return JsonResponse.success(batchPages);
    }
}

