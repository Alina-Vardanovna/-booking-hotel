package com.example.bookinghotelcore.service.impl;

import com.example.bookinghotelcore.entity.Book;
import com.example.bookinghotelcore.entity.User;
import com.example.bookinghotelcore.mapper.BookMapper;
import com.example.bookinghotelcore.repository.BookRepository;
import com.example.bookinghotelcore.service.BookService;
import com.example.bookinghotelcore.service.UserService;
import com.example.bookinghoteldatatransfer.request.BookRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final UserService userService;
    private final BookMapper bookMapper;


    @Override
    public Book save(BookRequest bookRequest, long userId) {
        log.info("request from user id: {} for booking home", userId);
        User userById = userService.findById(userId);
        Book book = bookMapper.toEntity(bookRequest);
        book.setUser(userById);
        Book save = bookRepository.save(book);
        log.info("user with id: {} successfully booked home", save.getId());
        return save;
    }

}

