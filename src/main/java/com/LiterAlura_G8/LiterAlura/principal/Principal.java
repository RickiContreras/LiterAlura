package com.LiterAlura_G8.LiterAlura.principal;

import com.LiterAlura_G8.LiterAlura.api.ConsumoAPI;
import com.LiterAlura_G8.LiterAlura.api.ConversorDeDatos;
import com.LiterAlura_G8.LiterAlura.repository.LibroRepository;

import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConversorDeDatos conversor = new ConversorDeDatos();
    private final String URL_BASE = "https://gutendex.com/books/?search=";

    private LibroRepository repository;

    public Principal(LibroRepository repository) {
        this.repository = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    Elija una  opción de búsqueda:
                    1 - Buscar libro por titulo
                    2 - Mostrar libros registrados
                    3 - Mostrar autores registrados
                    4 - Mostrar autores vivos en un determinado año
                    5 - Mostrar libros por idiomas
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    mostrarLibrosRegistrados();
                    break;
                case 3:
                    mostrarAutoresRegistrados();
                    break;
                case 4:
                    mostrarAutoresVivosPorAnio();
                    break;
                case 5:
                    mostrarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el título del libro a buscar:");
        String titulo = teclado.nextLine();
        String url = URL_BASE + titulo.replace(" ", "+");

        try {
            String json = consumoApi.obtenerDatos(url);
            DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);


            System.out.println("Libro encontrado:");
            System.out.println(datos);

        } catch (Exception e) {
            System.out.println("Error al buscar el libro: " + e.getMessage());
        }
    }


    private void mostrarLibrosRegistrados() {
        System.out.println("Mostrando libros registrados...");
    }

    private void mostrarAutoresRegistrados() {
        System.out.println("Mostrando autores registrados...");
    }

    private void mostrarAutoresVivosPorAnio() {
        System.out.println("Ingrese el año:");
        int anio = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Mostrando autores vivos en el año " + anio + "...");
    }

    private void mostrarLibrosPorIdioma() {
        System.out.println("Ingrese el código del idioma (por ejemplo: 'en'):");
        String idioma = teclado.nextLine();
        System.out.println("Mostrando libros en idioma: " + idioma + "...");
    }
}
