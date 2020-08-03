package estructuras_datos;

/**
 * @author José Herce
 * @version 0.1 - 27/07/2020
 */
public class TablaHash {
    public final int length;
    private ListaEnlazada[] arr;

    public TablaHash(int len) {
        this.length = len;
        arr = new ListaEnlazada[len];
        
        // Añadir en todas las posiciones una lista vacia
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ListaEnlazada();
        }
    }

    public void add(int key, Object valor) {
        // Calcular el indice con la funcion hash y añadir a la lista
        arr[funcionHash(key)].addEnFin(valor);
    }

    public Object search(int key) {
        ListaEnlazada val = arr[funcionHash(key)];
        return null;
    }

    private int funcionHash(int key) {
        return key%length;
    }

    @Override
    public String toString() {
        String s = new String();
        for (int i = 0; i < arr.length; i++) {
            s = s + "\n" + String.valueOf(i) + ")  " + arr[i].toString();
        }
        return s;
    }

}

