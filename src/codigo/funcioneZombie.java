/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author Braian
 */
public class funcioneZombie {

    private static nodoZombie listaCatalogo;

    public void agregarLista(nodoZombie elemento) {
        if (listaCatalogo == null) {
            listaCatalogo = new nodoZombie();
            listaCatalogo = elemento;
        } else {
            nodoZombie aux = listaCatalogo;
            while (aux.sig != null) {
                aux = aux.sig;

            }
            aux.sig = elemento;

        }
    }

    public nodoZombie getRaiz() {
        nodoZombie aux = listaCatalogo;
        return aux;
    }

    public boolean modificar(String nombre, String nuevo, String ataque, int modif) {
        nodoZombie aux = listaCatalogo;
        while (aux != null) {
            if (aux.Nombre == nombre) {
                aux.Nombre = nuevo;
                aux.ataque = ataque;
                aux.puntos = modif;
                return true;
            }
            aux = aux.sig;
        }
        return false;
    }
    

    public boolean eliminar(String nom, String jugador, int numPla, nodo raiz) {

        nodoZombie aux = listaCatalogo;
        if (listaCatalogo.Nombre == nom) {

            if (aux.sig != null) {
                nodoZombie aux2 = listaCatalogo.sig;
                System.out.println("esto es lo despues " + aux2.Nombre);
                listaCatalogo = aux2;
            } else {

                listaCatalogo = null;

            }
            frameZombies frame = new frameZombies(jugador, numPla, raiz, listaCatalogo);
            frame.setVisible(true);
            return true;

        } else {

            try {

                while (aux.sig != null) {

                    if (aux.sig.Nombre == nom) {
                        nodoZombie aux2 = aux.sig;
                        aux.sig = aux2.sig;
                        frameZombies frame = new frameZombies(jugador, numPla, raiz, listaCatalogo);
                        frame.setVisible(true);
                        return true;

                    } else {
                        // aux.sig = aux2.sig;
                    }
                    aux = aux.sig;
                }
                //aux = aux.sig;
                listaCatalogo = aux;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return false;
    }

    int contador = 0;

    public int getTamaño() {

        nodoZombie aux = listaCatalogo;
        if (aux == null) {
            // contador++;
            // System.out.println(contador + " CUANTO TIENE ANTES");
        } else {
            contador++;
            //System.out.println(contador + " CUANTO TIENE ahora");
            while (aux.sig != null) {
                contador++;
                System.out.println(contador + " CUANTO TIENE");
                aux = aux.sig;
            }

        }

        return contador;
    }
}
