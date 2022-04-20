package ru.pobedonostsev.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ru.pobedonostsev.library.dto.BookDto;
import ru.pobedonostsev.library.entity.Book;
import ru.pobedonostsev.library.exception.BookNotFoundException;
import ru.pobedonostsev.library.exception.NoSuchBookException;
import ru.pobedonostsev.library.repository.AuthorRepository;
import ru.pobedonostsev.library.repository.BookRepository;
import ru.pobedonostsev.library.repository.GenreRepository;
import ru.pobedonostsev.library.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Book getBookById(long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createBook(BookDto dto) {
        Book book = new Book();
        fillBook(book, dto);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(long id) {
        try {
            bookRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchBookException("No such book");
        }
    }

    @Override
    public void updateBook(long id, BookDto dto) {
        Book book = getBookById(id);
        fillBook(book, dto);
        bookRepository.save(book);
    }

    private void fillBook(Book book, BookDto dto) {
        book.setName(dto.getName());
        book.setDescription(dto.getDescription());
        book.setAuthors(authorRepository.findAllById(dto.getAuthors()));
        book.setGenres(genreRepository.findAllById(dto.getGenres()));
    }
}
