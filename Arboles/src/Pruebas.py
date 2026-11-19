
def print(param):
    pass


print("=== Prueba Árbol AVL ===")


class ArbolAVL:
    pass


avl = ArbolAVL()
secuencia = [30, 20, 10, 25, 40, 50, 22, 5, 35, 45]
for val in secuencia:
    avl.insertar_clave(val)

print("Recorrido inorden AVL:")
avl.inorden(avl.raiz)
print()

buscado = 22
nodo = avl.buscar(avl.raiz, buscado)
print(f"Búsqueda AVL de {buscado}: {'Encontrado' if nodo else 'No encontrado'}")

# Prueba Árbol Rojo-Negro
print("\n=== Prueba Árbol Rojo-Negro ===")


class ArbolRojoNegro:
    pass


rb = ArbolRojoNegro()
for val in secuencia:
    rb.insertar(val)

print("Recorrido inorden Rojo-Negro:")
rb.inorden(rb.raiz)
print()

nodo_rb = rb.buscar(rb.raiz, buscado)
print(f"Búsqueda Rojo-Negro de {buscado}: {'Encontrado' if nodo_rb != rb.NIL else 'No encontrado'}")
