package ru.example.bookuser.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.example.bookuser.entity.User;
import ru.example.bookuser.repository.UserRepository;

@Service
public class UserPrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserPrincipalDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(s);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
