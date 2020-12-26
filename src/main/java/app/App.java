package app;

import estructuras_datos.*;
import estructuras_datos.arboles.*;
import lab1.cola.Cola;
import lab1.pila.Pila;

/**
 * App para testeo de las estructuras de datos
 * 
 * @author José Herce
 * @version 0.1 - 27/07/2020
 */
public class App {
    public static void main(final String[] args) throws Exception {
        ejemplo_arbol_binario_busqueda();
        
    }

    static void ejemplo_arbol_binario_busqueda() throws Exception {
        ABB a = new ABB();
        System.out.println("Arbol objetivo:\n");
        int valores[] = {52,90,23,48,17,36,42,88,21,57,72};
        System.out.println("Elementos a insertar:");
        System.out.println("52 90 23 48 17 36 42 88 21 57 72");
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
        System.out.println("\nArbol según orden de inserción:\n");
        System.out.println("           (52)       ");
        System.out.println("          /    \\      ");
        System.out.println("      (23)     (90)   ");
        System.out.println("     /   \\     /      ");
        System.out.println(" (17)   (48) (88)     ");
        System.out.println("   \\    /    /        ");
        System.out.println("  (21)(36) (57)       ");
        System.out.println("        \\    \\        ");
        System.out.println("        (42) (72)     ");
        for (int i : valores) {
            a.insertar(i);
        }

        a.print();

        System.out.println("\n\nPreorder previsto:");
        System.out.println("52 23 17 21 48 36 42 90 88 57 72");
        System.out.println("Preorder resultado:");
        a.printPreorder();
        System.out.println("\n\nInorder previsto:");
        System.out.println("17 21 23 36 42 48 52 57 72 88 90");
        System.out.println("Inorder resultado:");
        a.printInorder();
        System.out.println("\n\nPostorder previsto:");
        System.out.println("21 17 42 36 48 23 72 57 88 90 52");
        System.out.println("Postorder resultado:");
        a.printPostoder();
        System.out.println("\n\nEn anchura previsto:");
        System.out.println("52 23 90 17 48 88 21 36 57 42 72");
        System.out.println("En anchura resultado:");
        a.breadthWalk();
        System.out.println();

        System.out.println("Máximo: " + a.maximo());
        System.out.println("Mínimo: " + a.minimo());

        System.out.print("Ruta hasta el 72: ");
        // ABB.printPath(a.buscar(72));
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
        // NOTA: Para obtener los árboles de arriba borrar 23 o 52. Uno u otro, no ambos.
        // //a.borrar(52);
        // a.delete(23);

        a.printPreorder();
        System.out.println();
        a.printInorder();
        System.out.println();
        a.printPostoder();
        System.out.println();
    }

    // static void ejemplo_arbol_binario() throws Exception {
    //     /*
    //     *           (4) 
    //     *          /  \
    //     *       (5)   (3)
    //     *      /  \     \
    //     *    (1)  (2)   (6)
    //     *        / 
    //     *      (7)
    //     */
    //     ArbolBinario a = new ArbolBinario();   // Raíz
    //     a.setRoot(4);
    //     a.root.setHijoIzq(5);
    //     a.root.hijoIzq.setHijoIzq(1);
    //     a.root.hijoIzq.setHijoDch(2);
    //     a.root.hijoIzq.hijoDch.setHijoIzq(7);
    //     a.root.setHijoDch(3);
    //     a.root.hijoDch.setHijoDch(6);

    //     ArbolBinario.inorderWalk(a.root);
    //     System.out.println();

    //     ArbolBinario.postoderWalk(a.root);
    //     System.out.println();

    //     ArbolBinario.preorderWalk(a.root);
    //     System.out.println();

    //     ArbolBinario.breadthWalk(a.root);
    //     System.out.println();
    // }

    static void ejemplo_cola() throws Exception {
        final Cola<Integer> p = new Cola<Integer>();

        p.queue(1);
        p.queue(2);
        p.queue(3);
        p.queue(4);
        p.queue(5);
        p.dequeue();
        p.queue(6);
        p.dequeue();
        p.dequeue();
        p.queue(7);
        p.dequeue();
        p.dequeue();
        p.dequeue();
        p.dequeue();
    }

    static void ejemplo_pila() throws Exception {
        final Pila<Integer> p = new Pila<Integer>();

        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);
        p.push(5);
        p.pop();
        p.push(6);
        p.pop();
        p.pop();
        p.push(7);
        p.pop();
        p.pop();
        p.pop();
    }


    
    
}