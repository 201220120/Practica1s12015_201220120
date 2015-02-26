package MatrizOrtogonal;

//import Ventanas.Panel_Minuatura;
//import Ventanas.Ventana_Lista;
//import Ventanas.Ventana_Nuevo;

/**
 * Esta clase es donde se encapsula la informacion de las celulas
 * El estado de cada celula viva se representa por medio de un numero:
 * 1 = verde
 * 2 = Morado
 * 3 = Rojo
 * 4 = Naranaja
 * 5 = Amarillo
 * @author zetser
 */
public class Nodo {

    public Nodo Arriba;
    public Nodo Abajo;
    public Nodo Izquierda;
    public Nodo Derecha;

    
    /**
     * Este Nodo es utilizado en la lista de los encabezados.
     */
    public Nodo enlace;
    public Nodo nodoCelula;
    public static final int verde = 1;
    public static final int morado = 2;
    public static final int rojo = 3;
    public static final int naranja = 4;
    public static final int amarillo = 5;
    private int estado;
    private int columna;
    private int fila;

    /**
     * <H1>CONSTRUCTOR PARA CREAR UN NUEVO ENCABEZADO</H1>
     * @param estado
     */
    public Nodo(int estado) {
        this.estado = estado;
    }

    /**
     * <H1>CONSTRUCTOR PARA CREAR NUEVOS JUEGOS</H1>
     * @param columna
     * @param fila
    /**
     * <H1>CONSTRUCTOR PARA CREAR NUEVOS JUEGOS</H1>
     * @param columna
     * @param fila
     */


    /**
     * <H1>CONSTRUCTOR PARA CREAR NUEVAS CELULAS</H1>
     * @param columna
     * @param fila
     */
    public Nodo(int columna, int fila) {
        this.estado = verde;
        this.columna = columna;
        this.fila = fila;
        Arriba = null;
        Abajo = null;
        Izquierda = null;
        Derecha = null;
    }

    /**
     * <H1>CONSTRUCTOR PARA CREAR NUEVAS CELULAS Y DEFINIR UN ESTADO</H1>
     * @param columna
     * @param fila
     */
    public Nodo(int columna, int fila, int estado) {
        this.estado = estado;
        this.columna = columna;
        this.fila = fila;
        if (estado >= 6) {
            this.estado = 1;
        }
        Arriba = null;
        Abajo = null;
        Izquierda = null;
        Derecha = null;
    }

    public int getEstado() {
        return estado;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }


    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
