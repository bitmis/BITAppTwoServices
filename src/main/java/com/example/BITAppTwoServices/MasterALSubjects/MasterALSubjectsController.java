package com.example.BITAppTwoServices.MasterALSubjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "/api")
@RestController
public class MasterALSubjectsController {


    @Autowired
    private MasterALSubjectsService masterALSubjectsService;

    @GetMapping("/get_al_subjects")
    public List<MasterALSubjects> getALSubjects() {

        System.out.println("calling AL Subjects");
        return this.masterALSubjectsService.getAllSubjects();

    }

}
