package lab1.lista;

class Nodo<Tipo> {
    /*
     *************************************************************************
     * Atributos
     *************************************************************************/

    private Nodo<Tipo> anterior;
    private Nodo<Tipo> siguiente;
    private final Tipo dato;

    /*
     *************************************************************************
     * Constructores
     *************************************************************************/

    Nodo(final Tipo dato) {
        this.dato = dato;
    }

    /*
     *************************************************************************
     * Getters y Setters
     *************************************************************************/

    public Tipo dato() {
        return dato;
    }

    public Nodo<Tipo> siguiente() {
        return siguiente;
    }

    public void siguiente(final Nodo<Tipo> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<Tipo> anterior() {
        return anterior;
    }

    public void anterior(final Nodo<Tipo> anterior) {
        this.anterior = anterior;
    }

    /*
     *************************************************************************
     * Metodos Override
     *************************************************************************/

    @Override
    public String toString() {
        return dato == null ? "null" : dato.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dato == null) ? 0 : dato.hashCode());
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
        @SuppressWarnings("unchecked")
        Nodo<Tipo> other = (Nodo<Tipo>) obj;
        if (dato == null) {
            if (other.dato != null)
                return false;
        } else if (!dato.equals(other.dato))
            return false;
        return true;
    }

}
