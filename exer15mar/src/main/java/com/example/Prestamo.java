package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionPrevista;

    public Prestamo() {
        this.libro = null;
        this.usuario = null;
        this.fechaPrestamo = null;
        this.fechaDevolucionPrevista = null;
    }

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucionPrevista) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
    }

    public Prestamo(Libro libro) {
        this.libro = libro;
        this.usuario = null;
        this.fechaPrestamo = null;
        this.fechaDevolucionPrevista = null;
    }

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = null;
        this.fechaDevolucionPrevista = null;
    }

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaPrestamo) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionPrevista = null;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        if (libro != null) {
            this.libro = libro;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario != null) {
            this.usuario = usuario;
        }
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucionPrevista() {
        return fechaDevolucionPrevista;
    }

    public void setFechaDevolucionPrevista(LocalDate fechaDevolucionPrevista) {
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
    }

    // Método para calcular días de retraso
    public int diasRetraso(LocalDate fechaActual) {
        if (fechaDevolucionPrevista == null || fechaActual == null) {
            return 0; // No delay if either LocalDate is null
        }
        long diasDeRetraso = ChronoUnit.DAYS.between(fechaDevolucionPrevista, fechaActual);
        System.out.println("Días de retraso: " + Math.max(diasDeRetraso, 0));
        return (int) Math.max(diasDeRetraso, 0); // Return 0 if no delay
    }

    // Método toString() para mostrar información del préstamo
    @Override
    public String toString() {
        return "Prestamo {Libro: " + libro + ", Usuario: " + usuario + ", Fecha de Prestamo: " + fechaPrestamo
                + ", Fecha de Devolucion Prevista: " + fechaDevolucionPrevista + "}";
    }
}
