package lab1.demo;

import lab1.demo.blackjack.Carta;
import lab1.demo.blackjack.Figura;
import lab1.demo.blackjack.Palo;
import lab1.demo.util.io;
import lab1.lista.Lista;

public class DemoTADLista {
    private static int ancho=60;

    public static void main(String[] args) {

        cabecera();

        testAdd();
        testPrint();
        testClear();
        testGet();
        testExtract();
        testCheck();
        testIndexOf();
        testDatosCompuestos();
        testNodoVacio();

    }

    private static void cabecera() {
        System.out.println();
		System.out.println(io.box('=', ancho, '='));
		System.out.println(io.linea("             - Estructuras de datos lineales -", ancho, "|"));
		System.out.println(io.box('=', ancho, '|'));
		System.out.println(io.linea("                 Lista doblemente enlazada", ancho, "|"));
		System.out.println(io.box('-', ancho, '|'));
		System.out.println(io.parrafo("Testeo de funcionalidades de la lista doblemente enlaza.", ancho, "|", 1));
		System.out.println(io.linea("   por: José Herce Preciado", ancho, "|"));
		System.out.println(io.box('=', ancho, '='));
		System.out.println();
    }

    private static void testNodoVacio() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test iniciar nodos a null ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"null\"");
        miLista.add(null);
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"null\"");
        miLista.add(null);
        miLista.print();
        io.esperarUsuario();
    }

    private static void testClear() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test Clear lista ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir 3 elementos");
        miLista.add("cero");
        miLista.add("uno");
        miLista.add("dos");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Reiniciar lista");
        miLista.clear();
        io.esperarUsuario();

        System.out.println("Imprimir lista");
        miLista.print();
        io.esperarUsuario();
    }

    private static void testCheck() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test Comprobar existencia datos ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.print();
        io.esperarUsuario();

        System.out.println("Comprobar si esta \"uno\"");
        System.out.println(miLista.check("uno") ? "\"uno\" si esta" : "\"uno\" no esta");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir 3 elementos");
        miLista.add("cero");
        miLista.add("uno");
        miLista.add("dos");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Comprobar si esta \"uno\"");
        System.out.println(miLista.check("uno") ? "\"uno\" si esta" : "\"uno\" no esta");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Comprobar si esta \"tres\"");
        System.out.println(miLista.check("tres") ? "\"tres\" si esta" : "\"tres\" no esta");
        miLista.print();
        io.esperarUsuario();

    }

    private static void testPrint() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test Imprimir datos ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        System.out.println("Imprimir Lista");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Imprimir posicion 2");
        if (miLista.print(2) == null)
            System.out.println("Dato no encontrado");
        else
            System.out.println("Dato encontrado");

        io.esperarUsuario();

        System.out.println("Aniadir 3 elementos");
        miLista.add("cero");
        miLista.add("uno");
        miLista.add("dos");
        System.out.println("Imprimir Lista");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Imprimir y recuperar dato posicion 2");
        String dato = miLista.print(2);
        if (dato == null)
            System.out.println("Dato no encontrado");
        else
            System.out.println("Dato recuperado");

        System.out.println("Imprimir dato recuperado");
        System.out.println(dato);
        io.esperarUsuario();
    }

    private static void testExtract() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test Extraer por dato ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.print();
        io.esperarUsuario();

        System.out.println("Sacar e imprimir \"uno\"");
        String dato = miLista.extract("uno");
        if (dato != null)
            System.out.println("Se ha localizado el elemento. Su posicion es: " + dato);
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir 4 elementos");
        miLista.add("cero");
        miLista.add("uno");
        miLista.add("dos");
        miLista.add("uno");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Sacar e imprimir \"uno\"");
        dato = miLista.extract("uno");
        if (dato != null)
        System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Sacar e imprimir \"cero\"");
        dato = miLista.extract("cero");
        if (dato != null)
        System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Sacar e imprimir \"uno\"");
        dato = miLista.extract("uno");
        if (dato != null)
        System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Sacar e imprimir \"dos\"");
        dato = miLista.extract("dos");
        if (dato != null)
        System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test Extraer por posicion ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Sacar e imprimir posicion 1");
        dato = miLista.extract(1);
        if (dato != null)
        System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir 4 elementos");
        miLista.add("cero");
        miLista.add("uno");
        miLista.add("dos");
        miLista.add("tres");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Sacar e imprimir posicion 3");
        dato = miLista.extract(3);
        if (dato != null)
        System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Sacar e imprimir posicion 0");
        dato = miLista.extract(0);
        if (dato != null)
            System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Sacar e imprimir posicion 1");
        dato = miLista.extract(1);
        if (dato != null)
            System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Sacar e imprimir posicion 0");
        dato = miLista.extract(0);
        if (dato != null)
            System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();
    }

    private static void testGet() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test Obtener posicion ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.print();
        io.esperarUsuario();

        System.out.println("Obtener posicion 2");
        String dato = miLista.get(2);
        if (dato != null)
            System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir elemento \"cero\"");
        miLista.add("cero");

        System.out.println("Obtener posicion 2");
        dato = miLista.get(2);
        if (dato != null)
            System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir elemento \"uno\"");
        miLista.add("uno");

        System.out.println("Obtener posicion 1");
        dato = miLista.get(1);
        if (dato != null)
            System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir elemento \"dos\"");
        miLista.add("dos");

        System.out.println("Obtener posicion 2");
        dato = miLista.get(2);
        if (dato != null)
            System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir elemento \"tres\"");
        miLista.add("tres");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Obtener posicion 2");
        dato = miLista.get(2);
        if (dato != null)
            System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

        System.out.println("Obtener posicion 1");
        dato = miLista.get(1);
        if (dato != null)
            System.out.println("Se ha localizado el elemento. El elemento es: \"" + dato + "\"");
        else
            System.out.println("Imposible recuperar el dato");

        miLista.print();
        io.esperarUsuario();

    }

    private static void testDatosCompuestos() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test Busqueda Por Contenido - datos compuestos", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Lista tipo Objetos Carta");
        Lista<Carta> miListaObj = new Lista<>();
        miListaObj.print();
        io.esperarUsuario();

        System.out.println("Aniadir As de pikas");
        miListaObj.add(new Carta(Palo.PIKAS, Figura.AS));
        miListaObj.print();
        io.esperarUsuario();

        System.out.println("Aniadir K de treboles");
        miListaObj.add(new Carta(Palo.TREBOLES, Figura.K));
        miListaObj.print();
        io.esperarUsuario();

        System.out.println("Aniadir K de ROMBOS");
        miListaObj.add(new Carta(Palo.ROMBOS, Figura.K));
        miListaObj.print();
        io.esperarUsuario();

        System.out.println("Aniadir K de CORAZONES");
        miListaObj.add(new Carta(Palo.CORAZONES, Figura.K));
        miListaObj.print();
        io.esperarUsuario();

        System.out.println("Buscar posicion de un K de treboles");
        Carta carta = new Carta(Palo.TREBOLES, Figura.K);
        int p = miListaObj.indexOf(carta);
        if (miListaObj.indexOf(carta) != -1)
            System.out.println("Encontrado " + carta + " en posicion " + p);
        else
            System.out.println("No se ha encontrado " + carta);
        miListaObj.print();
        io.esperarUsuario();

        System.out.println("Buscar posicion de un 5 de treboles");
        carta = new Carta(Palo.TREBOLES, Figura.V);
        p = miListaObj.indexOf(carta);
        if (p != -1)
            System.out.println("Encontrado " + carta + " en posicion " + p);
        else
            System.out.println("No se ha encontrado " + carta);
        miListaObj.print();
        io.esperarUsuario();

        System.out.println("Comprobar si hay un K de treboles");
        carta = new Carta(Palo.TREBOLES, Figura.K);
        if (miListaObj.check(carta))
            System.out.println("Se ha encontrado " + carta);
        else
            System.out.println("No se ha encontrado " + carta);
        miListaObj.print();
        io.esperarUsuario();

        System.out.println("Comprobar si hay un 5 de treboles");
        carta = new Carta(Palo.TREBOLES, Figura.V);
        if (miListaObj.check(carta))
            System.out.println("Encontrado " + carta + " en posicion " + p);
        else
            System.out.println("No se ha encontrado " + carta);
        miListaObj.print();
        io.esperarUsuario();
    }

    private static void testIndexOf() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test Obtener posicion ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.print();
        io.esperarUsuario();

        System.out.println("Obtener posicion que contiene \"dos\"");
        int dato = miLista.indexOf("dos");
        if (dato < 0)
            System.out.println("Imposible recuperar el dato");
        else
        System.out.println("Se ha localizado el elemento. Su posicion es: " + dato);
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir elemento \"cero\"");
        miLista.add("cero");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Obtener posicion que contiene \"dos\"");
        dato = miLista.indexOf("dos");
        if (dato < 0)
            System.out.println("Imposible recuperar el dato");
        else
        System.out.println("Se ha localizado el elemento. Su posicion es: " + dato);
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir elemento \"uno\"");
        miLista.add("uno");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Obtener posicion que contiene \"dos\"");
        dato = miLista.indexOf("dos");
        if (dato < 0)
            System.out.println("Imposible recuperar el dato");
        else
        System.out.println("Se ha localizado el elemento. Su posicion es: " + dato);
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir elemento \"dos\"");
        miLista.add("dos");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Obtener posicion que contiene \"dos\"");
        dato = miLista.indexOf("dos");
        if (dato < 0)
            System.out.println("Imposible recuperar el dato");
        else
        System.out.println("Se ha localizado el elemento. Su posicion es: " + dato);
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir elemento \"uno\"");
        miLista.add("uno");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Obtener posicion que contiene \"dato\"");
        dato = miLista.indexOf("dato");
        if (dato < 0)
            System.out.println("Imposible recuperar el dato");
        else
        System.out.println("Se ha localizado el elemento. Su posicion es: " + dato);
        miLista.print();
        io.esperarUsuario();

        System.out.println("Obtener posicion que contiene \"dos\"");
        dato = miLista.indexOf("dos");
        if (dato < 0)
            System.out.println("Imposible recuperar el dato");
        else
        System.out.println("Se ha localizado el elemento. Su posicion es: " + dato);
        miLista.print();
        io.esperarUsuario();

    }

    private static void testAdd() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test aniadir datos al final", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"cero\"");
        miLista.add("cero");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"uno\"");
        miLista.add("uno");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"dos\"");
        miLista.add("dos");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"tres\"");
        miLista.add("tres");
        miLista.print();
        io.esperarUsuario();

        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test aniadir datos en posicion ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Insertar elemento en posicion 2");
        if (miLista.add("insert 2", 2))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Insertar elemento en posicion 1");
        if (miLista.add("insert 1", 1))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Insertar elemento en posicion 0");
        if (miLista.add("insert 0", 0))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Reset Lista");
        miLista.clear();
        miLista.print();
        io.esperarUsuario();

        System.out.println("Insertar elemento en posicion -1");
        if (miLista.add("insert -1", -1))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Insertar elemento en posicion 10");
        if (miLista.add("insert 10", 10))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Insertar elemento 'uno' en posicion 0");
        if (miLista.add("uno", 0))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Insertar elemento 'dos' en posicion 0");
        if (miLista.add("dos", 0))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Insertar elemento 'tres' en posicion 0");
        if (miLista.add("tres", 0))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Insertar elemento en posicion 1");
        if (miLista.add("insert 1", 1))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.print();
        io.esperarUsuario();

        System.out.println("Insertar elemento en posicion 4");
        if (miLista.add("insert 4", 4))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.print();
        io.esperarUsuario();
    }

}
