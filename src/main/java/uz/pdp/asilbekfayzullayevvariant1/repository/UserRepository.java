package uz.pdp.asilbekfayzullayevvariant1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.asilbekfayzullayevvariant1.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);
}
