package com.albertdevproyects.literaturechallenge.repository;


import com.albertdevproyects.literaturechallenge.models.BooksData;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface BookRepository extends JpaRepository<BooksData, Long> {

    BooksData findByTitle(String title);
    List<BooksData> findByAuthors(String author);
    List<BooksData> findByLanguage(String language);
    
}
