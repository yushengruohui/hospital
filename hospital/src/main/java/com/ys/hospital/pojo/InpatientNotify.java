package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (InpatientNotify)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class InpatientNotify implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer inpatientNotifyId;
    //1：已处理；0：未处理
    private Integer inpatientNotifyStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    //处理住院时间
    private Date inpatientDealTime;
    //所属诊断单id
    private Integer diagnosisId;
    //处理住院的护士
    private Integer employeeId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getInpatientNotifyId() {
        return inpatientNotifyId;
    }

    public void setInpatientNotifyId(Integer inpatientNotifyId) {
        this.inpatientNotifyId = inpatientNotifyId;
    }

    public Integer getInpatientNotifyStatus() {
        return inpatientNotifyStatus;
    }

    public void setInpatientNotifyStatus(Integer inpatientNotifyStatus) {
        this.inpatientNotifyStatus = inpatientNotifyStatus;
    }

    public Date getInpatientDealTime() {
        return inpatientDealTime;
    }

    public void setInpatientDealTime(Date inpatientDealTime) {
        this.inpatientDealTime = inpatientDealTime;
    }

    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Integer diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}