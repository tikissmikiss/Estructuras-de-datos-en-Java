package lab1.demo.blackjack;

import lab1.demo.DemoUsoTADs;
import lab1.demo.util.io;

public class UI {

	private static int ancho = 60;

	public static void textoReconstruirMazo() {
		System.out.println("- Reincorporar la pila de descartes en el mazo y volver ");
		System.out.println("  a mezclar. Para hacer esto se desopilan las cartas de ");
		System.out.println("  la pila de descartes una por una, y se meten en el mazo, ");
		System.out.println("  en el que internamente usa una cola de cartas. El proceso ");
		System.out.println("  de mezclar ya se ha explicado. ");
		io.esperarUsuario();
	}

	public static void textoComprobarCartasEnMazo() {
		System.out.println("- Comprobar si quedan cartas suficientes en el mazo. ");
		System.out.println("  Para ello se mira el tamaño de la pila.");
		io.esperarUsuario();
	}

	public static void textoDescartarCartas() {
		System.out.println("- Retirar cartas de la mesa. ");
		System.out.println(io.parrafo(
				"Para ello se sacan las cartas de las pilas del crupier y del jugador y se apilan en la pila de descarte.",
				ancho, "", 0));
		io.esperarUsuario();
	}

	public static void textoImpresionMarcador() {
		System.out.println();
		System.out.println("Para imprimir el marcador se imprime la cola de jugadores");
		System.out.println("Cola de jugadores:");
	}

	public static void textoReencolarJugador(Jugador jugador) {
		System.out.println("\n- " + jugador.getNombre() + " vuelve a la cola de jugadores");
		System.out.println(io.parrafo(
				"El jugador de este turno se vuelve a meter en la cola de jugadores, por lo que quedara el último y tendrá que esperar los turnos del resto hasta volver a jugar.",
				ancho, "", 0));
		io.esperarUsuario();
	}

	public static void mostrarGanador(Jugador jugador) {
		System.out.println(UI.comprobarGanador(jugador));
		io.esperarUsuario();
	}

	public static void turnoCrupier(int ronda, Jugador jugador) {
		System.out.println();
		System.out.println("- El crupier descubre su carta");
		DemoUsoTADs.crupier.getMano().peek().setVisibilidad(Carta.VISIBLE);

		boolean plantado = false;
		while (!plantado) {
			UI.printMesa(ronda, jugador);

			System.out.println("- Juega " + DemoUsoTADs.crupier);
			if (jugador.getPuntuacion() <= 21 && jugador.getPuntuacion() > DemoUsoTADs.crupier.getPuntuacion()
					&& DemoUsoTADs.crupier.getPuntMin() < 21) {
				System.out.println("Pide carta...");
				io.esperarUsuario();
				DemoUsoTADs.crupier.recibirCarta(DemoUsoTADs.mazo.darCarta(Carta.VISIBLE));
			} else {
				plantado = true;
				System.out.println(" Se planta con " + DemoUsoTADs.crupier.getPuntuacion() + " puntos");
				io.esperarUsuario();
			}
		}
	}

	public static void trunoJugador(int maxToPlay, int ronda, Jugador jugador) {
		boolean plantado = false;
		while (!plantado) {
			UI.printMesa(ronda, jugador);

			System.out.println("- Juega " + jugador);
			if (jugador.getPuntMin() <= maxToPlay) {
				System.out.println("Pide carta...");
				io.esperarUsuario();
				jugador.recibirCarta(DemoUsoTADs.mazo.darCarta(Carta.VISIBLE));
			} else {
				plantado = true;
				System.out.println(" Se planta con " + jugador.getPuntuacion() + " puntos");
				io.esperarUsuario();
			}
		}
	}

	public static void comprobarBJCrupier(int ronda, Jugador jugador) {
		System.out.println("- El crupier descubre su carta");
		DemoUsoTADs.crupier.getMano().peek().setVisibilidad(Carta.VISIBLE);

		UI.printMesa(ronda, jugador);
		jugador.resetPuntuacion();
		io.esperarUsuario();
	}

	public static void textoComprobarBlackjackCrupier() {
		// si crupier tiene blackjack gana
		System.out.println("- Comprobar si Crupier tiene blackjack: ");
		System.out.println("  Si tiene 21 de dadas gana. ");
		io.esperarUsuario();
	}

	public static void textoRepartirCartas() {
		System.out.println("- Repartir cartas: ");
		System.out.println(io.parrafo(
				"Se sacan 2 cartas del mazo descubiertas para el jugador y 2 para el Crupier, una cubierta y otra descubierta. Las cartas sacadas del mazo se apilan en una pila interna de cada jugador.",
				ancho, "", 0));
		System.out.println();
		io.esperarUsuario();
	}

	public static void textoCrearPilaDescartes() {
		System.out.println("Crear pila de descartes: ");
		System.out.println(io.parrafo(
				"Al terminar la mano, las cartas jugadas se apilarán aquí, hasta que en el mazo queden menos de 10 cartas, en cuyo caso se reintroducirán en el mazo y se volverá a mezclar.",
				ancho, "", 0));
		io.esperarUsuario();
	}

	public static void textoMezclarMazo() {
		System.out.println("- Mezclar mazo");
		System.out.println(io.parrafo(
				"Para mezclar las cartas, el mazo utiliza internamente una lista doblemente enlazada auxiliar para mezclar las cartas en dos tiempos:",
				ancho, "", 0));
		System.out.println(" 1- Se desencolan las cartas de una en una y se van insertando ");
		System.out.println("    en una posición aleatoria dentro de la longitud de la lista ");
		System.out.println("    auxiliar.");
		System.out.println("    Esto hace que todas las cartas del mazo queden desordenadas");
		System.out.println("    en la lista.");
		System.out.println(" 2- Se encolan de nuevo las cartas en el mazo desde la lista ");
		System.out.println("    auxiliar. Ahora las cartas se van recuperando de la lista ");
		System.out.println("    de una en una, desde una posición aleatoria dentro de su longitud.");
		System.out.println("    Esto además de devolver las cartas al mazo consigue que se haga ");
		System.out.println("    con grado de mezclado mayor.");
		io.esperarUsuario();
	}

	public static void textoCrearMazo() {
		System.out.println("Crear mazo: ");
		String str = "La baraja está construida internamente por una cola de cartas, de modo que solo se puede sacar cartas por un lado.";
		System.out.println(io.parrafo(str, ancho, "", 0));
		io.esperarUsuario();
	}

	public static void textoCabecera() {
		System.out.println();
		System.out.println(io.box('=', ancho, '='));
		System.out.println(io.linea("                           TAD", ancho, "|"));
		System.out.println(io.box('=', ancho, '|'));
		System.out.println(io.linea("                   Lista - Pila - Cola", ancho, "|"));
		System.out.println(io.box('-', ancho, '|'));
		System.out.println(io.parrafo("Demostración de uso práctico de estructuras de datos.", ancho, "|", 1));
		System.out.println(io.linea("   por: José Herce Preciado", ancho, "|"));
		System.out.println(io.box('=', ancho, '='));
		System.out.println();

		String str = "Se va a simular una partida de una variación de Blackjack. La variación consiste en que el Crupier no juega su mano contra todos los jugadores al mismo tiempo, si no que jugará una mano contra cada jugador, de modo que los jugadores esperan en fila su turno. Esto será un reflejo más práctico del uso del TDA cola.";
		System.out.println(io.parrafo(str, ancho, "", 0));
		io.esperarUsuario();

	}

	public static String comprobarGanador(Jugador jugador) {
		int pntJug = jugador.getPuntuacion();
		int pntCru = DemoUsoTADs.crupier.getPuntuacion();
		if (pntJug == pntCru) {
			return " >>> Empate <<<";
		}
		if (pntCru > 21 || (pntCru < 21 && pntJug > pntCru && pntJug < 21)) {
			jugador.addWin();
			return " >>> Gana " + jugador + " <<<";
		}
		DemoUsoTADs.crupier.addWin();
		return " >>> Gana " + DemoUsoTADs.crupier + " <<<";
	}

	public static void printMesa(int ronda, Jugador jugador) {
		System.out.println(io.box('=', ancho, '='));
		System.out.println(io.linea(" Ronda " + ronda + "  |  " + jugador.getNombre(), 60, "|"));
		System.out.println(io.box('-', ancho, '|'));
		System.out.println(io.linea(" Cartas mazo: " + DemoUsoTADs.mazo.getLength(), 60, "|"));
		System.out.println(io.box('=', ancho, '|'));
		System.out.println(io.linea(" Mano " + DemoUsoTADs.crupier.getNombre() + "     >>> "
				+ UI.stringPuntuacion(DemoUsoTADs.crupier) + " <<<", 60, "|"));
		System.out.println(DemoUsoTADs.crupier.manoToString());
		System.out.println(io.box('-', ancho, '|'));
		System.out.println(
				io.linea(" Mano " + jugador.getNombre() + "   >>> " + UI.stringPuntuacion(jugador) + " <<<", 60, "|"));
		System.out.println(jugador.manoToString());
		System.out.println(io.box('=', ancho, '='));
	}

	public static String stringPuntuacion(Jugador jugador) {
		int p = jugador.getPuntuacion();
		return p == 21 ? p + " Blackjack" : p + "";
	}

}
