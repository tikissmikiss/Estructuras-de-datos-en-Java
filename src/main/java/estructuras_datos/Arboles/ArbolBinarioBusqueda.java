package estructuras_datos.Arboles;

/**
 * Extiende funcionalidades de un Arbol binario, incorporando 
 * metodos para inserción y eliminación de nodos, manteniendo 
 * la propidad de ordenación, que dice:
 * <p>{@code hijoIzq} <= {@code valor} <= {@code hijoDch}</p>
 * <p>Para estandarizar la estructura, la propiedad de ordenación 
 * se cumple siempre de la forma:</p>
 * <p>{@code hijoIzq} <= {@code valor} < {@code hijoDch}</p>
 */
public class ArbolBinarioBusqueda extends ArbolBinario {

    // Constructor
    public ArbolBinarioBusqueda(int v) {
        super(v);
    }

    public ArbolBinarioBusqueda() {
	}

	/**
     * Busca un elemento por valor 
     * @param v = Valor buscado
     * @return la referencia al nodo si existe.
     * <li>{@code null} si no existe.</li>  
     */
    public NodoBin search(int v) {
        return searchNodo(this.root, v);
    }
    /**
     * Busqueda recursiva de un nodo con valor {@code v} desde el nodo {@code n}
     * @param n nodo desde el que se busca
     * @param v valor buscado
     * @return el primer nodo con el valor buscado.<li>{@code null} si valor no encontrado.</li>
     */
    private NodoBin searchNodo(NodoBin n, int v) {
        if (n.value == v)
            return n;
        else if (v < n.value)
            return searchNodo(n.hijoIzq, v);
        else if (v > n.value)
            return searchNodo(n.hijoDch, v);
        return null;
    }

    public NodoBin maximunNodo() {
        return maxNodo(root);
    }
    private NodoBin maxNodo(NodoBin n) {
        if (n.hijoDch != null)
            return maxNodo(n.hijoDch);
        return n;
    }

    public int maximunVal() {
        return maxVal(root);
    }
    private int maxVal(NodoBin n) {
        return maxNodo(n).value;
    }

    public NodoBin minimunNodo() {
        return minNodo(root);
    }
    private NodoBin minNodo(NodoBin n) {
        if (n.hijoIzq != null)
            return minNodo(n.hijoIzq);
        return n;
    }

    public int minimunVal() {
        return minVal(root);
    }
    private int minVal(NodoBin n) {
        return minNodo(n).value;
    }

    /**
     * Crea un nuevo nodo con el valor dado y lo inserta manteniendo 
     * la propidad de ordenación.
     * <p>{@code hijoIzq} <= {@code valor} <= {@code hijoDch}</p>
     * <p>De este modo:</p>
     * <p>{@code hijoIzq} <= {@code valor} < {@code hijoDch}</p>
     * @param v
     */
    public void insert(int v) {
        NodoBin n = new NodoBin(v);
        insert(this.root, n);
    }
    /**
     * Inserta el nodo {@code n} manteniendo la propidad de ordenación.
     * <p>{@code hijoIzq} <= {@code valor} <= {@code hijoDch}</p>
     * <p>De este modo:</p>
     * <p>{@code hijoIzq} <= {@code valor} < {@code hijoDch}</p>
     * @param r raiz del sub/arbol en donde insertar
     * @param n nodo a insertar
     */
    private void insert(NodoBin r, NodoBin n) {
        n.padre = r;    // Actualizar el padre del nodo
        if (r == null)  // Si el arbol esta vacio establecer como raiz
            this.root = n;
        else if (n.value <= r.value) 
            if (r.hijoIzq == null) 
                r.hijoIzq = n;
            else 
                insert(r.hijoIzq, n);
        else if (n.value > r.value) 
            if (r.hijoDch == null) 
                r.hijoDch = n;
            else 
                insert(r.hijoDch, n);
    }

    /**
     * Busca el nodo con el valor dado y lo elimina manteniendo la propidad de ordenación.
     * <p>{@code hijoIzq} <= {@code valor} <= {@code hijoDch}</p>
     * <p>De este modo:</p>
     * <p>{@code hijoIzq} <= {@code valor} < {@code hijoDch}</p>
     * @param v valor del nodo que se desea eliminar.
     * @throws Exception No existe el elemento que se intenta borrar
     */
    public void delete(int v) throws Exception {
        delete(this.search(v));
    }
    /**
     * Elimina un nodo manteniendo la propidad de ordenación.
     * <p>{@code hijoIzq} <= {@code valor} <= {@code hijoDch}</p>
     * <p>De este modo:</p>
     * <p>{@code hijoIzq} <= {@code valor} < {@code hijoDch}</p>
     * @param n nodo a eliminar
     * @throws Exception No existe el elemento que se intenta borrar
     */
    public void delete(NodoBin n) throws Exception {
        if (n != null) {
            if (n.hijoIzq == null) {
                n.hijoDch.setPadre(n.padre);
                n.hijoDch.setHijoIzq(n.hijoIzq);
                n.hijoDch.setHijoDch(n.hijoDch);                
            } else if (n.hijoDch == null) {
                n.hijoIzq.setPadre(n.padre);
                n.hijoIzq.setHijoIzq(n.hijoIzq);
                n.hijoIzq.setHijoDch(n.hijoDch);                
            } else {
                // Subir el hijo iquierdo a la posicion del elemento a eliminar.
                n.hijoIzq.setPadre(n.padre);     // Apunta el padre del nodo que sube, al padre del nodo a borrar.
                if (n.padre == null)           // Si el padre era null, actualiza el raiz del arbol.
                    this.root = n.hijoIzq; 
                if (n.padre == null);            // Si el elemento a borrar es el raiz, no hacer nada.
                else if (n.padre.hijoIzq == n)   // Si el nodo a borrar es el hijo derecho de su padre.
                    n.padre.setHijoIzq(n.hijoIzq);    // Actualizarlo para que apunte al nodo que sube.
                else if (n.padre.hijoDch == n)   // Si el nodo a borrar es el hijo izquierdo de su padre.
                    n.padre.setHijoDch(n.hijoIzq);    // Actualizarlo para que apunte al nodo que sube.
                // Insertar el hijo derecho en el subarbol del hijo izquierdo.
                this.insert(n.hijoIzq, n.hijoDch);
            }
        } else throw new Exception("No existe el elemento que se intenta borrar");
    }

    /**
     * Imprime la ruta desde el raiz al nodo de entrada
     * @param n destino de la ruta a imprimir
     */
    public static void printPath(NodoBin n) {
        if (n.padre != null)
            printPath(n.padre);
        if (n.padre != null)
            System.out.print("-->");
        System.out.print("("+n.value+")");
    }
}