class Nodo:
    def __init__(self, dato):
        self.dato = dato
        self.conexion = None

    def conectar(self, otro_nodo):
        self.conexion = otro_nodo

    def desconectar(self):
        self.conexion = None

    def extraer(self):
        return self.dato

    def mostrar_info(self):
        if self.conexion is not None:
            conexion_info = self.conexion.extraer()
        else:
            conexion_info = "None"
        print(f"Nodo: {self.dato} | Conectado a: {conexion_info}")

if __name__ == "__main__":
    nodo1 = Nodo("Alexis")
    nodo2 = Nodo("9.8")
    nodo3 = Nodo("15")
    nodo4 = Nodo("")
    nodo5 = Nodo("Alde")
    nodo1.conectar(nodo2)
    nodo2.conectar(nodo3)
    nodo3.conectar(nodo4)
    nodo4.conectar(nodo5)
    print("Estado de los nodos")
    nodo1.mostrar_info()
    nodo2.mostrar_info()
    nodo3.mostrar_info()
    nodo4.mostrar_info()
    nodo5.mostrar_info()
    nodo3.desconectar()
    print("\nEstado de los nodos después de desconectar Nodo 3:")
    nodo1.mostrar_info()
    nodo2.mostrar_info()
    nodo3.mostrar_info()
    nodo4.mostrar_info()
    nodo5.mostrar_info()
    info_nodo1 = nodo1.extraer()
    print(f"\nInformación extraída de Nodo 1: {info_nodo1}")

    info_nodo4 = nodo4.extraer()
    print(f"Información extraída de Nodo 4: {info_nodo4}")
