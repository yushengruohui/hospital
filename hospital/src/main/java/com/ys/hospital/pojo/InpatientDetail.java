package com.ys.hospital.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (InpatientDetail)实体类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Data
public class InpatientDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer inpatientDetailId;
    //每天的住院费
    private Double inpatientDetailPrice;
    //护士对患者的观察建议
    private String inpatientDetailDescription;
    //住院每天的时间
    private Date inpatientDetailDate;
    //所属住院单
    private Integer inpatientId;
    
}