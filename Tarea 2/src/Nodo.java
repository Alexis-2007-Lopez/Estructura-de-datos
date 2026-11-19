class Nodo<T> {
    T dato;
    Nodo<T> siguiente; // Para la lista simplemente enlazada
    Nodo<T> anterior; // Para la lista doblemente enlazada

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}