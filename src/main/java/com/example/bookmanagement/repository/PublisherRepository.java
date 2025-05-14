package com.example.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmanagement.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {}