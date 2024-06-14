package com.albertdevproyects.literaturechallenge.repository;

import com.albertdevproyects.literaturechallenge.models.AuthorsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorRepository extends JpaRepository<AuthorsData, Long> {
    AuthorsData findByName(String name);
}
