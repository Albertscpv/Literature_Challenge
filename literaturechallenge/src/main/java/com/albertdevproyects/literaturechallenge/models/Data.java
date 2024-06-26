package com.albertdevproyects.literaturechallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Data(
        List<Books> results
) {

}
