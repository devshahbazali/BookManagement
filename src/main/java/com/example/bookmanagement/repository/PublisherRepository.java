package com.example.bookmanagement.repository;

import com.example.bookmanagement.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
