package ru.itgirl.libraryproject21.controller.rest;

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
public class BookRestController {
    private final BookService bookService;
    @GetMapping("/book")
    BookDto getBookByName(@RequestParam("name") String name) {
        return bookService.getByNameV1(name);
    }
    @GetMapping("/book/v2")
    BookDto getBookByNameV2(@RequestParam("name") String name) {
        return bookService.getByNameV2(name);
    }
    @GetMapping("/book/v3")
    BookDto getBookByNameV3(@RequestParam("name") String name) {
        return bookService.getByNameV3(name);
    }

    @GetMapping("/books")
    String getBooksView(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }
}
