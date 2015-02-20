/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.*;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Braian
 */
public class creacionZombies extends javax.swing.JPanel implements ActionListener {

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
    nodoZombie catalogo;
    frameZombies obj;

    public creacionZombies(String nick, int plantas, nodo nodoUsuarios, nodoZombie catalogo, frameZombies aux) {
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
    funcioneZombie fun = new funcioneZombie();

    boolean p1, p2, p3, p4;
    static int auxiliar;
    static String nomAux = null;

    public void pintarCatalogo() {
        totalPlanta = fun.getTamaño();
        // System.out.println("ESTIMADO DE CONTADOR " + totalPlanta);
        nodoZombie aux = catalogo;
        for (int i = 0; i < totalPlanta; i++) {

            TableroBoton.getButton(i, 1).setText(aux.Nombre);
            TableroBoton.getButton(i, 2).setText(String.valueOf(aux.puntos));
            TableroBoton.getButton(i, 3).setText(String.valueOf(aux.ataque));

            if (TableroBoton.getButton(i, 1).getText().equals("PATIÑO")) {
                TableroBoton.getButton(i, 0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zo2.png")));
                p2 = true;
            } else if (TableroBoton.getButton(i, 1).getText().equals("SEPHIROT")) {
                TableroBoton.getButton(i, 0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zo3.png")));
                p3 = true;
            } else if (TableroBoton.getButton(i, 1).getText().equals("KRUEGER")) {
                TableroBoton.getButton(i, 0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zo1.png")));
                p1 = true;
            } else if (TableroBoton.getButton(i, 1).getText().equals("SEVERUS")) {
                TableroBoton.getButton(i, 0).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zo4.png")));
                p4 = true;
            }

            Font font = TableroBoton.getButton(i, 4).getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            TableroBoton.getButton(i, 4).setFont(font.deriveFont(attributes));
            auxiliar = i;
            TableroBoton.getButton(i, 4).setText("Modificar");

            TableroBoton.getButton(i, 4).addMouseListener(new MouseAdapter() {
                int aux = auxiliar;

                public void mouseClicked(MouseEvent e) {
                    String nom = TableroBoton.getButton(aux, 1).getText();

                    catalogoZombies menu = new catalogoZombies(nombreJ, plantas, p1, p2, p3, p4, nom);
                    menu.setVisible(true);

                    obj.setVisible(false);

                }
            });
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            TableroBoton.getButton(i, 5).setFont(font.deriveFont(attributes));

            TableroBoton.getButton(i, 5).setText("Eliminar");

            TableroBoton.getButton(i, 5).addMouseListener(new MouseAdapter() {
                int aux = auxiliar;

                public void mouseClicked(MouseEvent e) {
                    System.out.println(TableroBoton.getButton(aux, 1).getText());
                    String nom = TableroBoton.getButton(aux, 1).getText();
                    System.out.println(nom);
                    
                    fun.eliminar(nom,nombreJ,plantas,raiz);
                    obj.dispose();
                    
                    

                }
            });
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
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/tab2.png"));
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
            catalogoZombies menu = new catalogoZombies(nombreJ, plantas, p1, p2, p3, p4, null);
            frameZombies frame = new frameZombies(nombreJ, plantas, raiz, catalogo);
            menu.setVisible(true);
            obj.setVisible(false);

        }

    }

}
