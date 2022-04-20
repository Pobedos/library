package ru.pobedonostsev.library.service;

import java.util.List;

import ru.pobedonostsev.library.dto.AuthorDto;
import ru.pobedonostsev.library.dto.BookDto;
import ru.pobedonostsev.library.entity.Author;
import ru.pobedonostsev.library.exception.AuthorNotFoundException;

public interface AuthorService {
    Author getAuthorById(long id) throws AuthorNotFoundException;
    List<Author> getAllAuthors();
    void createAuthor(AuthorDto dto);
    void deleteAuthor(long id);
    void updateAuthor(long id, AuthorDto dto);
}
