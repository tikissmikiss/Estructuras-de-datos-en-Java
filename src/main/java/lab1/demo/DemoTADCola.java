package lab1.demo;

import java.util.ArrayList;

import lab1.cola.Cola;
import lab1.demo.blackjack.Carta;
import lab1.demo.blackjack.Figura;
import lab1.demo.blackjack.Palo;
import lab1.demo.util.io;

public class DemoTADCola {
    private static int ancho = 60;

    public static void main(String[] args) {
        System.out.println();
        System.out.println(io.box('=', ancho, '='));
        System.out.println(io.linea("             - Estructuras de datos lineales -", ancho, "|"));
        System.out.println(io.box('=', ancho, '|'));
        System.out.println(io.linea("                       Cola dinamica", ancho, "|"));
        System.out.println(io.box('-', ancho, '|'));
        System.out.println(io.parrafo("Testeo de funcionalidades de la cola dinamica.", ancho, "|", 1));
        System.out.println(io.linea("   por: José Herce Preciado", ancho, "|"));
        System.out.println(io.box('=', ancho, '='));
        System.out.println();

        testCola();

    }

    private static void testCola() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test poner en Cola ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Cola<Object>. Podra contener cualquier tipo de objeto.");
        Cola<Object> miCola = new Cola<Object>();
        miCola.print();
        io.esperarUsuario();

        System.out.println("Crear objetos ArrayList<> para trabajar con instancias de objeto");
        ArrayList<String> listaStrings = new ArrayList<>();
        listaStrings.add("Esto es un string - cero");
        listaStrings.add("Esto es un string - uno");
        listaStrings.add("Esto es un string - dos");

        ArrayList<Integer> listaIntegers = new ArrayList<>();
        listaIntegers.add(0);
        listaIntegers.add(1);
        listaIntegers.add(2);

        ArrayList<Double> listaDoubles = new ArrayList<>();
        listaDoubles.add(1.1);
        listaDoubles.add(22.22);
        listaDoubles.add(333.333);

        ArrayList<Boolean> listaBooleans = new ArrayList<>();
        listaBooleans.add(true);
        listaBooleans.add(false);
        listaBooleans.add(true);

        ArrayList<Carta> listaCartas = new ArrayList<>();
        listaCartas.add(new Carta(Palo.PIKAS, Figura.AS));
        listaCartas.add(new Carta(Palo.CORAZONES, Figura.K));
        listaCartas.add(new Carta(Palo.ROMBOS, Figura.II));

        System.out.println("Aniadir un elemento \"listaStrings\"");
        miCola.queue(listaStrings);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"listaIntegers\"");
        miCola.queue(listaIntegers);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"listaDoubles\"");
        miCola.queue(listaDoubles);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"listaBooleans\"");
        miCola.queue(listaBooleans);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"listaCartas\"");
        miCola.queue(listaCartas);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"cero\"");
        miCola.queue("cero");
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"uno\"");
        miCola.queue("uno");
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"dos\"");
        miCola.queue("dos");
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"tres\"");
        miCola.queue("tres");
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Integer\"");
        miCola.queue((Integer) 25);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Double\"");
        miCola.queue((Double) 25.125);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Boolean\"");
        miCola.queue((Boolean) true);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"String\"");
        miCola.queue("Esto es una cadena");
        miCola.print();
        io.esperarUsuario();

        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test desencolar ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        while (!miCola.isEmpty()) {
            System.out.println("Desencolar e imprimir un elemento");
            System.out.println(miCola.dequeue());
            io.esperarUsuario();
            System.out.println("Imprimir Cola");
            miCola.print();
            io.esperarUsuario();
        }

        System.out.println("Desencolar e imprimir un elemento");
        System.out.println(miCola.dequeue());
        io.esperarUsuario();
        System.out.println("Imprimir Cola");
        System.out.println(miCola);
        io.esperarUsuario();
    }

}