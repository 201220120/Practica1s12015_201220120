/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizOrtogonal;

/**
 * Esta lista representa los encabezados para poder acceder a todos los nodos
 * en la matriz.
 * @author zetser
 */
public class ListaEncabezados {

    private Nodo Primero;

    /**
     * Este constructor inicia la lista al tamaño deseado
     * @param size el numero de elementos en la lista, lo cual representara
     * filas o columnas.
     */
    public ListaEncabezados(int size) {
        this.Primero = null;
        for (int i = 0; i < size; i++) {
            InsertarUltimo();
        }
    }

    /**
     * Este metodo se utiliza para eliminar nodos.
     * @param dato el dato que el nodo que se desea eliminar esta guardando
     * @return Lista que representa a la lista pero si el nodo que se ha
     * eliminado.
     */
    public ListaEncabezados Eliminar(int dato) {
        Nodo actual = Primero;
        Nodo anterior = null;
        boolean encontrado = false;

        while ((actual != null) && (!encontrado)) {
            encontrado = (actual.getEstado() == dato);
            if (!encontrado) {
                anterior = actual;
                actual = actual.enlace;
            }
        }

        if (actual != null) {
            if (actual == Primero) {
                Primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
        return this;
    }

    /**
     * Este metodo se utiliza para eliminar nodos.
     * @return Lista que representa a la lista pero si el nodo que se ha
     * eliminado.
     */
    public ListaEncabezados EliminarUltimo() {
        Nodo actual = Primero;
        Nodo anterior = null;

        if (Primero != null) {
            while (actual.enlace != null) {
                anterior = actual;
                actual = actual.enlace;
            }

            if (actual != null) {
                if (actual == Primero) {
                    Primero = actual.enlace;
                } else {
                    anterior.enlace = actual.enlace;
                }
                actual = null;
            }
        }
        return this;
    }

    /**
     * Elimina los nodos finales hasta igualar el tamaño de la lista
     * con el parametro size.
     * @param size El tamaño al que se debe de recortar la lista.
     * @return ListaEncabezados la lista de encabezados modificada
     */
    public ListaEncabezados TrimToSize(int size) {
        int Actualsize = size();
        int Elementos = Actualsize - size;
        if (Elementos >= 0) {
            for (int i = 0; i < Elementos; i++) {
                EliminarUltimo();
            }
        }
        return this;
    }

    /**
     * Regresa el nodo en la posicion n.
     * @param n El indice del elemento que se desea recuperar.
     * @return El nodo en la posicion n
     */
    public Nodo ElementAt(int n) {
        Nodo indice;
        int i;
        if (n < 0) {
            return null;
        }
        indice = Primero;
        for (i = 0; (i < n) && (indice != null); i++) {
            indice = indice.enlace;
        }
        return indice;
    }

    /**
     * Este metodo inserta un elemento en la ultima posicion de la lista.
     * @return ListaEncabezados con el nuevo nodo agregado
     */
    public ListaEncabezados InsertarUltimo() {
        int numero = size();
        Nodo ultimo = Primero;
        if (ultimo == null) {
            Nodo Nuevo = new Nodo(numero);
            Nuevo.enlace = Primero;
            Primero = Nuevo;
        } else {
            while (ultimo.enlace != null) {
                ultimo = ultimo.enlace;
            }
            ultimo.enlace = new Nodo(numero);
            ultimo = ultimo.enlace;
        }
        return this;
    }

    /**
     *
     * @return int El numero de elementos que contiene la lista.
     */
    public int size() {
        int contador = 0;
        Nodo actual = Primero;
        while (actual != null) {
            contador++;
            actual = actual.enlace;
        }
        return contador;
    }

    /**
     * Muestra los elementos de la lista de encabezados
     */
    public void MostrarElementos() {
        Nodo actual = Primero;
        while (actual != null) {
            System.out.println("Nodo actual: " + actual.getEstado());
            actual = actual.enlace;
        }
    }
}
