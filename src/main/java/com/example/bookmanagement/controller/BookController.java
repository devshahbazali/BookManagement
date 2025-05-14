package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.model.Genre;
import com.example.bookmanagement.model.Publisher;
import com.example.bookmanagement.service.BookService;
import com.example.bookmanagement.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;

    private List<Genre> genreOptions = Arrays.asList(
        new Genre("Fiction"),
        new Genre("Non-Fiction"),
        new Genre("Science Fiction"),
        new Genre("Biography"),
        new Genre("Fantasy")
    );

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("genres", genreOptions);
        model.addAttribute("publishers", publisherService.findAll());
        return "books/form";
    }

    @PostMapping
    public String save(@ModelAttribute @Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("genres", genreOptions);
            model.addAttribute("publishers", publisherService.findAll());
            return "books/form";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("genres", genreOptions);
        model.addAttribute("publishers", publisherService.findAll());
        return "books/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
