package uz.pdp.asilbekfayzullayevvariant1.repository;

//Asilbek Fayzullayev 08.04.2022 8:53   

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.asilbekfayzullayevvariant1.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
