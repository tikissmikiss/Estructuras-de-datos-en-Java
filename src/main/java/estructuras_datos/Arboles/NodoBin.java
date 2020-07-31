package estructuras_datos.Arboles;

/**
 * Objeto nodo de un arbol binario. Contiene un atributo de valor y 3 punteros, 
 * uno apuntando a su nodo padre (parent) y dos apuntando a sus nodos hijos, 
 * izquierdo y derecho respectivamente.
 * @param value
 * @param padre
 * @param hijoIzq
 * @param hijoDch
 * @author Jose Herce
 * @version 0.1 - 27/07/2020
 */
public class NodoBin {
    // Parametros
    public int value;
    public NodoBin padre;
    public NodoBin hijoIzq;
    public NodoBin hijoDch;

    // Constructor
    public NodoBin(int v) {
        this.setValue(v);
        this.hijoIzq = null;
        this.hijoDch = null;
        this.padre = null;
    }

    public NodoBin getPadre() {
        return padre;
    }

    public void setPadre(NodoBin padre) {
        this.padre = padre;
    }

    public NodoBin getHijoDch() {
        return hijoDch;
    }

    public void setHijoDch(NodoBin hijoDch) {
        this.hijoDch = hijoDch;
    }

    public NodoBin getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoBin hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Inserta hijo derercho
     * @param v = Valor del nodo hijo
     * @throws Exception Ya existe un hijo derecho
     */
    public void setHijoDch(int v) throws Exception { // Rigth
        if (this.hijoDch == null)
            this.hijoDch = new NodoBin(v);
        else throw new Exception("Ya existe un hijo derecho");
    }

    /**
     * Inserta hijo izquierdo
     * @param v = Valor del nodo hijo
     * @throws Exception Ya existe un hijo izquierdo
     */
    public void setHijoIzq(int v) throws Exception { // Left
        if (this.hijoIzq == null)
            this.hijoIzq = new NodoBin(v);
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