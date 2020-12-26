package lab1.pila;

import lab1.lista.Lista;

public class Pila<Tipo> {
    private Lista<Tipo> lista;

    public Pila() {
        lista = new Lista<Tipo>();
        this.clear();
    }

    public boolean push(Tipo dato) {
        return lista.add(dato);
    }

    public Tipo pop() {
        return lista.extract(lista.size() - 1);
    }

    public Tipo peek() {
        return lista.get(lista.size() - 1);
    }

    public boolean check(Tipo dato) {
        return lista.check(dato);
    }

    public int size() {
        return lista.size();
    }

    public boolean isEmpty() {
        return lista.size() == 0;
    }

    public void clear() {
        lista.clear();
    }

    public void print() {
        String str = "";
        str += "    n:" + size() + "\n";
        str += "    cima:" + peek() + "\n";
        str += "    Elemento en Pila:\n" + lista;
        System.out.println(str);
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}
