package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (Inpatient)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class Inpatient implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer inpatientId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    //入院时间
    private Date inpatientEntryTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    //离院时间
    private Date inpatientLeaveTime;
    //1：已处理；0:未处理
    private Integer inpatientStatus;
    //所属住院通知
    private Integer inpatientNotifyId;
    //病床id
    private Integer bedId;
    //住院总费用
    private Double inpatientPrice;
    //1：已支付；0：未支付
    private Integer inpatientPayStatus;
    //患者预交费用
    private Double inpatientPrepaidPrice;
    //住院详情
    private List<InpatientDetail> inpatientDetails;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getInpatientId() {
        return inpatientId;
    }

    public void setInpatientId(Integer inpatientId) {
        this.inpatientId = inpatientId;
    }

    public Date getInpatientEntryTime() {
        return inpatientEntryTime;
    }

    public void setInpatientEntryTime(Date inpatientEntryTime) {
        this.inpatientEntryTime = inpatientEntryTime;
    }

    public Date getInpatientLeaveTime() {
        return inpatientLeaveTime;
    }

    public void setInpatientLeaveTime(Date inpatientLeaveTime) {
        this.inpatientLeaveTime = inpatientLeaveTime;
    }

    public Integer getInpatientStatus() {
        return inpatientStatus;
    }

    public void setInpatientStatus(Integer inpatientStatus) {
        this.inpatientStatus = inpatientStatus;
    }

    public Integer getInpatientNotifyId() {
        return inpatientNotifyId;
    }

    public void setInpatientNotifyId(Integer inpatientNotifyId) {
        this.inpatientNotifyId = inpatientNotifyId;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Double getInpatientPrice() {
        return inpatientPrice;
    }

    public void setInpatientPrice(Double inpatientPrice) {
        this.inpatientPrice = inpatientPrice;
    }

    public Integer getInpatientPayStatus() {
        return inpatientPayStatus;
    }

    public void setInpatientPayStatus(Integer inpatientPayStatus) {
        this.inpatientPayStatus = inpatientPayStatus;
    }

    public Double getInpatientPrepaidPrice() {
        return inpatientPrepaidPrice;
    }

    public void setInpatientPrepaidPrice(Double inpatientPrepaidPrice) {
        this.inpatientPrepaidPrice = inpatientPrepaidPrice;
    }

    public List<InpatientDetail> getInpatientDetails() {
        return inpatientDetails;
    }

    public void setInpatientDetails(List<InpatientDetail> inpatientDetails) {
        this.inpatientDetails = inpatientDetails;
    }
}