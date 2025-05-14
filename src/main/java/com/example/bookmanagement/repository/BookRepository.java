package com.example.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmanagement.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}