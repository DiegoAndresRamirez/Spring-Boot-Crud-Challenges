package com.riwi.library.application.services;

import com.riwi.library.application.IModels.IModelBook;
import com.riwi.library.domain.models.Book;
import com.riwi.library.domain.persistence.BookRepository;
import com.riwi.library.infrastructure.dto.request.bookRequestDtos.BookCreateRequestDTO;
import com.riwi.library.infrastructure.dto.response.bookResponseDtos.BookCreateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IModelBook {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookCreateResponseDTO create(BookCreateRequestDTO bookCreateRequestDTO) {

        Book book = Book.builder()
                .title(bookCreateRequestDTO.getTitle())
                .author(bookCreateRequestDTO.getAuthor())
                .year(bookCreateRequestDTO.getYear())
                .description(bookCreateRequestDTO.getDescription())
                .build();

        bookRepository.save(book);
        return BookCreateResponseDTO.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }
}
