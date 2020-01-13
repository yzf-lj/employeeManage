package com.dhcc.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dhcc.user.entities.Employee;
import com.dhcc.user.entities.User;
import com.dhcc.user.mapper.EmployeeMapper;
import com.dhcc.user.mapper.UserMapper;
import com.dhcc.user.service.EmployeeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yzf
 * @create 2020-01-10 9:55
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee(){
        return employeeMapper.selectList(null);
    }

    @Override
    public int insertEmployee(Employee employee){

        if (employee == null){
            return 0;
        }
        //唯一性校验
        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<Employee>()
                .eq(Employee::getName,employee.getName());
        Integer cnt =  employeeMapper.selectCount(lqw);
        if (cnt > 0){
            //已存在
            return 0;
        }
        int ret = employeeMapper.insert(employee);
        return ret;
    }

    @Override
    public Employee getEmployeeById(int employeeId){
        Employee employee = new Employee();
//        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<Employee>().eq(Employee::getId,employeeId);
//        employee.selectOne(lqw);
        employee.selectById(employeeId);
        return employee;

    }

    @Override
    public int updateEmployee(Employee employee){
        if (employee == null){
            return 0;
        }
        //唯一性校验
        LambdaQueryWrapper<Employee> lqw =new LambdaQueryWrapper<Employee>()
                .eq(Employee::getName,employee.getName());
        Integer cnt = employeeMapper.selectCount(lqw);
        Employee getEmployee = (Employee) employeeMapper.selectById(employee.getId());
        Boolean flag =
                (cnt > 0 && !employee.getName().equals(getEmployee.getName()))
                    || (cnt > 1 && employee.getName().equals(getEmployee.getName()));
        if (flag){
            //no
            return 0;
        }
        return employeeMapper.updateById(employee);
    }

    @Override
    public int deleteEmployeeById(int employeeId){

        return employeeMapper.deleteById(employeeId);
    }


    @Override
    public IPage<Employee> selectPageExt(int curPage,int pageNum){
        Page<Employee> page = new Page<>(curPage,pageNum);
        IPage<Employee> iPage = employeeMapper.selectPage(page,null);
        return iPage;
    }
}
