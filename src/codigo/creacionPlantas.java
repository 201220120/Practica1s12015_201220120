/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Braian
 */
public class creacionPlantas extends javax.swing.JPanel implements ActionListener {

    private JFrame jFramePadre;
    JButton continuarabtn;
    JButton agregarPlanta;
    JLabel nombre;
    JPanel fondoNombre;
    JLabel error;
    JLabel[][] matrizText;
    matrizBotones TableroBoton;
    JMenuBar menuHerramienta = new JMenuBar();
    JMenu menuArchivo = new JMenu();
    JMenuItem itemSalir = new JMenuItem();
    String nombreJ;
    int plantas;
    nodo raiz;
    nodoPlanta catalogo;
    framePlantas obj;

    public creacionPlantas(String nick, int plantas, nodo nodoUsuarios, nodoPlanta catalogo, framePlantas aux) {
        obj = aux;
        this.raiz = nodoUsuarios;
        this.catalogo = catalogo;
        TableroBoton = new matrizBotones(plantas);
        this.nombreJ = nick;
        this.plantas = plantas;
        continuarabtn = new JButton();
        nombre = new JLabel();
        fondoNombre = new JPanel();
        agregarPlanta = new JButton();

        initComponents();
        pintarCatalogo();
    }

    private void initComponents() {
        TableroBoton.setBounds(78, 72, 584, 498);
        TableroBoton.setBackground(null);
        TableroBoton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null));

        menuArchivo.setText("Archivo");
        itemSalir.setText("Reiniciar Tablero");
        itemSalir.addActionListener(this);
        menuArchivo.add(itemSalir);
        menuHerramienta.add(menuArchivo);
        menuHerramienta.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null));

        menuHerramienta.setBounds(0, 0, 900, 25);
        nombre.setText(nombreJ);

        nombre.setBounds(544, 45, 198, 25);

        agregarPlanta.setText("                          ");
        agregarPlanta.setBounds(670, 500, 130, 28);
        agregarPlanta.addActionListener(this);
        agregarPlanta.setOpaque(false);
        agregarPlanta.setContentAreaFilled(false);
        agregarPlanta.setBorderPainted(false);

        continuarabtn.setText("                             ");
        continuarabtn.setOpaque(false);
        continuarabtn.setContentAreaFilled(false);
        continuarabtn.setBorderPainted(false);
        continuarabtn.setBounds(662, 532, 137, 33);
    }
    int totalPlanta = 0;
    funcionePlanta fun = new funcionePlanta();

    public void pintarCatalogo() {
        totalPlanta = fun.getTamaño();
        System.out.println("ESTIMADO DE CONTADOR " + totalPlanta);
        nodoPlanta aux = catalogo;
        for (int i = 0; i < totalPlanta; i++) {

            TableroBoton.getButton(i, 1).setText(aux.Nombre);
            TableroBoton.getButton(i, 2).setText(String.valueOf(aux.puntos));
            TableroBoton.getButton(i, 3).setText(String.valueOf(aux.ataque));
            JButton botonModif = new JButton();
            botonModif.setText("Modificar");
            TableroBoton.getButton(i, 4).add(botonModif);
            if (TableroBoton.getButton(i, 1).getText().equals("DESTROYER")) {
                TableroBoton.getButton(i, 0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ico1.png")));

            } else if (TableroBoton.getButton(i, 1).getText().equals("BUMERAN")) {
                TableroBoton.getButton(i, 0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ico3.png")));

            } else if (TableroBoton.getButton(i, 1).getText().equals("LA MOLE")) {
                TableroBoton.getButton(i, 0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ico2.png")));

            } else if (TableroBoton.getButton(i, 1).getText().equals("DARTH VADER")) {
                TableroBoton.getButton(i, 0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ico4.png")));

            }

            aux = aux.sig;
        }

    }

    public JFrame getjFramePadre() {
        return jFramePadre;
    }

    public void setjFramePadre(JFrame jFramePadre) {

        this.jFramePadre = jFramePadre;
        this.jFramePadre.add(TableroBoton);
        this.jFramePadre.add(menuHerramienta);
        this.jFramePadre.add(continuarabtn);
        this.jFramePadre.add(nombre);
        this.jFramePadre.add(agregarPlanta);
        this.jFramePadre.add(agregarPlanta);

        //this.jFramePadre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.jFramePadre.setLocationRelativeTo(null);
//        this.jFramePadre.add(labels[3][3]);
    }

    @Override
    public void paint(Graphics g) {
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/creacionjugador2.png"));
        g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }

    public boolean keyTyped(KeyEvent ke) {
        char c = ke.getKeyChar();

        if (Character.isLetter(c)) {
            getToolkit().beep();

            ke.consume();

            return false;

        }
        return false;

    }

    boolean verificador = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregarPlanta) {
            catalogoPlantas menu = new catalogoPlantas(nombreJ, plantas);
            framePlantas frame = new framePlantas(nombreJ, plantas, raiz, catalogo);
            menu.setVisible(true);
            obj.setVisible(false);
            frame.ocultarVentana();

        }

    }

}
