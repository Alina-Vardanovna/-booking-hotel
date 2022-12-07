package com.example.bookinghotelcore.repository;

import com.example.bookinghotelcore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
