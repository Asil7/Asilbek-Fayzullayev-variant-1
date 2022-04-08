package uz.pdp.asilbekfayzullayevvariant1.model;

//Asilbek Fayzullayev 08.04.2022 8:54   

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private  Integer id;

    private String name;

    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
