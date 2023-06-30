package ru.itgirl.libraryproject21.controller.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.libraryproject21.dto.AuthorDto;
import ru.itgirl.libraryproject21.service.AuthorService;

@Controller
@RequiredArgsConstructor
public class AuthorRestController {
        private final AuthorService authorService;
        @GetMapping("/author/{id}")
        AuthorDto getAuthorById(@PathVariable("id") Long id) {
            return authorService.getAuthorById(id);
        }
        @GetMapping("/authors")
        String getAuthorsView(Model model) {
            model.addAttribute("authors", authorService.getAllAuthors());
            return "authors";
        }
}
