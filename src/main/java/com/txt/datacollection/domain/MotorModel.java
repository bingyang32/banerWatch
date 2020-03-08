package com.txt.datacollection.domain;

import lombok.Data;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ClassName MotorModel
 * @Description
 * @Author hysys
 * @Date 2020-03-08 15:31
 **/
@Entity
@Data
public class MotorModel {
    @Id
    @GeneratedValue
    //马达型号ID
    private Integer id;
    private String name;
    private Double xLower;
    private Double xUpper;
    private Double zUper;
    private Double zLower;
    private Double cUpper;
    private Double cLower;


}
