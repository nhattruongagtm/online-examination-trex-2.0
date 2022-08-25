package com.example.trex.onlineexamination.dto;

public class SubjectRequest {
    private String name;
    private String code;

    public SubjectRequest(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public SubjectRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
