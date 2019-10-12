package com.ys.hospital.tools;

import com.zhenzi.sms.ZhenziSmsClient;

import java.io.Serializable;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-12 15:15
 **/
public class SMSTool implements Serializable {
    private static final long serialVersionUID = 1L;
    //短信平台相关参数
    private String apiUrl = "https://sms_developer.zhenzikj.com";
    private String appId = "101189";
    private String appSecret = "OTRjZWQ2ZTUtZDY4Ny00NWFlLWIwNmYtMzkxYWM5NDg3ZDE4";

    public void send(String toPhone, String message) throws Exception {
        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
        String result = client.send(toPhone, message);
    }
}
