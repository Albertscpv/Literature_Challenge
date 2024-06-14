package com.albertdevproyects.literaturechallenge.models;

import com.albertdevproyects.literaturechallenge.repository.BookRepository;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class BooksData  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;

    @Enumerated(EnumType.STRING)
    private Languages languages;

    @ManyToOne
    private @JsonAlias("authors") AuthorsData authorsData;

    public BooksData(){}

    public BooksData(Books books) {
        this.title = books.title();
        this.languages = Languages.fromString(books.languages().stream().limit(1).collect(Collectors.joining()));
    }

    @Override
    public String toString() {
        return "BooksData{" +
                ", title='" + title + '\'' +
                ", languages=" + languages +
                ", authorsData=" + authorsData +
                '}';
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

    public Languages getLanguage() {
        return languages;
    }

    public void setLanguage(Languages language) {
        this.languages = language;
    }

    public AuthorsData getAuthorsData() {
        return authorsData;
    }

    public void setAuthorsData(AuthorsData authorsData) {
        this.authorsData = authorsData;
    }
}
