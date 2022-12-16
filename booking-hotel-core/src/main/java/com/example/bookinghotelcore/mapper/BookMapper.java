package com.example.bookinghotelcore.mapper;

import com.example.bookinghotelcore.entity.Book;
import com.example.bookinghotelcore.entity.Home;
import com.example.bookinghotelcore.mapper.base.BaseMapper;
import com.example.bookinghoteldatatransfer.request.BookRequest;
import com.example.bookinghoteldatatransfer.request.HomeRequest;
import com.example.bookinghoteldatatransfer.response.BookResponse;
import com.example.bookinghoteldatatransfer.response.HomeResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookMapper implements BaseMapper<Book, BookRequest, BookResponse> {

    private final ModelMapper modelMapper;

    @Override
    public Book toEntity(BookRequest bookRequest) {
        return modelMapper.map(bookRequest, Book.class);
    }

    @Override
    public BookResponse toResponse(Book book) {
        return modelMapper.map(book, BookResponse.class);
    }

}
