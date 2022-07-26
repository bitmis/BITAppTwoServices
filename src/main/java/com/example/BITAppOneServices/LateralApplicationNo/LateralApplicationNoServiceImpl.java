package com.example.BITAppOneServices.LateralApplicationNo;

import org.springframework.stereotype.Service;

@Service
public class LateralApplicationNoServiceImpl {

    private LateralApplicationNoRepository lateralApplicationNoRepository;

   
    public String fetchApplicationStatus(String registration_no) {
        return lateralApplicationNoRepository.fetchLateralApplicationStatus(registration_no);
    }
}
