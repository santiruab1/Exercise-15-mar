package com.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728 ", 1967, true);
        Libro libro2 = new Libro("1984", "George Orwell", "978-0451524935");
        Libro libro3 = new Libro("Los juegos del hambre", "Suzanne Collins");
        Libro libro4 = new Libro();

        libro4.setTitulo("El código Da Vinci");
        libro4.setAutor("Dan Brown");
        libro4.setISBN("978-0307474278");
        libro4.setAnioPublicacion(2003);

        System.out.println(libro4.toString());

        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario("002", "Juan Pérez", "juan.perez@example.com");
        Usuario usuario3 = new Usuario("003", "María Gómez");

        usuario1.setId("001");
        usuario1.setEmail("carlos.rodriguez@example.com");
        usuario3.setEmail("maria.gomez@example.com");

        System.out.println(usuario1.toString());
        System.out.println(usuario3.toString());

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.agregarLibroInventario(libro1);
        biblioteca.agregarLibroInventario(libro2);
        biblioteca.agregarLibroInventario(libro3);
        biblioteca.agregarLibroInventario(libro4);
        Libro libro5 = biblioteca.agregarLibroInventario("El principito", "Antoine de Saint-Exupéry", "978-0156012195",
                1943, true);
        Libro libro6 = biblioteca.agregarLibroInventario("Crimen y castigo", "Fiódor Dostoyevski");

        libro6.setAnioPublicacion(1866);

        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);
        biblioteca.registrarUsuario(usuario3);
        Usuario usuario4 = biblioteca.registrarUsuario("004", "Laura Fernández");

        usuario4.setEmail("laura.fernandez@example.com");

        Prestamo prestamo1 = biblioteca.realizarPrestamo("el principito", "003");
        Prestamo prestamo2 = biblioteca.realizarPrestamo("Crimen y castigo", "001");
        Prestamo prestamo3 = biblioteca.realizarPrestamo("los juegos del hambre", "003");
        Prestamo prestamo4 = biblioteca.realizarPrestamo("El código Da Vinci", "002");

        prestamo1.diasRetraso(LocalDate.of(2025, 4, 10));

        biblioteca.realizarDevolucion("el principito", "003");

        biblioteca.buscarLibros(libro6);
        biblioteca.buscarLibros("Cien años de soledad");

        biblioteca.generarInforme();
    }
}