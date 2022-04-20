package ru.pobedonostsev.library.service;

import java.util.List;

import ru.pobedonostsev.library.dto.GenreDto;
import ru.pobedonostsev.library.entity.Genre;
import ru.pobedonostsev.library.exception.GenreNotFoundException;

public interface GenreService {
    Genre getGenreById(long id) throws GenreNotFoundException;
    List<Genre> getAllGenres();
    void createGenre(GenreDto dto);
    void deleteGenre(long id);
    void updateGenre(long id, GenreDto dto);
}
