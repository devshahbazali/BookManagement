package com.example.bookmanagement.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Genre {
    @NotBlank
    private String name;
}
