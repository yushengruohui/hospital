package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (Room)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:40
 */
@Data
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer roomId;
    //诊室名称
    private String roomName;
    //所属室id
    private Integer branchId;
    //房间地址
    private String roomAddress;
    
}