package lab1.demo;

import java.util.ArrayList;

import lab1.demo.blackjack.Carta;
import lab1.demo.blackjack.Figura;
import lab1.demo.blackjack.Palo;
import lab1.demo.util.io;
import lab1.pila.Pila;

public class DemoTADPila {

    private static int ancho = 60;

    public static void main(String[] args) {
        cabecera();

        testPila();

    }

    private static void cabecera() {
        System.out.println();
        System.out.println(io.box('=', ancho, '='));
        System.out.println(io.linea("             - Estructuras de datos lineales -", ancho, "|"));
        System.out.println(io.box('=', ancho, '|'));
        System.out.println(io.linea("                       Pila dinamica", ancho, "|"));
        System.out.println(io.box('-', ancho, '|'));
        System.out.println(io.parrafo("Testeo de funcionalidades de la pila dinamica.", ancho, "|", 1));
        System.out.println(io.linea("   por: José Herce Preciado", ancho, "|"));
        System.out.println(io.box('=', ancho, '='));
        System.out.println();
    }

    private static void testPila() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test apilar ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Pila<Object>. Podra contener cualquier tipo de objeto.");
        Pila<Object> miPila = new Pila<Object>();
        miPila.print();
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

        ArrayList<Boolean> listaBouleans = new ArrayList<>();
        listaBouleans.add(true);
        listaBouleans.add(false);
        listaBouleans.add(true);

        ArrayList<Carta> listaCartas = new ArrayList<>();
        listaCartas.add(new Carta(Palo.PIKAS, Figura.AS));
        listaCartas.add(new Carta(Palo.CORAZONES, Figura.K));
        listaCartas.add(new Carta(Palo.ROMBOS, Figura.II));

        System.out.println("Aniadir el elemento listaStrings a la pila");
        miPila.push(listaStrings);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir el elemento listaIntegers a la pila");
        miPila.push(listaIntegers);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir el elemento listaDoubles a la pila");
        miPila.push(listaDoubles);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir el elemento listaBouleans a la pila");
        miPila.push(listaBouleans);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir el elemento listaCartas a la pila");
        miPila.push(listaCartas);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"cero\" a la pila");
        miPila.push("cero");
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"uno\" a la pila");
        miPila.push("uno");
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"dos\" a la pila");
        miPila.push("dos");
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"tres\" a la pila");
        miPila.push("tres");
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Integer\" a la pila");
        miPila.push((Integer) 25);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Double\" a la pila");
        miPila.push((Double) 25.125);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Boolean\" a la pila");
        miPila.push((Boolean) true);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"String\" a la pila");
        miPila.push("Esto es una cadena");
        miPila.print();
        io.esperarUsuario();

        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test desapilar ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));
        miPila.print();
        io.esperarUsuario();

        while (!miPila.isEmpty()) {
            System.out.println("Pila no vacia - Desapilar e imprimir un elemento");
            System.out.println(miPila.pop());
            io.esperarUsuario();
            System.out.println("Imprimir Pila");
            miPila.print();
            io.esperarUsuario();
        }

        System.out.println("Desapilar e imprimir un elemento");
        System.out.println(miPila.pop());
        io.esperarUsuario();
        System.out.println("Imprimir Pila");
        miPila.print();
        io.esperarUsuario();
    }

}
