package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Branch)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer branchId;
    
    private String branchName;
    
    private Integer departmentId;
    
}