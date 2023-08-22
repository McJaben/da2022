package Practicando_con_final2019;

public class Libro {
    // TDA ejercicio 1 del examen final libre del 2019

    // Atributos
    private String ISBN; // International Standard Book Number (su id)
    private String nombre;
    private String autor;
    private int ejemplares;

    // constructor
    public Libro(String unIsbn, String unNombre, String unAutor, int cantEjemplares) throws ISBNInvalidoException {
        if (unIsbn != null && !unIsbn.isEmpty()) {
            this.ISBN = unIsbn;
        } else {
            throw new ISBNInvalidoException("ISBN inválido: " + unIsbn);
        }
        if (unNombre != null && !unNombre.isEmpty()) {
            this.nombre = unNombre;
        } else {
            this.nombre = "desconocido";
        }
        if (!unAutor.isEmpty() && unAutor != null) {
            this.autor = unAutor;
        } else {
            this.autor = "desconocido";
        }
        if (cantEjemplares > 0) {
            this.ejemplares = cantEjemplares;
        } else {
            this.ejemplares = 0;
        }
    }

    // setters y getters
    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public void setAutor(String unAutor) {
        if (unAutor != null && unAutor != "") {
            this.autor = unAutor;
        }
    }

    public void setEjemplares(int cantEjemplares) {
        if (cantEjemplares > 0) {
            this.ejemplares = cantEjemplares;
        }
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getEjemplares() {
        return this.ejemplares;
    }

    // otros métodos propios del TDA
    @Override
    public boolean equals(Object o) {
        boolean respuesta = false;
        if (o instanceof Libro && o != null) {
            Libro otro = (Libro) o;
            if (this.ISBN.equals(otro.getISBN())) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    @Override
    public String toString() {
        return "{" + "ISBN = " + this.ISBN + " |" + " Nombre = " + this.nombre + " |"
                + " Autor = " + this.autor + " |" + " Ejemplares = " + this.ejemplares + '}';
    }

}
