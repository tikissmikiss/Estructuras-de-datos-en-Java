// package estructuras_datos.arboles;


// /**
//  * Extiende funcionalidades de un Árbol binario, incorporando Métodos para
//  * inserción y eliminación de nodos, manteniendo la propiedad de ordenación, que
//  * dice:
//  * <p>
//  * {@code hijoIzq} <= {@code valor} <= {@code hijoDch}
//  * </p>
//  * <p>
//  * Para estandarizar la estructura, la propiedad de ordenación se cumple siempre
//  * de la forma:
//  * </p>
//  * <p>
//  * {@code hijoIzq} <= {@code valor} < {@code hijoDch}
//  * </p>
//  */

//  /**
//      * Objeto nodo de un árbol binario. Contiene un atributo de valor y 3 punteros,
//      * uno apuntando a su nodo padre (parent) y dos apuntando a sus nodos hijos,
//      * izquierdo y derecho respectivamente.
//      * 
//      * @param valor
//      * @param padre
//      * @param izq
//      * @param dch
//      * @author José Herce
//      * @version 0.1 - 27/07/2020
//      */
// public class ABBsinNodo {
//         // Parámetros
//         private int dato;
//         private ABBsinNodo padre;
//         private ABBsinNodo izq;
//         private ABBsinNodo dch;

// // Constructores
//         public ABBsinNodo(int v) {
//             this.dato = v;
//             this.izq = null;
//             this.dch = null;
//             this.padre = null;
//         }
    
// // operaciones
// // - Búsqueda
// // - Inserción
// // - Borrado

//     // Getters y setters
//         public ABBsinNodo getPadre() {
//             return padre;
//         }
    
//         public void setPadre(ABBsinNodo padre) {
//             this.padre = padre;
//         }
    
//         public ABBsinNodo getDerecho() {
//             return dch;
//         }
    
//         public void setDerecho(ABBsinNodo hijoDch) {
//             this.dch = hijoDch;
//         }
    
//         public ABBsinNodo getIzquierdo() {
//             return izq;
//         }
    
//         public void setIzquierdo(ABBsinNodo hijoIzq) {
//             this.izq = hijoIzq;
//         }
    
//         public int getDato() {
//             return dato;
//         }
    
//         public void setDato(int value) {
//             this.dato = value;
//         }
    
//         /**
//          * Inserta hijo derecho
//          * 
//          * @param v = Valor del nodo hijo
//          * @throws Exception Ya existe un hijo derecho
//          */
//         public void setDerecho(int v) throws Exception { // Rigth
//             if (this.dch == null)
//                 this.dch = new ABBsinNodo(v);
//             else
//                 throw new Exception("Ya existe un hijo derecho");
//         }
    
//         /**
//          * Inserta hijo izquierdo
//          * 
//          * @param v = Valor del nodo hijo
//          * @throws Exception Ya existe un hijo izquierdo
//          */
//         public void setIzquierdo(int v) throws Exception { // Left
//             if (this.izq == null)
//                 this.izq = new ABBsinNodo(v);
//             else
//                 throw new Exception("Ya existe un hijo izquierdo");
//         }
    
//         /**
//          * Elimina hijo derecho
//          * 
//          * @throws Exception Intento de borrar nodo inexistente
//          */
//         public void borrarDerecho() throws Exception {
//             if (this.dch != null)
//                 this.dch = null;
//             else
//                 throw new Exception("Intento de borrar nodo inexistente");
//         }
    
//         /**
//          * Elimina hijo izquierdo
//          * 
//          * @throws Exception Intento de borrar nodo inexistente
//          */
//         public void borrarIzquierdo() throws Exception {
//             if (this.izq != null)
//                 this.izq = null;
//             else
//                 throw new Exception("Intento de borrar nodo inexistente");
//         }




















// 	/**
//      * Busca un elemento por valor 
//      * @param v = Valor buscado
//      * @return la referencia al nodo si existe.
//      * <li>{@code null} si no existe.</li>  
//      */
//     public ABBsinNodo search(int v) {
//         return searchNodo(this, v);
//     }
    
//     /**
//      * Búsqueda recursiva de un nodo con valor {@code v} desde el nodo {@code n}
//      * 
//      * @param abb nodo desde el que se busca
//      * @param v   valor buscado
//      * @return el primer nodo con el valor buscado.
//      *         <li>{@code null} si valor no encontrado.</li>
//      */
//     private ABBsinNodo searchNodo(ABBsinNodo abb, int v) {
//         if (abb.getDato() == v)
//             return abb;
//         else if (v < abb.getDato())
//             return searchNodo(abb.getIzquierdo(), v);
//         else if (v > abb.getDato())
//             return searchNodo(abb.getDerecho(), v);
//         return null;
//     }

//     public int maximo() {
//         return maxNodo(this).dato;
//     }
//     private ABBsinNodo maxNodo(ABBsinNodo abb) {
//         if (abb.getDerecho() != null)
//             return maxNodo(abb.getDerecho());
//         return abb;
//     }

//     public int minimo() {
//         return minNodo(this).dato;
//     }
//     private ABBsinNodo minNodo(ABBsinNodo n) {
//         if (n.getIzquierdo() != null)
//             return minNodo(n.getIzquierdo());
//         return n;
//     }

//     /**
//      * Crea un nuevo nodo con el valor dado y lo inserta manteniendo la propiedad de
//      * ordenación.
//      * <p>
//      * {@code hijoIzq} <= {@code valor} <= {@code hijoDch}
//      * </p>
//      * <p>
//      * De este modo:
//      * </p>
//      * <p>
//      * {@code hijoIzq} <= {@code valor} < {@code hijoDch}
//      * </p>
//      * 
//      * @param valor
//      */
//     public void insertar(int valor) {
//         ABBsinNodo n = new ABBsinNodo(valor);
//         insert(this, n);
//     }

//     /**
//      * Inserta el nodo {@code n} manteniendo la propiedad de ordenación.
//      * <p>
//      * {@code hijoIzq} <= {@code valor} <= {@code hijoDch}
//      * </p>
//      * <p>
//      * De este modo:
//      * </p>
//      * <p>
//      * {@code hijoIzq} <= {@code valor} < {@code hijoDch}
//      * </p>
//      * 
//      * @param raiz raíz del sub/árbol en donde insertar
//      * @param nodo nodo a insertar
//      */
//     private void insert(ABBsinNodo raiz, ABBsinNodo nodo) {
//         nodo.setPadre(raiz); // Actualizar el padre del nodo
//         if (raiz == null) // Si el árbol esta vacío establecer como raíz
//             this = n;
//         else if (nodo.dato <= raiz.dato)
//             if (raiz.hijoIzq == null)
//                 raiz.hijoIzq = nodo;
//             else
//                 insert(raiz.hijoIzq, nodo);
//         else if (nodo.dato > raiz.dato)
//             if (raiz.hijoDch == null)
//                 raiz.hijoDch = nodo;
//             else
//                 insert(raiz.hijoDch, nodo);
//     }

//     /**
//      * Busca el nodo con el valor dado y lo elimina manteniendo la propiedad de
//      * ordenación.
//      * <p>
//      * {@code hijoIzq} <= {@code valor} <= {@code hijoDch}
//      * </p>
//      * <p>
//      * De este modo:
//      * </p>
//      * <p>
//      * {@code hijoIzq} <= {@code valor} < {@code hijoDch}
//      * </p>
//      * 
//      * @param v valor del nodo que se desea eliminar.
//      * @throws Exception No existe el elemento que se intenta borrar
//      */
//     public void delete(int v) throws Exception {
//         delete(this.search(v));
//     }

//     /**
//      * Elimina un nodo manteniendo la propiedad de ordenación.
//      * <p>
//      * {@code hijoIzq} <= {@code valor} <= {@code hijoDch}
//      * </p>
//      * <p>
//      * De este modo:
//      * </p>
//      * <p>
//      * {@code hijoIzq} <= {@code valor} < {@code hijoDch}
//      * </p>
//      * 
//      * @param n nodo a eliminar
//      * @throws Exception No existe el elemento que se intenta borrar
//      */
//     public void delete(ABBsinNodo n) throws Exception {
//         if (n != null) {
//             if (n.hijoIzq == null) {
//                 n.hijoDch.setPadre(n.getPadre());
//                 n.hijoDch.setHijoIzq(n.hijoIzq);
//                 n.hijoDch.setHijoDch(n.hijoDch);
//             } else if (n.hijoDch == null) {
//                 n.hijoIzq.setPadre(n.getPadre());
//                 n.hijoIzq.setHijoIzq(n.hijoIzq);
//                 n.hijoIzq.setHijoDch(n.hijoDch);
//             } else {
//                 // Subir el hijo izquierdo a la posición del elemento a eliminar.
//                 n.hijoIzq.setPadre(n.getPadre()); // Apunta el padre del nodo que sube, al padre del nodo a borrar.
//                 if (n.getPadre() == null) // Si el padre era null, actualiza el raíz del árbol.
//                     this = n.hijoIzq;
//                 if (n.getPadre() == null)
//                     ; // Si el elemento a borrar es el raíz, no hacer nada.
//                 else if (n.getPadre().hijoIzq == n) // Si el nodo a borrar es el hijo derecho de su padre.
//                     n.getPadre().setHijoIzq(n.hijoIzq); // Actualizarlo para que apunte al nodo que sube.
//                 else if (n.getPadre().hijoDch == n) // Si el nodo a borrar es el hijo izquierdo de su padre.
//                     n.getPadre().setHijoDch(n.hijoIzq); // Actualizarlo para que apunte al nodo que sube.
//                 // Insertar el hijo derecho en el subárbol del hijo izquierdo.
//                 this.insert(n.hijoIzq, n.hijoDch);
//             }
//         } else
//             throw new Exception("No existe el elemento que se intenta borrar");
//     }

//     /**
//      * Imprime la ruta desde el raíz al nodo de entrada
//      * 
//      * @param n destino de la ruta a imprimir
//      */
//     public static void printPath(ABBsinNodo n) {
//         if (n.getPadre() != null)
//             printPath(n.getPadre());
//         if (n.getPadre() != null)
//             System.out.print("-->");
//         System.out.print("(" + n.dato + ")");
//     }

//     // Métodos
//     /**
//      * Recorre el árbol e imprime el resultado
//      * 
//      * @param r = ABB raíz
//      */
//     public static void inorderWalk(ABBsinNodo r) {
//         if (r.hijoIzq != null)
//             inorderWalk(r.hijoIzq);
//         System.out.print(r.dato + " ");
//         if (r.hijoDch != null)
//             inorderWalk(r.hijoDch);
//     }

//     public ABBsinNodo getRoot() {
//         return;
//     }

//     /**
//      * Añade un nodo raíz
//      * 
//      * @param v = Valor nodo raíz
//      */
//     public void setRoot(int v) {
//         this = new ABBsinNodo(v);
//     }

//     /**
//      * Recorre el árbol e imprime el resultado
//      * 
//      * @param r = ABB raíz
//      */
//     public static void postoderWalk(ABBsinNodo r) {
//         if (r.hijoIzq != null)
//             postoderWalk(r.hijoIzq);
//         if (r.hijoDch != null)
//             postoderWalk(r.hijoDch);
//         System.out.print(r.dato + " ");
//     }

//     /**
//      * Recorre el árbol e imprime el resultado
//      * 
//      * @param r = ABB raíz
//      */
//     public static void preorderWalk(ABBsinNodo r) {
//         System.out.print(r.dato + " ");
//         if (r.hijoIzq != null)
//             preorderWalk(r.hijoIzq);
//         if (r.hijoDch != null)
//             preorderWalk(r.hijoDch);
//     }

//     /**
//      * Recorre el árbol en anchura e imprime el resultado
//      * 
//      * @param r raíz del árbol o subárbol a recorrer
//      * @throws Exception
//      */
//     public static void breadthWalk(ABBsinNodo r) throws Exception {
//         /*
//          * encolar nodo raíz mientras cola no vacía sacar de la cola encolar hijo izq si
//          * existe encolar hijo dch si existe imprimir valor repetir con siguiente en
//          * cola
//          */
//         Cola<ABBsinNodo> c = new Cola<ABBsinNodo>();
//         c.queue(r);
//         while (!c.isEmpty()) {
//             ABBsinNodo n = (ABBsinNodo) c.dequeue();
//             if (n.hijoIzq != null)
//                 c.queue(n.hijoIzq);
//             if (n.hijoDch != null)
//                 c.queue(n.hijoDch);
//             System.out.print(n.dato + " ");
//             }
//         }  


// }