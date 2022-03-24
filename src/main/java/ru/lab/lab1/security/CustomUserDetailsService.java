package ru.lab.lab1.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.lab.lab1.model.IMDBUser;
import ru.lab.lab1.repository.IMDBUserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final IMDBUserRepository imdbUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        IMDBUser imdbUser = imdbUserRepository.findIMDBUserByLogin(username).orElseThrow(() -> new UsernameNotFoundException("Неизвестный пользователь."));
        return User.builder()
                .username(imdbUser.getLogin())
                .password(imdbUser.getPassword())
                .roles(imdbUser.getRole().getName())
                .build();
    }
}