package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    // List all publishers
    @GetMapping
    public String listPublishers(Model model) {
        model.addAttribute("publishers", publisherService.findAll());
        return "publishers/list";
    }

    // Create a new publisher
    @GetMapping("/new")
    public String createPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publishers/form";
    }

    @PostMapping
    public String savePublisher(@ModelAttribute @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "publishers/form";
        }
        publisherService.save(publisher);
        return "redirect:/publishers";
    }

    // Edit an existing publisher
    @GetMapping("/edit/{id}")
    public String editPublisher(@PathVariable Long id, Model model) {
        Publisher publisher = publisherService.findById(id);
        model.addAttribute("publisher", publisher);
        return "publishers/form";
    }

    // Delete a publisher
    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.delete(id);
        return "redirect:/publishers";
    }
}
