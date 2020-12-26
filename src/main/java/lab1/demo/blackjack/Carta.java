package lab1.demo.blackjack;

public class Carta {
    private Palo palo;
    private Figura figura;
    private VisibilidadCarta visibilidad;

    public static VisibilidadCarta VISIBLE = VisibilidadCarta.DESCUBIERTA;
    public static VisibilidadCarta CUBIERTA = VisibilidadCarta.CUBIERTA;

    public Carta(Palo palo, Figura figura) {
        this.palo = palo;
        this.figura = figura;
        this.visibilidad = VISIBLE;
    }

    public int getValor() {
        return getValor(false);
    }

    /**
     * devuelve el valor aunque este cubierta
     * 
     * @param incluirCubiertas
     * @return
     */
    public int getValor(boolean incluirCubiertas) {
        if (visibilidad == VISIBLE || incluirCubiertas)
            return figura.getValor();
        else
            return 0;
    }

    public void setVisibilidad(VisibilidadCarta visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String stringVisible() {
        return "[" + figura + " - " + palo + "]";
    }

    @Override
    public String toString() {
        if (visibilidad == VISIBLE)
            return "[" + figura + " - " + palo + "]";
        else
        // return "[  ♠  ♣  ♥  ♦  ]"; 
        // return "[ <>  JOSE  <> ]"; 
        return "[ <> <>  <> <> ]"; 
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((figura == null) ? 0 : figura.hashCode());
        result = prime * result + ((palo == null) ? 0 : palo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carta other = (Carta) obj;
        if (figura != other.figura)
            return false;
        if (palo != other.palo)
            return false;
        return true;
    }
}
