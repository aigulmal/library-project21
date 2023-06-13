package ru.itgirl.libraryproject21.service;

import ru.itgirl.libraryproject21.dto.GenreDto;

public interface GenreService {
    GenreDto getGenreById(Long id);
}