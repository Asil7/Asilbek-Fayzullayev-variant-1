package uz.pdp.asilbekfayzullayevvariant1.controller;

//Asilbek Fayzullayev 08.04.2022 8:49   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.asilbekfayzullayevvariant1.model.Book;
import uz.pdp.asilbekfayzullayevvariant1.repository.BookRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public HttpEntity<?> getAllBook() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @PostMapping
    public HttpEntity<?> addBook(@RequestBody Book book){
       return ResponseEntity.ok(bookRepository.save(book));
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editBook(@RequestBody Book book,@PathVariable Integer id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            Book editBook = optionalBook.get();
            editBook.setName(book.getName());
            editBook.setPrice(book.getPrice());
            bookRepository.save(editBook);
            return ResponseEntity.ok(editBook);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteBook(@PathVariable Integer id){
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getBookById(@PathVariable Integer id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        return ResponseEntity.status(optionalBook.isPresent()?200:400).body(optionalBook.orElse(null));
    }
}
