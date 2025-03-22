package com.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private List<Libro> prestamosActuales;

    public Usuario() {
        this.id = "id sin definir";
        this.nombre = "nombre sin definir";
        this.email = "email sin definir";
        this.prestamosActuales = new ArrayList<>();
    }

    public Usuario(String id) {
        this.id = id;
        this.nombre = "nombre sin definir";
        this.email = "email sin definir";
        this.prestamosActuales = new ArrayList<>();
    }

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.email = "email sin definir";
        this.prestamosActuales = new ArrayList<>();
    }

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.prestamosActuales = new ArrayList<>();
    }

    public Usuario(String id, String nombre, String email, List<Libro> prestamosActuales) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.prestamosActuales = prestamosActuales;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    public String getEmal() {
        return this.email;
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
    }

    public List<Libro> getPrestamosActuales() {
        return this.prestamosActuales;
    }

    public void setPrestamosActuales(List<Libro> prestamosActuales) {
        this.prestamosActuales = prestamosActuales;
    }

    // Método para agregar un préstamo a la lista
    public void agregarPrestamo(Libro libro) {
        if (libro != null) {
            this.prestamosActuales.add(libro);
            System.out.println("Libro agregado a la lista de prestamos satisfactoriamente: " + libro.getTitulo());
        }
    }

    // Método para eliminar un préstamo de la lista
    public void eliminarPrestamo(Libro libro) {
        if (libro != null) {
            this.prestamosActuales.remove(libro);
            System.out.println("Libro eliminado a la lista de prestamos satisfactoriamente: " + libro.getTitulo());
        }
    }

    // Método toString() para mostrar información del usuario
    @Override
    public String toString() {
        return "Informacion usuario {" + "Id: " + this.id + ", Nombre: " + this.nombre + ", Email: " + this.email
                + ", Prestamos: " + this.prestamosActuales + "}";
    }

}
