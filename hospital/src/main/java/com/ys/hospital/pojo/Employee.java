package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Employee)实体类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Data
public class Employee implements Serializable {
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
    
}