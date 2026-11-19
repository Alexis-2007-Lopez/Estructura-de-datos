class ListaSimplementeEnlazada<T> {
    private Nodo<T> cabeza;
    private int tamaño;

    public ListaSimplementeEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void insertarInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        tamaño++;
    }

    public void insertarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
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
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;
        tamaño++;
    }

    public void eliminarInicio() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
            tamaño--;
        }
    }

    public void eliminarFinal() {
        if (cabeza == null) return;
        if (cabeza.siguiente == null) {
            cabeza = null;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
        }
        tamaño--;
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
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }
        actual.siguiente = actual.siguiente.siguiente;
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
            System.out.print(actual.dato + " → ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
