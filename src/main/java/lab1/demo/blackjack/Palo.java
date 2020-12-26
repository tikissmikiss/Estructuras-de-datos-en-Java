package lab1.demo.blackjack;

public enum Palo {
    ROMBOS("Rombos   "), PIKAS("Pikas    "), CORAZONES("Corazones"), TREBOLES("Treboles ");

    private String nombre;

    private Palo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
