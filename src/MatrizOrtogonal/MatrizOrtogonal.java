package MatrizOrtogonal;

//import Ventanas.Ventana_Nuevo;

import javax.swing.JPanel;


/**
 * Esta clase implementa la matriz ortogonal
 * @author zetser
 */
public class MatrizOrtogonal extends JPanel{

    private int tamaño;
    public ListaEncabezados filas;
    public ListaEncabezados columnas;
    private int elementos = 0;

    /**
     * Constructor para crear una nueva instancia de la matriz, para este proyecto
     * la matriz siempre debe de ser cuadrado, lo que implica <code>X = Y</code>
     * @param tamaño el tamaño de la matriz.
     */
    public MatrizOrtogonal(int tamaño) {
        this.tamaño = tamaño;
        filas = new ListaEncabezados(tamaño);
        columnas = new ListaEncabezados(tamaño);
    }

    /**
     * Este metodo sirve para insertar elementos en las coordenadas dadas por
     * fila y columna
     * @param fila
     * @param columna
     * @return MatrizOrtogonal con el elemento insetado
     */
    public MatrizOrtogonal insertar(int columna, int fila) {
        if (fila < tamaño && columna < tamaño) {

            Nodo nuevo = new Nodo(columna, fila);
            Nodo f = filas.ElementAt(fila);
            Nodo c = columnas.ElementAt(columna);
//            Mostrar("Insertar nuevo nodo (" + columna + ", " + fila + ")");
//            //PONER EL APUNTADOR PARA LA COLUMNA
            if (c.nodoCelula != null) { // si ya ha sido agregado un elemento a la columna
//                Mostrar("\tLa columna " + columna + " tiene elementos, buscar posicion");
                //ahora se verifica si el nuevo nodo se inserta antes o despues

                Nodo mayor = c.nodoCelula;
                Nodo anterior = mayor;

//                Mostrar("\t\tNodo mayor: (" + mayor.getColumna() + ", " + mayor.getFila() + ")");
//                Mostrar("\t\tNodo anter: (" + anterior.getColumna() + ", " + anterior.getFila() + ")");

                while (mayor != null) {
                    if (mayor.getFila() < fila) {
//                        Mostrar("\t\t\tmayor (" + mayor.getFila() + ") < fila (" + fila + ")");
//                        Mostrar("\t\t\tavanzar uno hacia abajo");
                        anterior = mayor;
                        mayor = mayor.Abajo;
//                        Mostrar("\t\t\tmayor = " + mayor);
                        if (mayor == null) {
//                            Mostrar("\t\t\tEl nodo nuevo es el mayor");
//                            Mostrar("\t\t\tEl nodo nuevo se insertara al final de la columna");
                            nuevo.Arriba = anterior;
                            anterior.Abajo = nuevo;
                            break;
                        }
                    } else if (mayor.getFila() > fila) {
//                        Mostrar("\t\t\tmayor (" + mayor.getFila() + ") > fila (" + fila + ")");
//                        Mostrar("\t\t\tel nodo nuevo se inserta antes que el mayor");
//                        Mostrar("\t\t\tmayor = " + mayor);

                        nuevo.Abajo = mayor;
                        nuevo.Arriba = mayor.Arriba;

                        if (c.nodoCelula == mayor) {
                            c.nodoCelula = nuevo;
                        } else {
                            anterior.Abajo = nuevo;
                        }
                        mayor.Arriba = nuevo;
                        break;
                    }
                }

            } else {
//                Mostrar("\tLa columna " + columna + " no tiene elementos insertar nuevo");
                c.nodoCelula = nuevo;
            }

            //PONER EL APUNTADOR PARA LA FILA
            if (f.nodoCelula != null) { // si ya ha sido agregado un elemento a la fila
//                Mostrar("\tLa fila " + fila + " tiene elementos, buscar posicion");
                //ahora se verifica si el nuevo nodo se inserta antes o despues
                Nodo mayor = f.nodoCelula;
                Nodo anterior = mayor;

//                Mostrar("\t\tNodo mayor: (" + mayor.getColumna() + ", " + mayor.getFila() + ")");
//                Mostrar("\t\tNodo anter: (" + anterior.getColumna() + ", " + anterior.getFila() + ")");

                while (mayor != null) {
                    if (mayor.getColumna() < columna) {
//                        Mostrar("\t\t\tmayor (" + mayor.getColumna() + ") < fila (" + columna + ")");
//                        Mostrar("\t\t\tavanzar uno hacia la derecha");
                        anterior = mayor;
                        mayor = mayor.Derecha;
//                        Mostrar("\t\t\tmayor = " + mayor);
                        if (mayor == null) {
//                            Mostrar("\t\t\tEl nodo nuevo es el mayor");
//                            Mostrar("\t\t\tEl nodo nuevo se insertara al final de la fila");

                            nuevo.Izquierda = anterior;
                            anterior.Derecha = nuevo;

                            break;
                        }
                    } else if (mayor.getColumna() > columna) {
//                        Mostrar("\t\t\tmayor (" + mayor.getColumna() + ") > fila (" + columna + ")");
//                        Mostrar("\t\t\tel nodo nuevo se inserta antes que el mayor");
//                        Mostrar("\t\t\tmayor = " + mayor);

                        nuevo.Derecha = mayor;
                        nuevo.Izquierda = anterior;

                        if (f.nodoCelula == mayor) {
                            f.nodoCelula = nuevo;
                        } else {
                            anterior.Derecha = nuevo;
                        }
                        mayor.Izquierda = nuevo;
                        break;
                    }
                }
            } else {//si no hay ningun elemento en la fila
//                Mostrar("\tLa fila " + fila + " no tiene elementos insertar nuevo");
                f.nodoCelula = nuevo;
            }
        }
        return this;
    }

    /**
     * Este metodo sirve para insetar nodos ya creados en una posicion dada
     * por fila y columna
     * @param nuevo
     * @param columna
     * @param fila
     * @return MatrizOrtogonal modificada
     */
    public MatrizOrtogonal insertar(Nodo nuevo, int columna, int fila) {
        if (fila < tamaño && columna < tamaño) {

            nuevo.setColumna(columna);
            nuevo.setFila(fila);
            Nodo f = filas.ElementAt(fila);
            Nodo c = columnas.ElementAt(columna);
//            Mostrar("Insertar nuevo nodo (" + columna + ", " + fila + ")");
//            //PONER EL APUNTADOR PARA LA COLUMNA
            if (c.nodoCelula != null) { // si ya ha sido agregado un elemento a la columna
//                Mostrar("\tLa columna " + columna + " tiene elementos, buscar posicion");
                //ahora se verifica si el nuevo nodo se inserta antes o despues

                Nodo mayor = c.nodoCelula;
                Nodo anterior = mayor;

//                Mostrar("\t\tNodo mayor: (" + mayor.getColumna() + ", " + mayor.getFila() + ")");
//                Mostrar("\t\tNodo anter: (" + anterior.getColumna() + ", " + anterior.getFila() + ")");

                while (mayor != null) {
                    if (mayor.getFila() < fila) {
//                        Mostrar("\t\t\tmayor (" + mayor.getFila() + ") < fila (" + fila + ")");
//                        Mostrar("\t\t\tavanzar uno hacia abajo");
                        anterior = mayor;
                        mayor = mayor.Abajo;
//                        Mostrar("\t\t\tmayor = " + mayor);
                        if (mayor == null) {
//                            Mostrar("\t\t\tEl nodo nuevo es el mayor");
//                            Mostrar("\t\t\tEl nodo nuevo se insertara al final de la columna");
                            nuevo.Arriba = anterior;
                            anterior.Abajo = nuevo;
                            break;
                        }
                    } else if (mayor.getFila() > fila) {
//                        Mostrar("\t\t\tmayor (" + mayor.getFila() + ") > fila (" + fila + ")");
//                        Mostrar("\t\t\tel nodo nuevo se inserta antes que el mayor");
//                        Mostrar("\t\t\tmayor = " + mayor);

                        nuevo.Abajo = mayor;
                        nuevo.Arriba = mayor.Arriba;

                        if (c.nodoCelula == mayor) {
                            c.nodoCelula = nuevo;
                        } else {
                            anterior.Abajo = nuevo;
                        }
                        mayor.Arriba = nuevo;
                        break;
                    }
                }

            } else {
//                Mostrar("\tLa columna " + columna + " no tiene elementos insertar nuevo");
                c.nodoCelula = nuevo;
            }

            //PONER EL APUNTADOR PARA LA FILA
            if (f.nodoCelula != null) { // si ya ha sido agregado un elemento a la fila
//                Mostrar("\tLa fila " + fila + " tiene elementos, buscar posicion");
                //ahora se verifica si el nuevo nodo se inserta antes o despues
                Nodo mayor = f.nodoCelula;
                Nodo anterior = mayor;

//                Mostrar("\t\tNodo mayor: (" + mayor.getColumna() + ", " + mayor.getFila() + ")");
//                Mostrar("\t\tNodo anter: (" + anterior.getColumna() + ", " + anterior.getFila() + ")");

                while (mayor != null) {
                    if (mayor.getColumna() < columna) {
//                        Mostrar("\t\t\tmayor (" + mayor.getColumna() + ") < fila (" + columna + ")");
//                        Mostrar("\t\t\tavanzar uno hacia la derecha");
                        anterior = mayor;
                        mayor = mayor.Derecha;
//                        Mostrar("\t\t\tmayor = " + mayor);
                        if (mayor == null) {
//                            Mostrar("\t\t\tEl nodo nuevo es el mayor");
//                            Mostrar("\t\t\tEl nodo nuevo se insertara al final de la fila");

                            nuevo.Izquierda = anterior;
                            anterior.Derecha = nuevo;

                            break;
                        }
                    } else if (mayor.getColumna() > columna) {
//                        Mostrar("\t\t\tmayor (" + mayor.getColumna() + ") > fila (" + columna + ")");
//                        Mostrar("\t\t\tel nodo nuevo se inserta antes que el mayor");
//                        Mostrar("\t\t\tmayor = " + mayor);

                        nuevo.Derecha = mayor;
                        nuevo.Izquierda = anterior;

                        if (f.nodoCelula == mayor) {
                            f.nodoCelula = nuevo;
                        } else {
                            anterior.Derecha = nuevo;
                        }
                        mayor.Izquierda = nuevo;
                        break;
                    }
                }
            } else {//si no hay ningun elemento en la fila
//                Mostrar("\tLa fila " + fila + " no tiene elementos insertar nuevo");
                f.nodoCelula = nuevo;
            }
        }
        return this;
    }

    /**
     * Este metodo sirve para insertar elementos en las coordenadas dadas por
     * fila y columna
     * @param fila
     * @param columna
     * @return MatrizOrtogonal modificada
     */
    public MatrizOrtogonal insertar(int columna, int fila, int estado) {
        if (fila < tamaño && columna < tamaño) {

            Nodo nuevo = new Nodo(columna, fila, estado);
            Nodo f = filas.ElementAt(fila);
            Nodo c = columnas.ElementAt(columna);
//            Mostrar("Insertar nuevo nodo (" + columna + ", " + fila + ")");
//            //PONER EL APUNTADOR PARA LA COLUMNA
            if (c.nodoCelula != null) { // si ya ha sido agregado un elemento a la columna
//                Mostrar("\tLa columna " + columna + " tiene elementos, buscar posicion");
                //ahora se verifica si el nuevo nodo se inserta antes o despues

                Nodo mayor = c.nodoCelula;
                Nodo anterior = mayor;

//                Mostrar("\t\tNodo mayor: (" + mayor.getColumna() + ", " + mayor.getFila() + ")");
//                Mostrar("\t\tNodo anter: (" + anterior.getColumna() + ", " + anterior.getFila() + ")");

                while (mayor != null) {
                    if (mayor.getFila() < fila) {
//                        Mostrar("\t\t\tmayor (" + mayor.getFila() + ") < fila (" + fila + ")");
//                        Mostrar("\t\t\tavanzar uno hacia abajo");
                        anterior = mayor;
                        mayor = mayor.Abajo;
//                        Mostrar("\t\t\tmayor = " + mayor);
                        if (mayor == null) {
//                            Mostrar("\t\t\tEl nodo nuevo es el mayor");
//                            Mostrar("\t\t\tEl nodo nuevo se insertara al final de la columna");
                            nuevo.Arriba = anterior;
                            anterior.Abajo = nuevo;
                            break;
                        }
                    } else if (mayor.getFila() > fila) {
//                        Mostrar("\t\t\tmayor (" + mayor.getFila() + ") > fila (" + fila + ")");
//                        Mostrar("\t\t\tel nodo nuevo se inserta antes que el mayor");
//                        Mostrar("\t\t\tmayor = " + mayor);

                        nuevo.Abajo = mayor;
                        nuevo.Arriba = mayor.Arriba;

                        if (c.nodoCelula == mayor) {
                            c.nodoCelula = nuevo;
                        } else {
                            anterior.Abajo = nuevo;
                        }
                        mayor.Arriba = nuevo;
                        break;
                    }
                }

            } else {
//                Mostrar("\tLa columna " + columna + " no tiene elementos insertar nuevo");
                c.nodoCelula = nuevo;
            }

            //PONER EL APUNTADOR PARA LA FILA
            if (f.nodoCelula != null) { // si ya ha sido agregado un elemento a la fila
//                Mostrar("\tLa fila " + fila + " tiene elementos, buscar posicion");
                //ahora se verifica si el nuevo nodo se inserta antes o despues
                Nodo mayor = f.nodoCelula;
                Nodo anterior = mayor;

//                Mostrar("\t\tNodo mayor: (" + mayor.getColumna() + ", " + mayor.getFila() + ")");
//                Mostrar("\t\tNodo anter: (" + anterior.getColumna() + ", " + anterior.getFila() + ")");

                while (mayor != null) {
                    if (mayor.getColumna() < columna) {
//                        Mostrar("\t\t\tmayor (" + mayor.getColumna() + ") < fila (" + columna + ")");
//                        Mostrar("\t\t\tavanzar uno hacia la derecha");
                        anterior = mayor;
                        mayor = mayor.Derecha;
//                        Mostrar("\t\t\tmayor = " + mayor);
                        if (mayor == null) {
//                            Mostrar("\t\t\tEl nodo nuevo es el mayor");
//                            Mostrar("\t\t\tEl nodo nuevo se insertara al final de la fila");

                            nuevo.Izquierda = anterior;
                            anterior.Derecha = nuevo;

                            break;
                        }
                    } else if (mayor.getColumna() > columna) {
//                        Mostrar("\t\t\tmayor (" + mayor.getColumna() + ") > fila (" + columna + ")");
//                        Mostrar("\t\t\tel nodo nuevo se inserta antes que el mayor");
//                        Mostrar("\t\t\tmayor = " + mayor);

                        nuevo.Derecha = mayor;
                        nuevo.Izquierda = anterior;

                        if (f.nodoCelula == mayor) {
                            f.nodoCelula = nuevo;
                        } else {
                            anterior.Derecha = nuevo;
                        }
                        mayor.Izquierda = nuevo;
                        break;
                    }
                }
            } else {//si no hay ningun elemento en la fila
//                Mostrar("\tLa fila " + fila + " no tiene elementos insertar nuevo");
                f.nodoCelula = nuevo;
            }
        }
        return this;
    }

    /**
     * Este metodo sirve para insertar elementos en las coordenadas dadas por
     * fila y columna
     * @param fila
     * @param columna
     * @return MatrizOrtogonal modificada
     */
    /*
    public MatrizOrtogonal insertar(int columna, int fila, Ventana_Nuevo ventana) {
        if (fila < tamaño && columna < tamaño) {

            Nodo nuevo = new Nodo(columna, fila, ventana);
            Nodo f = filas.ElementAt(fila);
            Nodo c = columnas.ElementAt(columna);
//            Mostrar("Insertar nuevo nodo (" + columna + ", " + fila + ")");
//            //PONER EL APUNTADOR PARA LA COLUMNA
            if (c.nodoCelula != null) { // si ya ha sido agregado un elemento a la columna
//                Mostrar("\tLa columna " + columna + " tiene elementos, buscar posicion");
                //ahora se verifica si el nuevo nodo se inserta antes o despues

                Nodo mayor = c.nodoCelula;
                Nodo anterior = mayor;

//                Mostrar("\t\tNodo mayor: (" + mayor.getColumna() + ", " + mayor.getFila() + ")");
//                Mostrar("\t\tNodo anter: (" + anterior.getColumna() + ", " + anterior.getFila() + ")");

                while (mayor != null) {
                    if (mayor.getFila() < fila) {
//                        Mostrar("\t\t\tmayor (" + mayor.getFila() + ") < fila (" + fila + ")");
//                        Mostrar("\t\t\tavanzar uno hacia abajo");
                        anterior = mayor;
                        mayor = mayor.Abajo;
//                        Mostrar("\t\t\tmayor = " + mayor);
                        if (mayor == null) {
//                            Mostrar("\t\t\tEl nodo nuevo es el mayor");
//                            Mostrar("\t\t\tEl nodo nuevo se insertara al final de la columna");
                            nuevo.Arriba = anterior;
                            anterior.Abajo = nuevo;
                            break;
                        }
                    } else if (mayor.getFila() > fila) {
//                        Mostrar("\t\t\tmayor (" + mayor.getFila() + ") > fila (" + fila + ")");
//                        Mostrar("\t\t\tel nodo nuevo se inserta antes que el mayor");
//                        Mostrar("\t\t\tmayor = " + mayor);

                        nuevo.Abajo = mayor;
                        nuevo.Arriba = mayor.Arriba;

                        if (c.nodoCelula == mayor) {
                            c.nodoCelula = nuevo;
                        } else {
                            anterior.Abajo = nuevo;
                        }
                        mayor.Arriba = nuevo;
                        break;
                    }
                }

            } else {
//                Mostrar("\tLa columna " + columna + " no tiene elementos insertar nuevo");
                c.nodoCelula = nuevo;
            }

            //PONER EL APUNTADOR PARA LA FILA
            if (f.nodoCelula != null) { // si ya ha sido agregado un elemento a la fila
//                Mostrar("\tLa fila " + fila + " tiene elementos, buscar posicion");
                //ahora se verifica si el nuevo nodo se inserta antes o despues
                Nodo mayor = f.nodoCelula;
                Nodo anterior = mayor;

//                Mostrar("\t\tNodo mayor: (" + mayor.getColumna() + ", " + mayor.getFila() + ")");
//                Mostrar("\t\tNodo anter: (" + anterior.getColumna() + ", " + anterior.getFila() + ")");

                while (mayor != null) {
                    if (mayor.getColumna() < columna) {
//                        Mostrar("\t\t\tmayor (" + mayor.getColumna() + ") < fila (" + columna + ")");
//                        Mostrar("\t\t\tavanzar uno hacia la derecha");
                        anterior = mayor;
                        mayor = mayor.Derecha;
//                        Mostrar("\t\t\tmayor = " + mayor);
                        if (mayor == null) {
//                            Mostrar("\t\t\tEl nodo nuevo es el mayor");
//                            Mostrar("\t\t\tEl nodo nuevo se insertara al final de la fila");

                            nuevo.Izquierda = anterior;
                            anterior.Derecha = nuevo;

                            break;
                        }
                    } else if (mayor.getColumna() > columna) {
//                        Mostrar("\t\t\tmayor (" + mayor.getColumna() + ") > fila (" + columna + ")");
//                        Mostrar("\t\t\tel nodo nuevo se inserta antes que el mayor");
//                        Mostrar("\t\t\tmayor = " + mayor);

                        nuevo.Derecha = mayor;
                        nuevo.Izquierda = anterior;

                        if (f.nodoCelula == mayor) {
                            f.nodoCelula = nuevo;
                        } else {
                            anterior.Derecha = nuevo;
                        }
                        mayor.Izquierda = nuevo;
                        break;
                    }
                }
            } else {//si no hay ningun elemento en la fila
//                Mostrar("\tLa fila " + fila + " no tiene elementos insertar nuevo");
                f.nodoCelula = nuevo;
            }
        }
        return this;
    }
*/
    private void Mostrar(Object o) {
        System.out.println(o);
    }

    /**
     * Consulta en la matriz si el nodo con las coordenadas dadas existe, si existe
     * devuelve el nodo, de lo contrario devuelve null
     * @param fila La fila para buscar el nodo
     * @param columna La columna para buscar el nodo
     * @return El nodo que esta en la fila y columna
     */
    public Nodo getNodo(int fila, int columna) {
        Nodo Fila = filas.ElementAt(fila).nodoCelula;
        Nodo actual = columnas.ElementAt(columna).nodoCelula;
        boolean encontrado = false;
        if (actual != null && Fila != null) {
            while (actual != null) {
                encontrado = (actual.getColumna() == columna && actual.getFila() == fila);
                if (encontrado) {
                    return actual;
                }
                actual = actual.Abajo;
            }
        }
        return null;
    }

    /**
     * Muestra los elementos de la matriz
     * @param Nombre
     */
    public void MostrarElementos(String Nombre) {
        Mostrar("<------ " + Nombre + " ------>");
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                Nodo aux = getNodo(i, j);
                if (aux != null) {
                    System.out.print("(" + aux.getColumna() + "," + aux.getFila() + ")");
                } else {
                    System.out.print("(-,-)");
                }
            }
            System.out.println();
        }
    }

    /**
     * Recorre una fila de la matriz
     * @param fila La fila que se desea recorrer
     */
    public void RecorrerFila(int fila) {
        Nodo actual = filas.ElementAt(fila).nodoCelula;
        while (actual != null) {
//            System.out.print("(" + actual.getColumna() + "," + actual.getFila() + ")");
            actual = actual.Derecha;
            elementos++;
        }
//        System.out.println();
    }

    /**
     * Recorre una columna de la matriz
     * @param columna La columna que se desea recorrer
     */
    public void RecorrerColumna(int columna) {
        Nodo actual = columnas.ElementAt(columna).nodoCelula;
        while (actual != null) {
            System.out.println("(" + actual.getColumna() + "," + actual.getFila() + ")");
            actual = actual.Abajo;
            elementos++;
        }
        System.out.println();
    }

    /**
     * Sirve para saber cuantos elementos contiene la matriz
     * @return int El numero de elementos de la matriz
     */
    public int Elementos() {
        int f = filas.size();
        for (int i = 0; i < f; i++) {
            RecorrerFila(i);
        }
        int aux = elementos;
        elementos = 0;
        return aux;
    }

    /**
     * Metodo que sirve para eliminar un nodo de la matriz en una fila y columna
     * especificos
     * @param columna
     * @param fila
     * @return MatrizOrtogonal modificada
     */
    public MatrizOrtogonal EliminarAt(int columna, int fila) {
        if (fila < tamaño && columna < tamaño) {
            Nodo c = columnas.ElementAt(columna);
            Nodo f = filas.ElementAt(fila);

            //BUSCAMOS POR COLUMNAS
            Nodo actual = c.nodoCelula;
            Nodo anterior = null;
            boolean encontrado = false;

            while ((actual != null) && (!encontrado)) {
                encontrado = (actual.getColumna() == columna && actual.getFila() == fila);
                if (!encontrado) {
                    anterior = actual;
                    actual = actual.Abajo;
                }
            }

            if (actual != null) {
                // Eliminar de la columna
                if (actual == c.nodoCelula) {
                    c.nodoCelula = actual.Abajo;
                } else {
                    actual.Arriba.Abajo = actual.Abajo;
                    if (actual.Abajo != null) {
                        actual.Abajo.Arriba = actual.Arriba;
                    }
                }
                //Eliminar de la fila
                if (actual == f.nodoCelula) {
                    f.nodoCelula = actual.Derecha;
                } else {
                    actual.Izquierda.Derecha = actual.Derecha;
                    if (actual.Derecha != null) {
                        actual.Derecha.Izquierda = actual.Izquierda;
                    }
                }
                actual = null;
            }
        }
        return this;
    }

    /**
     * Metodo que sirve para eliminar un nodo de la matriz en una fila y columna
     * especificos
     * @param columna
     * @param fila
     * @return Nodo el nodo que se ha eliminado
     */
    public Nodo Eliminar(int columna, int fila) {
        if (fila < tamaño && columna < tamaño) {
            Nodo c = columnas.ElementAt(columna);
            Nodo f = filas.ElementAt(fila);

            //BUSCAMOS POR COLUMNAS
            Nodo actual = c.nodoCelula;
            Nodo anterior = null;
            boolean encontrado = false;

            while ((actual != null) && (!encontrado) && f != null) {
                encontrado = (actual.getColumna() == columna && actual.getFila() == fila);
                if (!encontrado) {
                    anterior = actual;
                    actual = actual.Abajo;
                }
            }

            if (actual != null) {
                // Eliminar de la columna
                if (actual == c.nodoCelula) {
                    c.nodoCelula = actual.Abajo;
                } else {
                    actual.Arriba.Abajo = actual.Abajo;
                    if (actual.Abajo != null) {
                        actual.Abajo.Arriba = actual.Arriba;
                    }
                }
                //Eliminar de la fila
                if (actual == f.nodoCelula) {
                    f.nodoCelula = actual.Derecha;
                } else {
                    actual.Izquierda.Derecha = actual.Derecha;
                    if (actual.Derecha != null) {
                        actual.Derecha.Izquierda = actual.Izquierda;
                    }
                }
                actual.Abajo = null;
                actual.Arriba = null;
                actual.Derecha = null;
                actual.Izquierda = null;
                return actual;
            }
        }
        return null;
    }

    public MatrizOrtogonal EliminarColumna(int columna) {
        for (int i = 0; i < tamaño; i++) {
            try {
                EliminarAt(columna, i);
            } catch (Exception e) {
            }
        }
        return this;
    }

    /**
     * Metodo para eliminar completamente una fila de la matriz
     * @param fila
     * @return MatrizOrtogonal despues de eliminar la fila dada
     */
    public MatrizOrtogonal EliminarFila(int fila) {
        for (int i = 0; i < tamaño; i++) {
            try {
                EliminarAt(i, fila);
            } catch (Exception e) {
            }
        }
        return this;
    }

    /**
     * Metodo que devuelve una posicion que esta diponible en la matriz
     * @return El nodo que esta disponible en la matriz
     */
    public Nodo getDisponible() {
        Nodo Disponible;
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                Disponible = getNodo(i, j);
                if (Disponible == null) {
                    return new Nodo(j, i);
                }
            }
        }
        return null;
    }

    /**
     * Metodo para obtener las dimensiones de la matriz
     * @return EL tamaño de la matriz
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Metodo para cambiar las dimensiones de la matriz
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * Metodo para agregar una cantidad de filas y columnas a la matriz
     * @param cantidad
     */
    public void AgregarFilaColum(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            tamaño++;
            columnas.InsertarUltimo();
            filas.InsertarUltimo();
        }
    }
}
