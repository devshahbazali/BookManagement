package com.example.bookmanagement;


import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.repository.PublisherRepository;
import com.example.bookmanagement.service.PublisherService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PublisherServiceTest {

    @Mock
    private PublisherRepository publisherRepository;

    @InjectMocks
    private PublisherService publisherService;

    private Publisher publisher;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("O'Reilly");
        publisher.setAddress("123 Tech Lane");
    }

    @Test
    void testSave() {
        publisherService.save(publisher);
        verify(publisherRepository).save(publisher);
    }

    @Test
    void testFindAll() {
        when(publisherRepository.findAll()).thenReturn(List.of(publisher));
        List<Publisher> result = publisherService.findAll();
        assertEquals(1, result.size());
        assertEquals("O'Reilly", result.get(0).getName());
    }

    @Test
    void testFindByIdExists() {
        when(publisherRepository.findById(1L)).thenReturn(Optional.of(publisher));
        Publisher result = publisherService.findById(1L);
        assertEquals("O'Reilly", result.getName());
    }

    @Test
    void testFindByIdNotFound() {
        when(publisherRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> publisherService.findById(99L));
    }

    @Test
    void testDelete() {
        publisherService.delete(1L);
        verify(publisherRepository).deleteById(1L);
    }
}

