package ru.pobedonostsev.library.service;

import java.util.List;

import ru.pobedonostsev.library.dto.AuthorDto;
import ru.pobedonostsev.library.dto.BookDto;
import ru.pobedonostsev.library.entity.Book;
import ru.pobedonostsev.library.exception.BookNotFoundException;

public interface BookService {
    Book getBookById(long id) throws BookNotFoundException;
    List<Book> getAllBooks();
    void createBook(BookDto dto);
    void deleteBook(long id);
    void updateBook(long id, BookDto dto);
}
