package com.example.bookinghotelcore.service;

import com.example.bookinghotelcore.entity.Book;
import com.example.bookinghoteldatatransfer.request.BookRequest;

public interface BookService {

    Book save(BookRequest bookRequest, long userId);

}
