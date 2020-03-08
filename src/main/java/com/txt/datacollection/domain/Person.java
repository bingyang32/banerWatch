package com.txt.datacollection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ClassName Person
 * @Description
 * @Author hysys
 * @Date 2020-03-08 14:37
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String gender;
    private String remark;


}
