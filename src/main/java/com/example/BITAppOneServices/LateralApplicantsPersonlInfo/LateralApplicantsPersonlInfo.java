package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lateral_applicants_personal_info")

public class LateralApplicantsPersonlInfo {

    @Id
    private String application_no;
    private String year;

    private String full_name;
    private String full_name_sinhala;
    private String full_name_tamil;
    private String name_marking;
    private String initials;
    private String title;
    private String gender;
    private String id_type;
    private String id_no;
    private String dob;
    private String citizenship;
    private String nationality;

    private String email;
    private String phone;
    private String mobile;
    private String address1;
    private String address2;
    private String address3;
    private String district;
    private String country;



    private String qualification_type;
    private String qualification_pending;
    private String need_different_req;
    private String al_year;
    private String al_index_no;
    private String al_type;
    private String al_subject1;
    private String al_result1;
    private String al_subject2;
    private String al_result2;
    private String al_subject3;
    private String al_result3;
    private String al_subject4;
    private String al_result4;

    private String ol_year1;
    private String ol_subject1;
    private String ol_result1;
    private String ol_year2;
    private String ol_subject2;
    private String ol_result2;

    private String type;
    private String payment_category;
    private String payment_type;
    private String amount;
    private String over_payment;
    private String surcharge;
    private String bank;
    private String bank_branch;
    private String paid_date;
    private String invoice_no;

    private String fit_registration_no;
    private String bit_registration_no;
    private String disabilities;

    private String application_status;
    private String apply_bit_year;



}
