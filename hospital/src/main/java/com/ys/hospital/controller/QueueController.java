package com.ys.hospital.controller;

import com.ys.hospital.pojo.Employee;
import com.ys.hospital.pojo.Queue;
import com.ys.hospital.service.QueueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * (Queue)表控制层
 *
 * @author yusheng
 * @since 2019-10-13 23:31:11
 */
@RestController
public class QueueController {
    private static final Logger logger = LoggerFactory.getLogger(QueueController.class);

    @Resource
    private QueueService queueService;

    @PostMapping("/queue")
    public String queue(HttpSession session, String patientId) throws ParseException {
        //获取医师信息
        Employee employee = (Employee) session.getAttribute("employee");

        //生成查询数据
        Queue queue = new Queue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(new Date());
        queue.setEmployeeId(employee.getEmployeeId());
        queue.setQueueTime(currentDate);

        //获取当天最大排位
        int maxNumber = queueService.findMaxNumber(queue);

        queue.setPatientId(Integer.valueOf(patientId));
        queue.setQueueNumber(maxNumber + 1);

        int flag = queueService.insertQueue(queue);
        if (flag == 1) {
            return "该患者排在第" + (maxNumber + 1) + "号";
        } else {
            return "error";
        }
    }


}