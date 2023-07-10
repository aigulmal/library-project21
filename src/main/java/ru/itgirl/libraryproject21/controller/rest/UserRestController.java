package ru.itgirl.libraryproject21.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itgirl.libraryproject21.dto.*;
import ru.itgirl.libraryproject21.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping("user/{id}")
    UserDto getUserById(@PathVariable("id") Long id){return userService.getUserById(id);}

    @GetMapping("/users")
    String getUsersView(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
    @PostMapping("/user/create")
    UserDto createUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.createUser(userCreateDto);
    }
    @PutMapping("/user/update")
    UserDto updateAuthor(@RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateUser(userUpdateDto);
    }
    @DeleteMapping("/user/delete/{id}")
    void updateAuthor(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
