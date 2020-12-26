package lab1.lista;

public class Lista<Tipo> {
    /*
     *************************************************************************
     * Atributos
     *************************************************************************/

    private Nodo<Tipo> cabeza;
    private Nodo<Tipo> cola;
    private int length;

    /*
     *************************************************************************
     * Constructores
     *************************************************************************/

    public Lista() {
        this.clear();
    }

    /*
     *************************************************************************
     * Metodos publicos
     *************************************************************************/

    /**
     * Inserta un elemento nuevo al final de la lista
     * 
     * @param dato String con el dato a añadir a la lista
     * @return devuelve true si el dato se añada satisfactoriamente.
     */
    public boolean add(Tipo dato) {
        Nodo<Tipo> nuevo = new Nodo<>(dato);
        if (cabeza == null) { // Si lista vacia
            cabeza = nuevo;
            cola = nuevo;
        } else { // Si mas de un elemento
            cola.siguiente(nuevo);
            nuevo.anterior(cola);
            cola = nuevo;
        }
        length++;
        return true;
    }

    /**
     * Inserta un elemento en la posicion solicitada
     * 
     * @param dato     Elemento a insertar
     * @param posicion Posicion de insercion
     * @return Devuelve true si la insercion se ha realizado con exito o false si no
     *         se ha podido insertar
     */
    public boolean add(Tipo dato, int posicion) {
        if (posicion == length)
            return add(dato);
        return addNodo(new Nodo<>(dato), getNodo(posicion));
    }

    /**
     * Devuelve el numero de elementos que contiene la lista
     * 
     * @return Entero con el numero de elementos que contiene la lista
     */
    public int size() {
        return length;
    }

    /**
     * Borra el nodo y retornar el dato de un elemento concreto de la lista. Solo se
     * elimina la primera coincidencia.
     * 
     * @param dato Tipo con el dato que se desea sacar.
     * @return Retorna el dato del elemento encontrado o null si no lo lo encuentra
     */
    public Tipo extract(Tipo dato) {
        Nodo<Tipo> n = getNodo(new Nodo<>(dato), cabeza);
        if (n != null) {
            remove(n);
            return dato; // n ya no tiene referencias
        }
        return null;
    }

    /**
     * Borrar el nodo y retornar el dato del elemento que ocupa una posición en la
     * lista.
     * 
     * @param posicion Posicion en la que se encuentra el elemnto que se desea sacar
     * @return Retorna el dato del elemento sacado o null si posicion esta fuera de
     *         rango
     */
    public Tipo extract(int posicion) {
        Nodo<Tipo> n = getNodo(posicion);
        if (n != null) {
            Tipo obj = n.dato();
            remove(n);
            return obj; // n ya no tiene referencias
        }
        return null;
    }

    /**
     * Comprueba si el dato pasado esta en la lista
     * 
     * @param dato Tipo que se desea comprobar
     * @return true si esta, false si no esta
     */
    public boolean check(Tipo dato) {
        return getNodo(new Nodo<>(dato), cabeza) != null;
    }

    /**
     * Busca un elemento con el contenido pasado, si lo encuentra devuelve su
     * posicion, si no lo encuentra devuelve -1
     * 
     * @param dato Contenido a buscar
     * @return Posicion de la primera coincidencia. -1 si no hay coincidencia.
     */
    public int indexOf(Tipo dato) {
        if (cabeza == null) // lista vacia?
            return -1;
        return indexOf(new Nodo<>(dato), cabeza, 0);
    }

    /**
     * Imprime y retorna el elemento que hay en una posición concreta de la lista.
     * Imprime null y retorna null si posicion esta fuera de rango
     * 
     * @param posicion Posicion del elemento solicitado
     * @return Devuelve un Tipo con el contenido del nodo solicitado. Devuelve null
     *         si la posicion esta fuera de rango
     */
    public String print(int posicion) {
        Nodo<Tipo> n = getNodo(posicion);
        System.out.println(n);
        return n == null ? null : n.toString();
    }

    /**
     * Recupera el nodo de una posicion concreta.
     * 
     * @param posicion Posicion del nodo que se quiere recuperar
     * @return El Nodo de la posicion seleccionada. Si la poscion esta fuera de
     *         rango se devuelve null
     */
    public Tipo get(int posicion) {
        if (cabeza == null)
            return null;

        Nodo<Tipo> n = getNodo(posicion);
        return n == null ? null : n.dato();
    }

    /**
     * Imprime por consola todos los elementos que contiene la lista.
     */
    public void print() {
        String str = "";
        str += "    Longitud: " + length + "\n";
        str += "    Primero: " + cabeza + "\n";
        str += "    Ultimo: " + cola + "\n";

        System.out.println(str + this);
    }

    /**
     * Inicializa la lista. Si se llama y la lista tiene contenido, el contenido de
     * la lista se elimina por completo.
     */
    public void clear() {
        length = 0;
        cabeza = null;
        cola = null;
    }

    /*
     *************************************************************************
     * Metodos privados
     *************************************************************************/

    /**
     * Inserta un Nodo en la posicion de otro Nodo. Esta diseñado para inserciones
     * de nodos nuevos, no para cambiar nodos de posicion, pero esto segundo seria
     * sencillo de implementar. Tan solo seria necesario comprobar el estado de
     * {@code anterior} y {@code siguiente} del nodo nuevo y actuar en consecuencia
     * si alguno de sus valores no es null para reenlazar la lista en la posicion de
     * extraccion.
     * 
     * @param nNuevo     Nodo nuevo a insertar en la posicion del Nodo {@code nodo}
     * @param nInsertPos Nodo de la posicion de insercion. Este sera el siguiente
     *                   del nuevo tras la insercion
     * @return Devuelve true si la insercion se efectua correctamente.
     */
    private boolean addNodo(Nodo<Tipo> nNuevo, Nodo<Tipo> nInsertPos) {
        if (nNuevo == nInsertPos)
            return false;
        if (nNuevo == null || nInsertPos == null)
            return false;
        // Desplaza el nodo actual y se inserta el nuevo delante
        nNuevo.siguiente(nInsertPos); // apunta siguiente del nuevo al nodo actual
        nNuevo.anterior(nInsertPos.anterior()); // apunta anterior del nuevo al nodo anterior del actual
        if (nInsertPos.anterior() != null) // Hay nodo delante del actual?
            nInsertPos.anterior().siguiente(nNuevo); // pone el anterior al actual apuntando al nuevo
        else // Si anterior es null el nuevo es ahora cabeza de lista
            cabeza = nNuevo;
        nInsertPos.anterior(nNuevo); // apunta anterior del nodo actual al nuevo
        length++;
        return true;
    }

    /**
     * Devuelve el nodo de la posicion solicita, o null en caso de estar fuera de
     * rango. Se recorre la ista en un sentido u otro dependiendo de donde este mas
     * cerca el elemnto a recuperar.
     * 
     * @param posicion Posicion de elemento que se desea recuperar
     * @return Devuelve el nodo de la poscion concreta. Devuelve null si la posicion
     *         solicitada esta fuera de rango
     */
    private Nodo<Tipo> getNodo(int posicion) {
        if (posicion >= length || posicion < 0)
            return null;
        if (posicion <= length / 2)
            return getNodo(cabeza, Sentido.AVANCE, posicion);
        else
            return getNodo(cola, Sentido.RETROCESO, length - posicion - 1);
    }

    /**
     * Metodo recursivo para recorrer la lista en orden ascendente o descendente a
     * peticion. Retorna el nodo de la posicion deseada.
     * 
     * @param nodo    Nodo desde el que iniciar a recorrer.
     * @param sentido Sentido en el que recorrer la lista. AVANCE o false para
     *                recorrer de principio hacia adelante. RETROCESO o true, para
     *                recorrerla en sentido inverso.
     * @param nPos    Numero de posiciones restantes para alcanzar el nodo objetivo.
     * @return Devuelve el nodo en la posicion solicitada o null si lista vacia.
     */
    private Nodo<Tipo> getNodo(Nodo<Tipo> nodo, Sentido sentido, int nPos) {
        if (nodo == null)
            return null;
        if (nPos != 0) {
            if (sentido == Sentido.RETROCESO)
                return getNodo(nodo.anterior(), sentido, --nPos);
            else
                return getNodo(nodo.siguiente(), sentido, --nPos);
        }
        return nodo;
    }

    /**
     * Busqueda recursiva de un nodo
     * 
     * @param nodoBuscado Nodo que se busca
     * @param nodoActual  Nodo a comparar
     * @return Devuelve el nodo encontrado o null si no lo encuentra
     */
    private Nodo<Tipo> getNodo(Nodo<Tipo> nodoBuscado, Nodo<Tipo> nodoActual) {
        if (nodoActual == null || nodoBuscado == null) // algun nodo no inicializado?
            return null;
        if (!nodoActual.equals(nodoBuscado)) // no son iguales?
            if (nodoActual.siguiente() != null) // no es el ultimo nodo?
                return getNodo(nodoBuscado, nodoActual.siguiente());
            else
                return null;
        return nodoActual;
    }

    /**
     * Borra el nodo y enlaza la lista adecuadamente
     * 
     * @param nodo Nodo que se desea borrar
     */
    private void remove(Nodo<Tipo> nodo) {
        length--;
        if (nodo != cabeza) // no es el primer nodo?
            nodo.anterior().siguiente(nodo.siguiente()); // enlazar anterior, con siguiente
        else
            cabeza = nodo.siguiente(); // apuntar cabeza al siguiente

        if (nodo != cola) // no es el ultimo nodo?
            nodo.siguiente().anterior(nodo.anterior()); // enlazar siguiente, con anterior
        else
            cola = nodo.anterior(); // apuntar cola al anterior
    }

    /**
     * Busqueda recursiva que compara el contenido de dos nodos recorriendo la
     * lista. Si hay coincidencia devuelve la posicion si no hay coincidencia, si no
     * hay coincidencia devuelve -1
     * 
     * @param nBuscado  Nodo buscado
     * @param nActual   Nodo a comparar
     * @param posActual Posicion actual
     * @return Si no hay coincidencia devuelve la posicion, si no hay coincidencia
     *         devuelve -1
     */
    private int indexOf(Nodo<Tipo> nBuscado, Nodo<Tipo> nActual, int posActual) {
        if (nBuscado.equals(nActual)) // coincide con cabeza?
            return posActual;
        if (nActual.siguiente() != null) // hay mas nodos?
            return indexOf(nBuscado, nActual.siguiente(), ++posActual); // comparar siguiente
        return -1; // no encontrado
    }

    /*
     *************************************************************************
     * Getters y Setters
     *************************************************************************/

    /*
     *************************************************************************
     * Metodos Override
     *************************************************************************/

    @Override
    public String toString() {
        String str = "";
        if (cabeza == null) {
            str = "- Vacia -\n";
        } else {
            Nodo<Tipo> aux = cabeza;
            for (int i = 0; i < length; i++) {
                str += "        [ " + i + ": " + aux + " ]"; 
                aux = aux.siguiente();
                if (aux != null)
                    str += "\n";
            }
        }
        return str;
    }

}
