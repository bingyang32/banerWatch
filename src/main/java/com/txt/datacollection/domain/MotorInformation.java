package com.txt.datacollection.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private Integer id;
    private String regStartId;
    private String ip;
    //马达型号ID
    private Integer motorId;
    private String line;
    private String name;
}
