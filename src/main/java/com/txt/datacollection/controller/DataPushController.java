package com.txt.datacollection.controller;

import com.mysql.cj.util.TimeUtil;
import com.txt.datacollection.domain.MotorLog;
import com.txt.datacollection.resipository.PersonResipository;
import com.txt.datacollection.service.MotorLogService;
import com.txt.datacollection.util.NetUtil;
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

        String strTime = request.getParameter("pkt");
        DateTimeFormatter formattor = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime dateTime = LocalDateTime.parse(strTime, formattor);
        String ipAddr=request.getParameter("ipaddr");
        MotorLog motorLog = null;
        for (int i = 0; i < startWithReg.size(); i+=5) {
            motorLog=new MotorLog();
            String paramName = startWithReg.get(i).toString();
            motorLog.setRegStartId(paramName);
            motorLog.setY(request.getParameter(paramName));
            motorLog.setZ(request.getParameter(startWithReg.get(i+1)));
            motorLog.setC(request.getParameter(startWithReg.get(i+2)));
            motorLog.setXas(request.getParameter(startWithReg.get(i+3)));
            motorLog.setYas(request.getParameter(startWithReg.get(i+4)));
            motorLog.setIp(ipAddr);
            motorLog.setTime(dateTime);
            motorLogService.save(motorLog);
        }



        // Log log = LogFactory.get();
        // DateTime timeParsed = DateUtil.parse("2017-01-15", "yyyy-MM-dd");


    }

}
