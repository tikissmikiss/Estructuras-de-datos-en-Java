package lab1.demo.blackjack;

public enum Figura {
    AS(" A", 11), II(" 2", 2), III(" 3", 3), IV(" 4", 4), V(" 5", 5), VI(" 6", 6), VII(" 7", 7), VIII(" 8", 8),
    IX(" 9", 9), X("10", 10), J(" J", 10), Q(" Q", 10), K(" K", 10);

    private String nombre;
    private int valor;

    private Figura(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public int getValor() {
        return valor;
    }

}
