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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

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
    JButton aceptarbtn;
    JButton borrarbtn;
    JPanel campo;
    JLabel nombretxt;
    JLabel cantidadtxt;
    JLabel campoextratxt;
    JTextField nombre;
    JTextField cantidad;
    JTextField campoextra;
    JLabel error;
    usuariosMenu obj;

    public panelUsuario(usuariosMenu aux) {
        obj = aux;
        initComponents();
    }

    private void initComponents() {
        plantasbtn = new JButton();
        plantasbtn.addActionListener(this);
        plantasbtn.setText("Jugador Plantas");
        plantasbtn.setBounds(50, 185, 200, 25);

        zombiesbtn = new JButton();
        zombiesbtn.addActionListener(this);
        zombiesbtn.setText("Jugador Zombies");
        zombiesbtn.setBounds(50, 235, 200, 25);
        zombiesbtn.setEnabled(false);

        iniciarbtn = new JButton();
        iniciarbtn.addActionListener(this);
        iniciarbtn.setText("Siguiente");
        iniciarbtn.setBounds(50, 260, 200, 25);
        iniciarbtn.setEnabled(false);

        resetbtn = new JButton();
        resetbtn.addActionListener(this);
        resetbtn.setText("Eliminar Datos");
        resetbtn.setBounds(50, 285, 200, 25);
        resetbtn.setEnabled(false);
        campo = new JPanel();

        campo.setBounds(340, 170, 305, 160);
        campo.setBackground(new Color(0, 0, 0, 65));
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Datos Personales");

        //Línea 2
        campo.setBorder(bordejpanel);

        nombretxt = new JLabel();
        nombretxt.setBounds(350, 200, 50, 10);
        nombretxt.setForeground(Color.WHITE);
        nombretxt.setText("NOMBRE:   ");
        campo.add(nombretxt);

        nombre = new JTextField(15);
        nombre.setBounds(400, 200, 100, 10);
        nombre.setText("");
        campo.add(nombre);

        cantidadtxt = new JLabel();
        cantidadtxt.setBounds(350, 220, 50, 10);
        cantidadtxt.setForeground(Color.WHITE);
        cantidadtxt.setText("CANTIDAD: ");
        campo.add(cantidadtxt);

        cantidad = new JTextField(15);
        cantidad.setBounds(400, 200, 100, 10);
        cantidad.setText("");
        campo.add(cantidad);

        campoextratxt = new JLabel();
        campoextratxt.setBounds(350, 240, 50, 10);
        campoextratxt.setForeground(Color.WHITE);
        campoextratxt.setText("CAMPOS EXTRAS (opcional): ");
        campo.add(campoextratxt);

        campoextra = new JTextField(6);
        campoextra.setBounds(400, 240, 100, 10);
        campo.add(campoextra);

        aceptarbtn = new JButton();
        aceptarbtn.addActionListener(this);
        aceptarbtn.setText("Guardar ");
        aceptarbtn.setBounds(450, 240, 10, 10);
        campo.add(aceptarbtn);

        borrarbtn = new JButton();
        borrarbtn.addActionListener(this);
        borrarbtn.setText(" Borrar ");
        borrarbtn.setBounds(470, 240, 10, 10);
        campo.add(borrarbtn);

        error = new JLabel();
        error.setBackground(Color.black);
        error.setForeground(Color.red);
        error.setBounds(400, 332, 200, 10);
        error.setVisible(false);

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
        //this.jFramePadre.add(iniciarbtn);
        this.jFramePadre.add(resetbtn);
        this.jFramePadre.add(campo);
        this.jFramePadre.add(error);
    }

    @Override
    public void paint(Graphics g) {
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/usuarios.png"));
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
    funciones fun = new funciones();

    private static boolean isNumber(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptarbtn) {
            error.setText("");
            if (verificador == false) {
                if (!(cantidad.getText().equals("")) && !(nombre.getText().equals(""))) {

                    String nick = nombre.getText();
                    String ataque = cantidad.getText();
                    if (isNumber(ataque)) {

                        nodo aux = new nodo();
                        aux.Nombre = nick;
                        aux.cantidad = Integer.parseInt(ataque);
                        aux.Tipo = "Planta";
                        if (!(campoextra.getText().equals(""))) {

                            String extras = campoextra.getText();
                            if (isNumber(extras)) {
                                aux.Extra = Integer.parseInt(extras);
                                fun.agregarLista(aux);
                                fun.imprimir();
                                verificador = true;
                                reiniciarDatos();
                                zombiesbtn.setEnabled(true);
                                plantasbtn.setEnabled(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Caracter invalido. Ingrese un campo extra númerico");
                                campoextra.setText("");
                                extras = campoextra.getText();

                            }
                        } else {
                            fun.agregarLista(aux);
                            fun.imprimir();
                            verificador = true;
                            reiniciarDatos();
                            zombiesbtn.setEnabled(true);
                            plantasbtn.setEnabled(false);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Caracter invalido. Ingrese una cantidad númerica");
                        cantidad.setText("");
                        ataque = cantidad.getText();
                    }

                    //estructura de los datos creados
                } else {
                    error.setVisible(true);
                    error.setText("Error en llenar los campos");
                }
            } else {

                if (!(cantidad.getText().equals("")) && !(nombre.getText().equals(""))) {
                    String nick = nombre.getText();

                    String ataque = cantidad.getText();
                    if (isNumber(ataque)) {
                        nodo aux = new nodo();
                        aux.Nombre = nick;
                        aux.cantidad = Integer.parseInt(ataque);
                        aux.Tipo = "Zombie";
                        if (!(campoextra.getText().equals(""))) {
                            String extras = campoextra.getText();
                            if (isNumber(extras)) {
                                aux.Extra = Integer.parseInt(extras);
                                fun.agregarLista(aux);
                                fun.imprimir();

                                reiniciarDatos();
                                campo.setVisible(false);
                                zombiesbtn.setEnabled(false);
                                iniciarbtn.setEnabled(true);

                                //iniciar juego
                                nodo nodoUsuarios = fun.getRaiz();
                                nodo aux2 = fun.buscar("Planta");
                                String nick2 = aux2.Nombre;
                                int cantidad = aux2.cantidad;
                                framePlantas frame = new framePlantas(nick2, cantidad, nodoUsuarios, null);
                                obj.setVisible(false);
                                frame.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Caracter invalido. Ingrese una cantidad númerica");
                                campoextra.setText("");
                                extras = campoextra.getText();

                            }
                        } else {
                            fun.agregarLista(aux);
                            fun.imprimir();

                            reiniciarDatos();
                            campo.setVisible(false);
                            zombiesbtn.setEnabled(false);
                            iniciarbtn.setEnabled(true);

                            //iniciar juego
                            nodo nodoUsuarios = fun.getRaiz();
                            nodo aux2 = fun.buscar("Planta");
                            String nick2 = aux2.Nombre;
                            int cantidad = aux2.cantidad;
                            framePlantas frame = new framePlantas(nick2, cantidad, nodoUsuarios, null);
                            obj.setVisible(false);
                            frame.setVisible(true);

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Caracter invalido. Ingrese una cantidad númerica");
                        cantidad.setText("");
                        ataque = cantidad.getText();
                    }

                    //estructura de los datos creados
                } else {
                    error.setVisible(true);
                    error.setText("Error en llenar los campos");
                }
            }
        }

        if (e.getSource()
                == borrarbtn) {
            reiniciarDatos();
        }

        if (e.getSource()
                == resetbtn) {
            reiniciarDatos();
            zombiesbtn.setEnabled(false);
            plantasbtn.setEnabled(true);
//            jplanta.eliminarNodo(0);
            verificador = false;

            //for (int i = 0; i < jplanta.getTamaño(); i++) {
            //}
        }

    }

    public void reiniciarDatos() {

        nombre.setText("");
        cantidad.setText("");
        campoextra.setText("");
    }

}
