package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Bed)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer bedId;
    
    private String bedName;
    //1:占用；2：空闲
    private Integer bedStatus;
    
    private Date bedEntryTime;
    
    private Date bedLeaveTime;
    
    private Double bedPrice;
    //入住的患者
    private Integer patientId;
    //属于某病房
    private Integer roomId;
    //归于护士管理
    private Integer employeeId;
    
}