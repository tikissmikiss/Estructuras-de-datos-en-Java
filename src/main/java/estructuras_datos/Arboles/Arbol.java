package estructuras_datos.arboles;

public class Arbol {
    private Arbol dch;
    private Arbol izq;
    private int valor;

    public boolean borrar(int v) {

        // soy yo el valor? // Es necesario consultar para la raiz, el resto de veces
        // será redundante, puesto que se consulta antes de la llamada recursiva
        if (this.valor != v) {
            // No soy yo el valor

            // el valor es mayor o menor que yo?
            if (v < this.valor) {
                // si valor menor que yo
                borrar(this.izq, v);
            } else {
                // si valor mayor que yo
                borrar(this.dch, v);
            }

        } else { // Si soy yo el valor
            // TODO pendiente
        }

        return false; // TODO retorno provisional
    }

    /**
     * <p>
     * Si hijo no es el valor a borrar se llama a su metodo borrar.
     * </p>
     * <p>
     * Si hijo es el valor - 3 opciones:
     * <ul>
     * <li>0 nietos: Se elimina la referencia al hijo.</li>
     * <li>1 nietos: El nieto sustituye al hijo.</li>
     * <li>2 nietos: 2 pasos
     * <ul>
     * <li>El sucesor del hijo sustituye al hijo.</li>
     * <li>Si el sucesor tiene hijo (Solo puede ser derecho, si tuviera hijo izq él
     * sería el sucesor por ser menor) este pasa a su posicion, es decir, su abuejo (padre del
     * sucesor) lo adopta</li>
     * </ul>
     * </li>
     * </ul>
     * </p>
     * <br>
     * 
     * @param hijo
     * @param v
     */
    private void borrar(Arbol hijo, int v) {
        // es hijo el valor?
        if (hijo.valor == v) { // hijo es el valor
            // 3 opciones:
            if (hijo.dch == null && hijo.izq == null) {
                // si 0 nietos: borrar mi referencia al hijo - der o izq, segun sea.
                this.dch = (hijo == this.dch) ? null : this.dch;
                this.izq = (hijo == this.izq) ? null : this.izq;
                // if (hijo == this.derecho) this.derecho = null;
                // if (hijo == this.izquierdo) this.izquierdo = null;
            } else if (hijo.dch == null || hijo.izq == null) {
                // si 1 nieto: El nieto pasa a ser el hijo - der o izq, segun sea.
                Arbol nieto = (hijo.dch == null) ? hijo.dch : hijo.izq;
                this.dch = (hijo == this.dch) ? nieto : this.dch;
                this.izq = (hijo == this.izq) ? nieto : this.izq;
            } else {
                // si 2 nietos
                
            }
        } else {
            // hijo no es el valor
            hijo.borrar(v); // Llamada recursiva
        }
    }

}
