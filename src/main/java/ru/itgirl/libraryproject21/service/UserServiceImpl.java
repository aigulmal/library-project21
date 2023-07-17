package ru.itgirl.libraryproject21.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject21.dto.*;
import ru.itgirl.libraryproject21.model.User;
import ru.itgirl.libraryproject21.repository.UserRepository;

import java.util.HashMap;
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
    public UserDto getByName(String username) {
        User user = userRepository.findUsersByUsername(username).orElseThrow();
        return convertEntityToDto(user);
    }
    public HashMap<String, String> getInformationAboutUserAsHashMap(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        HashMap<String, String> userData = new HashMap<>();
        userData.put("username", user.getLogin());
        userData.put("password", user.getPassword());
        userData.put("roles", getRolesAsString(user));
        return userData;
    }

    private List<String> getRolesAsStringList(User user) {
        UserDto userDto = convertEntityToDto(user);
        return userDto.getRoles().stream().map().toList();

    }
    private String getRolesAsString(User user) {
        UserDto userDto = convertEntityToDto(user);
        List<String> roles = userDto.getRoles().stream().map(RoleDto::getRolename).toList();
        return roles.toString();
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
        user.setLogin(userUpdateDto.getLogin());
        user.setPassword(user.getPassword());
        User savedUser = userRepository.save(user);
        UserDto userDto = convertEntityToDto(savedUser);
        return userDto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    private User convertDtoToEntity(UserCreateDto user) {
        List<RoleDto> rolesDto = user.getRoles().stream().
                map(role -> RoleDto.builder().
                        id(role.getId()).
                        rolename(role.getRolename()).
                        build()).
                toList();

        return UserDto.builder().
                id(user.getId()).
                login(user.getLogin()).
                password(user.getPassword()).
                roles(rolesDto).
                build();
    }

    private UserDto convertEntityToDto(User user) {
        List<RoleDto> rolesDto = user.getRoles().stream().
                map(role -> RoleDto.builder().
                        id(role.getId()).
                        rolename(role.getRolename()).
                        build()).
                toList();

        return UserDto.builder().
                id(user.getId()).
                login(user.getLogin()).
                password(user.getPassword()).
                roles(rolesDto.stream().map(RoleDto::getRolename).toList()).
                build();
    }
}
