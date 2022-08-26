package com.example.trex.onlineexamination.dto;

public class AuthDTO {
    private Long id;
    private int type;
    private String name;
    private String photoUrl;

    public AuthDTO(Long id, int type, String name, String photoUrl) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public AuthDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }
    //
//    public int getType() {
//        return type;
//    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}

