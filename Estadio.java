package TPFinal;

import java.text.Normalizer;

/**
 * @author Benjamín Morales <ben.morales99 at protonmail.com>
 */
public class Estadio {

    //Atributos
    private int numero;
    private final String nombre;
    private final String ciudad;
    private int capacidad;
    private String mundial;

    //Constructores
    public Estadio(int numero, String nombre, String ciudad, int capacidad, String mundial) {
        if (numero > 0) {
            this.numero = numero;
        } else {
            this.numero = 0;
        }
        if (!nombre.equals("")) {
            this.nombre = nombre;
        } else {
            this.nombre = "defaultStadium";
        }
        if (!ciudad.equals("")) {
            this.ciudad = ciudad;
        } else {
            this.ciudad = "defaultCity";
        }
        if (capacidad > 0) {
            this.capacidad = capacidad;
        } else {
            this.capacidad = 0;
        }
        if (!mundial.equals("")) {
            this.mundial = mundial;
        } else {
            this.mundial = "nonexistentWorldCup";
        }
    }

    public Estadio(String nombre, String ciudad) {
        this.numero = 0;
        if (!nombre.equals("")) {
            this.nombre = nombre;
        } else {
            this.nombre = "defaultStadium";
        }
        if (!ciudad.equals("")) {
            this.ciudad = ciudad;
        } else {
            this.ciudad = "defaultCity";
        }
        this.capacidad = 0;
        this.mundial = "nonexistentWorldCup";
    }

    //Observadores
    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getMundial() {
        return mundial;
    }

    //Modificadores
    public void setNumero(int num) {
        //Sólo modifica el atributo si el parámetro es mayor a cero.
        if (num > 0) {
            this.numero = num;
        }
    }

    public void setCapacidad(int cap) {
        //Sólo modifica el atributo si el parámetro es mayor a cero.
        if (cap > 0) {
            this.capacidad = cap;
        }
    }

    public void setMundial(String mundial) {
        /* Este método sólo modifica el atributo "mundial" si el String pasado 
         * por parámetro no es nulo.
         */
        if (!mundial.equals("")) {
            this.mundial = mundial;
        }
    }

    @Override
    public String toString() {
        return "{" + "Número = " + numero + " |" + " Nombre = " + nombre + " |"
                + " Ciudad = " + ciudad + " |" + " Capacidad = " + capacidad
                + " |" + " Mundial = " + mundial + '}';
    }

    public boolean equals(Estadio otro) {
        return (this.nombre.equals(otro.nombre) && this.ciudad.equals(otro.ciudad));
    }

    public int compareTo(Estadio otro) {
        /*Compara el número que hace referencia al orden entre un estadio y otro.
         * Retorna positivo si el Estadio llamador está después, según el orden numérico.
         * Retorna 0 si están en el mismo orden, y negativo si el llamador está antes.
         */
        int i;
        if (this.numero == otro.getNumero()) {
            i = 0;
        } else {
            i = this.numero - otro.getNumero();
        }
        return i;
    }

    public int ordenLexic(Estadio st) {
        /* Método que compara primero la ciudad de un estadio y, si son iguales,
         * el nombre de un estadio. Devuelve un entero, usa el método compareTo
         * de la clase String
         */
        int i;
        /* Para ignorar las tildes y caracteres especiales, llamo al módulo
         * normalizarCadena. Esto NO modifica los atributos de los estadios, sólo
         * se utiliza para ordenarlos lexicográficamente de forma correcta.
         */
        String thisNormalCity = this.ciudad;
        String stNormalCity = st.getCiudad();
        String thisNormalName = this.nombre;
        String stNormalName = st.getNombre();

        thisNormalCity = normalizarCadena(thisNormalCity);
        stNormalCity = normalizarCadena(stNormalCity);
        thisNormalName = normalizarCadena(thisNormalName);
        stNormalName = normalizarCadena(stNormalName);

        if (thisNormalCity.compareTo(stNormalCity) == 0) {
            i = thisNormalName.compareTo(stNormalName);
        } else {
            i = thisNormalCity.compareTo(stNormalCity);
        }
        return i;
    }

    private String normalizarCadena(String cadena) {
        /* Para realizar la comparación entre las cadenas de texto que representan
         * las ciudades y los nombres de los estadios, no vamos a tener en cuenta
         * las tildes, los signos diacríticos y caracteres especiales. Por lo 
         * tanto, implemento este módulo utilizando los métodos normalize de 
         * java.text.Normalizer. 
         */
        cadena = Normalizer.normalize(cadena, Normalizer.Form.NFD);
        cadena = cadena.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return cadena;
    }

}
