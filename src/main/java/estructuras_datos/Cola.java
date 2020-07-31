package estructuras_datos;

public class Cola {
    // Artibutos
    private ListaDobleEnlazada l;
    public boolean isEmpty;

    // Constructor
    public Cola() {
        l = new ListaDobleEnlazada();
        isEmpty = true;
    }

    public void enqueue(int value) {
        l.addEnIni(value);
        isEmpty = false;
    }
    
    public void enqueue(int value, boolean print) {
        enqueue(value);
        if (print) 
            l.printList();
    }
    
    public int dequeue() throws Exception {
        if (!l.isEmpty) {
            int v = l.ultimo.val;
            l.clrFin();
            this.isEmpty = l.isEmpty;
            return v;
        }
        else throw new Exception("La cola esta vacía");
    }
    
    public int dequeue(boolean print) throws Exception {
        int v = dequeue();
        if (print) 
            l.printList();
        return v;
    }
    
    public boolean isEmpty() {
        return l.isEmpty;
    }
}