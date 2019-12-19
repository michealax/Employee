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

    @RequestMapping(value = "/addResume", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse addResume(@RequestBody AddResumeRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return new BooleanResponse(true);//失败ID就是-1
    }

    @RequestMapping(value = "/delResume", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse delResume(@RequestBody DelResumeRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return new BooleanResponse(true);//失败ID就是-1
    }

    @RequestMapping(value = "/getResume", method = RequestMethod.POST)
    public @ResponseBody
    ResumeResponse getResume(@RequestBody GetResumeRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return null;//失败ID就是-1
    }

    @RequestMapping(value = "/updateBir", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse updateBir(@RequestBody UpdateBirRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return null;//失败ID就是-1
    }

    @RequestMapping(value = "/updateEdu", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse updateEdu(@RequestBody UpdateEduRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return null;//失败ID就是-1
    }

    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse updateInfo(@RequestBody UpdateInfoRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return null;//失败ID就是-1
    }

    @RequestMapping(value = "/updateWork", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse updateWork(@RequestBody UpdateWorkRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return null;//失败ID就是-1
    }

    @RequestMapping(value = "/updateObj", method = RequestMethod.POST)
    public @ResponseBody
    BooleanResponse updateObj(@RequestBody UpdateObjRequest request) throws IOException {
        resumeService.toString();
        request.toString();
        return null;//失败ID就是-1
    }
}
