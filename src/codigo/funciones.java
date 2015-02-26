package codigo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Braian
 */
public class funciones {

    private static nodo raiz;
    int contador;

    public void agregarLista(nodo elemento) {
        if (raiz == null) {
            raiz = new nodo();
            raiz = elemento;
        } else {
            nodo aux = raiz;
            while (aux.sig != null) {
                aux = aux.sig;

            }
            aux.sig = elemento;

        }
    }

    public nodo getRaiz() {
        nodo aux = raiz;
        return aux;
    }

    public int getTamaño() {

        nodo aux = raiz;
        while (aux != null) {
            contador++;

            aux = aux.sig;
        }
        return contador;

    }

    public nodo buscar(String tipo) {
        nodo aux = raiz;
        while (aux != null) {
            if (aux.Tipo == tipo) {
                return aux;
            } else {
                aux = aux.sig;
            }

        }
        return aux;
    }

    public boolean modificar(int cantidad, String nuevo, int modif) {
        nodo aux = raiz;
        while (aux != null) {
            if (aux.cantidad == cantidad) {
                aux.Nombre = nuevo;
                aux.cantidad = modif;
                return true;
            }
            aux = aux.sig;
        }
        return false;
    }

    public void clear() {
        while (raiz != null) {
            raiz = raiz.sig;

        }
    }

    public boolean eliminar(int cantidad) {
        if (raiz.cantidad == cantidad) {
            raiz = raiz.sig;
            return true;
        } else {
            try {
                nodo aux = raiz;
                while (aux.sig != null) {
                    if (aux.sig.cantidad == cantidad) {
                        nodo aux2 = aux.sig;
                        aux.sig = aux2.sig;
                        return true;
                    }
                }
                aux = aux.sig;
            } catch (Exception e) {
            }

        }

        return false;
    }
}
