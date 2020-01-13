package com.dhcc.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dhcc.user.mapper.EmployeeMapper;
import com.dhcc.user.mapper.UserMapper;
import com.dhcc.user.entities.Employee;
import com.dhcc.user.entities.User;
import com.dhcc.user.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class UserApplicationTests {
    
    private EmployeeMapper employeeMapper;
    
    @Test
    public void selectPage(){

        Page<Employee> page = new Page<Employee>(1, 5);
        IPage<Employee> employeeIPage = employeeMapper.selectPage(page, null);
        System.out.println("总页数："+employeeIPage.getPages());
        System.out.println("总记录数："+employeeIPage.getTotal());
        List<Employee> employeesList = employeeIPage.getRecords();
//        for (Employee employee : employeesList) {
//            System.out.println(employee);
//        }

    }
}
