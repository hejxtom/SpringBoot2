package com.atguigu.cache.controller;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname EmployeeController
 * @Description TODO
 * @Date 15:29 2022/4/28
 * @Created by hejx
 */

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee selectEmpId(@PathVariable Integer id) {
        return employeeService.getEmpById(id);
    }

    @PostMapping("/emp")
    public Employee updateEmp(Employee employee) {
        return employeeService.updateEmp(employee);
    }

    @DeleteMapping("/emp/{id}")
    public void deleteEmp(@PathVariable Integer id){
        employeeService.deleteEmp(id);
    }


    @DeleteMapping("/emp2/{id}")
    public Integer deleteEmp2(@PathVariable Integer id){
        return employeeService.deleteEmp2(id);
    }

    @GetMapping("/emp/last-name/{lastName}")
    public List<Employee> getEmpByLastName(@PathVariable String lastName){
        return employeeService.getEmpByLastName(lastName);
    }


}
