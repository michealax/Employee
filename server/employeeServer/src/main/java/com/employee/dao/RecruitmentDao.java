package com.employee.dao;

import com.employee.entity.Recruitment;
import com.employee.entity.RecruitmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecruitmentDao {
    long countByExample(RecruitmentExample example);

    int deleteByExample(RecruitmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Recruitment record);

    int insertSelective(Recruitment record);

    List<Recruitment> selectByExample(RecruitmentExample example);

    Recruitment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Recruitment record, @Param("example") RecruitmentExample example);

    int updateByExample(@Param("record") Recruitment record, @Param("example") RecruitmentExample example);

    int updateByPrimaryKeySelective(Recruitment record);

    int updateByPrimaryKey(Recruitment record);
}