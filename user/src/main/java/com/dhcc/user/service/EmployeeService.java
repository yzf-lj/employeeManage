package com.dhcc.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dhcc.user.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yzf
 * @create 2020-01-08 10:57
 */

public interface EmployeeService {

    List<Employee> getAllEmployee();

    int insertEmployee(Employee employee);

    Employee getEmployeeById(int employeeId);

    int updateEmployee(Employee employee);

    int deleteEmployeeById(int employeeId);

    IPage<Employee> selectPageExt(int curPage,int pageNum);

}
