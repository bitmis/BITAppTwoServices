package com.example.BITAppOneServices.LateralApplicationNo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LateralApplicationNoServiceImpl implements LateralApplicationNoService {


    @Autowired
    private LateralApplicationNoRepository lateralApplicationNoRepository;


    @Override
    public String fetchApplicationStatus(String registration_no) {
        return lateralApplicationNoRepository.fetchLateralApplicationStatus(registration_no);
    }
}
