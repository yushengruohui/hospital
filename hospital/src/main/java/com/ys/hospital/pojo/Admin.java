package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Admin)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:45
 */
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer adminId;
    
    private String adminName;
    
    private String adminPhone;
    
    private String adminPassword;
    
    private String adminEmail;
    
}