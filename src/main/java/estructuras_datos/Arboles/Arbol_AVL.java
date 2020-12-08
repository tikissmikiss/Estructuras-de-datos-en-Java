package estructuras_datos.Arboles;

/**
 * <p>
 * Árbol binario de búsqueda balanceado (AVL por sus inventores)
 * </p>
 * 
 * Extiende funcionalidades de un Árbol binario de búsqueda, sobrescribiendo los
 * métodos de inserción y borrado, de modo que además de mantenerse la propiedad
 * de ordenación se mantiene el árbol balanceado.
 * 
 * @author José Herce
 * @version 0.1 - 27/07/2020
 */
public class Arbol_AVL extends ABB {

    // Constructor
    public Arbol_AVL(int v) {
        super(v);
    }

    public Arbol_AVL() {
    }

    class AVL_Nodo extends Nodo {
        public int factorBalanceo; // Altura lado izq menos altura lado dch

        public AVL_Nodo(int v) {
            super(v);
            setFactorBalanceo(0);
        }

        public int getFactorBalanceo() {
            return factorBalanceo;
        }

        public void setFactorBalanceo(int factorBalanceo) {
            this.factorBalanceo = factorBalanceo;
        }
        
        @Override
        public AVL_Nodo getPadre() {
            return (AVL_Nodo) this.getPadre();
        }

        @Override
        public AVL_Nodo getHijoIzq() {
            return (AVL_Nodo) this.hijoIzq;
        }

        @Override
        public AVL_Nodo getHijoDch() {
            return (AVL_Nodo) this.hijoDch;
        }
    }

	@Override
    public void insert(int v) {
        AVL_Nodo n = new AVL_Nodo(v);
        this.insert((AVL_Nodo) this.root, (AVL_Nodo) n);
    }
    protected void insert(AVL_Nodo r, AVL_Nodo n) {
        // TODO Auto-generated method stub
        super.insert(r, n);
        if (n.getPadre() != null) // Si n no es el raíz
            balancear(r, n);
    }

    private void balancear(AVL_Nodo r, AVL_Nodo n) {
        AVL_Nodo hd = (AVL_Nodo) n.getPadre().getHijoDch();
        AVL_Nodo hi = (AVL_Nodo) n.getPadre().getHijoIzq();
        if (n.getPadre().getHijoDch() == n) { // Si n es el hijo derecho y no tiene hermano izquierdo
            n.getPadre().factorBalanceo--; // Decrementar factor balanceo padre
            if (n.getPadre().getPadre() != null && n.getPadre().getHijoIzq() == null) { // Si n tiene abuelo y no tiene hermano
                n.getPadre().getPadre().factorBalanceo--; // Decrementar factor balanceo del abuelo
            }
        } else {                         // Si n es el hijo izquierdo y no tiene hermano derecho
            n.getPadre().factorBalanceo++; // Incrementar factor balanceo padre
            if (n.getPadre().getPadre() != null && n.getPadre().getHijoDch() == null) { // Si n tiene abuelo y no tiene hermano
                n.getPadre().getPadre().factorBalanceo++; // Incrementar factor balanceo del abuelo
            }
        }


        System.out.println(n.getPadre().factorBalanceo);
    }

    // TODO en Árbol binario de búsqueda se complica. Implementar con árbol balanceado
    public Nodo succesor(int v){
        return succesor(root, v);
    }
    private Nodo succesor(Nodo n, int v) {
        if (v > n.value)
            return succesor(n.hijoDch, v);
        else if (n.hijoIzq != null)
            return succesor(n.hijoIzq, v);
        return n;
    }

    // TODO en Árbol binario de búsqueda se complica. Implementar con árbol balanceado
    public Nodo predecessor(int v){
        return predecessor(root, v);
    }
    private Nodo predecessor(Nodo n, int v) {
        if (n.value < v)
            return predecessor(n.hijoIzq, v);
        else if (n.hijoDch != null)
            return predecessor(n.hijoDch, v);
        return n;
    }

}