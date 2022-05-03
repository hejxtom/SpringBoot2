package com.atguigu.cache.mapper;

import com.atguigu.cache.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * 在Config类中(Boot2CacheApplication)加的有@MapperScan可以省略@Mapper
 */
//@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public Integer updateEmp(Employee employee);

    public List<Employee> getEmpByLastName(String lastName);

}
