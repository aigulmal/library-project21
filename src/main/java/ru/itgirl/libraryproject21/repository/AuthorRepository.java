package ru.itgirl.libraryproject21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.itgirl.libraryproject21.model.Author;
import ru.itgirl.libraryproject21.model.Book;

public interface AuthorRepository extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Book> {
}
