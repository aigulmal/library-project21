package ru.itgirl.libraryproject21.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ru.itgirl.libraryproject21.dto.UserDto;
import ru.itgirl.libraryproject21.service.UserService;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserService userService;
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/book").hasRole("USER")
                                .requestMatchers("/book/v2").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .httpBasic();

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService users() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDto userDto1 = userService.getUserById(1L);
        UserDto userDto2 = userService.getUserById(2L);

        List<String> userRoles1 = userDto1.getRoles();
        String[] roles1= new String[userRoles1.size()];


        UserDetails user1 = users
                .username(userDto1.getLogin())
                .password(userDto1.getPassword())
                .roles(userRoles1.toArray(roles1))
                .build();

        List<String> userRoles2 = userDto2.getRoles();
        String[] roles2= new String[userRoles2.size()];

        UserDetails user2 = users
                .username(userDto2.getLogin())
                .password(userDto2.getPassword())
                .roles(userRoles2.toArray(roles2))
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
