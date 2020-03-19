package com.txt.datacollection.service;

import com.txt.datacollection.domain.MotorInformation;
import com.txt.datacollection.resipository.MotoInformationResipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MotroLogDto
 * @Description
 * @Author hysys
 * @Date 2020-03-08 17:46
 **/
@Service
public class MotroInformationService {

    @Autowired
    MotoInformationResipository motoInformationResipository;

    MotorInformation getMotoInformationByRedId(String regId) {
        return motoInformationResipository.getOne(regId);
    }


    MotorInformation findMotorInformationByipAndRegStartId(String ip, String startId) {
        return motoInformationResipository.findMotorInformationByIpAndRegStartId(ip, startId);
    }

}
