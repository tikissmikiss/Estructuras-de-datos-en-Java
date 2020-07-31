package estructuras_datos;

/**
 * @author José Herce
 * @version 0.1 - 27/07/2020
 */
public class Cola {
    // Atributos
    private ListaDobleEnlazada l;
    public boolean isEmpty;

    // Constructor
    public Cola() {
        l = new ListaDobleEnlazada();
        isEmpty = true;
    }

    /**
     * Meter un elemento en la cola
     * @param value elemento a encolar
     */
    public void enqueue(Object value) {
        l.addEnIni(value);
        isEmpty = false;
    }

    /**
     * Meter un elemento en la cola
     * @param value elemento a encolar
     * @param print {@code true} para imprimir la cola después de encolar
     */
    public void enqueue(Object value, boolean print) {
        enqueue(value);
        if (print) 
            l.printList();
    }
    
    /**
     * Saca un elemento de la cola
     * @return referencia al objeto desencolado
     * @throws Exception QueueEmpty
     */
    public Object dequeue() throws Exception {
        if (!l.isEmpty) {
            Object v = l.ultimo.val;
            l.clrFin();
            this.isEmpty = l.isEmpty;
            return v;
        }
        else throw new Exception("QueueEmpty: La cola esta vac�a");
    }
    /**
     * Saca un elemento de la cola
     * @param print {@code true} para imprimir la cola después de desencolar
     * @return referencia al objeto desencolado
     * @throws Exception QueueEmpty
     */
    public Object dequeue(boolean print) throws Exception {
        Object v = dequeue();
        if (print) 
            l.printList();
        return v;
    }
    
    /**
     * @return {@code true} si la cola esta vacía
     */
    public boolean isEmpty() {
        return l.isEmpty;
    }
}