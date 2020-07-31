package estructuras_datos;

// Stack
/**
 * Pila (Stack): 
 * @author Jose Herce
 * @version 0.1 - 27/07/2020
 * @param isEmpty Devuelve true si la cola esta vacia
 */
public class Pila { 
    // Artibutos
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

	public Object pop(boolean print) throws Exception {
        Object b = pop();
        if (print) this.print(); // Para mostrar la pila
        return b;
	}

    /** Extrae elemento de la pila (Elimina el elemento de la pila)
     * @return Elemento de la posicion mas alta
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

    public boolean isEmpty() {
        return l.isEmpty;
    }

    /** Imprime la pila completa */
    public void print() {
        l.printList();
    }
}