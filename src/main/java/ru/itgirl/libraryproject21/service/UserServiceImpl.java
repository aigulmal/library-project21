package ru.itgirl.libraryproject21.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject21.dto.UserDto;
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

    private UserDto convertEntityToDto(User user){
        return UserDto.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }
}
