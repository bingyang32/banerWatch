package com.txt.datacollection.resipository;

import com.txt.datacollection.domain.MotorModel;
import com.txt.datacollection.domain.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteResipository extends JpaRepository<Site, Integer> {

}
