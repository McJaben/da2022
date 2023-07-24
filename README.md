# Desarrollo de Algoritmos 2022
En este repositorio subí las clases más importantes de la materia Desarrollo de Algoritmos de la Licenciatura en Ciencias de la Computación de la Universidad Nacional del Comahue.
Entre las clases, se encuentra el TP final de la materia, necesario para aprobar la cursada de ésta.

# TP Final: Estadios mundialistas - Enunciado

Se necesita analizar información de un grupo de estadios de fútbol. Para ello, desarrolle un programa que permita realizar los siguientes puntos:
## 1. TDA. Realizar el UML de un estadio. 
La información que contienen los estadios es:
• **_Número_**
• **_Nombre_**
• **_Ciudad_**
• **_Capacidad_**
• **_Mundial que se disputó_**.

El TDA debe incluir los métodos `equals()`, `toString()`, `compareTo()`, entre otros.
Guardar en un archivo de texto la información de 100 estadios. [Fuente de estadios de la Copa Mundial de Fútbol.](https://es.wikipedia.org/wiki/Anexo:Estadios_de_la_Copa_Mundial_de_Fútbol)

## 2. Arreglos/Matrices. 
Definir un arreglo de estadios. Realizar un módulo de carga del arreglo de estadios (de un archivo de texto)

## 3. Ordenamiento: Realizar un método copiaArreglo, que copia un arreglo de estadios.
Ordenar los estadios por el método definido de acuerdo a su legajo. El usuario debe indicar si el orden debe ser ascendente y descendente. 
(El método que deba hacer deberá hacerlo para ordenar ascendentemente y descendentemente por el nombre de la ciudad. Si hay más de un estadio por ciudad, por nombre del estadio).

0) Burbuja
1) Inserción (me tocó este, debido a mi legajo)
2) Selección

## 4. Manejo de String/recursividad. 
Dado el nombre de un estadio, generar su abreviatura (sacando las vocales y con la primera consonante con mayúsculas y sin espacios entre medio.
Solicitar al usuario el numero de estadio y mostrar el nombre original y el nombre modificado.
Ejemplo:
Estadio Ciudad de la Educación = Stdcdddldccn
Lusail = Lsl

# · Resolución - Informe

## INTRODUCCIÓN

En esta introducción, realizaré una breve descripción de lo que puede hacer el programa que desarrollé. Luego, en cada sección explicaré con mayor detalle cada módulo.

En este trabajo práctico se nos propuso desarrollar un programa en Java que permita realizar determinadas operaciones, con el fin de analizar información de un grupo de estadios mundialistas de fútbol.

Para ello, en primer lugar, creé el tipo de dato abstracto (TDA) llamado “Estadio”, que cuenta con los siguientes atributos:
- Número.
- Nombre.
- Ciudad.
- Capacidad.
- Mundial que se disputó.

En el TDA, además de los constructores, observadores y modificadores, se incluyen los métodos `equals()`, `toString()`, `compareTo()`, `ordenLexic()` y `normalizarCadena()`.

Luego, creé la clase `testEstadio`, que es donde se encuentra el método `main()` y el menú de usuario que permite acceder a otros módulos que, en conjunto, posibilitan realizar todas las operaciones que el enunciado del trabajo solicita.

En segundo lugar, dentro del algoritmo principal de la clase `testEstadio`, se crea y se carga un arreglo de estadios desde un archivo de texto llamado “estadiosMundiales.txt”, el cual se encuentra en “src/TPFinal/estadiosMundiales.txt”. La clase `testEstadio` está preparada para ejecutarse desde un IDE con el archivo de texto dentro de la carpeta "TPFinal" que contiene el archivo .java propio y del TDA.

Aclaración: si se desea ejecutar el programa desde la consola o con una ruta específica, deberá utilizar “\\” en Windows y “/” en Linux, macOS, BSD y otros Unix-like.

Para cargar el arreglo de estadios, se codificó el módulo `cargarArreglo()`.

En tercer lugar, se creó el módulo `copiarArreglo()`, que copia un arreglo de estadios. Éste se puede acceder mediante el menú que se despliega al usuario al ejecutar el programa. Asimismo, éste método es llamado por el módulo `insertionSort()`, que ordena lexicográficamente un arreglo de estadios pasado por parámetro. El mismo permite ordenar tanto ascendente como descendentemente, según lo que el usuario indique.

Aclaración: Implementé el método de ordenamiento `insertionSort()`, dado que es el tipo definido de acuerdo a mi índice de referencia, el cual es “1”.

Adicionalmente, implementé el módulo `ordenarNumero()` para reflejar mediante el atributo “número”, la posición de un estadio dentro de un arreglo de estadios ya ordenado lexicográficamente. Esto se hace para que el usuario vea en pantalla que cada estadio se encuentra en el orden lexicográfico que escogió (ascendente o descendente), y pueda tener ese número como referencia.

Por último, según lo indicado por el cuarto punto del enunciado: “Dado el nombre de un estadio, generar su abreviatura (sacando las vocales y con la primera consonante con mayúsculas y sin espacios entre medio. Solicitar al usuario el numero de estadio y mostrar el nombre original y el nombre modificado.”. 

Con el fin de lograr esto, los módulos implementados son: `generarAbreviatura()` y `esVocal()`.

## TDA Estadio

Este tipo de dato abstracto se creó para almacenar información de un Estadio, el cual está formado por variables de distinto tipo, como se puede ver a continuación en el UML.

### UML de la clase Estadio

  <tr>
   <td>**Estadio**

   </td>
  </tr>
  <tr>
   <td>**(*Atributos*)**

&lt;-> int número _(* según orden *)_

&lt;-> String nombre

&lt;-> String ciudad

&lt;-> int capacidad _(* cantidad máxima de espectadores *)_

&lt;-> int mundial _(* Mundial que se disputó*)_

   </td>
  </tr>
  <tr>
   <td>**(*Constructores*)**

&lt;+> Estadio(int numero, String nombre, String ciudad, int capacidad, String mundial) **_(* pre-condiciones: numero>0, nombre ≠ null, ciudad ≠ null, capacidad >0,  mundial ≠ null *) _**

&lt;+> Estadio(String nombre, String ciudad) **_(* pre-condiciones: nombre ≠ null, ciudad ≠ null *)_**

**(*Observadores*)**

&lt;+> getNumero() : int

&lt;+> getNombre() : String

&lt;+> getCiudad() : String

&lt;+> getCapacidad() : int

&lt;+> getMundial() : String

**(*Modificadores*)**

&lt;+> setNumero(int numero) : void _(* parámetro ≠ 0 *)_

&lt;+> setCapacidad(int capacidad) : void _(* parámetro ≠ 0 *)_

&lt;+> setMundial(String mundial) : void _(* parámetro ≠ null *)_

**(*Propias del tipo*)**

&lt;+> toString() : String

&lt;+> equals(Estadio otro) : boolean 

&lt;+> compareTo(Estadio otro) : int 

&lt;+> ordenLexic(Estadio st) : int

&lt;-> normalizarCadena(String cadena) : String

   </td>
  </tr>

### Métodos de la clase Estadio

En esta sección se explicará brevemente el funcionamiento de cada método de la clase:

* **toString().** Este método imprime por pantalla (en la consola) un objeto de la clase Estadio. Se colocan paréntesis de llaves al comienzo y al final, se menciona el nombre del atributo junto con su valor, y se separa cada campo con una barra vertical o _pipe_ “|”. 
* **equals(Estadio _otro_).** Método que compara si un objeto Estadio es igual a otro pasado por parámetro, verificando si el nombre y ciudad del objeto Estadio llamador es igual al del objeto **_otro_** (de tipo Estadio). Para ello, utiliza el método “equals()” de la clase String, dado que los atributos “nombre” y “ciudad” son de tipo String. \
Tomé la decisión de escoger el nombre y ciudad del estadio como su clave primaria, dado que al atributo número lo considero una referencia al orden del mismo en un arreglo. Por esto, puede suceder que exista un estadio repetido (mismo nombre y ciudad), dado que es probable que el mismo haya sido utilizado en otro mundial que se disputó en un mismo país (ej: el estadio Maracaná en Brasil 1950 y Brasil 2014), y puede que haya aumentado/disminuido su capacidad con el transcurso del tiempo.
* **compareTo(Estadio _otro_)**. Compara el atributo número, que hace referencia al orden entre un estadio y otro. Retorna positivo si el Estadio llamador está después, según el orden numérico. Retorna 0 si están en el mismo orden, y negativo si el llamador está antes. (Funciona de forma similar al compareTo() de la clase String).
* **normalizarCadena(String _cadena_)**. Para realizar la comparación entre las cadenas de texto que representan las ciudades y los nombres de los estadios, no vamos a tener en cuenta las tildes, los signos diacríticos y caracteres especiales. Por lo tanto, implemento este módulo utilizando los métodos normalize de java.text.Normalizer.  \
La clase Normalizer[^1] provee el método **_normalize(),_** que transforma un texto Unicode en un texto equivalente en forma compuesta o descompuesta, facilitando la búsqueda y ordenamiento del texto.


## Clase TestEstadio

En esta clase se encuentra el método `main()` junto con los módulos `cargarArreglo()`, `mostrarArreglo()`, `copiarArreglo()`, `compararArreglos()`, `insertionSort()`, `ordenarNumero()`, `esVocal()`,
`generarAbreviatura()`.

### Método main()

En el main se encuentra el menú que se muestra al usuario para seleccionar las distintas acciones que puede hacer el programa con la clase Estadio y un arreglo de estadios.

Menú:

1. Salir del programa.
2. Mostrar el arreglo de estadios.
3. Generar una copia del arreglo de estadios.
4. Comparar si un arreglo y su copia son iguales.
5. Comparar si un arreglo y su copia son iguales.
6. Comparar si un arreglo y su copia son iguales.

### Método insertionSort()

Es un método que ordena un arreglo de estadios con el método insertionSort. La variable _n_ indica si el orden será ascendente o descendente.

### Método ordenarNumero()

Este método ordena los números de un arreglo de estadios ya ordenado lexicográficamente. Esto se hace para que el usuario vea en pantalla que cada estadio se encuentra en el orden lexicográfico que escogió (ascendente o descendente), y pueda tener ese número como referencia.

<!-- Footnotes themselves at the bottom. -->
### Referencias
[^1]:
     Documentación: [Normalizer (Java Platform SE 7)](https://docs.oracle.com/javase/7/docs/api/java/text/Normalizer.html)
