package com.employee.dao;

import com.employee.entity.Birthday;
import com.employee.entity.BirthdayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BirthdayDao {
    long countByExample(BirthdayExample example);

    int deleteByExample(BirthdayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Birthday record);

    int insertSelective(Birthday record);

    List<Birthday> selectByExample(BirthdayExample example);

    Birthday selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Birthday record, @Param("example") BirthdayExample example);

    int updateByExample(@Param("record") Birthday record, @Param("example") BirthdayExample example);

    int updateByPrimaryKeySelective(Birthday record);

    int updateByPrimaryKey(Birthday record);
}