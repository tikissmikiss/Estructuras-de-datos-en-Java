package lab1.cola;

import lab1.lista.Lista;

public class Cola<Tipo> {
    private Lista<Tipo> lista;

    public Cola() {
        lista = new Lista<Tipo>();
        this.clear();
    }

    public boolean queue(Tipo dato) {
        return lista.add(dato);
    }

    public Tipo dequeue() {
        return lista.extract(0);
    }

    public boolean check(Tipo dato) {
        return lista.check(dato);
    }

    public Tipo next() {
        return lista.get(0);
    }

    public boolean isEmpty() {
        return lista.size() == 0;
    }

    public void clear() { 
        lista.clear();
    }

    public int size() {
        return lista.size();
    }

    public void print() {
        String str = "";
        str += "    Elementos en cola: " + size() + "\n";
        str += "    Primero: " + lista.get(0) + "\n";
        str += "    Ultimo:  " + lista.get(size() - 1) + "\n"; 
        str += "    Cola:\n" + lista;
        System.out.println(str);
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}
