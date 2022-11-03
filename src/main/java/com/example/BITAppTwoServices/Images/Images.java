package com.example.BITAppTwoServices.Images;


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
@Table(name = "lateral_images")

public class Images {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String type;

    private String application_no;

    private String image_name;

    @Column(name = "image", unique = false, nullable = false, length = 100000)
    private byte[] image;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApplication_no() {
        return application_no;
    }

    public void setApplication_no(String application_no) {
        this.application_no = application_no;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
