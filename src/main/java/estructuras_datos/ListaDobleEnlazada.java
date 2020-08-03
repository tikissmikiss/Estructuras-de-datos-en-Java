package estructuras_datos;

/**
 * @author José Herce
 * @version 0.1 - 27/07/2020
 * @param isEmpty Devuelve true si la lista esta vacía
 */
public class ListaDobleEnlazada<T> {
	// Atributos Lista Enlazada
	Nodo<T> primero; // Puntero a primer nodo
	Nodo<T> ultimo; // Puntero a ultimo nodo
	public boolean isEmpty;

	// Constructor Lista Enlazada
	public ListaDobleEnlazada() {
		this.primero = null;
		this.ultimo = null;
		this.isEmpty = true;
	}
	
	class Nodo<N> {
		// Atributos Nodo
		N val;
		Nodo<N> next;
		Nodo<N> anterior;

		// Constructor Nodo
		Nodo(N value) {
			this.val = value;
		}

		@Override
		public String toString() {
			if (next != null)
				return (String.valueOf(val)) + " --> " + next.toString();
			else
				return String.valueOf(val);
		}

	}
	
	/**
	 * Añadir nodo en inicio
	 * @param value objeto a añadir
	 */
	public void addEnIni(T value) {
		Nodo<T> n = new Nodo<T>(value);
		// Si la lista esta vacía se pone this.primero y this.ultimo apuntando al nuevo nodo
		if (this.isEmpty) {   
			this.primero = n;
			this.ultimo = n;
		} else { // Si no esta vacía
			n.next = this.primero;
			n.next = this.primero;	// El campo next nodo apunta al primero de la lista
			this.primero.anterior = n;	// El campo anterior del primer nodo apunta al nuevo
			this.primero = n;		// El campo primero de la lista apunta al nodo
		}
		this.isEmpty = false;
	}
	
	/**
	 * Añadir nodo al final
	 * @param v objeto a añadir
	 */
	public void addEnFin(T v) {
		Nodo<T> n = new Nodo<T>(v);
		// Si la lista esta vacía se pone this.primero y this.ultimo apuntando al nuevo nodo
		if (this.isEmpty) {   
			this.primero = n;
			this.ultimo = n;
		} else { // Si no esta vacía
			n.anterior = this.ultimo;		//anterior del nuevo nodo apuntando al ultimo nodo
			this.ultimo.next = n;	//next del ultimo nodo apuntando al nuevo
			this.ultimo = n;			//Actualizar referencia al ultimo nodo
		}
		this.isEmpty = false;
	}
	
	/**
	 * Borra el primer nodo
	 * @throws Exception ListEmpty
	 */
	public void clrIni() throws Exception {
		// Si no esta la lista vacía
		if (!this.isEmpty) {
			this.primero.next.anterior = null;
			this.primero = this.primero.next;
		}
		else throw new Exception("ListEmpty: La lista ya esta vacía");
		isEmpty();
	}

	/**
	 * Borra el ultimo nodo
	 * @throws Exception ListEmpty
	 */
	public void clrFin() throws Exception {
		if (this.isEmpty ) { 					// Si la lista esta vacía
			throw new Exception("ListEmpty: La lista ya esta vacía");
		} else if (this.primero==this.ultimo) { // Si solo hay un elemento
			this.primero = null;
			this.ultimo = null;
		} else {							 	// Si hay más de un elemento
			this.ultimo.anterior.next = null;
			this.ultimo = this.ultimo.anterior;
		}
		isEmpty();
	}

	/** Comprueba y actualiza el parámetro isEmpty
	 * @return true si vacía, false si no vacía
	 */
	private boolean isEmpty() {
		if (this.primero == null) // Si la lista está vacía
			isEmpty = true;
		else 
			isEmpty = false;

		return isEmpty;
	}

	/**
	 * Imprime todos los elementos de la lista
	 */
	public void printList() {
		if (this.primero != null) {
			printNodo(this.primero);
		}
		System.out.println();
	}
	
	/**
	 * Imprime los nodos siguientes de forma recursiva
	 * @param n nodo inicial
	 */
	private void printNodo (Nodo<T> n) {
		System.out.print(n.val);
		if (n.next != null)
			System.out.print("  -->  ");
		if (n.next != null) 
			printNodo(n.next);
	}

	@Override
	public String toString() {
		if (!this.isEmpty) 
			return primero.toString();
		else
			return "";
	}

}
