package estructuras_datos.Arboles;

import estructuras_datos.Cola;

/**
 * @author José Herce
 * @version 0.1 - 27/07/2020
 */
public class ArbolBinario {
    // Atributos
    public NodoBin root;

    // Constructores
    public ArbolBinario(){}
    public ArbolBinario(int v) {
        this.root = new NodoBin(v);
    }

    // Métodos
    /**
     * Recorre el árbol e imprime el resultado
     * @param r = Nodo raíz
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
     * Añade un nodo raíz
     * @param v = Valor nodo raíz
     */
	public void setRoot(int v) {
		this.root = new NodoBin(v);
	}

	/**
     * Recorre el árbol e imprime el resultado
     * @param r = Nodo raíz
     */
    public static void postoderWalk(NodoBin r){
        if (r.hijoIzq != null) postoderWalk(r.hijoIzq);
        if (r.hijoDch != null) postoderWalk(r.hijoDch);
        System.out.print(r.value + " ");
    }
    
    /**
     * Recorre el árbol e imprime el resultado
     * @param r = Nodo raíz
     */
    public static void preorderWalk(NodoBin r){
        System.out.print(r.value + " ");
        if (r.hijoIzq != null) preorderWalk(r.hijoIzq);
        if (r.hijoDch != null) preorderWalk(r.hijoDch);
    }

    /**
     * Recorre el árbol en anchura e imprime el resultado
     * 
     * @param r raíz del árbol o subárbol a recorrer
     * @throws Exception
     */
    public static void breadthWalk(NodoBin r) throws Exception {
        /*
        * encolar nodo raíz
        * mientras cola no vacía
        *   sacar de la cola
        *   encolar hijo izq si existe
        *   encolar hijo dch si existe
        *   imprimir valor
        * repetir con siguiente en cola
        */
        Cola c = new Cola();
        c.enqueue(r);
        while (!c.isEmpty) {
            NodoBin n = (NodoBin) c.dequeue();
            if (n.hijoIzq != null) c.enqueue(n.hijoIzq);
            if (n.hijoDch != null) c.enqueue(n.hijoDch);
            System.out.print(n.value + " ");
        }
    }  
}