package com.txt.datacollection.resipository;

import com.txt.datacollection.domain.MotorInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoInformationResipository extends JpaRepository<MotorInformation, String> {
        MotorInformation findMotorInformationByIpAndRegStartId(String ip, String startId);
}
