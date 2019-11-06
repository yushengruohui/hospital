package com.ys.hospital.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: yusheng
 * @create-time 2019-11-05 13:32
 **/
@Data
public class PermissionIndexVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String roleName;

    private String powerDetailUrl;

    private String powerDetailMethod;

    private String powerDetailDescription;
}
