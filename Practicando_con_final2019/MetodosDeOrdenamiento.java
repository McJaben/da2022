package Practicando_con_final2019;

import java.util.Arrays;

public class MetodosDeOrdenamiento {

    public static void main(String[] args) {
        int[] a = { 5, 1, 9, 2, 25, 83, 76 };
        int[] b = { 2, 7, 5, 3, 9, 11, 10 };
        int[] c = { 8, 7, 4, 2, 25, 43, 40 };
        System.out.println("Arreglo a:");
        System.out.println(Arrays.toString(a));
        System.out.println("Ordenando con bubble sort mejorado ascendente...");
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("Arreglo b:");
        System.out.println(Arrays.toString(b));
        System.out.println("Ordenando con el método selection sort");
        selectionSort(b);
        System.out.println(Arrays.toString(b));
        System.out.println("Arreglo c:");
        System.out.println(Arrays.toString(c));
        System.out.println("Ordenando con el método insertionSort");
        insertionSort(c);
        System.out.println(Arrays.toString(c));
    }

    // de fuerza bruta
    public static void bubbleSort(int[] arr) {
        int i = 0, j = 0, temp;
        boolean encontrado = false;
        while (i < arr.length - 1 && !encontrado) {
            encontrado = true;
            for (j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    encontrado = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            i++;
        }
    }

    // de fuerza bruta
    public static void selectionSort(int[] arr) {
        int i, j, pos, min, tmp;
        for (i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            pos = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    pos = j;
                }
            }
            if (pos != i) { // si hay algún elemento para intercambiar
                tmp = arr[i];
                arr[i] = arr[pos];
                arr[pos] = tmp;
            }
        }
    }
    // del tipo "disminuye y vencerás"
    public static void insertionSort(int[] arr) {
        int p, j, temp;
        for (p = 1; p < arr.length; p++) {
            temp = arr[p];
            j = p - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}