package com.zhao.vhr.Service;

import com.zhao.vhr.bean.Employee;
import com.zhao.vhr.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    public List<Employee> getEmlpoyeeByPage(Integer page,Integer size,String keywords,
                                            Long politicId,Long nationId,Long posId,
                                            Long jobLevelId,String engageForm,
                                            Long departmentId,String beginDateScope){
        int start = (page - 1) * size;
        Date startBeginDate = null;
        Date endBeginDate = null;
        if(beginDateScope != null && beginDateScope.contains(",")){
            String[] spilt = beginDateScope.split(",");
            try {
                startBeginDate = birthdayFormat.parse(spilt[0]);
                endBeginDate = birthdayFormat.parse(spilt[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return employeeMapper.getEmpByPage(start,size,keywords,politicId,nationId,posId, jobLevelId,engageForm,departmentId,startBeginDate,endBeginDate);
    }

    public Long getCountByKeywords(String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope) {
        Date startBeginDate = null;
        Date endBeginDate = null;
        if (beginDateScope != null && beginDateScope.contains(",")) {
            try {
                String[] split = beginDateScope.split(",");
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
            } catch (ParseException e) {
            }
        }
        return employeeMapper.getCountByKeywords(keywords, politicId, nationId, posId, jobLevelId, engageForm, departmentId, startBeginDate, endBeginDate);
    }
}
