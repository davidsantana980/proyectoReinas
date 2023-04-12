public class Pila <Tipo>{
    private class Nodo<T>{
        T info;
        Nodo<T> siguiente;
        public Nodo(T info) {
            this.info = info;
            this.siguiente = null;
        }
    }

    private Nodo<Tipo> top = null;
    private int elementos = 0;

    public void push(Tipo x){
        Nodo<Tipo> nuevoNodo = new Nodo<Tipo>(x);
        nuevoNodo.siguiente = top;
        elementos++;
        top = nuevoNodo;
    }

    public void muestraTodo(){
        Nodo<Tipo> copia = top;
        while(copia != null){
            System.out.println(copia.info);
            copia = copia.siguiente;
        }
    }

    public Tipo top(){
        return top.info;
    }

    public Tipo pop(){
        Tipo infoEliminada;
        infoEliminada = top.info;
        top = top.siguiente;
        elementos--;
        return infoEliminada;
    }
    public Tipo pop(int index) {
        Tipo infoEliminada;
        if (index == 0) {
            infoEliminada = this.pop();
        } else {
            Nodo<Tipo> nodo = top;
            for (int i = 0; i < index - 1 && nodo.siguiente != null; i++) {
                nodo = nodo.siguiente;
            }
            infoEliminada = nodo.siguiente.info;
            elementos--;
            nodo.siguiente = nodo.siguiente.siguiente;
        }

        return infoEliminada;
    }

    public void modifica(int indice, Tipo nuevoValor) {
        Nodo<Tipo> nodo = top;
        for (int i = 0; i < indice && nodo != null; i++) {
            nodo = nodo.siguiente;
        }
        nodo.info = nuevoValor;
    }   
    
    public Tipo mira(int indice) {
        if (indice < 0 || indice >= this.cantidadDeElementos()) {
            throw new IndexOutOfBoundsException();
        }
    
        Nodo<Tipo> nodo = top;
        for (int i = 0; i < indice && nodo != null; i++) {
            nodo = nodo.siguiente;
        }
        return nodo.info;
    } 

    public int indice(Tipo obj) {
        int pos = 1;
        for (Nodo<Tipo> nodo = top; nodo != null; nodo = nodo.siguiente) {
            if (nodo.info.equals(obj)) {
                return pos;
            }
            pos++;
        }
        return -1;
    }
    
    public boolean vacia(){
        return top == null;
    }

    public int cantidadDeElementos(){
        return elementos;
    }
}
