package com.example.bookmanagement.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Genre {

    @NotBlank
    private String name;

    public Genre() {}

    public Genre(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
