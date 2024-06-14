package com.albertdevproyects.literaturechallenge.repository;


import com.albertdevproyects.literaturechallenge.models.BooksData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BooksData, Long> {

    BooksData findByTitle(String title);
    List<BooksData> findByLanguages(String languages);
    
}
