package com.ys.hospital.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (EmployeeDetail)实体类
 *
 * @author yusheng
 * @since 2019-10-22 10:54:22
 */
@Data
public class EmployeeDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer employeeDetailId;
    //员工性别
    private String employeeDetailGender;
    //员工出生日期
    private Date employeeDetailBirthday;
    //员工详细地址
    private String employeeDetailAddress;
    //员工联系方式
    private String employeeDetailPhone;
    //员工身份证
    private String employeeDetailIdentity;
    //员工入职时间
    private Date employeeDetailEntryTime;
    //员工邮箱
    private String employeeDetailEmail;
    //员工简介
    private String employeeDetailDescript;
    //1:在职；0：离职
    private Integer employeeDetailStatus;
    //所属员工表
    private Integer employeeId;
    //职位id
    private Integer positionId;
    //科室id
    private Integer branchId;
    //职称id
    private Integer titleId;

    private Position position;

    private Branch branch;

    private Title title;
}