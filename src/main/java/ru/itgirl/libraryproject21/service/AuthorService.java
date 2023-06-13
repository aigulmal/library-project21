package ru.itgirl.libraryproject21.service;

import ru.itgirl.libraryproject21.dto.AuthorCreateDto;
import ru.itgirl.libraryproject21.dto.AuthorDto;
import ru.itgirl.libraryproject21.dto.AuthorUpdateDto;
import ru.itgirl.libraryproject21.dto.BookDto;

import java.util.List;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);

    AuthorDto getAuthorByNameV1(String name);

    AuthorDto getAuthorByNameV2(String name);

    List<AuthorDto> getAuthorByNameV3(String name);

    AuthorDto createAuthor(AuthorCreateDto authorCreateDto);

    AuthorDto updateAuthor(AuthorUpdateDto authorUpdateDto);
    void deleteAuthor(Long id);

    List<AuthorDto> getAllAuthors();
}
