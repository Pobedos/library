package ru.pobedonostsev.library.service.impl;

import java.util.List;

import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ru.pobedonostsev.library.dto.AuthorDto;
import ru.pobedonostsev.library.dto.GenreDto;
import ru.pobedonostsev.library.entity.Author;
import ru.pobedonostsev.library.entity.Genre;
import ru.pobedonostsev.library.exception.GenreNotFoundException;
import ru.pobedonostsev.library.exception.NoSuchGenreException;
import ru.pobedonostsev.library.repository.BookRepository;
import ru.pobedonostsev.library.repository.GenreRepository;
import ru.pobedonostsev.library.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository, BookRepository bookRepository) {
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Genre getGenreById(long id) throws GenreNotFoundException {
        return genreRepository.findById(id).orElseThrow(GenreNotFoundException::new);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public void createGenre(GenreDto dto) {
        Genre genre = new Genre();
        fillGenre(genre, dto);
        genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(long id) {
        try {
            genreRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchGenreException("No such genre");
        }
    }

    @Override
    public void updateGenre(long id, GenreDto dto) {
        Genre genre = getGenreById(id);
        fillGenre(genre, dto);
        genreRepository.save(genre);
    }

    private void fillGenre(Genre genre, GenreDto dto) {
        genre.setName(dto.getName());
        genre.setBooks(bookRepository.findAllById(dto.getBooks()));
    }
}
