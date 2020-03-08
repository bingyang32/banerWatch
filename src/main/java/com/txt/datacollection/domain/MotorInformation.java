package com.txt.datacollection.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName MotorInformation
 * @Description
 * @Author hysys
 * @Date 2020-03-08 15:29
 **/
@Data
@Entity
public class MotorInformation {
    @Id
    private String regId;
    //马达型号ID
    private String motorId;
    private String name;
    private String ip;
}
