package com.ys.hospital.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Employee)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
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
    private EmployeeDetail employeeDetail;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public Integer getEmployeeOnline() {
		return employeeOnline;
	}

	public void setEmployeeOnline(Integer employeeOnline) {
		this.employeeOnline = employeeOnline;
	}

	public Date getEmployeeLastLoginTime() {
		return employeeLastLoginTime;
	}

	public void setEmployeeLastLoginTime(Date employeeLastLoginTime) {
		this.employeeLastLoginTime = employeeLastLoginTime;
	}

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}