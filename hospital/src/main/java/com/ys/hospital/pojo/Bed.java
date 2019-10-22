package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (Bed)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer bedId;
    //病床名称
    private String bedName;
    //1:占用；2：空闲
    private Integer bedStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    //入住时间
    private Date bedEntryTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    //离开时间
    private Date bedLeaveTime;
    //病床价格
    private Double bedPrice;
    //入住的患者
    private Integer patientId;
    //属于某病房
    private Integer roomId;
    //归于护士管理
    private Integer employeeId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public String getBedName() {
        return bedName;
    }

    public void setBedName(String bedName) {
        this.bedName = bedName;
    }

    public Integer getBedStatus() {
        return bedStatus;
    }

    public void setBedStatus(Integer bedStatus) {
        this.bedStatus = bedStatus;
    }

    public Date getBedEntryTime() {
        return bedEntryTime;
    }

    public void setBedEntryTime(Date bedEntryTime) {
        this.bedEntryTime = bedEntryTime;
    }

    public Date getBedLeaveTime() {
        return bedLeaveTime;
    }

    public void setBedLeaveTime(Date bedLeaveTime) {
        this.bedLeaveTime = bedLeaveTime;
    }

    public Double getBedPrice() {
        return bedPrice;
    }

    public void setBedPrice(Double bedPrice) {
        this.bedPrice = bedPrice;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}