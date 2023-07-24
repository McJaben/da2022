
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Benjamín Morales <ben.morales99 at protonmail.com>
 */
public class testEstadio {

    public static void main(String[] args) {
        try (// Método main de la clase testEstadio.
             // Legajo: 3370. 3370 MOD 3 = 1. Me tocó el método de ordenamiento "Inserción".
                Scanner entrada = new Scanner(System.in)) {
            System.out.println("Este programa contiene la información de 100 estadios"
                    + " de todos los mundiales de fútbol de la historia");
            Estadio[] stArray = new Estadio[100];
            cargarArreglo(stArray);
            // Menú para el usuario
            System.out.println("Tiene disponibles las siguientes opciones, seleccione"
                    + " la acción que desea realizar:");
            System.out.println("1. Mostrar el arreglo de estadios.");
            System.out.println("2. Generar una copia del arreglo de estadios.");
            System.out.println("3. Comparar si un arreglo y su copia son iguales.");
            System.out.println("4. Ordenar un arreglo lexicográficamente.");
            System.out.println("5. Generar la abreviatura del nombre de un estadio.");
            System.out.println("0. Salir del programa.");
            int k = entrada.nextInt();
            while (k < 0 || k > 5) { // Si el usuario ingresa un número que no esté entre 0 y 5
                System.out.println("Error. Debe ingresar un número entre el 0 y el 5"
                        + " para seleccionar alguna de las opciones.");
                System.out.println("Tiene disponibles las siguientes opciones, seleccione"
                        + " la acción que desea realizar:");
                System.out.println("1. Mostrar el arreglo de estadios.");
                System.out.println("2. Generar una copia del arreglo de estadios.");
                System.out.println("3. Comparar si un arreglo y su copia son iguales.");
                System.out.println("4. Ordenar un arreglo lexicográficamente.");
                System.out.println("5. Generar la abreviatura del nombre de un estadio.");
                System.out.println("0. Salir del programa.");
                k = entrada.nextInt();
            }
            switch (k) {
                case 1:
                    System.out.println("Mostrando el arreglo de 100 estadios...");
                    mostrarArreglo(stArray);
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Generando una copia del arreglo de estadios...\n");
                    Estadio[] stCopy = copiarArreglo(stArray);
                    System.out.println("Mostrando el arreglo original...\n");
                    mostrarArreglo(stArray);
                    System.out.println("");
                    System.out.println("Mostrando la copia del arreglo original...\n");
                    mostrarArreglo(stCopy);
                    break;
                case 3:
                    Estadio[] stCopy2 = copiarArreglo(stArray);
                    boolean esIgual = compararArreglos(stArray, stCopy2);
                    mostrarArreglo(stArray);
                    System.out.println("");
                    mostrarArreglo(stCopy2);
                    System.out.println("");
                    System.out.println("¿Es el arreglo original igual a su copia?\n" + esIgual);
                    break;
                case 4:
                    Estadio[] stCopy3 = copiarArreglo(stArray); // Genero una copia del arreglo original
                    System.out.println("Seleccione la forma en que se ordenará el arreglo:");
                    System.out.println("1. Ascendente");
                    System.out.println("2. Descendente");
                    int orden = entrada.nextInt();
                    while (orden < 1 || orden > 2) {
                        System.out.println("Error. Debe ingresar 1 o 2.\n");
                        System.out.println("Seleccione la forma en que se ordenará el arreglo:");
                        System.out.println("1. Ascendente");
                        System.out.println("2. Descendente");
                        orden = entrada.nextInt();
                    }
                    insertionSort(stCopy3, orden);
                    if (orden == 1) {
                        System.out.println("Usted seleccionó la opción N°: " + orden);
                        System.out.println("Mostrando arreglo ordenado en forma ascendente:\n");
                    } else {
                        System.out.println("Usted seleccionó la opción N°: " + orden);
                        System.out.println("Mostrando arreglo ordenado en forma descendente:\n");
                    }
                    mostrarArreglo(stCopy3);
                    break;
                case 5:
                    mostrarArreglo(stArray);
                    System.out.println("");
                    System.out.println("Ingrese el número del estadio del cual desea"
                            + " generar una abreviatura:");
                    int n = entrada.nextInt();
                    while (n > 100 || n < 1) {
                        System.out.println("Debe ingresar un número entre el 1 y el 100");
                        System.out.println("Ingrese el número del estadio del cual desea"
                                + " generar una abreviatura:\n");
                        n = entrada.nextInt();
                    }
                    String abreviatura = "";
                    System.out.println("El nombre del estadio es: " + stArray[n - 1].getNombre());
                    abreviatura = generarAbreviatura(stArray[n - 1].getNombre());
                    System.out.println("La abreviatura generada es: " + abreviatura);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
            }
        }

    }

    public static void cargarArreglo(Estadio[] arreglo) {
        File f = new File("TP_Final/src/estadiosMundiales.txt");
        /*
         * Asumo que van a correr el programa desde un IDE y que el archivo está
         * dentro de la carpeta "TPFinal" que contiene el .java
         * En caso de utilizar en Windows, cambiar los "/" por "\\".
         * En caso de dar una ruta En Linux, macOS y otros Unix-like utilizar "/" en
         * lugar de "\\".
         * 
         * Creo un objeto File llamado f con mi archivo de texto
         */
        try {
            Scanner scF = new Scanner(f); // objeto Scanner con el objeto File f
            for (int i = 0; i < arreglo.length; i++) { // recorro el arreglo
                while (scF.hasNext()) {
                    /*
                     * Mientras exista algo después del cursor del obj Scanner
                     * scF, repite el código de abajo. Cuando ya no queda nada
                     * después del cursor, aumenta la variable iteradora i y
                     * continua hasta que termina de recorrer el arreglo pasado
                     * por parámetro.
                     */
                    String registro = scF.nextLine(); // scF por scanFile
                    try (// String que guarda la linea actual del archivo de texto
                            Scanner scR = new Scanner(registro)) {
                        // Scanner para el String registro
                        scR.useDelimiter("@"); // Delimitador para el Scanner del registro
                        // Declaro las variables que voy a usar para crear el obj Estadio
                        int numero, capacidad;
                        String nombre, ciudad, mundial;
                        /*
                         * Almaceno los valores de cada campo de datos separado por '@'
                         * en las variables correspondientes al tipo de dato que necesito
                         */
                        numero = scR.nextInt();
                        nombre = scR.next();
                        ciudad = scR.next();
                        capacidad = scR.nextInt();
                        mundial = scR.next();
                        // Creo el objeto Estadio st con las variables correspondientes
                        Estadio st = new Estadio(numero, nombre, ciudad, capacidad, mundial);
                        // Cargo el objeto actual al arreglo
                        arreglo[i] = st; // st de "stadium"
                    }
                    i++;
                }
            }
            scF.close(); // Cierro el scanner
        } catch (FileNotFoundException ex) {
            Logger.getLogger(testEstadio.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("El archivo del cual quiere leer no existe.");
        }
    }

    public static void mostrarArreglo(Estadio[] arreglo) {
        System.out.println("Arreglo de estadios:");
        // Uso el bucle for mejorado para que sea más legible y porque no tengo
        // que hacer modificaciones. Éste recorre el arreglo completo
        for (Estadio iterador : arreglo) {
            System.out.println(iterador.toString());
        }
    }

    public static Estadio[] copiarArreglo(Estadio[] arreglo) {
        // Copia el arreglo de estadios pasado por parámetro
        Estadio[] newArray = new Estadio[arreglo.length];
        for (int i = 0; i < newArray.length; i++) {
            // Primero defino variables para cada atributo del objeto estadio actual
            int numero = arreglo[i].getNumero();
            String nombre = arreglo[i].getNombre();
            String ciudad = arreglo[i].getCiudad();
            int capacidad = arreglo[i].getCapacidad();
            String mundial = arreglo[i].getMundial();
            // Creo el objeto Estadio sti con las variables correspondientes
            Estadio sti = new Estadio(numero, nombre, ciudad, capacidad, mundial);
            newArray[i] = sti;
        }
        return newArray;
    }

    public static boolean compararArreglos(Estadio[] arr1, Estadio[] arr2) {
        /*
         * Módulo que compara si dos arreglos de estadios son iguales tanto en
         * orden como en sus elementos.
         */
        boolean esIgual = true;
        if (arr1.length == arr2.length) { // Si tienen distina longitud, entonces no son iguales
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].equals(arr2[i])) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return esIgual;
    }

    public static void insertionSort(Estadio[] arr, int n) {
        /*
         * Módulo que ordena un arreglo con el método insertionSort.
         * la variable n indica si el orden será ascendente o descendente
         */
        int i, j;
        Estadio aux; // Obj. Estadio que utilizo como auxiliar para el ordenamiento
        int length = arr.length;
        if (n == 1) {
            System.out.println("Ordenando en forma ascendente...");
            for (i = 0; i < length; i++) {
                j = i;
                aux = arr[i];
                while (j > 0 && aux.ordenLexic(arr[j - 1]) < 0) { // Reubicando...
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = aux;
            }
        } else {
            System.out.println("Ordenando en forma descendente...");
            for (i = length - 1; i > -1; i--) {
                j = i;
                aux = arr[i];
                while (j < length - 1 && aux.ordenLexic(arr[j + 1]) < 0) { // Reubicando...
                    arr[j] = arr[j + 1];
                    j++;
                }
                arr[j] = aux;
            }
        }
        ordenarNumero(arr);

    }

    public static void ordenarNumero(Estadio[] st) {
        /*
         * Ordena los números de un arreglo de estadios ya ordenado lexicográficamente.
         * Esto se hace para que el usuario vea en pantalla que cada estadio está
         * en el orden lexicográfico que escogió (ascendente o descendente), y
         * pueda tener como referencia el atributo número.
         */
        for (int i = 0; i < st.length; i++) {
            st[i].setNumero(i + 1);
        }
    }

    public static boolean esVocal(char c) {
        boolean esVocal = false;
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A'
                || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            esVocal = true;
        }
        return esVocal;
    }

    public static String generarAbreviatura(String nombre) {
        /*
         * Primer paso: normalizo el texto, eliminando caracteres especiales
         * Para eso, utilizo los métodos normalize de java.text.Normalizer
         */
        String normalizado = Normalizer.normalize(nombre, Normalizer.Form.NFD);
        normalizado = normalizado.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        // Segundo paso: elimino las vocales del nombre normalizado
        String estadioSinVocales = "";
        char c;
        for (int j = 0; j < normalizado.length(); j++) {
            c = normalizado.charAt(j);

            if (!esVocal(c)) {
                estadioSinVocales += c;
            }
        }

        // Luego elimino los espacios del nombre sin vocales
        String estadioSinEspacios = estadioSinVocales.replace(" ", "");

        // Ahora paso todo a minúscula
        String estadioMinuscula = estadioSinEspacios.toLowerCase();

        // Por último, convierto el primer caracter a mayúscula
        /*
         * Para ello, convierto el String en un arreglo de caracteres, luego
         * convierto en mayúsculas al primer elemento del arreglo, y retorno un
         * String creado a partir del arreglo de caracteres.
         */
        char[] caracteres = estadioMinuscula.toCharArray();
        caracteres[0] = Character.toUpperCase(caracteres[0]);
        String abreviatura = new String(caracteres);
        return abreviatura;
    }
}
