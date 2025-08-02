package com.LiterAlura_G8.LiterAlura.dto;

import java.util.List;

public record LibroDTO(
        String title,
        List<AutorDTO> authors,
        List<String> languages,
        int download_count
) {
}
