package com.ys.hospital.employee;

import com.ys.hospital.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-12 09:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class employeeTest {
    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void test() {
        Employee employee = new Employee();
        employee.setEmployeeId(2019001);
        employee.setEmployeePassword("123456");

        Object o = redisTemplate.opsForValue().get(employee.getEmployeeId());

        System.out.println(o);
    }
}
