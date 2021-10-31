package com.example.demo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorDTO {
    private int id;
    @JsonProperty("First_name")
    private String First_name;
    @JsonProperty("Last_name")
    private String Last_name;
    @JsonProperty("Email")
    private String Email;
    @JsonProperty("Gender")
    private String Gender;
    private String her_his_book;
    private String libraryId;

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getHer_his_book() {
        return her_his_book;
    }

    public void setHer_his_book(String her_his_book) {
        this.her_his_book = her_his_book;
    }
}
