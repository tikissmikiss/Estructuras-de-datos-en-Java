package app;

import estructuras_datos.*;
import estructuras_datos.Arboles.*;
import estructuras_datos.Arboles.ArbolBinarioBusqueda;

public class App {
    public static void main(final String[] args) {
        // ejemplo_lista_doblemente_enlazada();
        // ejemplo_lista_enlazada();
        // ejemplo_pila();
        // ejemplo_cola();
        // ejemplo_arbol_binario();
        ejemplo_arbol_binario_busqueda();
    }

    private static void ejemplo_arbol_binario_busqueda() {
        ArbolBinarioBusqueda a = new ArbolBinarioBusqueda();
        int valores[] = {52,90,23,48,17,36,42,88,21,57,72};
        /*
        *            (52) 
        *           /    \
        *       (23)     (90)
        *      /   \     / 
        *  (17)   (48) (88)
        *    \    /    /
        *   (21)(36) (57)
        *         \    \
        *         (42) (72)
        */
        for (int i : valores) {
            a.insert(i);
        }

        // a.insert(21);
        // a.insert(52);
        // a.insert(88);

        ArbolBinarioBusqueda.preorderWalk(a.root);
        System.out.println();
        ArbolBinarioBusqueda.inorderWalk(a.root);
        System.out.println();
        ArbolBinarioBusqueda.postoderWalk(a.root);
        System.out.println();

        System.out.println("Máximo: " + a.maximunNodo().value);
        System.out.println("Máximo: " + a.maximunVal());
        System.out.println("Mínimo: " + a.minimunNodo().value);
        System.out.println("Mínimo: " + a.minimunVal());

        ArbolBinarioBusqueda.printPath(a.search(72));
        System.out.println();
        
        /*            BORRAR EL 23                    *             BORRAR EL 52
        *                  (52)                       *                (23)
        *                 /    \                      *               /   \
        *             (17)     (90)                   *           (17)    (48)
        *                \      /                     *             \    /    \
        *               (21)  (88)                    *            (21)(36)   (90)
        *                 \    /                      *                  \    / 
        *                (48)(57)                     *                 (42)(88)
        *                /     \                      *                     /
        *             (36)    (72)                    *                   (57)
        *               \                             *                      \
        *               (42)                          *                      (72)
        *                                             *
        * PREORDER:  52 17 21 48 36 42 90 88 57 72    * PREORDER:  23 17 21 48 36 42 90 88 57 72
        * INORDER:   17 21 36 42 48 52 57 72 88 90    * INORDER:   17 21 23 36 42 48 57 72 88 90 
        * POSTORDER: 42 36 48 21 17 72 57 88 90 52    * POSTORDER: 21 17 42 36 72 57 88 90 48 23
        */
        try {
            // NOTA: Para obtener los arboles de arriba borrar 23 o 52. Uno u otro, no ambos.
			// a.delete(23);
			a.delete(52);
		} catch (Exception e) {
			e.printStackTrace();
		}
        ArbolBinarioBusqueda.preorderWalk(a.root);
        System.out.println();
        ArbolBinarioBusqueda.inorderWalk(a.root);
        System.out.println();
        ArbolBinarioBusqueda.postoderWalk(a.root);
        System.out.println();

    }

    private static void ejemplo_arbol_binario() {
        /*
        *           (4) 
        *          /  \
        *       (5)   (3)
        *      /  \     \
        *    (1)  (2)   (6)
        *        / 
        *      (7)
        */
        ArbolBinario a = new ArbolBinario();   // Raiz
        try {
            a.setRoot(4);
			a.root.setHijoIzq(5);
            a.root.hijoIzq.setHijoIzq(1);
            a.root.hijoIzq.setHijoDch(2);
            a.root.hijoIzq.hijoDch.setHijoIzq(7);
            a.root.setHijoDch(3);
            a.root.hijoDch.setHijoDch(6);
		} catch (Exception e) {
			e.printStackTrace();
		}

        ArbolBinario.inorderWalk(a.root);
        System.out.println();

        ArbolBinario.postoderWalk(a.root);
        System.out.println();

        ArbolBinario.preorderWalk(a.root);
        System.out.println();
    }

    static void ejemplo_cola() {
        try {
            final Cola p = new Cola();

            p.enqueue(1, true);
            p.enqueue(2, true);
            p.enqueue(3, true);
            p.enqueue(4, true);
            p.enqueue(5, true);
            p.dequeue(true);
            p.enqueue(6, true);
            p.dequeue(true);
            p.dequeue(true);
            p.enqueue(7, true);
            p.dequeue(true);
            p.dequeue(true);
            p.dequeue(true);
            p.dequeue(true);
            p.dequeue(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void ejemplo_pila() {
        try {
            final Pila p = new Pila();

            p.push(1, true);
            p.push(2, true);
            p.push(3, true);
            p.push(4, true);
            p.push(5, true);
            p.pop();
            p.push(6, true);
            p.pop(true);
            p.pop(true);
            p.push(7, true);
            p.pop(true);
            p.pop(true);
            p.pop(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void ejemplo_lista_doblemente_enlazada() {
        try {
            final ListaDobleEnlazada lst = new ListaDobleEnlazada();
            lst.addEnFin(1);
            lst.addEnFin(2);
            lst.addEnFin(3);

            lst.printList();

            lst.addEnIni(4);
            lst.addEnIni(5);
            lst.addEnIni(6);

            lst.printList();

            lst.clrIni();
            lst.printList();

            lst.clrFin();
            lst.printList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void ejemplo_lista_enlazada() {
        try {
            final ListaEnlazada lst = new ListaEnlazada();
            lst.addEnFin(1);
            lst.addEnFin(2);
            lst.addEnFin(3);

            lst.printList();

            lst.addEnIni(4);
            lst.addEnIni(5);
            lst.addEnIni(6);

            lst.printList();

            lst.clrIni();
            lst.printList();

            lst.clrFin();
            lst.printList();

            lst.clrFin();
            lst.printList();

            lst.clrFin();
            lst.printList();

            lst.clrFin();
            lst.printList();

            lst.clrFin();
            lst.printList();

            lst.clrFin();
            lst.printList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}