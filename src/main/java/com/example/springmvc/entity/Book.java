package com.example.springmvc.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity(name = "books")
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String link;

    //    @ManyToOne
//    User user;
    public static Book test() {
        return new Book(999L, "default", "default");
    }
}
