package ru.itgirl.libraryproject21.controller.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itgirl.libraryproject21.dto.AuthorCreateDto;
import ru.itgirl.libraryproject21.dto.AuthorDto;
import ru.itgirl.libraryproject21.dto.AuthorUpdateDto;
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
    @PostMapping("/author/create")
    AuthorDto createAuthor(@RequestBody AuthorCreateDto authorCreateDto) {
        return authorService.createAuthor(authorCreateDto);
    }
    @PutMapping("/author/update")
    AuthorDto updateAuthor(@RequestBody AuthorUpdateDto authorUpdateDto) {
        return authorService.updateAuthor(authorUpdateDto);
    }
    @DeleteMapping("/author/delete/{id}")
    void updateAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
    }
}
