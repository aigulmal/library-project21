package ru.itgirl.libraryproject21.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCreateDto {
    private Long id;
    private String login;
    private String password;
    private List<RoleDto> roles;
}
