package codigo;

/**
 *
 * @author angel
 */
public class Cola {

    private nodoPlanta cola;

    public nodoPlanta obtenerSalida() {
        nodoPlanta aux = cola;
        return aux;

    }

    public boolean sacarCola(String nom) {
        nodoPlanta aux1 = cola;
        if(aux1.Nombre==nom){
        aux1 = aux1.sig;
        
        }
        cola = aux1;

        return false;
    }

    public boolean eliminardeCola(String nom) {
        System.out.println("NOMBRE A ELIMINAR " + nom);
        nodoPlanta aux = cola;
        if (cola.Nombre == nom) {

            if (aux.sig != null) {
                nodoPlanta aux2 = cola.sig;
                System.out.println("esto es lo despues " + aux2.Nombre);
                cola = aux2;
            } else {

                cola = null;

            }

            return true;

        } else {

            try {

                while (aux.sig != null) {

                    if (aux.sig.Nombre == nom) {
                        nodoPlanta aux2 = aux.sig;
                        aux.sig = aux2.sig;

                        return true;

                    } else {
                        // aux.sig = aux2.sig;
                    }
                    aux = aux.sig;
                }
                //aux = aux.sig;
                cola = aux;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return false;
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

    public void insert(String nombre, String ataque, int modif,String imagen) {
        nodoPlanta elemento = new nodoPlanta();
        elemento.Nombre = nombre;
        elemento.puntos = modif;
        elemento.ataque = ataque;
         elemento.imagen = imagen;
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
