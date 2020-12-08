package estructuras_datos.Arboles;

/**
 * Extiende funcionalidades de un Árbol binario, incorporando 
 * Métodos para inserción y eliminación de nodos, manteniendo 
 * la propiedad de ordenación, que dice:
 * <p>{@code hijoIzq} <= {@code valor} <= {@code hijoDch}</p>
 * <p>Para estandarizar la estructura, la propiedad de ordenación 
 * se cumple siempre de la forma:</p>
 * <p>{@code hijoIzq} <= {@code valor} < {@code hijoDch}</p>
 */
public class ABB extends ArbolBinario {

    // Constructor
    public ABB(int v) {
        super(v);
    }

    public ABB() {
	}

	/**
     * Busca un elemento por valor 
     * @param v = Valor buscado
     * @return la referencia al nodo si existe.
     * <li>{@code null} si no existe.</li>  
     */
    public Nodo search(int v) {
        return searchNodo(this.root, v);
    }
    /**
     * Búsqueda recursiva de un nodo con valor {@code v} desde el nodo {@code n}
     * @param n nodo desde el que se busca
     * @param v valor buscado
     * @return el primer nodo con el valor buscado.<li>{@code null} si valor no encontrado.</li>
     */
    private Nodo searchNodo(Nodo n, int v) {
        if (n.value == v)
            return n;
        else if (v < n.value)
            return searchNodo(n.hijoIzq, v);
        else if (v > n.value)
            return searchNodo(n.hijoDch, v);
        return null;
    }

    public Nodo maximunNodo() {
        return maxNodo(root);
    }
    private Nodo maxNodo(Nodo n) {
        if (n.hijoDch != null)
            return maxNodo(n.hijoDch);
        return n;
    }

    public int maximunVal() {
        return maxVal(root);
    }
    private int maxVal(Nodo n) {
        return maxNodo(n).value;
    }

    public Nodo minimunNodo() {
        return minNodo(root);
    }
    private Nodo minNodo(Nodo n) {
        if (n.hijoIzq != null)
            return minNodo(n.hijoIzq);
        return n;
    }

    public int minimunVal() {
        return minVal(root);
    }
    private int minVal(Nodo n) {
        return minNodo(n).value;
    }

    /**
     * Crea un nuevo nodo con el valor dado y lo inserta manteniendo 
     * la propiedad de ordenación.
     * <p>{@code hijoIzq} <= {@code valor} <= {@code hijoDch}</p>
     * <p>De este modo:</p>
     * <p>{@code hijoIzq} <= {@code valor} < {@code hijoDch}</p>
     * @param v
     */
    public void insert(int v) {
        Nodo n = new Nodo(v);
        insert(this.root, n);
    }
    /**
     * Inserta el nodo {@code n} manteniendo la propiedad de ordenación.
     * <p>{@code hijoIzq} <= {@code valor} <= {@code hijoDch}</p>
     * <p>De este modo:</p>
     * <p>{@code hijoIzq} <= {@code valor} < {@code hijoDch}</p>
     * @param r raíz del sub/árbol en donde insertar
     * @param n nodo a insertar
     */
    protected void insert(Nodo r, Nodo n) {
        n.setPadre(r);    // Actualizar el padre del nodo
        if (r == null)  // Si el árbol esta vacío establecer como raíz
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
     * Busca el nodo con el valor dado y lo elimina manteniendo la propiedad de ordenación.
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
     * Elimina un nodo manteniendo la propiedad de ordenación.
     * <p>{@code hijoIzq} <= {@code valor} <= {@code hijoDch}</p>
     * <p>De este modo:</p>
     * <p>{@code hijoIzq} <= {@code valor} < {@code hijoDch}</p>
     * @param n nodo a eliminar
     * @throws Exception No existe el elemento que se intenta borrar
     */
    public void delete(Nodo n) throws Exception {
        if (n != null) {
            if (n.hijoIzq == null) {
                n.hijoDch.setPadre(n.getPadre());
                n.hijoDch.setHijoIzq(n.hijoIzq);
                n.hijoDch.setHijoDch(n.hijoDch);                
            } else if (n.hijoDch == null) {
                n.hijoIzq.setPadre(n.getPadre());
                n.hijoIzq.setHijoIzq(n.hijoIzq);
                n.hijoIzq.setHijoDch(n.hijoDch);                
            } else {
                // Subir el hijo izquierdo a la posición del elemento a eliminar.
                n.hijoIzq.setPadre(n.getPadre());     // Apunta el padre del nodo que sube, al padre del nodo a borrar.
                if (n.getPadre() == null)           // Si el padre era null, actualiza el raíz del árbol.
                    this.root = n.hijoIzq; 
                if (n.getPadre() == null);            // Si el elemento a borrar es el raíz, no hacer nada.
                else if (n.getPadre().hijoIzq == n)   // Si el nodo a borrar es el hijo derecho de su padre.
                    n.getPadre().setHijoIzq(n.hijoIzq);    // Actualizarlo para que apunte al nodo que sube.
                else if (n.getPadre().hijoDch == n)   // Si el nodo a borrar es el hijo izquierdo de su padre.
                    n.getPadre().setHijoDch(n.hijoIzq);    // Actualizarlo para que apunte al nodo que sube.
                // Insertar el hijo derecho en el subárbol del hijo izquierdo.
                this.insert(n.hijoIzq, n.hijoDch);
            }
        } else throw new Exception("No existe el elemento que se intenta borrar");
    }

    /**
     * Imprime la ruta desde el raíz al nodo de entrada
     * @param n destino de la ruta a imprimir
     */
    public static void printPath(Nodo n) {
        if (n.getPadre() != null)
            printPath(n.getPadre());
        if (n.getPadre() != null)
            System.out.print("-->");
        System.out.print("("+n.value+")");
    }
}