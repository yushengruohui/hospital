package com.ys.hospital.pojo.dto;

import com.ys.hospital.pojo.Branch;
import com.ys.hospital.pojo.Position;
import com.ys.hospital.pojo.Title;
import lombok.Data;

import java.util.Date;

/**
 * @author: yusheng
 * @create-time 2019-10-28 15:12
 **/
@Data
public class EmployeeOnUpdateDTO {
    private Integer employeeId;
    //员工姓名
    private String employeeName;
    //员工密码
    private String employeePassword;
    //1:在线；0：离线
    private Integer employeeOnline;
    //离线时，自动更新最后登录时间
    private Date employeeLastLoginTime;

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
