package com.example.BITAppOneServices.Images;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

   public interface ImagesRepository extends JpaRepository<ImageModel, Long> {
        Optional<ImageModel> findByName(String name);


   }

