public class PruebaListaSimplementeEnlazada {
    public static void main(String[] args) {
        ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>();

        //Creación e inserción
        lista.insertarInicio(5);
        lista.insertarFinal(10);
        lista.insertarFinal(15);
        lista.insertarInicio(2);
        lista.insertarEn(2, 8);

        System.out.println("Contenido de la lista:");
        lista.mostrar(); // Debe mostrar 2 → 5 → 8 → 10 → 15 → null
        System.out.println("Tamaño: " + lista.tamaño()); // Debe ser 5

        //Pruebas adicionales
        System.out.println("Buscar 10: " + lista.buscar(10)); // Debe devolver 3
        System.out.println("Obtener posición 2: " + lista.obtener(2)); // Debe devolver 8

        lista.eliminarInicio();
        System.out.println("Después de eliminar inicio:");
        lista.mostrar(); // Debe mostrar 5 → 8 → 10 → 15 → null

        lista.eliminarFinal();
        System.out.println("Después de eliminar final:");
        lista.mostrar(); // Debe mostrar 5 → 8 → 10 → null
    }
}
