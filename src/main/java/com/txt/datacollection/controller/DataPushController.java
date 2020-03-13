package com.txt.datacollection.controller;

import com.txt.datacollection.domain.MotorLog;
import com.txt.datacollection.service.MotorLogService;
import com.txt.datacollection.util.RegUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    MotorLogService motorLogService;


    @GetMapping("push")
    public void getMapping(ServletRequest request) throws IOException, NoSuchFieldException, IllegalAccessException {
        Enumeration<String> parameterNames = request.getParameterNames();

        // IterUtil.toList()
        //将获取到的参数转化为列表
        ArrayList<String> list = Collections.list(parameterNames);
        //获取时间
        String strTime = request.getParameter("pkt");
        //解析时间
        DateTimeFormatter formattor = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dateTime =  LocalDateTime.parse(strTime, formattor);
        //获取ip地址，避免内网ip，取请求ip
        String ipAddr=request.getParameter("ipaddr");
        MotorLog motorLog = null;
        //获取reg开头的参数,并按照数字部分进行排序
        List<String> startWithReg = list.stream().filter(s -> s.startsWith("reg")).sorted((o1, o2) -> {
            //参数动态排序
            String num1 = RegUtil.getNum(o1);
            String num2 = RegUtil.getNum(o2);
            Double d1 = Double.parseDouble(num1);
            Double d2 = Double.parseDouble(num2);
            return d1.compareTo(d2);

        }).collect(Collectors.toList());
        //保存reg开头参数和必要参数
        for (int i = 0; i < startWithReg.size(); i+=5) {
            motorLog=new MotorLog();
            String paramName = startWithReg.get(i).toString();
            motorLog.setRegStartId(paramName);
            motorLog.setX(Double.parseDouble(request.getParameter(paramName)));
            motorLog.setY(Double.parseDouble(request.getParameter(startWithReg.get(i+1))) );
            motorLog.setC(Double.parseDouble(request.getParameter(startWithReg.get(i + 2))));
            motorLog.setXas(Double.parseDouble(request.getParameter(startWithReg.get(i + 3))));
            motorLog.setYas(Double.parseDouble(request.getParameter(startWithReg.get(i + 4))));
            motorLog.setIp(ipAddr);
            motorLog.setTime(dateTime);
            motorLogService.save(motorLog);
        }



        // Log log = LogFactory.get();
        // DateTime timeParsed = DateUtil.parse("2017-01-15", "yyyy-MM-dd");


    }

}
