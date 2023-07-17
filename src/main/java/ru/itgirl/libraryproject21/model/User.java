package ru.itgirl.libraryproject21.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Setter
    private String login;

    @Column(nullable = false)
    @Setter
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    @Setter
    @Getter
    private Set<Roles> roles;
}
