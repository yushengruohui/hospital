package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Bed)实体类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Data
public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer bedId;
    //病床名称
    private String bedName;
    //1:占用；2：空闲
    private Integer bedStatus;
    //入住时间
    private Date bedEntryTime;
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
    
}