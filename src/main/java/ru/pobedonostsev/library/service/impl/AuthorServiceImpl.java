package ru.pobedonostsev.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import ru.pobedonostsev.library.dto.AuthorDto;
import ru.pobedonostsev.library.entity.Author;
import ru.pobedonostsev.library.exception.AuthorNotFoundException;
import ru.pobedonostsev.library.exception.NoSuchAuthorException;
import ru.pobedonostsev.library.repository.AuthorRepository;
import ru.pobedonostsev.library.repository.BookRepository;
import ru.pobedonostsev.library.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Author getAuthorById(long id) throws AuthorNotFoundException {
        return authorRepository.findById(id).orElseThrow(AuthorNotFoundException::new);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void createAuthor(AuthorDto dto) {
        Author author = new Author();
        fillAuthor(author, dto);
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(long id) {
        try {
            authorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchAuthorException("No such author");
        }
    }

    @Override
    public void updateAuthor(long id, AuthorDto dto) {
        Author author = getAuthorById(id);
        fillAuthor(author, dto);
        authorRepository.save(author);
    }

    private void fillAuthor(Author author, AuthorDto dto) {
        author.setBirthDay(dto.getBirthDay());
        author.setDescription(dto.getDescription());
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setPatronymic(dto.getPatronymic());
        author.setBooks(bookRepository.findAllById(dto.getBooks()));
    }
}
