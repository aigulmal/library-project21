package ru.itgirl.libraryproject21.service;


import ru.itgirl.libraryproject21.dto.UserDto;
import ru.itgirl.libraryproject21.model.User;

public interface UserService {
    UserDto getUserById(Long id);
}
