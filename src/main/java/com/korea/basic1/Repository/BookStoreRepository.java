package com.korea.basic1.Repository;

import com.korea.basic1.Entity.Book;
import com.korea.basic1.Entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreRepository extends JpaRepository<BookStore, Integer> {
    BookStore findByBookName(String bookName);
}
