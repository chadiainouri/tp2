package com.example.tp2.models;

public class Article {

    private int id;
    private String title;
    private String body;

    public Article(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public String getBody() { return body; }

    public String getImageUrl() {
        return "https://picsum.photos/seed/" + id + "/200/200";
    }
}
