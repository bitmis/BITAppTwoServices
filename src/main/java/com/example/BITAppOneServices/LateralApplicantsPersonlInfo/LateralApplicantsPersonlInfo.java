package com.example.BITAppOneServices.LateralApplicantsPersonlInfo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
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
    @Column(length = 20)
    private String application_no;
    @Column(length = 10)
    private String year;
    @Column(length = 150)
    private String full_name;
    @Column(length = 150)
    private String full_name_sinhala;
    @Column(length = 150)
    private String full_name_tamil;
    @Column(length = 50)
    private String name_marking;
    @Column(length = 20)
    private String initials;
    @Column(length = 20)
    private String title;
    @Column(length = 20)
    private String gender;
    @Column(length = 20)
    private String id_type;
    @Column(length = 20)
    private String id_no;
    @Column(length = 20)
    private String dob;
    @Column(length = 20)
    private String citizenship;
    @Column(length = 20)
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
