/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;

/**
 *
 * @author Braian
 */
public class funcionesMatriz {

    private static NodoMatriz nodoTablero;
    ArrayList<NodoMatriz> arreglo = new ArrayList();

    public void insertar(nodoElemento elemento) {
        //Si la entrada viene vacia que no la meta...
        if (elemento == null) {
            return;
        }
        //para el nodo modelo
        String nombre = elemento.getNombre();
        String ataque = elemento.getAtaque();
        int puntos = elemento.getPuntos();

        NodoMatriz temp = nodoTablero;
        NodoMatriz tempIzq = nodoTablero;
        if (temp == null) {
            NodoMatriz nodoElemento = new NodoMatriz();
            nodoElemento.agregarElemento(elemento);
            temp = nodoElemento;

            return;
        }
//////----------------------El ingreso de la primera vez------------------\\\\\\
        ///caso1///

        if (temp.getDerecha() == null && temp.getAbajo() == null) {
            //Se crea el nodo del modelo, el de la marca y el del elemento

            NodoMatriz nodoElemento = new NodoMatriz();
            //Se le agregan sus datos a cada nodo

            nodoElemento.agregarElemento(elemento);
            //nodo modelo a punta al elemento y a la base
            nodoElemento.setArriba(nodoElemento.arriba);
            nodoElemento.setIzquierda(temp);
            nodoElemento.setAbajo(nodoElemento.abajo);
            nodoElemento.setDerecha(nodoElemento.derecha);
			//la marca a punta al modelo y a la base

            // la base a punta al modelo y a la marca
            temp.setDerecha(nodoElemento);
            temp.setAbajo(null);

            return;
        }
//------------------------------------------------------------------------------
        //se le pone temporal al nuevo nodo de la fecha...
        temp = nodoTablero.getAbajo();
        //se le pone temporal al nuevo nodo de la marca...
        boolean hayDato = false;

        while (temp != null) {

            temp = temp.getAbajo();
            hayDato = true;
        }

////--------------------------Si hay uno igual.../******************************
        if (hayDato == true) {
            //el temporizador ya no es el modelo si no que el siguiente 
            temp = temp.getDerecha();
            hayDato = false;
            //los recorre y mientras no sea null 
            while (temp != null) {
                /////Si en cuentra a uno que tambien sea de la misma marca
                hayDato = true;
                temp = temp.getDerecha();
            }
            ////Si es el mismo modelo y la misma marca..../**************************
            ///Caso2///
            if (hayDato == true) {
                temp.agregarElemento(elemento);
                return;
            } /**
             * ************************************************************************
             */
            ///Caso3///
            else {
                NodoMatriz temp2 = nodoTablero.getDerecha();

                NodoMatriz nodoElemento = new NodoMatriz();
                nodoElemento.agregarElemento(elemento);
                boolean findebusqueda = false;
                while (temp2 != null) {
                    if (temp2.getDerecha() != null) {
                        nodoElemento.setAbajo(nodoElemento.abajo);
                        nodoElemento.setIzquierda(temp2);
                        nodoElemento.setArriba(nodoElemento.arriba);
                        temp2.setDerecha(nodoElemento);
                        break;
                    }
                    temp2 = temp2.getDerecha();
                }
                temp = nodoTablero.getAbajo();
                boolean hayDato2 = false;
                NodoMatriz tempo = nodoTablero.getAbajo();
                while (tempo != null) {

                    hayDato2 = true;

                    tempo = tempo.getAbajo();
                }
                if (hayDato2 == true) {
                    NodoMatriz tempo2 = tempo.getDerecha();
                    while (tempo2 != null) {
                        if (tempo2.getDerecha() == null) {
                            tempo2.setDerecha(nodoElemento);
                            nodoElemento.setIzquierda(tempo2);
                            break;
                        }
                        tempo2 = tempo2.getDerecha();
                    }
                }
                return;
            }
        } else {
            ///////////////////////Caso4   y caso 5/////////////////////////
            // no hay modelo
            //temporizador esta en el primer modelo
            NodoMatriz tempy = nodoTablero.getAbajo();

            NodoMatriz nodoElemento = new NodoMatriz();
            nodoElemento.agregarElemento(elemento);
            while (tempy != null) {
                //caso5

                if (tempy.getAbajo() == null) {
                    tempy.setAbajo(nodoElemento);
                    nodoElemento.setArriba(tempy);
                    nodoElemento.setDerecha(nodoElemento.derecha);
                    nodoElemento.setIzquierda(nodoElemento.Izquierda);
                    break;
                }
            }
            tempy = tempy.getAbajo();

            NodoMatriz tempo = nodoTablero.getDerecha();
            while (tempo != null) {

                NodoMatriz tempus = tempo.getAbajo();
                if (tempus != null) {
                    while (tempus != null) {
                        /*
                         NodoMatriz antetemp = tempus.getArriba();
                         nodoElemento.setAbajo(tempus);
                         nodoElemento.setArriba(antetemp);
                         antetemp.setAbajo(nodoElemento);
                         tempus.setArriba(nodoElemento);
                         //break;
                            
                         tempus = tempus.getAbajo();
                         }
                         break;
                         } else {
                         nodoElemento.setArriba(tempus);
                         tempus.setAbajo(nodoElemento);
                         break;
                    
                         } else {*/
                        //caso6
                        if (tempo.getDerecha() == null) {

                            tempo.setDerecha(nodoElemento);
                            nodoElemento.setIzquierda(tempo);
                            nodoElemento.setAbajo(nodoElemento.abajo);
                            nodoElemento.setArriba(nodoElemento.arriba);
                        }
                    }
                    tempo = tempo.getDerecha();
                }
            }
            return;
        }

    }
}
