package ru.itgirl.libraryproject21.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itgirl.libraryproject21.dto.AuthorCreateDto;
import ru.itgirl.libraryproject21.dto.AuthorDto;
import ru.itgirl.libraryproject21.service.AuthorService;
import ru.itgirl.libraryproject21.service.BookService;

@Controller
@RequiredArgsConstructor
public class AuthorController
{

}
