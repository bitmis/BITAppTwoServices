package com.example.BITAppTwoServices.Images;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

   public interface ImagesRepository extends JpaRepository<ImageModel, Long> {
        Optional<ImageModel> findByName(String name);


   }

