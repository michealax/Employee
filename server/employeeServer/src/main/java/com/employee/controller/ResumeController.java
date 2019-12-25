package com.employee.controller;

import com.employee.request.*;
import com.employee.response.BooleanResponse;
import com.employee.response.ResumeResponse;
import com.employee.service.ResumeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class ResumeController {
    @Resource
    ResumeService resumeService;
    //添加简历
    @RequestMapping(value = "/addResume", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse addResume(@RequestBody AddResumeRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return new BooleanResponse(true);//失败ID就是-1
    }
    //删除简历
    @RequestMapping(value = "/delResume", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse delResume(@RequestBody DelResumeRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return new BooleanResponse(true);//失败ID就是-1
    }
    //获得简历
    @RequestMapping(value = "/getResume", method = RequestMethod.POST)
    public @ResponseBody
    ResumeResponse getResume(@RequestBody GetResumeRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return null;//失败ID就是-1
    }

    //添加生日
    @RequestMapping(value = "/addBir", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse addBir(@RequestBody UpdateBirRequest request) throws IOException {
        boolean result=resumeService.addBir(request.getPersonID(),request.getYear(),request.getMonth(),request.getDay());
        return new BooleanResponse(result);
    }
    //更新生日
    @RequestMapping(value = "/updateBir", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse updateBir(@RequestBody UpdateBirRequest request) throws IOException {
        boolean result=resumeService.updateBir(request.getPersonID(),request.getYear(),request.getMonth(),request.getDay());
        return new BooleanResponse(result);
    }

    //添加教育经历
    @RequestMapping(value = "/addEdu", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse addEdu(@RequestBody UpdateEduRequest request) throws IOException {
        boolean result=resumeService.addEdu(request.getPersonID(),request.getStart(),request.getEnd(),request.getName(),request.getProfessional());
        return new BooleanResponse(result);
    }
    //更新教育经历
    @RequestMapping(value = "/updateEdu", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse updateEdu(@RequestBody UpdateEduRequest request) throws IOException {
        boolean result=resumeService.updateEdu(request.getPersonID(),request.getStart(),request.getEnd(),request.getName(),request.getProfessional());
        return new BooleanResponse(result);
    }

    //更新个人信息
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse updateInfo(@RequestBody UpdateInfoRequest request) throws IOException {
        boolean result=resumeService.updateInfo(request.getPersonID(),request.getName(),request.getGender(),request.getPhone(),request.getEmail(),request.getLive());
        return new BooleanResponse(result);
    }

    //添加工作经历
    @RequestMapping(value = "/addWork", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse addWork(@RequestBody UpdateWorkRequest request) throws IOException {
        boolean result=resumeService.addWork(request.getPersonID(),request.getStart(),request.getEnd(),request.getCompany(),request.getPosition(),request.getDepartment(),request.getDescription());
        return new BooleanResponse(result);
    }
    //更新工作经历
    @RequestMapping(value = "/updateWork", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse updateWork(@RequestBody UpdateWorkRequest request) throws IOException {
       boolean result=resumeService.updateWork(request.getPersonID(),request.getStart(),request.getEnd(),request.getCompany(),request.getPosition(),request.getDepartment(),request.getDescription());
        return new BooleanResponse(result);
    }

    //添加意向
    @RequestMapping(value = "/addObj", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse addObj(@RequestBody UpdateObjRequest request) throws IOException {
        boolean result=resumeService.addObj(request.getPersonID(),request.getSalary(),request.getPlace(),request.getPosition(),request.getType());
        return new BooleanResponse(result);
    }
    //更新意向
    @RequestMapping(value = "/updateObj", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse updateObj(@RequestBody UpdateObjRequest request) throws IOException {
        boolean result=resumeService.updateObj(request.getPersonID(),request.getSalary(),request.getPlace(),request.getPosition(),request.getType());
        return new BooleanResponse(result);
    }
}
