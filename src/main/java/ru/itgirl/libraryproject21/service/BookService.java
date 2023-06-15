package ru.itgirl.libraryproject21.service;

import ru.itgirl.libraryproject21.dto.BookDto;

import java.util.List;

public interface BookService {

    BookDto getByNameV1(String name);

    BookDto getByNameV2(String name);

    BookDto getByNameV3(String name);

    BookDto getBookById(Long id);
    void deleteBook(Long id);

    List<BookDto> getAllBooks();

}
