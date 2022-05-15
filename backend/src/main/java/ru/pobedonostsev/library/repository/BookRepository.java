package ru.pobedonostsev.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.pobedonostsev.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}