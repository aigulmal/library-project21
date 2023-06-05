package ru.itgirl.libraryproject21.service;

import ru.itgirl.libraryproject21.dto.AuthorDto;
import ru.itgirl.libraryproject21.dto.BookDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAllAuthors();
}
