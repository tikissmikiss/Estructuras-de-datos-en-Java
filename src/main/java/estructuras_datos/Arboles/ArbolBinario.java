package estructuras_datos.Arboles;

public class ArbolBinario {
    // Artibutos
    public NodoBin root;

    // Constructores
    public ArbolBinario(){}
    public ArbolBinario(int v) {
        this.root = new NodoBin(v);
    }

    // Metodos
    // void insertElement();
    // void clearElement(int value);
    
    /**
     * Recorre el arbol e imprime el resultado
     * @param r = Nodo raiz
     */
    public static void inorderWalk(NodoBin r) {
        if (r.hijoIzq != null) inorderWalk(r.hijoIzq);
        System.out.print(r.value + " ");
        if (r.hijoDch != null) inorderWalk(r.hijoDch);
    }
    
    public NodoBin getRoot() {
		return root;
	}

    /**
     * Añade un nodo raiz
     * @param v = Valor nodo raiz
     */
	public void setRoot(int v) {
		this.root = new NodoBin(v);
	}

	/**
     * Recorre el arbol e imprime el resultado
     * @param r = Nodo raiz
     */
    public static void postoderWalk(NodoBin r){
        if (r.hijoIzq != null) postoderWalk(r.hijoIzq);
        if (r.hijoDch != null) postoderWalk(r.hijoDch);
        System.out.print(r.value + " ");
    }
    
    /**
     * Recorre el arbol e imprime el resultado
     * @param r = Nodo raiz
     */
    public static void preorderWalk(NodoBin r){
        System.out.print(r.value + " ");
        if (r.hijoIzq != null) preorderWalk(r.hijoIzq);
        if (r.hijoDch != null) preorderWalk(r.hijoDch);
    }

    public static void breadthWalk(){}  // Recorrido en anchura
}