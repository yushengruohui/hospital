package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Department)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer departmentId;
    
    private String departmentName;
    
}