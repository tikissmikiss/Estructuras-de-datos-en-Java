package estructuras_datos.Arboles;

/**
 * <p>Arbol binario de busqueda balanceado (AVL por sus inventores)</p>
 * 
 * Extiende funcionalidades de un Arbol binario de busqueda, sobreescribiendo
 * los metodos de inserción y borrado, de modo que ademas de mantenerse la 
 * propiedad de ordenación se mantiene el arbos balanceado.
 * @author Jose Herce
 * @version 0.1 - 27/07/2020
 */
public class Arbol_AVL extends ArbolBinarioBusqueda {

    // Constructor
    public Arbol_AVL(int v) {
        super();
    }

    public Arbol_AVL() {
	}

	@Override
    public void insert(int v) {
        NodoBin n = new NodoBin(v);
        insert(this.root, n);
    }
    private void insert(NodoBin R, NodoBin n) {
        
    }

    // TODO en Arbol binario de busqueda se complica. Implementar con arbol balanceado
    public NodoBin succesor(int v){
        return succesor(root, v);
    }
    private NodoBin succesor(NodoBin n, int v) {
        if (v > n.value)
            return succesor(n.hijoDch, v);
        else if (n.hijoIzq != null)
            return succesor(n.hijoIzq, v);
        return n;
    }

    // TODO en Arbol binario de busqueda se complica. Implementar con arbol balanceado
    public NodoBin predecessor(int v){
        return predecessor(root, v);
    }
    private NodoBin predecessor(NodoBin n, int v) {
        if (n.value < v)


            return predecessor(n.hijoIzq, v);
        else if (n.hijoDch != null)
            return predecessor(n.hijoDch, v);
        return n;
    }

}