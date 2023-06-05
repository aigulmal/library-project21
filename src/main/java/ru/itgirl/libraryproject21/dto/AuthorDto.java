package ru.itgirl.libraryproject21.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirl.libraryproject21.model.Book;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthorDto {
    private Long id;
    private String name;
    private String surname;
    private List<BookDto> books;
}
