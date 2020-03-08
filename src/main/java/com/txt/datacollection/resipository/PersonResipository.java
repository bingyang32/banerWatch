package com.txt.datacollection.resipository;

import com.txt.datacollection.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName PersonResipository
 * @Description
 * @Author hysys
 * @Date 2020-03-08 14:39
 **/
public interface PersonResipository extends JpaRepository<Person,Integer> {


}
