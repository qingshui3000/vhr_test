package com.zhao.vhr.mapper;

import com.zhao.vhr.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    List<Employee> getEmpByPage(
            @Param("start") Integer start, @Param("size") Integer size,
            @Param("keywords") String keywords, @Param("politicId")Long politicId,
            @Param("nationId")Long nationId, @Param("posId")Long posId,
            @Param("jobLevelId")Long jobLevelId, @Param("engageForm")String engageForm,
            @Param("departmentId")Long departmentId,
            @Param("startBeginDate")Date startBeginDate,
            @Param("endBeginDate")Date endBeginDate);

    Long getCountByKeywords(
            @Param("keywords") String keywords, @Param("politicId") Long politicId,
            @Param("nationId") Long nationId, @Param("posId") Long posId,
            @Param("jobLevelId") Long jobLevelId, @Param("engageForm") String engageForm,
            @Param("departmentId") Long departmentId, @Param("startBeginDate") Date startBeginDate,
            @Param("endBeginDate") Date endBeginDate);
}
