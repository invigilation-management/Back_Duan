package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.model.dto.PageDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.RegistrationService;
import com.example.mybatisplus.model.domain.Registration;

import javax.servlet.http.HttpSession;


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
@RequestMapping("/api/registration")
public class RegistrationController {

    private final Logger logger = LoggerFactory.getLogger( RegistrationController.class );

    @Autowired
    private RegistrationService registrationService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Registration  registration =  registrationService.getById(id);
        return JsonResponse.success(registration);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        registrationService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateRegistration(Registration  registration) throws Exception {
        registrationService.updateById(registration);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Registration
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Registration  registration) throws Exception {
        registrationService.save(registration);
        return JsonResponse.success(null);
    }



    @RequestMapping(value = "getWaitingToBeApproval",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getWaitingToBeApproval(Long userId){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationPages=registrationService.getWaitingToBeApproval(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "getWaitingUnclearFindByWorkNum")
    @ResponseBody
    public JsonResponse getWaitingUnclearFindByWorkNum(Long userId,Long worknum){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationFindPages=registrationService.getWaitingUnclearFindByWorkNum(userId,pageDTO,worknum);
        return JsonResponse.success(registrationFindPages);
    }

    @RequestMapping(value = "getWaitingUnclearFindByName")
    @ResponseBody
    public JsonResponse getWaitingUnclearFindByName(Long userId,String name){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationFindPages=registrationService.getWaitingUnclearFindByName(userId,pageDTO,name);
        return JsonResponse.success(registrationFindPages);
    }



    @RequestMapping(value = "getAlreadyAgree",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAlreadyAgree(Long userId){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationPages=registrationService.getAlreadyAgree(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }

    @RequestMapping(value = "getAgreeUnclearFindByWorkNum")
    @ResponseBody
    public JsonResponse getAgreeUnclearFindByWorkNum(Long userId,Long worknum){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationFindPages=registrationService.getAgreeUnclearFindByWorkNum(userId,pageDTO,worknum);
        return JsonResponse.success(registrationFindPages);
    }



    @RequestMapping(value = "getAgreeUnclearFindByName")
    @ResponseBody
    public JsonResponse getAgreeUnclearFindByName(Long userId,String name){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationFindPages=registrationService.getAgreeUnclearFindByName(userId,pageDTO,name);
        return JsonResponse.success(registrationFindPages);
    }



    @RequestMapping(value = "getAlreadyDisagree",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAlreadyDisagree(Long userId){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationPages=registrationService.getAlreadyDisagree(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "getDisagreeUnclearFindByWorkNum")
    @ResponseBody
    public JsonResponse getDisagreeUnclearFindByWorkNum(Long userId,Long worknum){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationFindPages=registrationService.getDisagreeUnclearFindByWorkNum(userId,pageDTO,worknum);
        return JsonResponse.success(registrationFindPages);
    }

    @RequestMapping(value = "getDisagreeUnclearFindByName")
    @ResponseBody
    public JsonResponse getDisagreeUnclearFindByName(Long userId,String name){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationFindPages=registrationService.getDisagreeUnclearFindByName(userId,pageDTO,name);
        return JsonResponse.success(registrationFindPages);
    }



    @RequestMapping(value = "getWaitingToBeApprovalALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getWaitingToBeApprovalALL(Long userId){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationPages=registrationService.getWaitingToBeApprovalALL(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "getAlreadyAgreeALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAlreadyAgreeALL(Long userId){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        Page<Registration> registrationPages=registrationService.getAlreadyAgreeALL(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }




}

