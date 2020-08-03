package app;

import estructuras_datos.*;
import estructuras_datos.Arboles.*;

/**
 * App para testeo de las estructuras de datos
 * 
 * @author José Herce
 * @version 0.1 - 27/07/2020
 */
public class App {
    public static void main(final String[] args) throws Exception {
        ejemplo_lista_doblemente_enlazada();
        ejemplo_lista_enlazada();
        ejemplo_pila();
        ejemplo_cola();
        ejemplo_arbol_binario();
        ejemplo_arbol_binario_busqueda();
        ejemplo_tabla_hash();
        // ejemplo_arbol_AVL();
    }

    static void ejemplo_arbol_AVL() throws Exception {
        Arbol_AVL a = new Arbol_AVL();
        int valores[] = { 52, 90, 23, 48, 17, 36, 42, 88, 21, 57, 72 };
        /*
         * TODO Actualizar a balanceado (52) / \ (23) (90) / \ / (17) (48) (88) \ / /
         * (21)(36) (57) \ \ (42) (72)
         */
        for (int i : valores) {
            a.insert(i);
        }
    }

    static void ejemplo_tabla_hash() throws Exception {
        Person[] people = {
            new Person("Pepe"),
            new Person("Jose"),
            new Person("Marisa"),
            new Person("Elena"),
            new Person("Pedro"),
            new Person("Jose Antonio"),
            new Person("Luisa"),
            new Person("Samuel"),
            new Person("Isabel"),
            new Person("Zaira"),
            new Person("Jose"),
        };
        TablaHash t1 = new TablaHash(3);
        for (Person person : people) {
            t1.add(person.key, person);
        }
        System.out.println(t1.toString());

        if (people[1].equals(people[2]));
        boolean b = (people[1]==people[10]) ? true : false;
        System.out.println(b);
        b = people[1].equals(people[10]);
        System.out.println(b);

        // TODO continuar tabla hash

        TablaHash t2 = new TablaHash(10);
        int valor;

        for (int i = 0; i < 20; i++) {
            valor = (int) (Math.random()*100);
            // t.add(valor, String.valueOf(valor));
            // char c = (char) ((char) (Math.random() * ('Z' - 'A')) + 'A');
            char[] c = {
                (char) ((char) (Math.random() * ('Z' - 'A')) + 'A'),
                (char) ((char) (Math.random() * ('Z' - 'A')) + 'A'), 
                (char) ((char) (Math.random() * ('Z' - 'A')) + 'A')};

                // TODO ??????????????????????????
            // String string = String.valueOf(c);

                // String string = 
                // String.valueOf((char) (Math.random() * ((int) 'Z' - (int) 'A')) + (int) 'A') + 
                // String.valueOf((char) (Math.random() * ((int) 'Z' - (int) 'A')) + (int) 'A') + 
                // String.valueOf((char) (Math.random() * ((int) 'Z' - (int) 'A')) + (int) 'A');

            t2.add(valor, String.valueOf(c));
        }
    }
    
    static class Person {
        private int key;
        private String name;

        public static int count = 0;

        public Person(int k, String name) {
            this.setKey(k);
            this.setName(name);
            count++;
        }

        public Person(String name) {
            this.setKey(count++);
            this.setName(name);
        }

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public boolean equals(Object person) {
            Person p = (Person) person;
            return this.name == p.name;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static void ejemplo_arbol_binario_busqueda() throws Exception {
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

        ArbolBinarioBusqueda.preorderWalk(a.root);
        System.out.println();
        ArbolBinarioBusqueda.inorderWalk(a.root);
        System.out.println();
        ArbolBinarioBusqueda.postoderWalk(a.root);
        System.out.println();
        ArbolBinarioBusqueda.breadthWalk(a.root);
        System.out.println();

        System.out.println("Máximo: " + a.maximunNodo().value);
        System.out.println("Máximo: " + a.maximunVal());
        System.out.println("Mínimo: " + a.minimunNodo().value);
        System.out.println("Mínimo: " + a.minimunVal());

        System.out.print("Ruta hasta el 72: ");
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
        // NOTA: Para obtener los árboles de arriba borrar 23 o 52. Uno u otro, no ambos.
        a.delete(52);
        // a.delete(23);

        ArbolBinarioBusqueda.preorderWalk(a.root);
        System.out.println();
        ArbolBinarioBusqueda.inorderWalk(a.root);
        System.out.println();
        ArbolBinarioBusqueda.postoderWalk(a.root);
        System.out.println();
    }

    static void ejemplo_arbol_binario() throws Exception {
        /*
        *           (4) 
        *          /  \
        *       (5)   (3)
        *      /  \     \
        *    (1)  (2)   (6)
        *        / 
        *      (7)
        */
        ArbolBinario a = new ArbolBinario();   // Raíz
        a.setRoot(4);
        a.root.setHijoIzq(5);
        a.root.hijoIzq.setHijoIzq(1);
        a.root.hijoIzq.setHijoDch(2);
        a.root.hijoIzq.hijoDch.setHijoIzq(7);
        a.root.setHijoDch(3);
        a.root.hijoDch.setHijoDch(6);

        ArbolBinario.inorderWalk(a.root);
        System.out.println();

        ArbolBinario.postoderWalk(a.root);
        System.out.println();

        ArbolBinario.preorderWalk(a.root);
        System.out.println();

        ArbolBinario.breadthWalk(a.root);
        System.out.println();
    }

    static void ejemplo_cola() throws Exception {
        final Cola<Integer> p = new Cola<Integer>();

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
    }

    static void ejemplo_pila() throws Exception {
        final Pila<Integer> p = new Pila<Integer>();

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
    }

    static void ejemplo_lista_doblemente_enlazada() throws Exception {
        final ListaDobleEnlazada<Integer> lst = new ListaDobleEnlazada<Integer>();
        lst.addEnFin(1);
        lst.addEnFin(2);
        lst.addEnFin(3);

        System.out.println(lst.toString());

        lst.addEnIni(4);
        lst.addEnIni(5);
        lst.addEnIni(6);

        System.out.println(lst.toString());

        lst.clrIni();
        System.out.println(lst.toString());

        lst.clrFin();
        System.out.println(lst.toString());
    }

    static void ejemplo_lista_enlazada() throws Exception {
        final ListaEnlazada lst = new ListaEnlazada();
        lst.addEnFin(1);
        lst.addEnFin(2);
        lst.addEnFin(3);

        System.out.println(lst.toString());

        lst.addEnIni(4);
        lst.addEnIni(5);
        lst.addEnIni(6);

        System.out.println(lst.toString());

        lst.clrIni();
        System.out.println(lst.toString());

        lst.clrFin();
        System.out.println(lst.toString());

        lst.clrFin();
        System.out.println(lst.toString());

        lst.clrFin();
        System.out.println(lst.toString());

        lst.clrFin();
        System.out.println(lst.toString());

        lst.clrFin();
        System.out.println(lst.toString());

    }
}