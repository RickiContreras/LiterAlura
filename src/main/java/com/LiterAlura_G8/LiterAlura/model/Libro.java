package com.LiterAlura_G8.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ElementCollection
    private List<String> idiomas;
    private Integer descargas;
    @ElementCollection
    private List<String> autores;
    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

    @Override
    public String toString() {
        return ", titulo='" + titulo + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", descargas=" + descargas +
                ", autores=" + autores +
                '}';
    }

    // Constructor por defecto (requerido por JPA)
    public Libro() {
    }

    // Constructor
    public Libro(String titulo, List<String> idiomas, List<String> autores) {
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.autores = autores;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }
}
