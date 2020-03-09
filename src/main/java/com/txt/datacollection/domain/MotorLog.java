package com.txt.datacollection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String c;
    private String y;
    private String z;
    private String xas;
    private String yas;
    private LocalDateTime time;
    private String regStartId;



}
