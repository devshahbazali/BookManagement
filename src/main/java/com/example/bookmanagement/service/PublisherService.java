package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    public Publisher findById(Long id) {
    return publisherRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Publisher not found with id " + id));
}

    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void delete(Long id) {
        publisherRepository.deleteById(id);
    }
}
