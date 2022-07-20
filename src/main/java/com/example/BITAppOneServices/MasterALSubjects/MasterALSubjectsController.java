package com.example.BITAppOneServices.MasterALSubjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MasterALSubjectsController {


    @Autowired
    private MasterALSubjectsService masterALSubjectsService;

    @GetMapping("/get_al_subjects")
    public List<MasterALSubjects> getALSubjects() {

        System.out.println("gggg");
        return this.masterALSubjectsService.getAllSubjects();

    }

}
