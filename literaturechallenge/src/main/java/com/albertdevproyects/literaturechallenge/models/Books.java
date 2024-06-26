package com.albertdevproyects.literaturechallenge.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Books(
        String title,
        @JsonAlias("authors") List<Authors> authorsData,
        List<String> languages){
}
