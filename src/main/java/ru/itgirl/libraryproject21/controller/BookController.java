package ru.itgirl.libraryproject21.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.libraryproject21.dto.BookDto;
import ru.itgirl.libraryproject21.service.BookService;
@Controller
@RequiredArgsConstructor
public class BookController {
//    private final BookService bookService;
//
//    @GetMapping("/books")
//    String getBooksView(Model model) {
//        model.addAttribute("books", bookService.getAllBooks());
//        return "books";
//    }
}