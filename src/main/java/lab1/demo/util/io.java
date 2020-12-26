package lab1.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lab1.demo.Demo;

public class io {

    public static int leerInt(String msg) {
        System.out.println(msg);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String resp;
        try {
            resp = in.readLine();
            return Integer.parseInt(resp);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Entrada no permitida");
            return leerInt(msg);
        }
    }

    public static int leerInt(String msg, int defecto) {
        System.out.println(msg);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String resp;
        try {
            resp = in.readLine();
            if (resp.equals(""))
                return defecto;
            return Integer.parseInt(resp);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Entrada no permitida");
            return leerInt(msg, defecto);
        }
    }

    public static String leerString(String msg) {
        System.out.println(msg);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            return in.readLine();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Entrada no permitida");
            return leerString(msg);
        }
    }

    public static String leerString(String msg, String defecto) {
        System.out.println(msg);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String resp;
        try {
            resp = in.readLine();
            if (resp.equals(""))
                return defecto;
            return resp;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Entrada no permitida");
            return leerString(msg);
        }
    }

    public static void esperarUsuario() {
        System.out.println();
        if (Demo.stepByStep) {
            io.leerString("    >>> pulse ENTER para continuar <<<");
        }
    }

    /**
     * Dibuja una apertura/cierre/seccion de caja
     * 
     * @param charLinea     Caracter para hacer la linea
     * @param numCaracteres longitud de la linea
     * @param charExtremos  primer y ultimo caracter
     * @return La cadena a imprimir
     */
    public static String box(char charLinea, int numCaracteres, char charExtremos) {
        char[] linea = new char[numCaracteres - 2];
        for (int i = 0; i < linea.length; i++) {
            linea[i] = charLinea;
        }
        return charExtremos + new String(linea) + charExtremos;
    }

    /**
     * Inserta texto en una caja
     * 
     * @param string        Cadena a insertar en la caja
     * @param numCaracteres anchura de la caja
     * @param strinExtremos caracter de apertura y cierre
     * @return La cadena a imprimir
     */
    public static String linea(String string, int numCaracteres, String strinExtremos) {
        String s = strinExtremos + string;
        if (s.length() < numCaracteres) {
            int len = numCaracteres - 1 - s.length();
            char[] sufijo = new char[len];
            for (int i = 0; i < sufijo.length; i++) {
                sufijo[i] = ' ';
            }
            s += new String(sufijo) + strinExtremos;
        }
        return s;
    }

    public static String parrafo(String string, int ancho, String charExtremos, int spcMargen) {
        String[] palabra = string.split(" ");
        final String sp = " ";
        string = "";
        String margen = "";
        for (int i = 0; i < spcMargen; i++) {
            margen += " ";
        }

        String linea = margen + palabra[0];
        for (int i = 1; i < palabra.length; i++) {
            if (linea.length() + sp.length() + palabra[i].length() + margen.length()
                    + charExtremos.length() * 2 <= ancho) {
                linea += sp + palabra[i];
            } else {
                string += linea(linea, ancho, charExtremos) + "\n";
                linea = margen + palabra[i];
            }
        }
        string += linea(linea, ancho, charExtremos);
        return string;
    }

}
