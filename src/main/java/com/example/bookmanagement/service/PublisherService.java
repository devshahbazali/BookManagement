
package com.example.bookmanagement.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookmanagement.model.Publisher;

@Service
public class PublisherService {
    @Autowired private com.example.bookmanagement.repository.PublisherRepository publisherRepository;
    public List<Publisher> findAll() { return publisherRepository.findAll(); }
    public Publisher save(Publisher publisher) { return publisherRepository.save(publisher); }
    public Publisher findById(Long id) { return publisherRepository.findById(id).orElse(null); }
    public void delete(Long id) { publisherRepository.deleteById(id); }
}