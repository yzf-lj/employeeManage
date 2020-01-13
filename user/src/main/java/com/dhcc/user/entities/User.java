package com.dhcc.user.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import javax.validation.constraints.NotBlank;


/**
 * @author yzf
 * @create 2019-12-05 15:11
 */
@Data
@TableName(value = "user")
public class User extends Model<User> {

    /**
     * 主键ID  设置自增
     * */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private int id;

    @NotBlank(message = "用户名不能为空")
    @TableField(value = "username")
    private String username;

    @NotBlank(message = "密码不能为空")
    @TableField(value = "password")
    private String password;
}
