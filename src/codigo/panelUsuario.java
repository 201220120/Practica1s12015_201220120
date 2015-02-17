/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Braian
 */
public class panelUsuario extends javax.swing.JPanel implements ActionListener {

    private JFrame jFramePadre;
    JButton plantasbtn;
    JButton zombiesbtn;
    JButton iniciarbtn;
    JButton resetbtn;

    public panelUsuario() {

        initComponents();
    }

    private void initComponents() {
        plantasbtn = new JButton();
        plantasbtn.addActionListener(this);
        plantasbtn.setText("Jugador Plantas");
        plantasbtn.setBounds(50, 280, 200, 25);

        zombiesbtn = new JButton();
        zombiesbtn.addActionListener(this);
        zombiesbtn.setText("Jugador Zombies");
        zombiesbtn.setBounds(50, 320, 200, 25);

        iniciarbtn = new JButton();
        iniciarbtn.addActionListener(this);
        iniciarbtn.setText("Siguiente");
        iniciarbtn.setBounds(50, 360, 200, 25);

        resetbtn = new JButton();
        resetbtn.addActionListener(this);
        resetbtn.setText("Eliminar Datos");
        resetbtn.setBounds(50, 400, 200, 25);

    }

    public JFrame getjFramePadre() {
        return jFramePadre;
    }

    public void setjFramePadre(JFrame jFramePadre) {

        this.jFramePadre = jFramePadre;
        //this.jFramePadre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.jFramePadre.setLocationRelativeTo(null);

        this.jFramePadre.add(plantasbtn);
        this.jFramePadre.add(zombiesbtn);
        this.jFramePadre.add(iniciarbtn);
        this.jFramePadre.add(resetbtn);
    }

    @Override
    public void paint(Graphics g) {
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/usuarios.png"));
        g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
