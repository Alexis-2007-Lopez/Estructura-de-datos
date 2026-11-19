class ListaDobleEnlazada<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamaño;

    public ListaDobleEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public void insertarInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            cola = nuevoNodo;
        } else {
            cabeza.anterior = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        }
        cabeza = nuevoNodo;
        tamaño++;
    }

    public void insertarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.anterior = cola;
            cola.siguiente = nuevoNodo;
        }
        cola = nuevoNodo;
        tamaño++;
    }

    public void insertarEn(int posicion, T dato) {
        if (posicion < 0 || posicion > tamaño) {
            System.out.println("Posición inválida.");
            return;
        }
        if (posicion == 0) {
            insertarInicio(dato);
            return;
        }
        if (posicion == tamaño) {
            insertarFinal(dato);
            return;
        }
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        nuevoNodo.siguiente = actual;
        nuevoNodo.anterior = actual.anterior;
        actual.anterior.siguiente = nuevoNodo;
        actual.anterior = nuevoNodo;
        tamaño++;
    }

    public void eliminarInicio() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null;
            }
            tamaño--;
        }
    }

    public void eliminarFinal() {
        if (cola != null) {
            cola = cola.anterior;
            if (cola != null) {
                cola.siguiente = null;
            } else {
                cabeza = null;
            }
            tamaño--;
        }
    }

    public void eliminarEn(int posicion) {
        if (posicion < 0 || posicion >= tamaño) {
            System.out.println("Posición inválida.");
            return;
        }
        if (posicion == 0) {
            eliminarInicio();
            return;
        }
        if (posicion == tamaño - 1) {
            eliminarFinal();
            return;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;
        tamaño--;
    }

    public int buscar(T dato) {
        Nodo<T> actual = cabeza;
        for (int i = 0; i < tamaño; i++) {
            if (actual.dato.equals(dato)) {
                return i;
            }
            actual = actual.siguiente;
        }
        return -1; // No encontrado
    }

    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= tamaño) {
            System.out.println("Posición inválida.");
            return null;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public int tamaño() {
        return tamaño;
    }

    public void mostrar() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ⇄ ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public void mostrarInverso() {
        Nodo<T> actual = cola;
        while (actual != null) {
            System.out.print(actual.dato + " ⇄ ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }
}
