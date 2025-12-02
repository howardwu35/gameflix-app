package org.example.gameflix.model;

public class Movie {
    private int id;
    private String title;
    private String description;
    private int year;

    public Movie(int id, String title, String description, int year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }
}