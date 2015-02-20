/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Braian
 */
public class framePlantas extends JFrame implements ActionListener {

    JPanel Contab1 = new JPanel();
    JButton prueba = new JButton();
    JPanel panel = new JPanel();
    String nick;
    int plantas;
    nodo raiz;
    nodoPlanta catalogo;

    public framePlantas(String nombre, int plantas, nodo nodoUsuarios, nodoPlanta catalogo) {
        if (this.isEnabled()) {
            this.dispose();

        }
        this.raiz = nodoUsuarios;
        this.nick = nombre;
        this.catalogo = catalogo;
        this.plantas = plantas;
//ImagePanel panel = new ImagePanel(new ImageIcon("/imagenes/creacionjugador.png").getImage());
        setSize(800, 600);
        setTitle("Catalogo de Plantas");
        setResizable(false);
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }

    public void initComponents() {

        formWindowOpened(null);
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {

        creacionPlantas p = new creacionPlantas(nick, plantas, raiz,catalogo,this);
        p.setjFramePadre(this);

        this.add(p, BorderLayout.CENTER);
        p.repaint();
    }

    public void ocultarVentana() {
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        framePlantas frame = new framePlantas("BRAIAN", 10, null, null);
        frame.setVisible(true);
    }

}
