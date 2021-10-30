package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="public.libra")
public class Library {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="number_of_pages")
    private int number_of_pages;
    @Column(name="author_name")
    private String author_name;
    @Column(name="publish_date")
    private int publish_date;
    @Column(name="name")
    private String name;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "library")
    private List<Author> authors;

    public Library(int number_of_pages, String author_name, int publish_date, String name) {
        this.number_of_pages = number_of_pages;
        this.author_name = author_name;
        this.publish_date = publish_date;
        this.name = name;
    }

    public Library() {

    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(int publish_date) {
        this.publish_date = publish_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
