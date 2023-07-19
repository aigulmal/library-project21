package ru.itgirl.libraryproject21.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoleDto {
    private Long id;
    private String rolename;
}