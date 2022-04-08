package uz.pdp.asilbekfayzullayevvariant1.repository;

//Asilbek Fayzullayev 08.04.2022 11:08   

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.asilbekfayzullayevvariant1.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
