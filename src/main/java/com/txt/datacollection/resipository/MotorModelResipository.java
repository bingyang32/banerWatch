package com.txt.datacollection.resipository;

import com.txt.datacollection.domain.MotorInformation;
import com.txt.datacollection.domain.MotorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorModelResipository extends JpaRepository<MotorModel, Integer> {

}
