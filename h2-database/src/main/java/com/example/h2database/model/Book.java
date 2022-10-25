package com.example.h2database.model;

import org.springframework.data.annotation.Id;

public record Book(
        @Id Integer id,
        String title,
        Integer pages,
        String author
) {



}
