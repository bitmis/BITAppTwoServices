package com.example.BITAppOneServices.LateralApplicationNo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LateralApplicationNoRepository extends JpaRepository<LateralApplicationNo,Integer> {

    @Query("select l.bit_registration_no from LateralApplicationNo l where l.bit_registration_no = ?1")
    String fetchLateralApplicationStatus(String bit_registration_no);
}
