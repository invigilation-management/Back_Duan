package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.domain.Registration;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.model.dto.FacultyUpdateDTO;
import com.example.mybatisplus.model.dto.PageDTO;
import com.example.mybatisplus.service.RegistrationService;
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

    @Autowired
    private RegistrationService registrationService;

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




    @RequestMapping(value = "updateFaculty", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateFaculty(@RequestBody FacultyUpdateDTO facultyUpdateDTO) {
        facultyService.updateFaculty(facultyUpdateDTO);
        return JsonResponse.success(true);
    }

    @RequestMapping(value = "seeAllRoleOfTheCollege", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse seeAllRoleOfTheCollege(Long collegeId,Integer pageSize,Integer pageNo){

        System.out.println(collegeId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Faculty> registrationPages=facultyService.seeAllRoleOfTheCollege(collegeId,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "getInfomationConfirmVice", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getInfomationConfirmVice(String batchName,Integer pageSize,Integer pageNo){

        System.out.println(batchName);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Faculty> registrationPages=facultyService.getInfomationConfirmVice(batchName,pageDTO);
        return JsonResponse.success(registrationPages);
    }

    @RequestMapping(value = "seeDetailsOfOffice", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse seeDetailsOfOffice(Long userId,Long trueFacultyId,String batchName){

        System.out.println(trueFacultyId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationPages=facultyService.seeDetailsOfOffice(userId,trueFacultyId,pageDTO,batchName);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "findBeforePost", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse findBeforePost(String trueFacultyName){

        System.out.println(trueFacultyName);

        PageDTO pageDTO=new PageDTO();
        Page<Faculty> registrationPages=facultyService.findBeforePost(pageDTO,trueFacultyName);
        return JsonResponse.success(registrationPages);
    }

}

