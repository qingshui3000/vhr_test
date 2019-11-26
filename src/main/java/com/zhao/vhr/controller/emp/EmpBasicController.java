package com.zhao.vhr.controller.emp;

import com.zhao.vhr.Service.EmployeeService;
import com.zhao.vhr.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public Map<String,Object> getEmpByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10")Integer size,
            @RequestParam(defaultValue = "") String keywords,
            Long politicId,Long nationId,Long posId,Long jobLevelId,
            String engageForm,Long departmentId,String beginDateScope
    ){
        Map<String,Object> map = new HashMap<>();
        List<Employee> list = employeeService.getEmlpoyeeByPage(page,size,keywords,politicId
        ,nationId,posId,jobLevelId,engageForm,departmentId,beginDateScope);
        Long cnt = employeeService.getCountByKeywords(keywords,politicId,nationId,posId,jobLevelId,
                engageForm,departmentId,beginDateScope);
        map.put("emps",list);
        map.put("count",cnt);
        return map;
    }
}
