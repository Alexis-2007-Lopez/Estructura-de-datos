class NodoRojoNegro:
    def __init__(self, clave):
        self.clave = clave
        self.color = "rojo"
        self.izq = None
        self.der = None
        self.padre = None


def print(param, end):
    pass


class ArbolRojoNegro:
    def __init__(self):
        self.NIL = NodoRojoNegro(None)
        self.NIL.color = "negro"
        self.raiz = self.NIL

    def insertar(self, clave):
        nodo = NodoRojoNegro(clave)
        nodo.izq = self.NIL
        nodo.der = self.NIL

        padre = None
        actual = self.raiz
        while actual != self.NIL:
            padre = actual
            if nodo.clave < actual.clave:
                actual = actual.izq
            elif nodo.clave > actual.clave:
                actual = actual.der
            else:
                return  # No duplicados

        nodo.padre = padre
        if padre is None:
            self.raiz = nodo
        elif nodo.clave < padre.clave:
            padre.izq = nodo
        else:
            padre.der = nodo

        nodo.color = "rojo"
        self.insertar_arreglar(nodo)

    def insertar_arreglar(self, nodo):
        while nodo != self.raiz and nodo.padre.color == "rojo":
            if nodo.padre == nodo.padre.padre.izq:
                tio = nodo.padre.padre.der
                if tio.color == "rojo":
                    nodo.padre.color = "negro"
                    tio.color = "negro"
                    nodo.padre.padre.color = "rojo"
                    nodo = nodo.padre.padre
                else:
                    if nodo == nodo.padre.der:
                        nodo = nodo.padre
                        self.rotacion_izquierda(nodo)
                    nodo.padre.color = "negro"
                    nodo.padre.padre.color = "rojo"
                    self.rotacion_derecha(nodo.padre.padre)
            else:
                tio = nodo.padre.padre.izq
                if tio.color == "rojo":
                    nodo.padre.color = "negro"
                    tio.color = "negro"
                    nodo.padre.padre.color = "rojo"
                    nodo = nodo.padre.padre
                else:
                    if nodo == nodo.padre.izq:
                        nodo = nodo.padre
                        self.rotacion_derecha(nodo)
                    nodo.padre.color = "negro"
                    nodo.padre.padre.color = "rojo"
                    self.rotacion_izquierda(nodo.padre.padre)
        self.raiz.color = "negro"

    def rotacion_izquierda(self, x):
        y = x.der
        x.der = y.izq
        if y.izq != self.NIL:
            y.izq.padre = x
        y.padre = x.padre
        if x.padre is None:
            self.raiz = y
        elif x == x.padre.izq:
            x.padre.izq = y
        else:
            x.padre.der = y
        y.izq = x
        x.padre = y

    def rotacion_derecha(self, y):
        x = y.izq
        y.izq = x.der
        if x.der != self.NIL:
            x.der.padre = y
        x.padre = y.padre
        if y.padre is None:
            self.raiz = x
        elif y == y.padre.der:
            y.padre.der = x
        else:
            y.padre.izq = x
        x.der = y
        y.padre = x

    def inorden(self, nodo):
        if nodo != self.NIL:
            self.inorden(nodo.izq)
            print(f"{nodo.clave}({nodo.color[0]})", end=' ')
            self.inorden(nodo.der)

    def buscar(self, nodo, clave):
        if nodo == self.NIL or clave == nodo.clave:
            return nodo
        if clave < nodo.clave:
            return self.buscar(nodo.izq, clave)
        else:
            return self.buscar(nodo.der, clave)
