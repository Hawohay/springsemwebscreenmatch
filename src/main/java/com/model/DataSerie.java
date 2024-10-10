package com.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSerie(@JsonAlias("Title") String title,
                        @JsonAlias("totalSeason")Integer totalSeasons,
                        @JsonAlias("imdbRating")String reviews) {

}
