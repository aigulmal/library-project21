package ru.itgirl.libraryproject21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.libraryproject21.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
