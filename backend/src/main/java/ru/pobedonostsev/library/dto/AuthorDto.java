package ru.pobedonostsev.library.dto;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AuthorDto {
    private LocalDate birthDay;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String patronymic;
    @NotNull
    private Set<Long> books;
    private String description;
}
