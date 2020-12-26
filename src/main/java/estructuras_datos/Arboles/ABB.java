package estructuras_datos.arboles;

import lab1.cola.Cola;

/**
 * Extiende funcionalidades de un Árbol binario, incorporando Métodos para
 * inserción y eliminación de nodos, manteniendo la propiedad de ordenación, que
 * dice:
 * <p>
 * {@code hijoIzq} <= {@code valor} <= {@code hijoDch}
 * </p>
 * <p>
 * Para estandarizar la estructura, la propiedad de ordenación se cumple siempre
 * de la forma:
 * </p>
 * <p>
 * {@code hijoIzq} <= {@code valor} < {@code hijoDch}
 * </p>
 */
public class ABB {
    private SubArbol raiz;
    private int size;
    private int maximo;
    private int minimo;

    // Constructores
    /**
     * Solo se premite construir un arbol ABB pasando un valor para la raiz. aunque
     * el arbol puede llegar a estar vacion si se borra su ultimo nodo
     * 
     * @param v
     */
    public ABB(int v) {
        raiz = new SubArbol(v);
        size = 0;
    }

    public ABB() {
        size = 0;
    }

    /**
     * Busca un elemento por valor
     * 
     * @param v = Valor buscado
     * @return la referencia al nodo si existe.
     *         <li>{@code null} si no existe.</li>
     */
    public SubArbol buscar(int v) {
        return busacar(raiz, v);
    }

    /**
     * Búsqueda recursiva de un nodo con valor {@code v} desde el nodo {@code n}
     * 
     * @param n nodo en el que se está buscando
     * @param v valor buscado
     * @return el primer nodo con el valor buscado.
     *         <li>{@code null} si el valor no es encontrado.</li>
     */
    private SubArbol busacar(SubArbol n, int v) {
        if (n.getValor() == v)
            return n;
        else if (v < n.getValor())
            return busacar(n.getIzquierdo(), v);
        else if (v > n.getValor())
            return busacar(n.getDerecho(), v);
        return null;
    }

    public int maximo() {
        return maximo(raiz).getValor();
    }

    private SubArbol maximo(SubArbol n) {
        if (n.getDerecho() != null)
            return maximo(n.getDerecho());
        return n;
    }

    public int minimo() {
        return minimo(raiz).getValor();
    }

    private SubArbol minimo(SubArbol n) {
        if (n.getIzquierdo() != null)
            return minimo(n.getIzquierdo());
        return n;
    }

    private SubArbol preSucesor(SubArbol n) {
        if (n.getIzquierdo() != null)
            if (n.getIzquierdo().getIzquierdo() != null)
                return preSucesor(n.getIzquierdo());
        return n;
    }

    /**
     * Crea un nuevo nodo con el valor dado y lo inserta manteniendo la propiedad de
     * ordenación.
     * <p>
     * {@code hijoIzq} <= {@code valor} <= {@code hijoDch}
     * </p>
     * <p>
     * De este modo:
     * </p>
     * <p>
     * {@code hijoIzq} <= {@code valor} < {@code hijoDch}
     * </p>
     * 
     * @param v
     */
    public void insertar(int v) {
        if (raiz == null) // Si el árbol esta vacío establecer como raíz
            this.raiz = new SubArbol(v);
        else
            insertar(raiz, v);
        size++;
    }

    /**
     * Inserta el valor {@code v} manteniendo la propiedad de ordenación.
     * <p>
     * {@code izquierdo} <= {@code valor} <= {@code derecho}
     * </p>
     * <p>
     * De este modo:
     * </p>
     * <p>
     * {@code izquierdo} <= {@code valor} < {@code derecho}
     * </p>
     * 
     * @param n raíz del sub/árbol en donde insertar
     * @param v valor a insertar
     */
    private void insertar(SubArbol n, int v) {
        try {
            // v.setPadre(r); // Actualizar el padre del nodo // Se encarga el nodo
            if (v <= n.getValor()) { // si menor o igual que el valor del nodo
                if (n.getIzquierdo() != null) // Si tiene hijo izquierdo llamada recursiva pasando hijo izquierdo
                    insertar(n.getIzquierdo(), v);
                else
                    n.setIzquierdo(v);
            } else { // si mayor que el valor del nodo
                if (n.getDerecho() != null) // Si tiene hijo derecho llamada recursiva pasando hijo derecho
                    insertar(n.getDerecho(), v);
                else
                    n.setDerecho(v);
            }
        } catch (Exception e) {
            /*
             * Imprimimos traza porque esta excepcion solo puede darse por error de
             * programacion, metodo privado llamando a metodo privado
             */
            e.printStackTrace();
        }
    }

    /**
     * Busca el nodo con el valor dado y lo elimina manteniendo la propiedad de
     * ordenación.
     * <p>
     * {@code hijoIzq} <= {@code valor} <= {@code hijoDch}
     * </p>
     * <p>
     * De este modo:
     * </p>
     * <p>
     * {@code hijoIzq} <= {@code valor} < {@code hijoDch}
     * </p>
     * 
     * @param v valor del nodo que se desea eliminar.
     * @return
     * @throws Exception
     */
    public int borrar(int v) throws Exception {
        // Es el raiz?
        if (raiz.getValor() == v) {
            // TODO borrar raiz
        } else {
            borrar(raiz, v);
        }
        size--;
        return size;
    }

    public static void main(String[] args) throws Exception {
        ABB a = new ABB();
        int[] elementos = { 8, 3, 10, 1, 6, 14, 4, 7, 13, 5 };
        for (int i : elementos) {
            a.insertar(i);
        }
        a.printInorder();
        System.out.println();
        a.printPostoder();
        System.out.println();
        a.printPreorder();
        System.out.println();

        System.out.println();
        a.print();
        a.printInorder();
        a.borrar(6);
        a.print();
        a.printInorder();
        a.borrar(3);
        a.print();
        a.printInorder();
        a.borrar(4);
        a.print();
        a.printInorder();
        a.borrar(10);
        a.print();
        a.printInorder();
    }

    private SubArbol borrar(SubArbol n, int v) throws Exception {
        // No puedo ser v, porque no se hubiera llegado aqui.
        // soy menor o mayor que v?
        if (v < n.getValor()) { // si menor
            SubArbol hijo = n.getIzquierdo();
            // tengo hijo izquierdo?
            if (hijo != null) { // si tengo hijo izq
                // es v mi hijo?
                if (v == hijo.getValor()) {// Si v es mi hijo
                    SubArbol nietoDch = hijo.getDerecho();
                    SubArbol nietoIzq = hijo.getIzquierdo();
                    if (nietoDch != null && nietoIzq != null) { // Si tengo 2 nietos
                        // Como estamos revisando el hijo izq por ser v menor que yo, buscamos su
                        // sucesor que es el menor de los que son mayores que él, es decir, el menor del
                        // subarbol del nieto derecho.
                        SubArbol padreSucesor = preSucesor(nietoDch);
                        SubArbol sucesor = padreSucesor.getIzquierdo();
                        // el hijo del sucesor pasa a ser el hijo izq del padre del sucesor
                        padreSucesor.setIzquierdo(sucesor.getDerecho());
                        // subir sucesor como mi hijo
                        n.setIzquierdo(sucesor);
                        // el hijo derecho del sucesor ahora será mi nieto derecho
                        sucesor.setDerecho(nietoDch);
                        // y el hijo izquierdo del sucesor ahora será mi nieto iquierdo
                        sucesor.setIzquierdo(nietoIzq);

                    } else if (nietoDch != null || nietoIzq != null) { // Si tengo 1 nieto
                        // subir al nieto como hijo
                        hijo = nietoDch != null ? nietoDch : nietoIzq;
                    } else { // Si no tengo nietos
                        // borrar hijo
                        hijo = null;
                    }
                } else { // si no es mi hijo
                    // TODO llamada recursiva ¿? Comprobar
                    borrar(hijo, v);
                }
                return null;
            } else if (v > n.getValor()) { // si no tengo hijo izq
                // TODO error elemento no encontrado - comprobar
                return null;
            }
        } else if (v > n.getValor()) { // si mayor
            // TODO Gestion del lado derecho
            SubArbol hijo = n.getDerecho();
            // tengo hijo izquierdo?
            if (hijo != null) { // si tengo hijo izq
                // es v mi hijo?
                if (v == hijo.getValor()) {// Si v es mi hijo
                    SubArbol nietoDch = hijo.getDerecho();
                    SubArbol nietoIzq = hijo.getIzquierdo();

                    if (nietoDch != null && nietoIzq != null) { // Si tengo 2 nietos
                        // Como estamos revisando el hijo izq por ser v menor que yo, buscamos su
                        // sucesor que es el menor de los que son mayores que él, es decir, el menor del
                        // subarbol del nieto derecho.
                        SubArbol padreSucesor = preSucesor(nietoDch);
                        SubArbol sucesor = padreSucesor.getIzquierdo();
                        // el hijo del sucesor pasa a ser el hijo izq del padre del sucesor
                        padreSucesor.setIzquierdo(sucesor.getDerecho());
                        // subir sucesor como mi hijo
                        n.setIzquierdo(sucesor);
                        // el hijo derecho del sucesor ahora será mi nieto derecho
                        sucesor.setDerecho(nietoDch);
                        // y el hijo izquierdo del sucesor ahora será mi nieto iquierdo
                        sucesor.setIzquierdo(nietoIzq);

                    } else if (nietoDch != null || nietoIzq != null) { // Si tengo 1 nieto
                        // subir al nieto como hijo
                        hijo = nietoDch != null ? nietoDch : nietoIzq;
                    } else { // Si no tengo nietos
                        // borrar hijo
                        hijo = null;
                    }
                } else { // si no es mi hijo
                    // TODO llamada recursiva ¿? Comprobar
                    borrar(hijo, v);
                }
                return null;
            } else if (v > n.getValor()) { // si no tengo hijo izq
                // TODO error elemento no encontrado - comprobar
                return null;
            }
        } else {
            // TODO error de codigo no se debeiria de haber llegado aqui
            throw new Exception("Error de codigo. Situacion imposibles. "
                    + "Se ha alcanzado un nodo sin hijos en el proceso de borraro. "
                    + "Revisar codigo, nunca se deberia llmar a esta funcion pasando un nosdo sin hijos.");
        }
        size++;
        return null;
    }

    private Object borrado(SubArbol n, SubArbol hijo, int v) throws Exception {
        // comprobar que esta incializado. De lo contrario no deberia llegar aqui.
        if (hijo != null) {
            // soy v?
            if (v == hijo.getValor()) {// Si soy v
                SubArbol nietoDch = hijo.getDerecho();
                SubArbol nietoIzq = hijo.getIzquierdo();
                if (nietoDch != null && nietoIzq != null) { // Si tengo 2 hijos
                    // buscamos su sucesor, que es el menor de los de la derecha.
                    SubArbol padreSucesor = preSucesor(nietoDch);
                    SubArbol sucesor = padreSucesor.getIzquierdo();
                    // el hijo del sucesor pasa a ser el hijo izq del padre del sucesor
                    padreSucesor.setIzquierdo(sucesor.getDerecho());
                    // subir sucesor como mi hijo
                    n.setIzquierdo(sucesor);
                    // el hijo derecho del sucesor ahora será mi nieto derecho
                    sucesor.setDerecho(nietoDch);
                    // y el hijo izquierdo del sucesor ahora será mi nieto iquierdo
                    sucesor.setIzquierdo(nietoIzq);
                } else if (nietoDch != null || nietoIzq != null) { // Si tengo 1 nieto
                    // subir al nieto como hijo
                    hijo = nietoDch != null ? nietoDch : nietoIzq;
                } else { // Si no tengo nietos
                    // borrar hijo
                    hijo = null;
                }
            } else { // si no es mi hijo
                // TODO llamada recursiva ¿? Comprobar
                borrar(hijo, v);
            }
            return null;
        } else if (v > n.getValor()) { // si no tengo hijo izq
            // TODO error elemento no encontrado - comprobar
            return null;
        }

        return false;

    }

    // private boolean borrar(SubArbol n) {
    // if (n.getIzquierdo() == null) {
    // n.getDerecho().setPadre(n.getPadre());
    // n.getDerecho().setIzquierdo(n.getIzquierdo());
    // n.getDerecho().setDerecho(n.getDerecho());
    // } else if (n.getDerecho() == null) {
    // n.getIzquierdo().setPadre(n.getPadre());
    // n.getIzquierdo().setIzquierdo(n.getIzquierdo());
    // n.getIzquierdo().setDerecho(n.getDerecho());
    // } else {
    // // Subir el hijo izquierdo a la posición del elemento a eliminar.
    // n.getIzquierdo().setPadre(n.getPadre()); // Apunta el padre del nodo que
    // sube, al padre del nodo a borrar.
    // if (n.getPadre() == null) // Si el padre era null, actualiza el raíz del
    // árbol.
    // raiz = n.getIzquierdo();
    // if (n.getPadre() == null)
    // ; // Si el elemento a borrar es el raíz, no hacer nada.
    // else if (n.getPadre().getIzquierdo() == n) // Si el nodo a borrar es el hijo
    // derecho de su padre.
    // n.getPadre().setIzquierdo(n.getIzquierdo()); // Actualizarlo para que apunte
    // al nodo que sube.
    // else if (n.getPadre().getDerecho() == n) // Si el nodo a borrar es el hijo
    // izquierdo de su padre.
    // n.getPadre().setDerecho(n.getIzquierdo()); // Actualizarlo para que apunte al
    // nodo que sube.
    // // Insertar el hijo derecho en el subárbol del hijo izquierdo.
    // raiz.insertar(n.getIzquierdo(), n.getDerecho());
    // }
    // return false;
    // }
    /**
     * Elimina un nodo manteniendo la propiedad de ordenación.
     * <p>
     * {@code hijoIzq} <= {@code valor} <= {@code hijoDch}
     * </p>
     * <p>
     * De este modo:
     * </p>
     * <p>
     * {@code hijoIzq} <= {@code valor} < {@code hijoDch}
     * </p>
     * 
     * @param n nodo a eliminar
     * @throws Exception No existe el elemento que se intenta borrar
     */
    // private boolean borrar(SubArbol n, long i) throws Exception {
    // if (n != null) {
    // if (n.getIzquierdo() == null) {
    // n.getDerecho().setPadre(n.getPadre());
    // n.getDerecho().setIzquierdo(n.getIzquierdo());
    // n.getDerecho().setDerecho(n.getDerecho());
    // } else if (n.getDerecho() == null) {
    // n.getIzquierdo().setPadre(n.getPadre());
    // n.getIzquierdo().setIzquierdo(n.getIzquierdo());
    // n.getIzquierdo().setDerecho(n.getDerecho());
    // } else {
    // // Subir el hijo izquierdo a la posición del elemento a eliminar.
    // n.getIzquierdo().setPadre(n.getPadre()); // Apunta el padre del nodo que
    // sube, al padre del nodo a borrar.
    // if (n.getPadre() == null) // Si el padre era null, actualiza el raíz del
    // árbol.
    // raiz = n.getIzquierdo();
    // if (n.getPadre() == null)
    // ; // Si el elemento a borrar es el raíz, no hacer nada.
    // else if (n.getPadre().getIzquierdo() == n) // Si el nodo a borrar es el hijo
    // derecho de su padre.
    // n.getPadre().setIzquierdo(n.getIzquierdo()); // Actualizarlo para que apunte
    // al nodo que sube.
    // else if (n.getPadre().getDerecho() == n) // Si el nodo a borrar es el hijo
    // izquierdo de su padre.
    // n.getPadre().setDerecho(n.getIzquierdo()); // Actualizarlo para que apunte al
    // nodo que sube.
    // // Insertar el hijo derecho en el subárbol del hijo izquierdo.
    // raiz.insertar(n.getIzquierdo(), n.getDerecho());
    // }
    // } else
    // throw new Exception("No existe el elemento que se intenta borrar");
    // }

    /**
     * Imprime la ruta desde el raíz al nodo de entrada
     * 
     * @param n destino de la ruta a imprimir
     */
    // public static void printPath(SubArbol n) {
    // if (n.getPadre() != null)
    // printPath(n.getPadre());
    // if (n.getPadre() != null)
    // System.out.print("-->");
    // System.out.print("(" + n.value + ")");
    // }

    // Métodos
    /**
     * Recorre el árbol e imprime el resultado
     * 
     * @param r = Nodo raíz
     */
    private void inorderWalk(SubArbol r) {
        if (r.getIzquierdo() != null)
            inorderWalk(r.getIzquierdo());
        System.out.print(r.getValor() + " ");
        if (r.getDerecho() != null)
            inorderWalk(r.getDerecho());
    }

    public void printInorder() {
        inorderWalk(raiz);
    }

    public SubArbol getRoot() {
        return raiz;
    }

    /**
     * Añade un nodo raíz
     * 
     * @param v = Valor nodo raíz
     */
    public void setRoot(int v) {
        raiz = new SubArbol(v);
    }

    /**
     * Recorre el árbol e imprime el resultado
     * 
     * @param r = Nodo raíz
     */
    private void postoderWalk(SubArbol r) {
        if (r.getIzquierdo() != null)
            postoderWalk(r.getIzquierdo());
        if (r.getDerecho() != null)
            postoderWalk(r.getDerecho());
        System.out.print(r.getValor() + " ");
    }

    public void printPostoder() {
        postoderWalk(raiz);
    }

    /**
     * Recorre el árbol e imprime el resultado
     * 
     * @param r = Nodo raíz
     */
    private void preorderWalk(SubArbol r) {
        System.out.print(r.getValor() + " ");
        if (r.getIzquierdo() != null)
            preorderWalk(r.getIzquierdo());
        if (r.getDerecho() != null)
            preorderWalk(r.getDerecho());
    }

    public void printPreorder() {
        preorderWalk(raiz);
    }

    /**
     * Recorre el árbol en anchura e imprime el resultado
     * 
     * @param r raíz del árbol o subárbol a recorrer
     * @throws Exception
     */
    private void breadthWalk(SubArbol r) throws Exception {
        /*
         * encolar nodo raíz mientras cola no vacía sacar de la cola encolar hijo izq si
         * existe encolar hijo dch si existe imprimir valor repetir con siguiente en
         * cola
         */
        Cola<SubArbol> c = new Cola<SubArbol>();
        c.queue(r);
        while (!c.isEmpty()) {
            SubArbol n = (SubArbol) c.dequeue();
            if (n.getIzquierdo() != null)
                c.queue(n.getIzquierdo());
            if (n.getDerecho() != null)
                c.queue(n.getDerecho());
            System.out.print(n.getValor() + " ");
        }
    }

    public void breadthWalk() throws Exception {
        breadthWalk(raiz);
    }

    public void print() {
        print(raiz, "\nR:", 0);
    }

    private void print(SubArbol n, String str, int altura) {
        String s = "";
        for (int i = 0; i < altura; i++) {
            s += "   ";
        }
        altura++;
        System.out.println(s + str + n.getValor());
        if (n.getDerecho() != null || n.getIzquierdo() != null) {
            if (n.getDerecho() != null) {
                print(n.getDerecho(), "d:", altura);
            } else {
                System.out.println("   " + s + "d:-");
            }
            if (n.getIzquierdo() != null) {
                print(n.getIzquierdo(), "i:", altura);
            } else {
                System.out.println("   " + s + "i:-");
            }
        }
    }
}