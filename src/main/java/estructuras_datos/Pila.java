package estructuras_datos;

/**
 * Pila (Stack): 
 * @author José Herce
 * @version 0.1 - 27/07/2020
 * @param isEmpty Devuelve true si la cola esta vacía
 */
public class Pila { 
    // Atributos
    private ListaDobleEnlazada l;
    public boolean isEmpty;

    // Constructor
    public Pila() {
        l = new ListaDobleEnlazada();
        isEmpty = true;
    }

    /** Añadir elemento a la pila
     * @param value Valor del elemento
     */
    public void push(int value) { //Apilar
        l.addEnFin(value);
    }

    /** Añadir elemento a la pila
     * @param value Valor del elemento
     */
    public void push(int value, boolean print) { //Apilar
        l.addEnFin(value);
        if (print) this.print(); // Para mostrar la pila
    }

    /**
     * Añade elemento a la pila
     * @param print {@code true} para que se imprima la pila tras eliminar el elemento
     * @return referencia al objeto sacado de la pila
     * @throws Exception StackUnderflow
     */
	public Object pop(boolean print) throws Exception {
        Object b = pop();
        if (print) this.print(); // Para mostrar la pila
        return b;
	}

    /** Extrae elemento de la pila (Elimina el elemento de la pila)
     * @return Elemento de la posición mas alta
     * @throws Exception StackUnderflow
     */
    public Object pop() throws Exception { // Desapilar
        if (l.primero == null) {
            throw new Exception("StackUnderflow");
        } else {
            Object v = l.primero.val;
            l.clrFin();
            this.print(); // Para mostrar la pila
            return v;
        }
    }

    /**
     * @return {@code true} si la pila esta vacía
     */
    public boolean isEmpty() {
        return l.isEmpty;
    }

    /** Imprime la pila completa */
    public void print() {
        l.printList();
    }
}