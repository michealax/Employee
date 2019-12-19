package com.employee.service;

import com.employee.dao.BirthdayDao;
import com.employee.dao.EducationDao;
import com.employee.dao.PersonalDao;
import com.employee.dao.WorkDao;
import com.employee.entity.Objective;
import org.springframework.beans.factory.annotation.Autowired;

public class ResumeService {
    @Autowired
    private PersonalDao personalDao;//个人信息
    private BirthdayDao birthdayDao;//生日信息
    private EducationDao educationDao;//教育经历
    private WorkDao workDao;//工作经历
    private Objective objective;//求职意向
}
