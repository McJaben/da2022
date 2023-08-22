package Practicando_con_final2019;

import java.util.Scanner;
import java.util.Arrays;

public class TestLibro {

    public static void main(String[] args) {
        // Crear un libro con datos válidos
        try {
            Libro libroValido = new Libro("9781234567890", "Libro válido", "Ramirez; Joaquín", 10);
            System.out.println("Libro válido:");
            System.out.println("ISBN: " + libroValido.getISBN());
            System.out.println("Nombre: " + libroValido.getNombre());
            System.out.println("Autor: " + libroValido.getAutor());
            System.out.println("Ejemplares: " + libroValido.getEjemplares());
            Libro otroLibroValido = new Libro("123456789", "Otro libro válido", "Rozas; Laura", 15);
            Libro librito = new Libro("1234", "Moby Dick", "Rodriguez Mesa; Pablo Andrés", 0);
            Libro[] otroArray = { libroValido, otroLibroValido, librito };
            // Crear un libro con ISBN inválido
            // Libro libroInvalido = new Libro("", "Libro inválido", "Autor inválido", -5);
            // System.out.println("\nLibro inválido:");
            // System.out.println("ISBN: " + libroInvalido.getISBN());
            // System.out.println("Nombre: " + libroInvalido.getNombre());
            // System.out.println("Autor: " + libroInvalido.getAutor());
            // System.out.println("Ejemplares: " + libroInvalido.getEjemplares());

            // Libro[] array = new Libro[2];
            // cargarArreglo(array);
            // mostrarArreglo(array);
            mostrarArreglo(otroArray);
            System.out.println("¿Hay libros sin ejemplares?: " + sinEjemplaresSala(otroArray));
        } catch (ISBNInvalidoException e) {
            System.out.println("Error al crear el libro: " + e.getMessage());
        }
    }

    public static void cargarArreglo(Libro[] arr) throws ISBNInvalidoException {
        Scanner sc = new Scanner(System.in);
        int ejemplares;
        String isbn = "", nombre = "", autor = "";
        boolean codigoValido;
        int i;
        for (i = 0; i < arr.length; i++) {
            System.out.println("Vamos a ingresar los datos del libro número: " + (i + 1));
            sc.nextLine();
            System.out.println("Ingrese el ISBN");
            isbn = sc.nextLine();
            codigoValido = esValido(arr, isbn, i);
            while (!codigoValido) {
                System.out.println("Lo siento, el ISBN de cada libro debe"
                        + "ser único y éste ya está registrado, ingréselo nuevamente.");
                isbn = sc.nextLine();
                codigoValido = esValido(arr, isbn, i);
            }
            // sc.nextLine();
            System.out.println("Ingrese el nombre del libro");
            nombre = sc.nextLine();
            // sc.nextLine();
            System.out.println("Ingrese el autor del libro");
            autor = sc.nextLine();
            System.out.println("Ingrese la cantidad de ejemplares del libro");
            ejemplares = sc.nextInt();
            Libro nuevo = new Libro(isbn, nombre, autor, ejemplares);
            arr[i] = nuevo;
        }
    }

    public static boolean sinEjemplaresSala(Libro[] arreglo) {
        boolean resultado = false;
        int i = 0;
        while (i < arreglo.length && !resultado) {
            if (arreglo[i].getEjemplares() == 0) {
                resultado = true;
            }
            i++;
        }
        return resultado;
    }

    public static boolean esValido(Libro[] arr, String unISBN, int pos) {
        int i = 0;
        boolean valido = true;
        while (valido && i < pos) {
            if (arr[i].getISBN().equals(unISBN)) {
                return false;
            } else {
                i++;
            }
        }
        return valido;
    }

    public static void mostrarArreglo(Libro[] arreglo) {
        System.out.println("Arreglo de libros:");
        // Uso el bucle for mejorado para que sea más legible y porque no tengo
        // que hacer modificaciones. Éste recorre el arreglo completo
        for (Libro iterador : arreglo) {
            System.out.println(iterador.toString());
        }
    }

    public static String[][] matrizAutores(Libro[] array) {
        String[][] matriz = new String[array.length - 1][2];
        int i, j;
        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz[0].length; j++){
                
            }
        }
    }

}