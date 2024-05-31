package com.albertdevproyects.literaturechallenge.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
public class AuthorsData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String name;
    private String birth_year;
    private String death_year;
    @OneToMany(mappedBy = "authorsData", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<BooksData> booksDataList;

    public AuthorsData(){}

    public AuthorsData(Authors authors) {
        this.name = authors.name();
        this.birth_year = authors.birth_year();
        this.death_year = authors.death_year();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getDeath_year() {
        return death_year;
    }

    public void setDeath_year(String death_year) {
        this.death_year = death_year;
    }

    public List<BooksData> getBooksDataList() {
        return booksDataList;
    }

    public void setBooksDataList(List<BooksData> booksDataList) {
        this.booksDataList = booksDataList;
    }

    @Override
    public String toString() {
        return "AuthorsData{" +
                ", name='" + name + '\'' +
                ", birth_year='" + birth_year + '\'' +
                ", death_year='" + death_year + '\'' +
                ", booksDataList=" + booksDataList;
    }
}
