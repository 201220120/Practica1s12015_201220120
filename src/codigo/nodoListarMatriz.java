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
public class nodoListarMatriz {
    //Clas Nodo
	private nodoElemento mDato = null; //Carro: donde estan todos los datos del carro
	private nodoListarMatriz mSiguiente = null; //apuntador siguiente
	private nodoListarMatriz mAnterior = null;

    public nodoListarMatriz getMAnterior() {
        return mAnterior;
    }

    public nodoElemento getmDato() {
        return mDato;
    }

    public void setmDato(nodoElemento mDato) {
        this.mDato = mDato;
    }

    public nodoListarMatriz getmSiguiente() {
        return mSiguiente;
    }

    public void setmSiguiente(nodoListarMatriz mSiguiente) {
        this.mSiguiente = mSiguiente;
    }

    public nodoListarMatriz getmAnterior() {
        return mAnterior;
    }

    public void setmAnterior(nodoListarMatriz mAnterior) {
        this.mAnterior = mAnterior;
    }

    public void setMAnterior(nodoListarMatriz mAtras) {
        this.mAnterior = mAtras;
    }
	
	public nodoListarMatriz(){
		//Constructor	
	}
    
}
