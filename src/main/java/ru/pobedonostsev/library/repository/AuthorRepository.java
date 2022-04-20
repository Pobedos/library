package ru.pobedonostsev.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.pobedonostsev.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}