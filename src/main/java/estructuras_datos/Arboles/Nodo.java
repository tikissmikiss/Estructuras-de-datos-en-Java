package estructuras_datos.Arboles;

/**
 * Objeto nodo de un árbol binario. Contiene un atributo de valor y 3 punteros, 
 * uno apuntando a su nodo padre (parent) y dos apuntando a sus nodos hijos, 
 * izquierdo y derecho respectivamente.
 * @param value
 * @param padre
 * @param hijoIzq
 * @param hijoDch
 * @author José Herce
 * @version 0.1 - 27/07/2020
 */
public class Nodo {
    // Parámetros
    public int value;
    private Nodo padre;
    public Nodo hijoIzq;
    public Nodo hijoDch;

    // Constructor
    public Nodo(int v) {
        this.setValue(v);
        this.hijoIzq = null;
        this.hijoDch = null;
        this.padre = null;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo getHijoDch() {
        return hijoDch;
    }

    public void setHijoDch(Nodo hijoDch) {
        this.hijoDch = hijoDch;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Inserta hijo derecho
     * @param v = Valor del nodo hijo
     * @throws Exception Ya existe un hijo derecho
     */
    public void setHijoDch(int v) throws Exception { // Rigth
        if (this.hijoDch == null)
            this.hijoDch = new Nodo(v);
        else throw new Exception("Ya existe un hijo derecho");
    }

    /**
     * Inserta hijo izquierdo
     * @param v = Valor del nodo hijo
     * @throws Exception Ya existe un hijo izquierdo
     */
    public void setHijoIzq(int v) throws Exception { // Left
        if (this.hijoIzq == null)
            this.hijoIzq = new Nodo(v);
        else throw new Exception("Ya existe un hijo izquierdo");
    }

    /**
     * Elimina hijo derecho
     * @throws Exception Intento de borrar nodo inexistente
     */
    public void clrHijoDch() throws Exception {
        if (this.hijoDch != null)
            this.hijoDch = null;
            else throw new Exception("Intento de borrar nodo inexistente");
    }

    /**
     * Elimina hijo izquierdo
     * @throws Exception Intento de borrar nodo inexistente
     */
    public void clrHijoIzq() throws Exception {
        if (this.hijoIzq != null)
            this.hijoIzq = null;
        else throw new Exception("Intento de borrar nodo inexistente");
    }
}