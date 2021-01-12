package com.hotinterviewquestions.rest.webservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hotinterviewquestions.rest.webservices.entity.User;
import com.hotinterviewquestions.rest.webservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;

        try {
            user = this.userRepository.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
            }
        } catch (IncorrectResultSizeDataAccessException e) {
            System.out.println(e.getMessage());
        }

        return new JwtUserDetails(user);
    }

}