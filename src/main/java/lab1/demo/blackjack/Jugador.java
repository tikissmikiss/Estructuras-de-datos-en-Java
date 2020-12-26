package lab1.demo.blackjack;

import lab1.demo.util.io;
import lab1.pila.Pila;

public class Jugador {
    private String nombre;
    private Pila<Carta> mano;
    private int puntuacion;
    private int cntGanadas;
    private int puntMin;

    public Jugador(String nombre) {
        this.nombre = nombre;
        mano = new Pila<Carta>();
        puntuacion = 0;
    }

    public void recibirCarta(Carta carta) {
        mano.push(carta);
    }

    public Carta sacarCarta() {
        return mano.pop();
    }

    public void sumarPuntuacion(int puntos) {
        puntuacion += puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return getPuntuacion(false);
    }

    public int getPuntuacion(boolean incluirCubiertas) {
        if (mano.isEmpty())
            return 0;
        puntuacion = 0;
        Pila<Carta> auxPila = new Pila<>();
        int cntAs = 0;
        while (!mano.isEmpty()) {
            auxPila.push(mano.pop());
            int val = auxPila.peek().getValor(incluirCubiertas);
            puntuacion += val;
            if (val == 11) { // Si es un AS se contabiliza el AS
                cntAs++;
            }
        }
        // Si hay Ases, si se supera 21 se resta 10 para que el valor del As sea 1
        puntMin = puntuacion;
        for (; cntAs > 0; cntAs--) {
            puntMin -= 10; // puntuacion minima para toma de decisiones de mas cartas
            if (puntuacion > 21)
                puntuacion -= 10;
        }
        while (!auxPila.isEmpty())
            mano.push(auxPila.pop());
        return puntuacion;
    }

    public void addWin() {
        cntGanadas++;
    }

    public String manoToString() {
        String s = mano.toString();
        String[] strCarta = s.split("\n");
        s = "";
        for (int i = 0; i < strCarta.length; i++) {
            s += io.linea(strCarta[i], 60, "|");
            if (i < strCarta.length-1)
                s += "\n";
        }
        return s;
    }

    public int getPuntMin() {
        return puntMin;
    }

    public Pila<Carta> getMano() {
        return mano;
    }

    public void resetPuntuacion() {
        puntuacion = 0;
    }

    @Override
    public String toString() {
        return nombre + " " + "   |   Victorias: " + cntGanadas;
    }

}
