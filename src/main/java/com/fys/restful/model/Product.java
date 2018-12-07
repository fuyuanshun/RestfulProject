package com.fys.restful.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class Product  {

    private String name;

    private String decription;
    private List<MultipartFile> musics;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public List<MultipartFile> getMusics() {
        return musics;
    }

    public void setMusics(List<MultipartFile> musics) {
        this.musics = musics;
    }
}
