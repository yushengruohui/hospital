package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (RolePower)实体类
 *
 * @author yusheng
 * @since 2019-10-09 09:00:06
 */
@Data
public class RolePower implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer rolePowerId;
    //外键：角色id
    private Integer roleId;
    //外键：权限id
    private Integer powerId;
    
}