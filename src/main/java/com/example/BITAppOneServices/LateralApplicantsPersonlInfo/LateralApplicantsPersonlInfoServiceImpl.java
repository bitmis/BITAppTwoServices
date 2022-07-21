package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LateralApplicantsPersonlInfoServiceImpl implements LateralApplicantsPersonlInfoService {


    @Autowired
    private LateralApplicantsPersonlInfoRepository lateralApplicantsPersonlInfoRepository;

    // Save operation
    @Override
    public LateralApplicantsPersonlInfo saveLateralApplicantsPersonlInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo) {
        return lateralApplicantsPersonlInfoRepository.save(lateralApplicantsPersonlInfo);
    }

    // Read operation
    @Override
    public LateralApplicantsPersonlInfo fetchLateralApplicantsPersonlInfo(String application_no) {
        return lateralApplicantsPersonlInfoRepository.findById(application_no).get();
    }

    // Update operation
    @Override
    public LateralApplicantsPersonlInfo
    updateLateralApplicantsPersonlInfo(LateralApplicantsPersonlInfo lateralApplicantsPersonlInfo,
                                       String application_no) {
        LateralApplicantsPersonlInfo db_info
                = lateralApplicantsPersonlInfoRepository.findById(application_no)
                .get();

        if (Objects.nonNull(lateralApplicantsPersonlInfo.getFull_name())
                && !"".equalsIgnoreCase(
                lateralApplicantsPersonlInfo.getFull_name())) {
            db_info.setFull_name(
                    lateralApplicantsPersonlInfo.getFull_name());
        }


        return lateralApplicantsPersonlInfoRepository.save(db_info);
    }

    // Delete operation
    @Override
    public void deleteLateralApplicantsPersonlInfoById(String application_no) {
        lateralApplicantsPersonlInfoRepository.deleteById(application_no);
    }


}
