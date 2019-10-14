package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Patient)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    //就诊人id
    private Integer patientId;
    //就诊人联系方式
    private String patientPhone;
    //就诊人姓名
    private String patientName;
    //性别
    private String patientGender;
    //身份证
    private String patientIdentity;
    //地址
    private String patientAddress;
    //所属用户id
    private Integer clientId;
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getPatientIdentity() {
		return patientIdentity;
	}
	public void setPatientIdentity(String patientIdentity) {
		this.patientIdentity = patientIdentity;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}