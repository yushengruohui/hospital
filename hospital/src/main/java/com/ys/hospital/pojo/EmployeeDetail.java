package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (EmployeeDetail)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
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
	public Integer getEmployeeDetailId() {
		return employeeDetailId;
	}
	public void setEmployeeDetailId(Integer employeeDetailId) {
		this.employeeDetailId = employeeDetailId;
	}
	public String getEmployeeDetailGender() {
		return employeeDetailGender;
	}
	public void setEmployeeDetailGender(String employeeDetailGender) {
		this.employeeDetailGender = employeeDetailGender;
	}
	public Date getEmployeeDetailBirthday() {
		return employeeDetailBirthday;
	}
	public void setEmployeeDetailBirthday(Date employeeDetailBirthday) {
		this.employeeDetailBirthday = employeeDetailBirthday;
	}
	public String getEmployeeDetailAddress() {
		return employeeDetailAddress;
	}
	public void setEmployeeDetailAddress(String employeeDetailAddress) {
		this.employeeDetailAddress = employeeDetailAddress;
	}
	public String getEmployeeDetailPhone() {
		return employeeDetailPhone;
	}
	public void setEmployeeDetailPhone(String employeeDetailPhone) {
		this.employeeDetailPhone = employeeDetailPhone;
	}
	public String getEmployeeDetailIdentity() {
		return employeeDetailIdentity;
	}
	public void setEmployeeDetailIdentity(String employeeDetailIdentity) {
		this.employeeDetailIdentity = employeeDetailIdentity;
	}
	public Date getEmployeeDetailEntryTime() {
		return employeeDetailEntryTime;
	}
	public void setEmployeeDetailEntryTime(Date employeeDetailEntryTime) {
		this.employeeDetailEntryTime = employeeDetailEntryTime;
	}
	public String getEmployeeDetailEmail() {
		return employeeDetailEmail;
	}
	public void setEmployeeDetailEmail(String employeeDetailEmail) {
		this.employeeDetailEmail = employeeDetailEmail;
	}
	public String getEmployeeDetailDescript() {
		return employeeDetailDescript;
	}
	public void setEmployeeDetailDescript(String employeeDetailDescript) {
		this.employeeDetailDescript = employeeDetailDescript;
	}
	public Integer getEmployeeDetailStatus() {
		return employeeDetailStatus;
	}
	public void setEmployeeDetailStatus(Integer employeeDetailStatus) {
		this.employeeDetailStatus = employeeDetailStatus;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public Integer getTitleId() {
		return titleId;
	}
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}