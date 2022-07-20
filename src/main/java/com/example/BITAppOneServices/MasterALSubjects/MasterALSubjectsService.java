package com.example.BITAppOneServices.MasterALSubjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterALSubjectsService {

    @Autowired
    private MasterALSubjectsRepository repository;

    public List<MasterALSubjects> getAllSubjects(){

        return repository.findAll();


    }
}
