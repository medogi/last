package com.example.demo;

public class Library {
    private int id;
    private int number_of_pages;
    private String author_name;
    private int publish_date;
    private String name;

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
