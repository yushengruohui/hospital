package com.ys.hospital.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * (AiGuide)实体类
 *
 * @author yusheng
 * @since 2019-10-10 08:09:39
 */
@Data
public class AiGuide implements Serializable {
    private static final long serialVersionUID = 1L;
    //智能导诊id
    private Integer aiguideId;
    //导诊关键字
    private String aiguideKey;
    //导诊回复
    private String aiguideContent;
	
}