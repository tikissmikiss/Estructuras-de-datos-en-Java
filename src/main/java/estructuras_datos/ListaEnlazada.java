package estructuras_datos;

/** Linked List
 * @author José Herce
 * @version 0.1 - 27/07/2020
 * @param isEmpty Devuelve true si la lista esta vacía
 */
public class ListaEnlazada {
	// Atributos Lista Enlazada
	Nodo<Object> primero;	// Puntero a primero nodo
	Nodo<Object> ultimo;	// Puntero a primero nodo
	public boolean isEmpty;
	
	// Constructor Lista Enlazada
	public ListaEnlazada() {
		this.primero = null;
		this.ultimo = null;
		this.isEmpty = true;
	}
	
	public class Nodo<N> {
		// Atributos Nodo
		N val;
		Nodo<N> next;
		
		// Constructor Nodo
		Nodo(final N valor) {
			this.val = valor;
		}

		@Override
		public String toString() {
			if (next != null)
				return (String.valueOf(val)) + "\t├> " + "" + next.toString(); // codigo ascii 195 = ├ ( Línea vertical con empalme de recuadro gráfico )
			else
				return String.valueOf(val);
		}
	}

	/**
	 * Añadir nodo nuevo al inicio con el valor de la entrada
	 * @param value valor para el nuevo nodo
	 */
	public void addEnIni(final Object value) {
		/*
		 * Añadir nodo en primero: - Crear nodo nuevo con el valor de entrada - Apuntar
		 * next a primero nodo
		 */
		final Nodo<Object> n = new Nodo<Object>(value);
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
	 * Añadir nodo nuevo al final con el valor de la entrada
	 * @param value valor para el nuevo nodo
	 */
	public void addEnFin(final Object value) {
		final Nodo<Object> n = new Nodo<Object>(value);
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
	 * @throws Exception Lista vací­a
	 */
	public void clrIni() throws Exception {
		if (!this.isEmpty) {	// Si no esta la lista vacía
			this.primero = this.primero.next;
			this.isEmpty();
		} 
		else throw new Exception("La lista ya esta vací­a");
	}

	/**
	 * Borra el último nodo
	 * @throws Exception Lista vacía
	 */
	public void clrFin() throws Exception {
		if (!this.isEmpty) {	// Si no esta la lista vacía
			if (this.primero.next == null) { // Si el primero nodo es el último
				this.primero = null;
			} else { // Si el primero nodo no es el ultimo
				Nodo<Object> tmp = this.primero; // Guardar referencia al primero nodo
				while (tmp.next.next != null) // Recorre la lista hasta el penúltimo nodo
					tmp = tmp.next;
				tmp.next = null;
			}
			this.isEmpty();
		} 
		else throw new Exception("La lista ya esta vací­a");
	}

	public Nodo<Object> searchNodo(Object v) {
		return searchNodo(this.primero, v);
	}
	/**
	 * Busca desde el nodo {@code n} el elemento {@code v}. Si lo 
	 * encuentra devuelve un areferencia al objeto, si no lo encuentra 
	 * devuelve {@code null}
	 * @param n nodo de partida
	 * @param v elemento buscado
	 * @return referencia al nodo si lo encuentra, de lo contario {@code null}.
	 */
	private Nodo<Object> searchNodo(Nodo<Object> n, Object v) {
		if (n.val == v) 
			return n;
		else 
			return searchNodo(n.next, v);
	}

	/** Comprueba y actualiza el parámetro isEmpty
	 * @return true si vacía, false si no vacía
	 */
	private boolean isEmpty() {
		if (this.primero == null) {// Si la lista está vacía
			isEmpty = true;
			primero = null;
			ultimo = null;
		} else 
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

	/**
	 * Imprime los nodos siguientes de forma recursiva
	 * @param n nodo inicial
	 */
	protected void printNodo(final Nodo<Object> n) {
		System.out.print(n.val);
		if (n.next != null)
			System.out.print(" --> ");
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
