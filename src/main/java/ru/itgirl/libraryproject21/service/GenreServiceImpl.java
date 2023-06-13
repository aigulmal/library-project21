package ru.itgirl.libraryproject21.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject21.dto.AuthorDto;
import ru.itgirl.libraryproject21.dto.BookDto;
import ru.itgirl.libraryproject21.dto.GenreDto;
import ru.itgirl.libraryproject21.model.Genre;
import ru.itgirl.libraryproject21.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();
        return convertToDto(genre);
    }

    private GenreDto convertToDto(Genre genre) {
        List<BookDto> bookDtoList = genre.getBooks()
                .stream()
                .map(book -> {
                    List<AuthorDto> authorDtoList = book.getAuthors()
                            .stream()
                            .map(author -> AuthorDto.builder()
                                    .id(author.getId())
                                    .name(author.getName())
                                    .surname(author.getSurname())
                                    .build()
                            ).toList();
                    return BookDto.builder()
                            .genre(genre.getName())
                            .authors(authorDtoList)
                            .id(book.getId())
                            .name(book.getName())
                            .build();
                }) .toList();
        return GenreDto.builder()
                .books(bookDtoList)
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }
}
