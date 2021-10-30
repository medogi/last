package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @Column(name = "id")
    int id;
    @Column(name = "First_name")
    String First_name;
    @Column(name = "Last_name")
    String Last_name;
    @Column(name = "Email")
    String Email;
    @Column(name = "Gender")
    String Gender;
    @Column(name = "her_his_book")
    String her_his_book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    Library library;

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
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
