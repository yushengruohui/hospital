package com.ys.hospital.pojo.vo;

import com.ys.hospital.pojo.EmployeeDetail;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: yusheng
 * @create-time 2019-10-30 10:11
 **/
@Data
public class EmployeeInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;
    //员工id
    private Integer employeeId;
    //员工姓名
    private String employeeName;
    //员工密码
    private String employeePassword;
    //1:在线；0：离线
    private Integer employeeOnline;
    //离线时，自动更新最后登录时间
    private Date employeeLastLoginTime;

    private EmployeeDetail employeeDetail;

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

    private String titleName;
}
