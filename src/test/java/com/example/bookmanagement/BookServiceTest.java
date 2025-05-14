package com.example.bookmanagement;


import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.model.Genre;
import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.repository.BookRepository;
import com.example.bookmanagement.service.BookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book sampleBook;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("Test Publisher");
        publisher.setAddress("123 Main St");

        sampleBook = new Book();
        sampleBook.setId(1L);
        sampleBook.setTitle("Sample Book");
        sampleBook.setAuthor("Author Name");
        sampleBook.setGenre(new Genre("Fiction"));
        sampleBook.setPublisher(publisher);
    }

    @Test
    void testSaveBook() {
        bookService.save(sampleBook);
        verify(bookRepository, times(1)).save(sampleBook);
    }

    @Test
    void testFindAll() {
        when(bookRepository.findAll()).thenReturn(List.of(sampleBook));
        List<Book> result = bookService.findAll();
        assertEquals(1, result.size());
        assertEquals("Sample Book", result.get(0).getTitle());
    }

    @Test
    void testFindByIdExists() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(sampleBook));
        Book result = bookService.findById(1L);
        assertEquals("Sample Book", result.getTitle());
    }

    @Test
    void testFindByIdNotFound() {
        when(bookRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> bookService.findById(2L));
    }

    @Test
    void testDelete() {
        bookService.delete(1L);
        verify(bookRepository).deleteById(1L);
    }
}
