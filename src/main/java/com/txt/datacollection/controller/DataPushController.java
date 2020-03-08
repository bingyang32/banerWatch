package com.txt.datacollection.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.txt.datacollection.content.PararmNameValue;
import com.txt.datacollection.domain.MotorLog;
import com.txt.datacollection.domain.Person;
import com.txt.datacollection.resipository.PersonResipository;
import com.txt.datacollection.service.MotorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName DataPushController
 * @Description
 * @Author hysys
 * @Date 2020-03-08 15:03
 **/
@RestController
public class DataPushController {
    @Autowired
    PersonResipository personResipository;
    @Autowired
    MotorLogService motorLogService;

    @GetMapping("push")
    public void getMapping(ServletRequest request) throws IOException, NoSuchFieldException, IllegalAccessException {
        Enumeration<String> parameterNames = request.getParameterNames();
        //判断当前参数是否以reg 开头

        //如果是判断-1 mod 5 = 0 则找到都

        // IterUtil.toList()

        ArrayList<String> list = Collections.list(parameterNames);


        //获取reg开头的参数
        List<String> startWithReg = list.stream().filter(s -> s.startsWith("reg")).collect(Collectors.toList());

        MotorLog motorLog = null;
        for (int i = 0; i < startWithReg.size(); i++) {


            //如果可以被5整除则为第1个参数，创建对象并进行复制

            if (i % 5 == 0) {
                if (motorLog != null)
                    motorLogService.save(motorLog);

                motorLog = new MotorLog();

                String regId = startWithReg.get(i);
                motorLog.setRegStartId(regId.toString());

            } else {

                String paramName = startWithReg.get(i);
                String parameterValue = request.getParameter(paramName);
                //获取参数名称
                String filedName = PararmNameValue.getObjectName(paramName);
                //通过属性名字 获取Filed对下给你
                Field declaredField = motorLog.getClass().getDeclaredField(filedName);
                //设置访问权限
                declaredField.setAccessible(true);
                // 赋值
                declaredField.set(motorLog, parameterValue);

            }

        }


        for (String s : startWithReg) {

            System.out.println(String.format(request.getParameter("reg") + ":%s", s));

        }
        // Log log = LogFactory.get();
        // DateTime timeParsed = DateUtil.parse("2017-01-15", "yyyy-MM-dd");


    }

}
