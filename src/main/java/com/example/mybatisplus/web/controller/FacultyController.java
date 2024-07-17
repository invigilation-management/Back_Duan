package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.FacultyService;
import com.example.mybatisplus.model.domain.Faculty;


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
@RequestMapping("/api/faculty")
public class FacultyController {

    private final Logger logger = LoggerFactory.getLogger( FacultyController.class );

    @Autowired
    private FacultyService facultyService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Faculty  faculty =  facultyService.getById(id);
        return JsonResponse.success(faculty);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        facultyService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateFaculty(Faculty  faculty) throws Exception {
        facultyService.updateById(faculty);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Faculty
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Faculty  faculty) throws Exception {
        facultyService.save(faculty);
        return JsonResponse.success(null);
    }
}

