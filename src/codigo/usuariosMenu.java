/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Braian
 */
public class usuariosMenu extends JFrame implements ActionListener{
   
    public usuariosMenu(){
        
setSize(700,400);
setTitle("Menu Usuario");
formWindowOpened(null);
initComponents();

} 
    public void initComponents()
    {
  
    
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        panelUsuario p = new panelUsuario(this);
        p.setjFramePadre(this);
        this.add( p , BorderLayout.CENTER);
        p.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
