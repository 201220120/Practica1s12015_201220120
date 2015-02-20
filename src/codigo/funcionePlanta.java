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
public class funcionePlanta {

    private static nodoPlanta listaCatalogo;

    public void agregarLista(nodoPlanta elemento) {
        if (listaCatalogo == null) {
            listaCatalogo = new nodoPlanta();
            listaCatalogo = elemento;
        } else {
            nodoPlanta aux = listaCatalogo;
            while (aux.sig != null) {
                aux = aux.sig;

            }
            aux.sig = elemento;

        }
    }

    public nodoPlanta getRaiz() {
        nodoPlanta aux = listaCatalogo;
        return aux;
    }
    int contador = 0;

    public int getTamaño() {

        nodoPlanta aux = listaCatalogo;
        if (aux == null) {
            // contador++;
            System.out.println(contador + " CUANTO TIENE ANTES");
        } else {
            contador++;
            System.out.println(contador + " CUANTO TIENE ahora");
            while (aux.sig != null) {
                contador++;
                System.out.println(contador + " CUANTO TIENE");
                aux = aux.sig;
            }

        }

        return contador;
    }
}
