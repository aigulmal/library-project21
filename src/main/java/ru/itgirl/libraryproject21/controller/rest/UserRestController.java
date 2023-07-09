package ru.itgirl.libraryproject21.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.libraryproject21.dto.AuthorDto;
import ru.itgirl.libraryproject21.dto.UserDto;
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

}
