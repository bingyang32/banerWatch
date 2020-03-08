package com.txt.datacollection.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.txt.datacollection.domain.Person;
import com.txt.datacollection.resipository.PersonResipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.io.IOException;
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
public class DataPushController
{
    @Autowired
    PersonResipository personResipository;

    @GetMapping("push")
    public void getMapping(ServletRequest request) throws IOException {
        Enumeration<String> parameterNames = request.getParameterNames();
        //判断当前参数是否以reg 开头

        //如果是判断-1 mod 5 = 0 则找到都

        // IterUtil.toList()

        ArrayList<String> list = Collections.list(parameterNames);
        for (String s : list) {
            System.out.println(s);
        }



        // System.out.println(list);
        System.out.println("=================");
        list.forEach(System.out::println);
        System.out.println("=================");


        List<String> startWithReg = list.stream().filter(s -> s.startsWith("reg")).collect(Collectors.toList());

        for (String s : startWithReg) {

            System.out.println(String.format(request.getParameter("reg")+":%s",s));

        }
        // Log log = LogFactory.get();
        // DateTime timeParsed = DateUtil.parse("2017-01-15", "yyyy-MM-dd");





     /*
        log.info("----------华丽的分割线------------");
        if (list.size()!=0) {
            for (String paramName : list) {

                String value = request.getParameter(paramName);
                String strResult = String.format("paramName:%s,Value:%s", paramName, value);
                log.info(strResult);

            }

        } else {
           log.info("有人访问，但是没有参数。。。。");
        }

      */


        String s = "20150203";
        DateTime parsedDate = DateUtil.parse(s, "yyyyMMdd");
        System.out.println(parsedDate);


        int j = 0;

        for (int i = 0; i < list.size(); i++) {
            j++;

            if ((j - 1) % 5 == 0) {
                //保存对象
                //创建新的对象
                //从数据库中获取数据




            } else {

            }
        }

    }

}
