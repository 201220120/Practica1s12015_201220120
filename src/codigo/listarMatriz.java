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
public class listarMatriz {
    private nodoListarMatriz mBase = null;
    
    public void borrarPorId(String nombre){
		int pos = buscarPorId( nombre );
		borrarPorPosicion( pos );
	}
    public int buscarPorId(String nombre){
		nodoListarMatriz temp = mBase;
		int pos = 0;
		while(temp != null){
			if(temp.getmDato().getNombre() == nombre){
				return pos;
			}
			pos++;
			temp = temp.getmSiguiente();
		}	
		return -1;
	}
    
    public void borrarPorPosicion(int pPos){
		nodoListarMatriz temp = mBase;
		int pos = 0;
		if(mBase == null){
			return;
		}
		if(mBase.getmSiguiente()== null){
			if( pos == pPos ){
				mBase = null;
			}
			return;
		}else{
			if(pPos == pos){
				mBase = mBase.getmSiguiente();
					return;
			}
		}
		nodoListarMatriz actual = mBase.getmAnterior();
		pos = 1;
		while(actual != null){
			if(pos == pPos){
				temp.setmSiguiente(actual.getmSiguiente());
				return;
			}
			pos++;
			temp = actual;
			actual = actual.getmSiguiente();
		}	
	}
    
	public int getSize(){
		nodoListarMatriz temp = mBase;
		int size = 0;
		while(temp != null){
			size++;
			temp = temp.getmSiguiente();
		}
		return size;
	}
        
        public nodoElemento getCarroPorPosicion(int pPos){
		nodoListarMatriz temp = mBase;
		int size = 0;
		while( temp != null )	
		{
			if(size == pPos){
				return temp.getmDato();
			}
			size++;
			temp = temp.getmSiguiente();
		}	
		return null;
	}
        
        
	public void insertarDato(nodoElemento elemento){
		if(elemento == null){
			return;
		}
		nodoListarMatriz temp = new nodoListarMatriz();
		temp.setmDato(elemento);
		if(mBase == null){
			mBase = temp;
			return;
		}
		temp.setmSiguiente(mBase);
		mBase = temp;	
	}
        
        public void dPrint(){
		System.out.println("imprimir");
	}
    
}
