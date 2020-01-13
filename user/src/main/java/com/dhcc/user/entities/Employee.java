package com.dhcc.user.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author yzf
 * @create 2019-12-02 11:31
 */
@Data
public class Employee extends Model<Employee> {

    //员工---id,name,email,gender/department/birth

    @NotBlank(message = "id不能为空")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "email不能为空")
    private String email;

    //1:male  0:female

    @NotBlank(message = "gender不能为空")
    private Integer gender;

    @NotBlank(message = "department不能为空")
    private String department;

    @NotBlank(message = "birth不能为空")
    private Date birth;

}
