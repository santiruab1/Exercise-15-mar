package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    // Método para agregar un libro al inventario (con sobrecarga)
    public void agregarLibroInventario(Libro libro) {
        if (libro != null) {
            this.libros.add(libro);
            System.out.println("Libro agregado exitosamente al inventario: " + libro.getTitulo());
        }
    }

    public Libro agregarLibroInventario(String titulo, String autor, String ISBN, int anioPublicacion,
            boolean disponible) {
        Libro nuevoLibro = new Libro(titulo, autor, ISBN, anioPublicacion, disponible);
        this.libros.add(nuevoLibro);
        System.out.println("Libro agregado exitosamente al inventario: " + nuevoLibro.getTitulo());
        return nuevoLibro;
    }

    public Libro agregarLibroInventario(String titulo) {
        Libro nuevoLibro = new Libro(titulo);
        this.libros.add(nuevoLibro);
        System.out.println("Libro agregado exitosamente al inventario: " + nuevoLibro.getTitulo());
        return nuevoLibro;
    }

    public Libro agregarLibroInventario(String titulo, String autor) {
        Libro nuevoLibro = new Libro(titulo, autor);
        this.libros.add(nuevoLibro);
        System.out.println("Libro agregado exitosamente al inventario: " + nuevoLibro.getTitulo());
        return nuevoLibro;
    }

    public Libro agregarLibroInventario(String titulo, String autor, String ISBN) {
        Libro nuevoLibro = new Libro(titulo, autor, ISBN);
        this.libros.add(nuevoLibro);
        System.out.println("Libro agregado exitosamente al inventario: " + nuevoLibro.getTitulo());
        return nuevoLibro;
    }

    // Método para registrar un usuario (con sobrecarga)
    public void registrarUsuario(Usuario usuario) {
        if (usuario != null) {
            this.usuarios.add(usuario);
            System.out.println("Usuario registrado exitosamente:" + usuario.getNombre());
        }
    }

    public Usuario registrarUsuario(String id) {
        Usuario nuevoUsuario = new Usuario(id);
        this.usuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado exitosamente:" + nuevoUsuario.getNombre());
        return nuevoUsuario;
    }

    public Usuario registrarUsuario(String id, String nombre) {
        Usuario nuevoUsuario = new Usuario(id, nombre);
        this.usuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado exitosamente:" + nuevoUsuario.getNombre());
        return nuevoUsuario;
    }

    public Usuario registrarUsuario(String id, String nombre, String email) {
        Usuario nuevoUsuario = new Usuario(id, nombre, email);
        this.usuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado exitosamente:" + nuevoUsuario.getNombre());
        return nuevoUsuario;
    }

    // Método para realizar un préstamo
    public Prestamo realizarPrestamo(String titulo, String id) {
        Prestamo nuevoPrestamo = null; // Declare the variable outside the loops
        if (titulo != null && !titulo.isEmpty()) {
            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    if (libro.getDisponible()) {
                        if (id != null && !id.isEmpty()) {
                            for (Usuario usuario : usuarios) {
                                if (usuario.getId().equalsIgnoreCase(id)) {
                                    libro.marcarComoPrestado();
                                    usuario.agregarPrestamo(libro);
                                    nuevoPrestamo = new Prestamo(libro, usuario, LocalDate.now(),
                                            LocalDate.now().plusDays(15));
                                    prestamos.add(nuevoPrestamo);
                                    System.out.println("Libro '" + libro.getTitulo()
                                            + "'  prestado exitosamente al Usuario '" + usuario.getNombre() + "'");
                                }
                            }
                        }
                    }
                }
            }
        }
        return nuevoPrestamo;
    }

    // Método para registrar una devolución
    public void realizarDevolucion(String titulo, String id) {
        if (titulo != null && !titulo.isEmpty()) {
            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    if (!libro.getDisponible()) {
                        if (id != null && !id.isEmpty()) {
                            for (Usuario usuario : usuarios) {
                                if (usuario.getId().equalsIgnoreCase(id)) {
                                    libro.marcarComoDisponible();
                                    usuario.eliminarPrestamo(libro);
                                    Prestamo devolucionPrestamo = null;
                                    for (Prestamo prestamo : prestamos) {
                                        if (libro.getTitulo().equalsIgnoreCase(titulo)
                                                && usuario.getId().equalsIgnoreCase(id)) {
                                            System.out.println("Libro '" + libro.getTitulo()
                                                    + "' devuelto exitosamente por Usuario '" + usuario.getNombre()
                                                    + "'");
                                            devolucionPrestamo = prestamo;
                                            break;
                                        }
                                    }
                                    if (devolucionPrestamo != null) {
                                        prestamos.remove(devolucionPrestamo);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
    }

    // Método para buscar libros (con sobrecarga para diferentes criterios)
    public void buscarLibros(Libro libroBuscado) {
        if (libroBuscado != null) {
            for (Libro libro : libros) {
                if (libro.equals(libroBuscado)) {
                    System.out.println(libroBuscado.toString());
                    break;
                }
            }
        }
    }

    public void buscarLibros(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println(libro.toString());
                    break;
                }
            }
        }
    }

    // Método para consultar préstamos de un usuario
    public void prestamosUsuario(Usuario usuarioConsulta) {
        if (usuarioConsulta != null) {
            for (Usuario usuario : usuarios) {
                if (usuario.equals(usuarioConsulta)) {
                    System.out.println(usuarioConsulta.getPrestamosActuales());
                    break;
                }
            }
        }
    }

    // Método para generar informes
    public void generarInforme() {
        System.out.println("=== Informe de la Biblioteca ===");

        // Libros en inventario
        System.out.println("\nLibros en inventario:");
        if (libros == null || libros.isEmpty()) {
            System.out.println("No hay libros en el inventario.");
        } else {
            for (Libro libro : libros) {
                System.out.println("- " + libro.toString());
            }
        }

        // Usuarios registrados
        System.out.println("\nUsuarios registrados:");
        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println("- " + usuario.toString());
            }
        }

        // Préstamos realizados
        System.out.println("\nPréstamos realizados:");
        if (prestamos == null || prestamos.isEmpty()) {
            System.out.println("No se han realizado préstamos.");
        } else {
            for (Prestamo prestamo : prestamos) {
                System.out.println("- " + prestamo.toString());
            }
        }
    }
}
