package codigo;

/**
 * @(#)NodoMatriz.java
 *
 *
 * @author
 * @version 1.00 2015/2/21
 */
public class NodoMatriz {

    funcionePlanta plantasEnNodo;
    public NodoMatriz derecha;
    public NodoMatriz Izquierda;
    public NodoMatriz abajo;
    public NodoMatriz arriba;
    public String Nombre;
    public int puntos;
    public String ataque;
    private listarMatriz mElementos = null;

    public NodoMatriz() {
        plantasEnNodo = new funcionePlanta();
        derecha = null;
        Izquierda = null;
        abajo = null;
        arriba = null;
    }
public void agregarElemento(nodoElemento elemento){
		
		if(elemento == null){
			return;
		}
		
		if(mElementos == null){
			Nombre = elemento.getNombre();
                        ataque = elemento.getAtaque();
                        puntos = elemento.getPuntos();
			
			mElementos = new listarMatriz();
		}
		
		mElementos.insertarDato(elemento);
	}

    public funcionePlanta getPlantasEnNodo() {
        return plantasEnNodo;
    }

    public void setPlantasEnNodo(funcionePlanta plantasEnNodo) {
        this.plantasEnNodo = plantasEnNodo;
    }

    public NodoMatriz getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoMatriz derecha) {
        this.derecha = derecha;
    }

    public NodoMatriz getIzquierda() {
        return Izquierda;
    }

    public void setIzquierda(NodoMatriz Izquierda) {
        this.Izquierda = Izquierda;
    }

    public NodoMatriz getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }

    public NodoMatriz getArriba() {
        return arriba;
    }

    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

}
