class ListaCircularSimplementeEnlazada<T> {
    private Nodo<T> cabeza;
    private int tamaño;

    public ListaCircularSimplementeEnlazada() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    public void insertarInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != cabeza) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
        tamaño++;
    }

    public void insertarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != cabeza) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
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
            if (cabeza.siguiente == cabeza) {
                cabeza = null;
            } else {
                Nodo<T> actual = cabeza;
                while (actual.siguiente != cabeza) {
                    actual = actual.siguiente;
                }
                actual.siguiente = cabeza.siguiente;
                cabeza = cabeza.siguiente;
            }
            tamaño--;
        }
    }

    public void eliminarFinal() {
        if (cabeza != null) {
            if (cabeza.siguiente == cabeza) {
                cabeza = null;
            } else {
                Nodo<T> actual = cabeza;
                while (actual.siguiente.siguiente != cabeza) {
                    actual = actual.siguiente;
                }
                actual.siguiente = cabeza;
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
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }
        actual.siguiente = actual.siguiente.siguiente;
        tamaño--;
    }

    public int buscar(T dato) {
        if (cabeza == null) {
            return -1;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < tamaño; i++) {
            if (actual.dato.equals(dato)) {
                return i;
            }
            actual = actual.siguiente;
        }
        return -1;
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
        if (cabeza != null) {
            Nodo<T> actual = cabeza;
            do {
                System.out.print(actual.dato + " → ");
                actual = actual.siguiente;
            } while (actual != cabeza);
            System.out.println("(ciclo)");
        }
    }
}