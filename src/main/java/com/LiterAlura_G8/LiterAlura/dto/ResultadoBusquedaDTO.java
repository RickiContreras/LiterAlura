package com.LiterAlura_G8.LiterAlura.dto;

import java.util.List;

public record ResultadoBusquedaDTO(
        int count,
        List<LibroDTO> results
) {
}
