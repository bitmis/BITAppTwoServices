package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LateralApplicantsPersonlInfoRepository extends JpaRepository<LateralApplicantsPersonlInfo ,String> {


    @Query("select l.application_status from LateralApplicantsPersonlInfo l where l.application_no = ?1")
    String fetchLateralApplicationStatus(String application_no);
}
