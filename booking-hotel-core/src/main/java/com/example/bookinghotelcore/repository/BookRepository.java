package com.example.bookinghotelcore.repository;

import com.example.bookinghotelcore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByCreationDateTimeAfterAndCreationDateTimeBefore(LocalDateTime after, LocalDateTime before);

}
