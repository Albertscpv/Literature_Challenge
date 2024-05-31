package com.albertdevproyects.literaturechallenge.models;

import jakarta.persistence.*;

import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class BooksData{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToOne
    private AuthorsData authorsData;

    public BooksData(){}

    public BooksData(Books books) {
        this.title = books.title();
        this.language = Language.fromString(books.languages().stream().limit(1).collect(Collectors.joining()));
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public AuthorsData getAuthorsData() {
        return authorsData;
    }

    public void setAuthorsData(AuthorsData authorsData) {
        this.authorsData = authorsData;
    }
}
