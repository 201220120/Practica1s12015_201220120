/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphViz;

import javax.swing.JLabel;

/**
 *
 * @author Walter Mendoza
 */
public class Cuadrante extends JLabel implements Runnable {

    private int x,y;
    private String dato;
    
    public Cuadrante(int x,int y,String dato)
    {
        this.dato=dato;
        this.setText(dato);
        
        this.setBounds(x*120 + 120, y*120+20,x*50+60, y*120+100);
        //this.setBounds(null);
        this.x=x;
        this.y=y;
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getXM(){return x;}
    public int getYm(){return y;}
    
    public String getDato(){return dato;}
    
    @Override
    public String toString()
    {
        return dato;
    }
    
}
