package ru.pobedonostsev.library.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BookDto {
    @NotBlank
    private String name;
    @NotNull
    private List<Long> genres;
    @NotNull
    private List<Long> authors;
    private String description;
}
