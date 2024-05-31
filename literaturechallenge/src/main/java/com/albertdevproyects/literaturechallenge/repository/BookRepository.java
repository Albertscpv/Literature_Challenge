package com.albertdevproyects.literaturechallenge.repository;

import com.albertdevproyects.literaturechallenge.models.Books;
import com.albertdevproyects.literaturechallenge.models.BooksData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookRepository extends JpaRepository<BooksData, Long> {

    List<BooksData> findByTitle(String title);
    List<BooksData> findByAuthors(String author);
    List<BooksData> findByLanguage(String language);
    
}
