package com.dhcc.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhcc.user.entities.Employee;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author yzf
 * @create 2019-12-05 15:04
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
