package com.example.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.repository.BookRepository;

@Service
public class BookService {
    @Autowired private BookRepository bookRepository;
    public List<Book> findAll() { return bookRepository.findAll(); }
    public Book save(Book book) { return bookRepository.save(book); }
    public Book findById(Long id) { return bookRepository.findById(id).orElse(null); }
    public void delete(Long id) { bookRepository.deleteById(id); }
}