package ru.pobedonostsev.library.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GenreDto {
    @NotBlank
    private String name;
    @NotNull
    private List<Long> books;
}
