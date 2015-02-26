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
public class Pila2 {

    nodoZombie cabeza;
    int contador = 0;

    public Pila2() {
        this.cabeza = null;
    }

    public Pila2 insertaP(nodoZombie elemento) {
        nodoZombie nuevo = new nodoZombie();
        nuevo.Nombre = elemento.Nombre;
        nuevo.ataque = elemento.ataque;
        nuevo.puntos = elemento.puntos;
         nuevo.imagen = elemento.imagen;

// verificar si la pila está vacia
        if (cabeza == null) {
            nuevo.sig = null;
            cabeza = nuevo;
            contador++;
            System.out.println("prder elemento " + nuevo.Nombre);
        } else {
            nuevo.sig = cabeza;
            cabeza = nuevo;
            System.out.println("prd elemento " + nuevo.Nombre);
            contador++;
        }
        return this;
    }// fin del insertado producto.

    public nodoZombie sacaP() {
        if (cabeza == null) {
            System.out.println("loto esta vacia");
        }
        while (cabeza != null) {
            nodoZombie aux = cabeza;
            cabeza = cabeza.sig;
            System.out.println(aux.Nombre);
            System.out.println(aux.ataque);

            aux.sig = null;
            contador--;
        }
        return cabeza;
    }
     public int getTamaño() {
        return this.contador;

    }
}
