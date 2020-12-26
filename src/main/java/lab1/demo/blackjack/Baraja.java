package lab1.demo.blackjack;

import java.util.Random;

import lab1.cola.Cola;
import lab1.lista.Lista;

public class Baraja {
    private static final int NUMERO_MEZCLAS = 4;
    private int numeroPalos;
    private int numeroFiguras;
    private Cola<Carta> mazo;

    public Baraja(int numeroPalos, int numeroFiguras) {
        inicializar(numeroPalos, numeroFiguras, 1);
    }

    public Baraja(int numeroPalos, int numeroFiguras, int numBarajas) {
        inicializar(numeroPalos, numeroFiguras, numBarajas);
    }

    private void inicializar(int numeroPalos, int numeroFiguras, int numBarajas) {
        setNumeroPalos(numeroPalos);
        setNumeroFiguras(numeroFiguras);
        mazo = new Cola<>();
        for (int i = 0; i < numBarajas; i++) {
            buildBaraja();
        }
    }

    private void buildBaraja() {
        Palo[] palos = Palo.values();
        Figura[] figuras = Figura.values();
        for (int i = 0; i < numeroPalos; i++) {
            for (int j = 0; j < numeroFiguras; j++) {
                mazo.queue(new Carta(palos[i], figuras[j]));
            }
        }
    }

    public boolean mezclar() {
        Lista<Carta> aux1 = new Lista<>();
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < NUMERO_MEZCLAS; i++) {
            while (!mazo.isEmpty()) {
                int insertPos = random.nextInt(aux1.size() + 1);
                aux1.add(mazo.dequeue(), insertPos);
            }
            while (aux1.size() > 0) {
                int extracPos = random.nextInt(aux1.size());
                mazo.queue(aux1.extract(extracPos));
            }
        }
        return true;
    }

    private void setNumeroFiguras(int numeroFiguras) {
        if (numeroFiguras < 1)
            this.numeroFiguras = 1;
        if (numeroFiguras > 15)
            this.numeroFiguras = 15;
        this.numeroFiguras = numeroFiguras;
    }

    private void setNumeroPalos(int numeroPalos) {
        if (numeroFiguras < 1)
            this.numeroPalos = 1;
        if (numeroFiguras > 5)
            this.numeroPalos = 5;
        this.numeroPalos = numeroPalos;
    }

    public int getLength() {
        return mazo.size();
    }

    public Carta darCarta() {
        if (!mazo.isEmpty())
            return mazo.dequeue();
        return null;
    }

    public Carta darCarta(VisibilidadCarta visibilidad) {
        if (!mazo.isEmpty()) {
            Carta c = mazo.dequeue();
            c.setVisibilidad(visibilidad);
            return c;
        }
        return null;
    }

	public void meterCarta(Carta c) {
        mazo.queue(c);
	}

    @Override
    public String toString() {
        return "Baraja:\n" + mazo;
    }

}
