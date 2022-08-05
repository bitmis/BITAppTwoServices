package com.example.BITAppOneServices.DIT.LateralApplicationNo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LateralApplicationNoServiceImpl implements LateralApplicationNoService {


    @Autowired
    private LateralApplicationNoRepository lateralApplicationNoRepository;


    @Override
    public LateralApplicationNo fetchApplicationStatus(String registration_no) {
        return lateralApplicationNoRepository.fetchLateralApplicationStatus(registration_no);
    }

    @Override
    public void saveTempApplicationNo(String registration_no, String year) {

        LateralApplicationNo lateralApplicationNo = new LateralApplicationNo();
        lateralApplicationNo.setApplication_no("xxx");
        lateralApplicationNo.setBit_registration_no(registration_no);
        lateralApplicationNo.setYear(year);
        lateralApplicationNo.setApplication_status("pending");

        LateralApplicationNo exists_L = lateralApplicationNoRepository.findByRegNo(registration_no);
        System.out.println(exists_L+"  *** check if exists");
        if (exists_L == null) {
            lateralApplicationNoRepository.save(lateralApplicationNo);
        }

        LateralApplicationNo tempEntity = lateralApplicationNoRepository.findByRegNo(registration_no);
        System.out.println(tempEntity.getId());

        int id = tempEntity.getId();
        String formatted = String.format("%06d", id);
        //21Y2M000047
        //22Y2M000004
        String correct_application_no = "22Y" + year + "N" + formatted;

        lateralApplicationNoRepository.updateCorrectApplicationNo(correct_application_no, year, registration_no);


    }


}
