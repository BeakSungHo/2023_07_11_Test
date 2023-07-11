package com.korea.basic1.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jdk.jfr.Frequency;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private  String store_Name;

    @OneToMany(mappedBy = "bookStore", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private  List<Book>bookList;

}