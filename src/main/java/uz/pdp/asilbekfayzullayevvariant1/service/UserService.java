package uz.pdp.asilbekfayzullayevvariant1.service;

//Asilbek Fayzullayev 08.04.2022 10:07   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.asilbekfayzullayevvariant1.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return   userRepository.findByUsername(username).orElseThrow(() ->
                new IllegalStateException(String.format("Username not found!",username)));
    }
}
