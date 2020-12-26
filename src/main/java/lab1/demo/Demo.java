package lab1.demo;

import lab1.demo.util.io;

public class Demo {
    public static boolean stepByStep;

    public static void main(String[] args) {
        consulta();

        DemoTADLista.main(args);
        DemoTADPila.main(args);
        DemoTADCola.main(args);

        DemoUsoTADs.main(args);
    }

    private static void consulta() {
        String rsp;
        do {
            rsp = io.leerString("\nHabilitar ejecución paso a paso? [y/n] (por defecto: n)", "n");
            if (rsp.equals("y"))
                stepByStep = true;
            else if (rsp.equals("n"))
                stepByStep = false;
            else
                System.out.println("Respuesta no aceptada...");
        } while (!(rsp.equals("y") || rsp.equals("n")));
    }
}
