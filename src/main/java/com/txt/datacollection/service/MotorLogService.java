package com.txt.datacollection.service;

import com.txt.datacollection.domain.MotorLog;
import com.txt.datacollection.resipository.MotorLogResipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MotorLogService
 * @Description
 * @Author hysys
 * @Date 2020-03-08 17:46
 **/
@Service
public class MotorLogService {

    @Autowired
    MotorLogResipository motorLogResipository;

    public MotorLog save(MotorLog motorLog) {
        return motorLogResipository.save(motorLog);
    }



}
