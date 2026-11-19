public class PruebaListaDobleEnlazada {
    public static void main(String[] args) {
        ListaDobleEnlazada<String> lista = new ListaDobleEnlazada<>();

        //Creación e inserción
        lista.insertarInicio("Tsubasa");
        lista.insertarFinal("Nitta");
        lista.insertarFinal("Diaz");
        lista.insertarInicio("Karl");
        lista.insertarEn(2, "Misaki");

        System.out.println("Contenido de la lista:");
        lista.mostrar();
        System.out.println("Tamaño: " + lista.tamaño());

        // Búsquedas
        System.out.println("Buscar 'Diaz': " + lista.buscar("Diaz"));
        System.out.println("Obtener posición 1: " + lista.obtener(1));

        // Eliminaciones
        lista.eliminarInicio();
        System.out.println("Después de eliminar inicio:");
        lista.mostrar();

        lista.eliminarFinal();
        System.out.println("Después de eliminar final:");
        lista.mostrar();

        System.out.println("Mostrar inverso:");
        lista.mostrarInverso();
    }
}
