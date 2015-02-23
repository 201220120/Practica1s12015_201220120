package codigo;

/**
 *
 * @author angel
 */
public class Cola {

    private nodoPlanta cola;
    private static nodoZombie listaCatalogo;

    public nodoPlanta obtenerSalida() {
        nodoPlanta aux = cola;
        return aux;

    }

    public int getTamaño() {
        int contador = 0;
        nodoPlanta aux = cola;

        if (aux == null) {
            System.out.println("auxiliar null");
        } else {
            contador++;
            while (aux.sig != null) {
                System.out.println("paso una vez " + aux.Nombre + "  " + aux.sig.Nombre);
                contador++;
                System.out.println(contador + " CUANTO TIENE");
                aux = aux.sig;
            }

        }

        return contador;

    }

    public void insert(String nombre, String ataque, int modif) {
        nodoPlanta elemento = new nodoPlanta();
        elemento.Nombre = nombre;
        elemento.puntos = modif;
        elemento.ataque = ataque;
        if (cola == null) {
            cola = new nodoPlanta();
            cola = elemento;
            System.out.println("se agrego un elemto");
        } else {
            nodoPlanta aux = cola;
            while (aux.sig != null) {
                aux = aux.sig;

            }
            aux.sig = elemento;

        }
        //System.out.println("ELEMENTO en tamaño " + getTamaño());
    }

    public nodoPlanta getRaiz() {
        nodoPlanta aux = cola;
        return aux;
    }

}
