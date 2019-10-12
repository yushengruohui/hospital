package com.ys.hospital.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    //管理员id
    private Integer adminId;
    //管理员姓名
    private String adminName;
    //管理员联系方式
    private String adminPhone;
    //管理员登录密码
    private String adminPassword;
    //管理员邮箱
    private String adminEmail;


}