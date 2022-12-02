package com.example.moviemanager.requests;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Getter
public class EditMovieRequest {

    @NotBlank
    private String newName;
    @NotBlank
    private String genre;
    private int year;
    @Min(value = 1)
    @Max(value = 10)
    private int rating;
}
