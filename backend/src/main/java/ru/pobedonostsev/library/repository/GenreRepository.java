package ru.pobedonostsev.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.pobedonostsev.library.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}