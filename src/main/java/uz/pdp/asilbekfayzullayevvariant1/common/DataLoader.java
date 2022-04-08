package uz.pdp.asilbekfayzullayevvariant1.common;

//Asilbek Fayzullayev 08.04.2022 11:08   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.asilbekfayzullayevvariant1.model.Book;
import uz.pdp.asilbekfayzullayevvariant1.model.Role;
import uz.pdp.asilbekfayzullayevvariant1.model.User;
import uz.pdp.asilbekfayzullayevvariant1.repository.BookRepository;
import uz.pdp.asilbekfayzullayevvariant1.repository.RoleRepository;
import uz.pdp.asilbekfayzullayevvariant1.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BookRepository bookRepository;


    public void run(String... args) throws Exception {
        bookRepository.save(new Book("book1", 12000.5));

        bookRepository.save(new Book("book2", 17500.5));

        bookRepository.save(new Book("book3", 22500.9));


        Role role_user = roleRepository.save(new Role("ROLE_USER"));
        Role role_admin = roleRepository.save(new Role("ROLE_ADMIN"));
        Role role_super_admin = roleRepository.save(new Role("ROLE_SUPER_ADMIN"));

        Set<Role> roles = new HashSet<>();

        roles.add(role_admin);
        roles.add(role_user);
        roles.add(role_super_admin);


        userRepository.save(new User(
                "user",
                "user",
                passwordEncoder.encode("1"),
                Collections.singleton(role_user)));

        userRepository.save(new User(
                "admin",
                "admin",
                passwordEncoder.encode("2"),
                Collections.singleton(role_admin)));

        userRepository.save(new User(
                "super_admin",
                "super_admin",
                passwordEncoder.encode("3"),
                Collections.singleton(role_user)));
    }

}
