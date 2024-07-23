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
    public JsonResponse getWaitingToBeApproval(Long userId,Integer pageSize,Integer pageNo){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.getWaitingToBeApproval(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "getWaitingUnclearFindByWorkNum")
    @ResponseBody
    public JsonResponse getWaitingUnclearFindByWorkNum(Long userId,Long worknum,Integer pageSize,Integer pageNo){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationFindPages=registrationService.getWaitingUnclearFindByWorkNum(userId,pageDTO,worknum);
        return JsonResponse.success(registrationFindPages);
    }

    @RequestMapping(value = "getWaitingUnclearFindByName")
    @ResponseBody
    public JsonResponse getWaitingUnclearFindByName(Long userId,String name,Integer pageSize,Integer pageNo){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationFindPages=registrationService.getWaitingUnclearFindByName(userId,pageDTO,name);
        return JsonResponse.success(registrationFindPages);
    }



    @RequestMapping(value = "getAlreadyAgree",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAlreadyAgree(Long userId,Integer pageSize,Integer pageNo){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.getAlreadyAgree(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }

    @RequestMapping(value = "getAgreeUnclearFindByWorkNum")
    @ResponseBody
    public JsonResponse getAgreeUnclearFindByWorkNum(Long userId,Long worknum,Integer pageSize,Integer pageNo){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationFindPages=registrationService.getAgreeUnclearFindByWorkNum(userId,pageDTO,worknum);
        return JsonResponse.success(registrationFindPages);
    }



    @RequestMapping(value = "getAgreeUnclearFindByName")
    @ResponseBody
    public JsonResponse getAgreeUnclearFindByName(Long userId,String name,Integer pageSize,Integer pageNo){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationFindPages=registrationService.getAgreeUnclearFindByName(userId,pageDTO,name);
        return JsonResponse.success(registrationFindPages);
    }



    @RequestMapping(value = "getAlreadyDisagree",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAlreadyDisagree(Long userId,Integer pageSize,Integer pageNo){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.getAlreadyDisagree(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "getDisagreeUnclearFindByWorkNum")
    @ResponseBody
    public JsonResponse getDisagreeUnclearFindByWorkNum(Long userId,Long worknum,Integer pageSize,Integer pageNo){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationFindPages=registrationService.getDisagreeUnclearFindByWorkNum(userId,pageDTO,worknum);
        return JsonResponse.success(registrationFindPages);
    }

    @RequestMapping(value = "getDisagreeUnclearFindByName")
    @ResponseBody
    public JsonResponse getDisagreeUnclearFindByName(Long userId,String name,Integer pageSize,Integer pageNo){
        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationFindPages=registrationService.getDisagreeUnclearFindByName(userId,pageDTO,name);
        return JsonResponse.success(registrationFindPages);
    }



    @RequestMapping(value = "getWaitingToBeApprovalALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getWaitingToBeApprovalALL(Long userId,Integer pageSize,Integer pageNo){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.getWaitingToBeApprovalALL(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "getAlreadyAgreeALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAlreadyAgreeALL(Long userId,Integer pageSize,Integer pageNo){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.getAlreadyAgreeALL(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "getAlreadyDisagreeALL",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAlreadyDisagreeALL(Long userId,Integer pageSize,Integer pageNo){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.getAlreadyDisagreeALL(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }



    @RequestMapping(value = "getWaitingUnclearALLByString",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getWaitingUnclearALLByString(Long userId,String trueFacultyName,Integer pageSize,Integer pageNo){

        System.out.println(trueFacultyName);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.getWaitingUnclearALLByString(userId,trueFacultyName,pageDTO);
        return JsonResponse.success(registrationPages);
    }



    @RequestMapping(value = "getWaitingUnclearALLWorknum",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getWaitingUnclearALLWorknum(Long userId,Long trueFacultyId,Integer pageSize,Integer pageNo){

        System.out.println(trueFacultyId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.getWaitingUnclearALLWorknum(userId,trueFacultyId,pageDTO);
        return JsonResponse.success(registrationPages);
    }



    @RequestMapping(value = "afterApproval",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse afterApproval(Long userId,Long trueFacultyId,String batchName,String targetCampus){

        System.out.println(trueFacultyId);

        Boolean Success=registrationService.afterApproval(userId,trueFacultyId,batchName,targetCampus);
        return JsonResponse.success(Success);
    }


    @RequestMapping(value = "afterDisapproval",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse afterDisapproval(Long userId,Long trueFacultyId,String batchName){

        System.out.println(trueFacultyId);

        Boolean Success=registrationService.afterDisapproval(userId,trueFacultyId,batchName);
        return JsonResponse.success(Success);
    }




    @RequestMapping(value = "getAgreeUnclearALLByString",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAgreeUnclearALLByString(Long userId,String trueFacultyName,Integer pageSize,Integer pageNo){

        System.out.println(trueFacultyName);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.getAgreeUnclearALLByString(userId,trueFacultyName,pageDTO);
        return JsonResponse.success(registrationPages);
    }

    @RequestMapping(value = "getDisagreeUnclearALLByString",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getDisagreeUnclearALLByString(Long userId,String trueFacultyName,Integer pageSize,Integer pageNo){

        System.out.println(trueFacultyName);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.getDisagreeUnclearALLByString(userId,trueFacultyName,pageDTO);
        return JsonResponse.success(registrationPages);
    }

    @RequestMapping(value = "teachersSeeTheirRegistrations",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse teachersSeeTheirRegistrations(Long userId,Integer pageSize,Integer pageNo){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.teachersSeeTheirRegistrations(userId,pageDTO);
        return JsonResponse.success(registrationPages);
    }



    @RequestMapping(value = "newRegister",method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse<Boolean> register(@RequestBody Registration registration) {
        boolean success = registrationService.registerNew(registration);
        if (!success) {
            return JsonResponse.failure("已经报名过");
        }
        return JsonResponse.success(true);
    }


    @RequestMapping(value = "afterApprovalOffice",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse afterApprovalOffice(Long userId,Long trueFacultyId,String batchName,String targetCampus){

        System.out.println(trueFacultyId);

        Boolean Success=registrationService.afterApprovalOffice(userId,trueFacultyId,batchName,targetCampus);
        return JsonResponse.success(Success);
    }


    @RequestMapping(value = "afterDisapprovalOffice",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse afterApprovalOffice(Long userId,Long trueFacultyId,String batchName){

        System.out.println(trueFacultyId);

        Boolean Success=registrationService.afterDisapprovalOffice(userId,trueFacultyId,batchName);
        return JsonResponse.success(Success);
    }


    @RequestMapping(value = "JianKaoXiangXiMingDan",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse JianKaoXiangXiMingDan(Long userId,String batchName,Integer pageSize,Integer pageNo){

        System.out.println(userId);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.JianKaoXiangXiMingDan(userId,batchName,pageDTO);
        return JsonResponse.success(registrationPages);
    }




    @RequestMapping(value = "ManageVice",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse ManageVice(String batchName,Integer pageSize,Integer pageNo){

        System.out.println(batchName);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.ManageVice(batchName,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "planVice",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse planVice(String batchName,Integer pageSize,Integer pageNo){

        System.out.println(batchName);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.planVice(batchName,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "infoConfirmVice",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse infoConfirmVice(String batchName,Integer pageSize,Integer pageNo){

        System.out.println(batchName);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.infoConfirmVice(batchName,pageDTO);
        return JsonResponse.success(registrationPages);
    }


    @RequestMapping(value = "feesVice",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse feesVice(String batchName,Integer pageSize,Integer pageNo){

        System.out.println(batchName);

        PageDTO pageDTO=new PageDTO();
        pageDTO.setPageNo(pageNo);
        pageDTO.setPageSize(pageSize);
        Page<Registration> registrationPages=registrationService.feesVice(batchName,pageDTO);
        return JsonResponse.success(registrationPages);
    }

}

