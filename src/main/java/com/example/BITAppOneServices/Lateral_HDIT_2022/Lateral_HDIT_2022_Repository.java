package com.example.BITAppOneServices.Lateral_HDIT_2022;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Lateral_HDIT_2022_Repository extends JpaRepository<Lateral_HDIT_2022, String> {

    @Query("select l from Lateral_HDIT_2022 l where l.registration_no = ?1 and l.id_no = ?2")
    Lateral_HDIT_2022 findByRegNoandNIC(String registration_no, String id_no);


}
