package com.txt.datacollection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName MotorLog
 * @Description
 * @Author hysys
 * @Date 2020-03-08 16:44
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorLog {
    @Id
    @GeneratedValue
    private Integer id;
    private String ip;
    private Double z;
    private Double x;
    //温度
    private Double c;
    //z加速度
    private Double zUpperAs;
    //x加速度
    private Double xas;
    //zLower
    private Double zLowerAs;
    private LocalDateTime time;
    private String regStartId;



}
