package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Room)实体类
 *
 * @author yusheng
 * @since 2019-09-26 10:43:46
 */
@Data
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer roomId;
    
    private String roomName;
    
    private Integer branchId;
    
}