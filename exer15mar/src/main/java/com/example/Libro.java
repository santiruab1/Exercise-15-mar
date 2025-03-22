package com.example;

public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private int anioPublicacion;
    private boolean disponible;

    public Libro(String titulo, String autor, String ISBN, int anioPublicacion, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }

    public Libro() {
        this.titulo = "titulo sin definir";
        this.autor = "autor sin definir";
        this.ISBN = "ISBN sin definir";
        this.anioPublicacion = 0;
        this.disponible = true;
    }

    public Libro(String titulo) {
        this.titulo = titulo;
        this.autor = "sin definir";
        this.ISBN = "ISBN sin definir";
        this.anioPublicacion = 0;
        this.disponible = true;
    }

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = "ISBN sin definir";
        this.anioPublicacion = 0;
        this.disponible = true;
    }

    public Libro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.anioPublicacion = 0;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor != null && !autor.isEmpty()) {
            this.autor = autor;
        }
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        if (ISBN != null && !ISBN.isEmpty()) {
            this.ISBN = ISBN;
        }
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion >= 0) {
            this.anioPublicacion = anioPublicacion;
        }

    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método para marcar como prestado
    public void marcarComoPrestado() {
        if (this.disponible) {
            this.disponible = false;
            System.out.println("Libro marcado como prestado exitosamente.");
        } else {
            System.out.println("El libro ya ha sido prestado.");
        }
    }

    // Método para marcar como disponible
    public void marcarComoDisponible() {
        if (!this.disponible) {
            this.disponible = true;
            System.out.println("Libro marcado como disponible exitosamente.");
        }
    }

    // Método toString() para mostrar información del libro
    public String toString() {
        return "Libro {Titulo: " + this.titulo + ", Autor: " + this.autor + ", ISBN: " + this.ISBN
                + ", Anio de publiacion: " + this.anioPublicacion + ", Disponibilidad: " + this.disponible + "}";
    }

}
