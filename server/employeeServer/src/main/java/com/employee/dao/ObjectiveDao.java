package com.employee.dao;

import com.employee.entity.Objective;
import com.employee.entity.ObjectiveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjectiveDao {
    long countByExample(ObjectiveExample example);

    int deleteByExample(ObjectiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Objective record);

    int insertSelective(Objective record);

    List<Objective> selectByExample(ObjectiveExample example);

    Objective selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Objective record, @Param("example") ObjectiveExample example);

    int updateByExample(@Param("record") Objective record, @Param("example") ObjectiveExample example);

    int updateByPrimaryKeySelective(Objective record);

    int updateByPrimaryKey(Objective record);
}