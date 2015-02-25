/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codigo;

/**
 *
 * @author Walter Mendoza
 */
public class NodoM <T> {
   
    
    private NodoM anterior;
    private NodoM siguiente;
    private NodoM arriba;
    private NodoM abajo;
    private T value;
    
    public NodoM( T value)
    {
        this.value = value;
        anterior=siguiente=arriba=abajo=null;
       
    }
    
    public void setAbajo(NodoM abajo)
    {
        this.abajo=abajo;
    }
    
    public void setAnterior(NodoM anterior)
    {
        this.anterior=anterior;
    }
    
    public void setArriba(NodoM arriba)
    {
        this.arriba=arriba;
    }
    
    public void setSiguiente(NodoM siguiente)
    {
        this.siguiente=siguiente;
    }
    
    public NodoM getAbajo()
    {
        return abajo;
    }
    
    public NodoM getArriba(){
        return arriba;
    }
    
    public NodoM getAnterior()
    {
        return anterior;
    }
    
    public NodoM getSiguiente()
    {
        return siguiente;
    }
    

    public T getValue()
    {
        return value;
    }
    
    public void setValue(T value)
    {
        this.value = value;
    }
    
}
