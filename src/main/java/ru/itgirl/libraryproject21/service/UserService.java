package ru.itgirl.libraryproject21.service;


import ru.itgirl.libraryproject21.dto.AuthorDto;
import ru.itgirl.libraryproject21.dto.UserDto;
import ru.itgirl.libraryproject21.model.Author;
import ru.itgirl.libraryproject21.model.User;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
}
