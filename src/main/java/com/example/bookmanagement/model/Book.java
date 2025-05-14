package com.example.bookmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @Embedded
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    // Getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public Genre getGenre() { return genre; }

    public void setGenre(Genre genre) { this.genre = genre; }

    public Publisher getPublisher() { return publisher; }

    public void setPublisher(Publisher publisher) { this.publisher = publisher; }
}
