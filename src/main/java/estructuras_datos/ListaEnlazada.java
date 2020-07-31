package estructuras_datos;

/** Linked List
 * @param isEmpty 
 */
public class ListaEnlazada {
	// Artibutos Lista Enlazada
	Nodo primero;	// Puntero a primero nodo
	Nodo ultimo;	// Puntero a primero nodo
	public boolean isEmpty;
	
	// Constructor Lista Enlazada
	public ListaEnlazada() {
		this.primero = null;
		this.ultimo = null;
		this.isEmpty = true;
	}
	
	public class Nodo {
		// Artibutos Nodo
		Object val;
		Nodo next;
		
		// Constructor Nodo
		Nodo(final int valor) {
			this.val = valor;
		}
	}

	/**
	 * 
	 * @param value
	 */
	public void addEnIni(final int value) {
		/*
		 * Añadir nodo en primero: - Crear nodo nuevo con el valor de entrada - Apuntar
		 * next a primero nodo
		 */
		final Nodo n = new Nodo(value);
		// Si la lista esta vacía primero y ultimo de lista apuntando al nuevo nodo
		if (this.isEmpty) {
			this.primero = n;
			this.ultimo = n;
		} // Si no esta vacía pone el nuevo nodo apuntando al primero
		else {
			n.next = this.primero;
			this.primero = n; //Actualiza con el nuevo nodo como el primero de la lista 
		}
		this.isEmpty = false;
	}

	/**
	 * Añadir nodo al  -Crear nodo nuevo con el valor de entrada Si la lista
	 * esta vacía -Se establece el nuevo nodo como el inicial Si no esta vacía -Se
	 * recorre la lista hasta el último elemento -Se actualiza el parámetro del
	 * ultimo elemento para que apunte al nuevo nodo
	 */
	public void addEnFin(final int value) {
		final Nodo n = new Nodo(value);
		// Si la lista esta vacía primero y ultimo de lista apuntando al nuevo nodo
		if (this.isEmpty) {   
			this.primero = n;
			this.ultimo = n;
		} // Si no esta vacía pone el ultimo nodo apuntando al nuevo
		else { 
			this.ultimo.next = n;	//next del ultimo nodo apuntando al nuevo
			this.ultimo = n;		//Actualizar referencia al ultimo nodo
		}
		this.isEmpty = false;
	}

	/**
	 * Borra el primero nodo: - Actualiza el puntero al nodo inicial de la lista
	 * para apuntar al segundo elemento
	 * 
	 * @throws Exception Lista vacía
	 */
	public void clrIni() throws Exception {
		if (!this.isEmpty) {	// Si no esta la lista vacía
			this.primero = this.primero.next;
			this.isEmpty();
		} 
		else throw new Exception("La lista ya esta vacía");
	}

	/**
	 * Borra el último nodo
	 * 
	 * @throws Exception Lista vacía
	 */
	public void clrFin() throws Exception {
		if (!this.isEmpty) {	// Si no esta la lista vacía
			if (this.primero.next == null) { // Si el primero nodo es el último
				this.primero = null;
			} else { // Si el primero nodo no es el ultimo
				Nodo tmp = this.primero; // Guardar referencia al primero nodo
				while (tmp.next.next != null) // Recorre la lista hasta el penúltimo nodo
					tmp = tmp.next;
				tmp.next = null;
			}
			this.isEmpty();
		} 
		else throw new Exception("La lista ya esta vacía");
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
		if (!this.isEmpty) {
			printNodo(this.primero);
		}
		System.out.println();
	}

	// Imprime los nodos siguientes de forma recursiva
	protected void printNodo(final Nodo n) {
		System.out.print(n.val);
		if (n.next != null)
			System.out.print(" --> ");
		if (n.next != null) 
			printNodo(n.next);
	}
}
