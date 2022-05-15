package ru.pobedonostsev.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.pobedonostsev.library.dto.BookDto;
import ru.pobedonostsev.library.entity.Book;
import ru.pobedonostsev.library.exception.BookNotFoundException;
import ru.pobedonostsev.library.service.BookService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> geAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody @Valid BookDto dto) {
        bookService.createBook(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable(name = "id") Long id, @RequestBody @Valid BookDto dto) {
        bookService.updateBook(id, dto);
    }
}
