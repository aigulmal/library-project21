package ru.itgirl.libraryproject21.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject21.dto.AuthorDto;
import ru.itgirl.libraryproject21.dto.BookDto;
import ru.itgirl.libraryproject21.model.Author;
import ru.itgirl.libraryproject21.model.Book;
import ru.itgirl.libraryproject21.repository.AuthorRepository;
import ru.itgirl.libraryproject21.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> books = authorRepository.findAll();
        return books.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
    private AuthorDto convertEntityToDto(Author author){
        List<BookDto> bookDtoList = null;
        if (author.getBooks() != null) {
            bookDtoList = author.getBooks()
                    .stream()
                    .map(book -> BookDto.builder()
                            .genre(book.getGenre().getName())
                            .name(book.getName())
                            .id(book.getId())
                            .build())
                    .toList();
        }
        return AuthorDto.builder()
                .id(author.getId())
                .surname(author.getSurname())
                .name(author.getName())
                .books(bookDtoList)
                .build();
    }
}
