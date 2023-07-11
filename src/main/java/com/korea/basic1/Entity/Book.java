package com.korea.basic1.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private  String bookName;
    @Column(length = 100)
    private  String author;
    @ManyToOne
    private BookStore bookStore;//

}
