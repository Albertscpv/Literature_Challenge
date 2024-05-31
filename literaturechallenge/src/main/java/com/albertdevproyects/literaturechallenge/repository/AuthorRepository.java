package com.albertdevproyects.literaturechallenge.repository;

import com.albertdevproyects.literaturechallenge.models.AuthorsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorsData, Long> {
    AuthorsData findByName(String name);

    @Query("SELECT a FROM AuthorsData a WHERE a.birth_date >= :date")
    List<AuthorsData> aliveSince(@Param("date")String date);
}
