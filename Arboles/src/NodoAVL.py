class NodoAVL:
    def __init__(self, clave):
        self.clave = clave
        self.izq = None
        self.der = None
        self.altura = 1


def max(param2, param1):
    pass


def print(clave1, end1):
    pass


class ArbolAVL:
    def __init__(self):
        self.raiz = None

    def obtener_altura(self, nodo):
        return nodo.altura if nodo else 0

    def obtener_factor(self, nodo):
        return self.obtener_altura(nodo.izq) - self.obtener_altura(nodo.der) if nodo else 0

    def rotacion_derecha(self, y):
        x = y.izq
        T2 = x.der
        x.der = y
        y.izq = T2
        y.altura = 1 + max(self.obtener_altura(y.izq), self.obtener_altura(y.der))
        x.altura = 1 + max(self.obtener_altura(x.izq), self.obtener_altura(x.der))
        return x

    def rotacion_izquierda(self, x):
        y = x.der
        T2 = y.izq
        y.izq = x
        x.der = T2
        x.altura = 1 + max(self.obtener_altura(x.izq), self.obtener_altura(x.der))
        y.altura = 1 + max(self.obtener_altura(y.izq), self.obtener_altura(y.der))
        return y

    def insertar(self, nodo, clave):
        if not nodo:
            return NodoAVL(clave)
        elif clave < nodo.clave:
            nodo.izq = self.insertar(nodo.izq, clave)
        elif clave > nodo.clave:
            nodo.der = self.insertar(nodo.der, clave)
        else:
            return nodo  # No inserta duplicados

        nodo.altura = 1 + max(self.obtener_altura(nodo.izq), self.obtener_altura(nodo.der))
        factor = self.obtener_factor(nodo)

        if factor > 1 and clave < nodo.izq.clave:
            return self.rotacion_derecha(nodo)
        if factor < -1 and clave > nodo.der.clave:
            return self.rotacion_izquierda(nodo)
        if factor > 1 and clave > nodo.izq.clave:
            nodo.izq = self.rotacion_izquierda(nodo.izq)
            return self.rotacion_derecha(nodo)
        if factor < -1 and clave < nodo.der.clave:
            nodo.der = self.rotacion_derecha(nodo.der)
            return self.rotacion_izquierda(nodo)

        return nodo

    def insertar_clave(self, clave):
        self.raiz = self.insertar(self.raiz, clave)

    def inorden(self, nodo):
        if nodo:
            self.inorden(nodo.izq)
            print(nodo.clave, end=' ')
            self.inorden(nodo.der)

    def buscar(self, nodo, clave):
        if nodo is None:
            return None
        if clave == nodo.clave:
            return nodo
        elif clave < nodo.clave:
            return self.buscar(nodo.izq, clave)
        else:
            return self.buscar(nodo.der, clave)
