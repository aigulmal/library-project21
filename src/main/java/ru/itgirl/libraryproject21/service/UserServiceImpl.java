package ru.itgirl.libraryproject21.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject21.dto.*;
import ru.itgirl.libraryproject21.model.Author;
import ru.itgirl.libraryproject21.model.Book;
import ru.itgirl.libraryproject21.model.User;
import ru.itgirl.libraryproject21.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return convertEntityToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }
    @Override
    public UserDto createUser(UserCreateDto userCreateDto) {
        User user = userRepository.save(convertDtoToEntity(userCreateDto));
        UserDto userDto = convertEntityToDto(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(userUpdateDto.getId()).orElseThrow();
        user.
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
    private User convertDtoToEntity(UserCreateDto authorCreateDto) {
        return Author.builder()
                .name(authorCreateDto.getName())
                .surname(authorCreateDto.getSurname())
                .build();
    }
    private UserDto convertEntityToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }
}
