package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname EmployeeService
 * @Description TODO
 * @Date 15:26 2022/4/28
 * @Created by hejx
 */
@Service
public interface EmployeeService {

    public Employee getEmpById(Integer id);

    public Employee updateEmp(Employee employee);

    public void deleteEmp(Integer id);

    public Integer deleteEmp2(Integer id);

    public List<Employee> getEmpByLastName(String lastName);
}
