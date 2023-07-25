package ru.itgirl.libraryproject21.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itgirl.libraryproject21.model.Roles;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCreateDto {
    private Long id;
    private String login;
    private String password;
    private List<Roles> roles;
}
