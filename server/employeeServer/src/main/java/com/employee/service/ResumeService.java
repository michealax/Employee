package com.employee.service;

import com.employee.dao.*;
import com.employee.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ResumeService {
    @Autowired
    private PersonalDao personalDao;//个人信息
    private BirthdayDao birthdayDao;//生日信息
    private EducationDao educationDao;//教育经历
    private WorkDao workDao;//工作经历
    private ObjectiveDao objectiveDao;//求职意向

    public boolean addBir(int perID,int year,int month,int day){
        BirthdayExample birthdayExample=new BirthdayExample();
        birthdayExample.createCriteria().andPersonalidEqualTo(perID);
        if (birthdayDao.selectByExample(birthdayExample).size()==0){
            Birthday birthday=new Birthday();
            birthday.setPersonalid(perID);
            birthday.setYear(year);
            birthday.setMonth(month);
            birthday.setDay(day);
            birthdayDao.insertSelective(birthday);
            return true;
        }
        return false;
    }

    public boolean updateBir(int perID,int year,int month,int day){
        BirthdayExample birthdayExample=new BirthdayExample();
        birthdayExample.createCriteria().andPersonalidEqualTo(perID);
        if (birthdayDao.selectByExample(birthdayExample).size()!=0){
            Birthday birthday=new Birthday();
            birthday.setYear(year);
            birthday.setMonth(month);
            birthday.setDay(day);
            birthdayDao.updateByExampleSelective(birthday,birthdayExample);
            return true;
        }
        return false;
    }

    public boolean addEdu(int perID, Date start,Date end,String name,String professional){
        EducationExample educationExample=new EducationExample();
        educationExample.createCriteria().andPersonalidEqualTo(perID);
        if (educationDao.selectByExample(educationExample).size()==0){
            Education education=new Education();
            education.setPersonalid(perID);
            education.setStarttime(start);
            education.setEndtime(end);
            education.setSchoolname(name);
            education.setProfessional(professional);
            educationDao.insertSelective(education);
            return true;
        }
        return false;
    }

    public boolean updateEdu(int perID, Date start,Date end,String name,String professional){
        EducationExample educationExample=new EducationExample();
        educationExample.createCriteria().andPersonalidEqualTo(perID);
        if (educationDao.selectByExample(educationExample).size()!=0){
            Education education=new Education();
            education.setStarttime(start);
            education.setEndtime(end);
            education.setSchoolname(name);
            education.setProfessional(professional);
           educationDao.updateByExampleSelective(education,educationExample);
            return true;
        }
        return false;
    }

    public boolean updateInfo(int perID,String name,int gender,String phone,String email,String live){
        PersonalExample personalExample=new PersonalExample();
        personalExample.createCriteria().andIdEqualTo(perID);
        if (personalDao.selectByExample(personalExample).size()!=0){
            Personal personal=new Personal();
            personal.setName(name);
            personal.setGender(gender);
            personal.setPhone(phone);
            personal.setEmail(email);
            personal.setLive(live);
            personalDao.updateByExampleSelective(personal,personalExample);
            return true;
        }
        return false;
    }

    public boolean addWork(int perID,Date start,Date end,String company,String position,String department,String description){
        WorkExample workExample=new WorkExample();
        workExample.createCriteria().andPersonalidEqualTo(perID);
        if (workDao.selectByExample(workExample).size()==0){
            Work work=new Work();
            work.setPersonalid(perID);
            work.setStarttime(start);
            work.setEndtime(end);
            work.setCompany(company);
            work.setPosition(position);
            work.setDepartment(department);
            work.setDescription(description);
            workDao.insertSelective(work);
            return true;
        }
        return false;
    }

    public boolean updateWork(int perID,Date start,Date end,String company,String position,String department,String description){
        WorkExample workExample=new WorkExample();
        workExample.createCriteria().andPersonalidEqualTo(perID);
        if (workDao.selectByExample(workExample).size()!=0){
            Work work=new Work();
            work.setStarttime(start);
            work.setEndtime(end);
            work.setCompany(company);
            work.setPosition(position);
            work.setDepartment(department);
            work.setDescription(description);
            workDao.updateByExampleSelective(work,workExample);
            return true;
        }
        return false;
    }

    public boolean addObj(int perID,int salary,String place,String position,int type){
        ObjectiveExample objectiveExample=new ObjectiveExample();
        objectiveExample.createCriteria().andPersonalidEqualTo(perID);
        if (objectiveDao.selectByExample(objectiveExample).size()==0){
            Objective objective=new Objective();
            objective.setPersonalid(perID);
            objective.setSalary(salary);
            objective.setPlace(place);
            objective.setPosition(position);
            objective.setType(type);
            objectiveDao.insertSelective(objective);
            return true;
        }
        return false;
    }

    public boolean updateObj(int perID,int salary,String place,String position,int type){
        ObjectiveExample objectiveExample=new ObjectiveExample();
        objectiveExample.createCriteria().andPersonalidEqualTo(perID);
        if (objectiveDao.selectByExample(objectiveExample).size()!=0){
            Objective objective=new Objective();
            objective.setSalary(salary);
            objective.setPlace(place);
            objective.setPosition(position);
            objective.setType(type);
            objectiveDao.updateByExampleSelective(objective,objectiveExample);
            return true;
        }
        return false;
    }

}
