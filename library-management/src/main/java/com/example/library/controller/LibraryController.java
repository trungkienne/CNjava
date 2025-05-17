package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.entity.Borrow;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibraryController {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BorrowRepository borrowRepo;

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "books";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long bookId, @RequestParam Long userId) {
        Book book = bookRepo.findById(bookId).orElse(null);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            bookRepo.save(book);

            Borrow borrow = new Borrow();
            borrow.setUserId(userId);
            borrow.setBook(book);
            borrowRepo.save(borrow);
        }
        return "redirect:/books";
    }
}
