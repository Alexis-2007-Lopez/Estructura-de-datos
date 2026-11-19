public class PruebaListaCircularSimplementeEnlazada {
    public static void main(String[] args) {
        ListaCircularSimplementeEnlazada<String> lista = new ListaCircularSimplementeEnlazada<>();

        //Creación e inserción
        lista.insertarInicio("Tsubasa");
        lista.insertarFinal("Hyuga");
        lista.insertarFinal("Genzo");
        lista.insertarInicio("Nitta");

        System.out.println("Contenido de la lista:");
        lista.mostrar();

        // Búsqueda y tamaño
        System.out.println("Buscar 'Hyuga': " + lista.buscar("Hyuga")); // Debe devolver 2
        System.out.println("Tamaño: " + lista.tamaño()); // Debe ser 4

        // Eliminaciones
        lista.eliminarInicio();
        System.out.println("Después de eliminar inicio:");
        lista.mostrar();

        lista.eliminarFinal();
        System.out.println("Después de eliminar final:");
        lista.mostrar();
    }
}
