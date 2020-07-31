package estructuras_datos;

public class ListaDobleEnlazada {
	// Artibutos Lista Enlazada
	Nodo primero; // Puntero a primer nodo
	Nodo ultimo; // Puntero a ultimo nodo
	public boolean isEmpty;

	// Constructor Lista Enlazada
	public ListaDobleEnlazada() {
		this.primero = null;
		this.ultimo = null;
		this.isEmpty = true;
	}
	
	class Nodo {
		// Artibutos Nodo
		Object val;
		Nodo next;
		Nodo anterior;

		// Constructor Nodo
		Nodo(Object value) {
			this.val = value;
		}
	}
	
	/** Añadir nodo en inicio:	 */
	public void addEnIni(Object value) {
		Nodo n = new Nodo(value);
		// Si la lista esta vacía se pone this.primero y this.ultimo apuntando al nuevo nodo
		if (this.isEmpty) {   
			this.primero = n;
			this.ultimo = n;
		} else { // Si no esta vacia
			n.next = this.primero;
			n.next = this.primero;	// El campo nexclr nodo apunta al primero de la lista
			this.primero.anterior = n;	// El campo anterior del primer nodo apunta al nuevo
			this.primero = n;		// El campo primero de la lista apunta al nodo
		}
		this.isEmpty = false;
	}
	
	/** Añadir nodo al final */
	public void addEnFin(int v) {
		Nodo n = new Nodo(v);
		// Si la lista esta vacía se pone this.primero y this.ultimo apuntando al nuevo nodo
		if (this.isEmpty) {   
			this.primero = n;
			this.ultimo = n;
		} else { // Si no esta vacia
			n.anterior = this.ultimo;		//anterior del nuevo nodo apuntando al ultimo nodo
			this.ultimo.next = n;	//next del ultimo nodo apuntando al nuevo
			this.ultimo = n;			//Actualizar referencia al ultimo nodo
		}
		this.isEmpty = false;
	}
	
	/**
	 * Borra el primer nodo
	 * 
	 * @throws Exception La lista ya esta vacía
	 */
	public void clrIni() throws Exception {
		// Si no esta la lista vacía
		if (!this.isEmpty) {
			this.primero.next.anterior = null;
			this.primero = this.primero.next;
		}
		else throw new Exception("La lista ya esta vacía");
		isEmpty();
	}

	/**
	 * Borra el ultimo nodo
	 * 
	 * @throws Exception La lista ya esta vacía
	 */
	public void clrFin() throws Exception {
		if (this.isEmpty ) { 					// Si la lista esta vacía
			throw new Exception("La lista ya esta vacía");
		} else if (this.primero==this.ultimo) { // Si solo hay un elemento
			this.primero = null;
			this.ultimo = null;
		} else {							 	// Si hay más de un elemento
			this.ultimo.anterior.next = null;
			this.ultimo = this.ultimo.anterior;
		}
		isEmpty();
	}

	/** Comprueba y actualiza el parametro isEmpty
	 * @return true si vacía, false si no vacía
	 */
	private boolean isEmpty() {
		if (this.primero == null) // Si la lista está vacía
			isEmpty = true;
		else 
			isEmpty = false;

		return isEmpty;
	}

	/** Imprime la lista enlazada */
	public void printList() {
		if (this.primero != null) {
			printNodo(this.primero);
		}
		System.out.println();
	}
	
	// Imprime los nodos siguientes de forma recursiva
	private void printNodo (Nodo n) {
		System.out.print(n.val);
		if (n.next != null)
			System.out.print("  -->  ");
		if (n.next != null) 
			printNodo(n.next);
	}
}
