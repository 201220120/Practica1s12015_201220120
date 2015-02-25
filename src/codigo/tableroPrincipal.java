/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Braian
 */
public class tableroPrincipal extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form tableroPrincipal
     */
    nodo nodoUsuarios;
    nodoPlanta catalogoPlanta;
    nodoZombie catalogoZombie;
    String nJugador1;
    String nJugador2;
    int contador1;
    int contador2;
    private JPanel tablero;
    private JButton[][] botones;

    matrizEstrucutas EDDCola;
    matrizEstrucutas EDDPila;
    funcionePlanta funPlanta = new funcionePlanta();
    funcioneZombie funZombie = new funcioneZombie();
    int fila;
    int columna;
    //private MatrizOrtogonal mo;
    matrizTableroPrincipal matrizTab;
    matrizTableroPrincipal TableroBoton;
    public boolean crear = false;
    public MatrizOrtogonal.MatrizOrtogonal matriz;
    private int[][] MatrizEnteros;

    public tableroPrincipal(nodo nodoUsuarios, nodoPlanta catalogoPlanta, nodoZombie catalogoZombie, int filas, int columnas) {
        this.nodoUsuarios = nodoUsuarios;
        this.catalogoPlanta = catalogoPlanta;
        this.catalogoZombie = catalogoZombie;
        this.fila = filas;
        this.columna = columnas;

        //mo = new MatrizOrtogonal(fila, columna, this);
        nodo usuario = nodoUsuarios;
        //Jugador uno
        nJugador1 = usuario.Nombre;
        contador1 = usuario.cantidad;

        nJugador2 = usuario.sig.Nombre;
        contador2 = usuario.sig.cantidad;

        EDDPila = new matrizEstrucutas(contador2, this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initComponents();
        agregarDatos();
        agregarPlantaCola.start();
        agregarZombiePila.start();
        crearTablero();
        fondoTableroPrincipal jpanel = new fondoTableroPrincipal();
        this.add(jpanel, BorderLayout.CENTER);

        this.setTitle("Elegir tablero de juego");

        this.setResizable(false);

        //this.setResizable(false);
        // this.setSize(1200, 700);
    }
    private Image imagen = null;

    public void crearTablero() {
        pnlTablero.removeAll();
        pnlTablero.updateUI();
        pnlTablero.repaint();
        TableroBoton = new matrizTableroPrincipal(fila, columna);
        TableroBoton.setBounds(0, 0, 540, 475);
        TableroBoton.setBackground(Color.GREEN);
        TableroBoton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null));

        pnlTablero.add(TableroBoton);

        //pnlTablero.add(mo);
        //this.add(pnlTablero);
        // pnlTablero.updateUI();
    }

    int random;
    Cola contenidoCola;

    //pila zombies
    public void agregarZombiePila() {
        if (contador2 > 0) {

            nodoZombie aux = elegirNodoZombie(catalogoCantidadombie);

            pilaZombieTablero.insertaP(aux);

            //System.out.println("este es el nombre de la planta "+aux.Nombre);
            contador2--;

            int i = pilaZombieTablero.getTamaño();
            System.out.println(i);
            actualizarPanelZombie(i, pilaZombieTablero);

        }

    }

    public nodoZombie elegirNodoZombie(int catagolo) {
        random = (int) (Math.random() * catagolo + 1);

        nodoZombie aux = catalogoZombie;
        nodoZombie aux2 = new nodoZombie();

        for (int i = 1; i < random; i++) {

            aux = aux.sig;

        }

        aux2 = aux;
        System.out.println("auxiliar en este momento" + aux2.Nombre);

        return aux2;
    }

    public void actualizarPanelZombie(int aux, Pila2 pilaEntarnte) {

        pnlZombie.removeAll();
        pnlZombie.updateUI();
        pnlZombie.repaint();
        System.out.println("esto va pa ra la matiz pila " + aux);
        EDDPila = new matrizEstrucutas(aux, this);
        EDDPila.setBounds(15, 20, 150, 400);
        EDDPila.setBackground(Color.RED);
        EDDPila.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null));
        nodoZombie nod = pilaEntarnte.cabeza;

        nodoZombie nombrebase = nod;
        for (int i = 0; i < aux; i++) {
            System.out.println("este es el nombre " + nombrebase.Nombre);

            System.out.println("este es el nuevoooo nombreeeeeee " + nombrebase.Nombre);
            if (nombrebase.Nombre.equals("KRUEGER")) {
                EDDPila.getButton((i)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zo1.png")));
                //System.out.println("se agrego una imagen" + i + " " + aux);
            } else if (nombrebase.Nombre.equals("PATIÑO")) {
                EDDPila.getButton((i)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zo2.png")));
            } else if (nombrebase.Nombre.equals("SEPHIROT")) {
                EDDPila.getButton((i)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zo3.png")));
            } else if (nombrebase.Nombre.equals("SEVERUS")) {
                EDDPila.getButton((i)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zo4.png")));
            }
            nod = nod.sig;
            nombrebase = nod;
        }

        EDDPila.getButton(0).addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "evento2");

            }
        });

        lblContadorP1.setText(String.valueOf(contador2));

        pnlZombie.add(EDDPila);

        this.pack();

    }

    public nodoPlanta elegirNodoPlanta(int catagolo) {
        random = (int) (Math.random() * catagolo + 1);
        System.out.println("NUMERO RANDOM " + random);
        nodoPlanta aux = catalogoPlanta;
        nodoPlanta aux2 = new nodoPlanta();

        for (int i = 1; i < random; i++) {
            System.out.println("AUXXXX " + aux.Nombre);
            //aux2 = aux;
            aux = aux.sig;

        }

        aux2 = aux;
        System.out.println("auxiliar en este momento" + aux2.Nombre);

        return aux2;
    }
    int catalogoCantidad = funPlanta.getTamaño();
    int catalogoCantidadombie = funZombie.getTamaño();

    public void agregarPlantaCola() {
        if (contador1 > 0) {
            System.out.println("CATALOGOCANTIDAD " + catalogoCantidad);
            nodoPlanta aux = elegirNodoPlanta(catalogoCantidad);

            colaPlanta.insert(aux.Nombre, aux.ataque, aux.puntos);

            //System.out.println("este es el nombre de la planta "+aux.Nombre);
            contador1--;
            System.out.println("ESTE CONTADOR TIENE " + contador1);

//        fun.eliminardeCola(aux.Nombre);
            int i = colaPlanta.getTamaño();
            System.out.println(i);
            actualizarPanel(i, colaPlanta);

        }

    }

    public void actualizarPanel(int aux, Cola nombre) {

        System.out.println("nombre que entra " + nombre);
        System.out.println("auxiliar que va a matriz " + aux);
        pnlPlantas.removeAll();
        pnlPlantas.updateUI();
        pnlPlantas.repaint();
        EDDCola = new matrizEstrucutas(aux, this);
        EDDCola.setBounds(15, 20, 150, 400);
        EDDCola.setBackground(Color.RED);
        EDDCola.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null));

        nodoPlanta nod = nombre.getRaiz();
        nodoPlanta nombrebase = nod;
        for (int i = 0; i < aux; i++) {
            System.out.println("este es el nombre " + nombrebase.Nombre);
            if (nombrebase.Nombre.equals("LA MOLE")) {
                EDDCola.getButton(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ico2.png")));
                System.out.println("se agrego una imagen" + i + " " + aux);
            } else if (nombrebase.Nombre.equals("DESTROYER")) {
                EDDCola.getButton(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ico1.png")));
            } else if (nombrebase.Nombre.equals("DARTH VADER")) {
                EDDCola.getButton(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ico4.png")));
            } else if (nombrebase.Nombre.equals("BUMERAN")) {
                EDDCola.getButton(i).setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ico3.png")));
            }
            nod = nod.sig;
            nombrebase = nod;
        }

        EDDCola.getButton(0).addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "evento");

            }
        });

        lblContadorP.setText(String.valueOf(contador1));

        pnlPlantas.add(EDDCola);

        this.pack();

    }
    int contadorAux = 1;

    nodoColaPlanta nodoColaPlanta = new nodoColaPlanta();
    Cola colaPlanta = new Cola();
   
    Pila2 pilaZombieTablero = new Pila2();

    funcionePlanta fun = new funcionePlanta();

    public void agregarDatos() {

        lblNombreP.setText(nJugador1);

        lblContadorP.setText(String.valueOf(contador1));
        //Jugador dos

        lblNombreP1.setText(nJugador2);
        lblContadorP1.setText(String.valueOf(contador2));

    }
    private final int BotonesSize = 15;

    public void AccionBoton(java.awt.event.MouseEvent evt) {
        int size = botones.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (evt.getSource() == botones[i][j]) {
                    // Hasta aqui identificamos el boton que presionamos
                    // Ahora debemos identificar con que click se ha presionado el boton

                    // Click Izquierdo
                    if (evt.getButton() == MouseEvent.BUTTON1) {
                        if (MatrizEnteros[i][j] == 1 && botones[i][j].getBackground() != Color.orange) {
                            botones[i][j].setBackground(Color.white);
                            MatrizEnteros[i][j] = 0;
                        } else {
                            if (MatrizEnteros[i][j] == 0 && botones[i][j].getBackground() != Color.orange) {
                                botones[i][j].setBackground(Color.black);
                                MatrizEnteros[i][j] = 1;
                            } else {
                                if (botones[i][j].getBackground() == Color.red && botones[i][j].getBackground() != Color.orange) {
                                    botones[i][j].setBackground(Color.black);
                                    MatrizEnteros[i][j] = 1;
                                }
                            }
                        }
                    }
                    return;
                }
            }
        }
    }
    /*
     private void CrearTablero() {
     pnltablero.removeAll();
     pnltablero.updateUI();
     pnltablero.repaint();
     try {
     //jScrollPane1.setViewportView(null);
     tablero.setVisible(false);
     tablero = null;
     botones = null;
     } catch (Exception e) {
     }
     int size = fila;

     tablero = new JPanel();
     tablero.setLayout(null);
     tablero.setVisible(true);
     tablero.setPreferredSize(new Dimension(size * (BotonesSize), size * (BotonesSize)));
     this.add(tablero);
     //jScrollPane1.setViewportView(tablero);

     botones = new JButton[size][size];
     MatrizEnteros = new int[size][size];
     int tam = fila;
     matriz = new MatrizOrtogonal.MatrizOrtogonal(tam);
     for (int i = 0; i < tam; i++) {
     for (int j = 0; j < tam; j++) {
     if (MatrizEnteros[i][j] == 1) {
     matriz.insertar(i, j);
     }
     }
     }
     System.out.println("fila esssssssssssssssssss " + size);
     for (int i = 0; i < size; i++) {
     for (int j = 0; j < size; j++) {
     botones[i][j] = new JButton();
     botones[i][j].setVisible(true);
     botones[i][j].setBounds(BotonesSize * i, BotonesSize * j, BotonesSize, BotonesSize);
     botones[i][j].setBackground(Color.white);
     botones[i][j].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null));
     botones[i][j].setText("planta");
     tablero.add(botones[i][j]);
     botones[i][j].addMouseListener(new java.awt.event.MouseAdapter() {

     @Override
     public void mouseClicked(java.awt.event.MouseEvent evt) {
     AccionBoton(evt);
     }
     });
     }
     }

     pnltablero.add(tablero);
        
     System.out.println("este tamaño tieneeee la mtrizzzzzz " + matriz.getTamaño());
     


     this.pack();
     }
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        txtnombreP = new javax.swing.JLabel();
        lblNombreP = new javax.swing.JLabel();
        txtDisponibleP = new javax.swing.JLabel();
        lblContadorP = new javax.swing.JLabel();
        pnlPlantas = new javax.swing.JPanel();
        pnlDatos2 = new javax.swing.JPanel();
        txtnombreP1 = new javax.swing.JLabel();
        lblNombreP1 = new javax.swing.JLabel();
        txtDisponibleP1 = new javax.swing.JLabel();
        lblContadorP1 = new javax.swing.JLabel();
        pnlZombie = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        pnlTablero = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenArchivo = new javax.swing.JMenu();
        JmunIteSlr = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        rptUsuario = new javax.swing.JMenuItem();
        rptZombie = new javax.swing.JMenuItem();
        rptPlantas = new javax.swing.JMenuItem();
        rptTablero = new javax.swing.JMenuItem();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tabPrincipal.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(861, 581));
        jLabel1.setPreferredSize(new java.awt.Dimension(861, 581));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        pnlDatos.setBackground(new java.awt.Color(153, 0, 0));
        pnlDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Jugador"));
        pnlDatos.setPreferredSize(new java.awt.Dimension(200, 100));

        txtnombreP.setText("Nombre:");

        lblNombreP.setText("jLabel1");

        txtDisponibleP.setText("Plantas Disponibles:");

        lblContadorP.setText("jLabel1");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtnombreP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtDisponibleP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblContadorP)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreP)
                    .addComponent(lblNombreP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDisponibleP)
                    .addComponent(lblContadorP)))
        );

        pnlPlantas.setBackground(new java.awt.Color(0, 153, 51));
        pnlPlantas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlPlantas.setPreferredSize(new java.awt.Dimension(200, 578));

        javax.swing.GroupLayout pnlPlantasLayout = new javax.swing.GroupLayout(pnlPlantas);
        pnlPlantas.setLayout(pnlPlantasLayout);
        pnlPlantasLayout.setHorizontalGroup(
            pnlPlantasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        pnlPlantasLayout.setVerticalGroup(
            pnlPlantasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        pnlDatos2.setBackground(new java.awt.Color(153, 0, 0));
        pnlDatos2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Jugador"));
        pnlDatos2.setPreferredSize(new java.awt.Dimension(200, 100));

        txtnombreP1.setText("Nombre:");

        lblNombreP1.setText("jLabel1");

        txtDisponibleP1.setText("Plantas Disponibles:");

        lblContadorP1.setText("jLabel1");

        javax.swing.GroupLayout pnlDatos2Layout = new javax.swing.GroupLayout(pnlDatos2);
        pnlDatos2.setLayout(pnlDatos2Layout);
        pnlDatos2Layout.setHorizontalGroup(
            pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addComponent(txtnombreP1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreP1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatos2Layout.createSequentialGroup()
                        .addComponent(txtDisponibleP1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblContadorP1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlDatos2Layout.setVerticalGroup(
            pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatos2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreP1)
                    .addComponent(lblNombreP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDisponibleP1)
                    .addComponent(lblContadorP1)))
        );

        pnlZombie.setBackground(new java.awt.Color(0, 153, 51));
        pnlZombie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlZombie.setPreferredSize(new java.awt.Dimension(200, 578));

        javax.swing.GroupLayout pnlZombieLayout = new javax.swing.GroupLayout(pnlZombie);
        pnlZombie.setLayout(pnlZombieLayout);
        pnlZombieLayout.setHorizontalGroup(
            pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        pnlZombieLayout.setVerticalGroup(
            pnlZombieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pnlTablero.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jmenArchivo.setText("Archivo");

        JmunIteSlr.setText("Salir");
        JmunIteSlr.setActionCommand("");
        jmenArchivo.add(JmunIteSlr);

        jMenuBar1.add(jmenArchivo);

        jMenu1.setText("Generar Reportes");

        rptUsuario.setText("Reporte de Usuario");
        rptUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(rptUsuario);

        rptZombie.setText("Reporte Catalogo Zombie");
        rptZombie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptZombieActionPerformed(evt);
            }
        });
        jMenu1.add(rptZombie);

        rptPlantas.setText("Reporte Catalogo Plantas");
        rptPlantas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptPlantasActionPerformed(evt);
            }
        });
        jMenu1.add(rptPlantas);

        rptTablero.setText("Reporte Tablero");
        rptTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rptTableroActionPerformed(evt);
            }
        });
        jMenu1.add(rptTablero);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 93, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlPlantas, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addComponent(jButton1)
                        .addContainerGap(99, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        CrearTablero();
        crearTablero();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void rptZombieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptZombieActionPerformed
        imprimirReporteCatalogoZombie();
// TODO add your handling code here:
    }//GEN-LAST:event_rptZombieActionPerformed

    private void rptTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptTableroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rptTableroActionPerformed

    private void rptUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptUsuarioActionPerformed
        imprimirReporteUsuarios();

// TODO add your handling code here:
    }//GEN-LAST:event_rptUsuarioActionPerformed

    private void rptPlantasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rptPlantasActionPerformed
        imprimirReporteCatalogoPlanta();
        // TODO add your handling code here:
    }//GEN-LAST:event_rptPlantasActionPerformed

    /**
     * @param args the command line arguments
     */
    String patch;

    public void imprimirReporteCatalogoZombie() {
        try {

            FileWriter fichero;
            //PrintWriter pw;
            fichero = new FileWriter("D:\\nodoCatalogoZombie.txt");

            nodo usuario = nodoUsuarios;

            fichero.write("graph G {" + "\n"
                    + " node [fontsize=10,width=\".2\", height=\".2\", margin=0];"
                    + "node [shape=box];");

            fichero.write("nodeJugador[ label = \"" + usuario.sig.Nombre + "\"];\n");
            int tamaño = pilaZombieTablero.getTamaño();
            
            JOptionPane.showMessageDialog(null, "Este es el tamaño de la Pila: "+tamaño);
             nodoZombie nod = pilaZombieTablero.cabeza;

        nodoZombie nodocatalogo = nod;
    
            System.out.println("esteee es el enonododo de la pilaaasss "+nodocatalogo.Nombre);
            for (int i = 0; i < tamaño; i++) {
                fichero.write("nodeZombie" + i + "[ label = \"Zombie" + (i + 1) + "\"];\n");
                fichero.write("catalogoZombie" + i + "[ label = \"" + nodocatalogo.Nombre + "\"];\n");
                fichero.write("catalogoAtaque" + i + "[ label = \"" + nodocatalogo.ataque + "\"];\n");
                fichero.write("catalogoPuntos" + i + "[ label = \"" + nodocatalogo.puntos + "\"];\n");
                fichero.write("\"nodeZombie" + i + "\" -- \"nodeZombie" + (i + 1) + "\";\n");
                fichero.write("\"nodeZombie" + i + "\" -- \"catalogoZombie" + i + "\";\n");
                fichero.write("\"catalogoZombie" + i + "\" -- \"catalogoAtaque" + i + "\";\n");
                fichero.write("\"catalogoAtaque" + i + "\" -- \"catalogoPuntos" + i + "\";\n");
                System.out.println("esteee es el enonododo de la pilaaa "+nodocatalogo.Nombre);
                nodocatalogo = nodocatalogo.sig;
                
            }
            fichero.write("\"nodeJugador\" -- \"nodeZombie0" + "\";\n");

            fichero.write("}");

            fichero.close();

            JOptionPane.showMessageDialog(null, "Se creo el Reporte en la carpeta D:\\");
        } catch (Exception e) {
            e.printStackTrace();
        }
        crearImagenCatalogoZombie();

    }

    public void crearImagenCatalogoZombie() {
        try {

            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String fileInputPath = "D:\\nodoCatalogoZombie.txt";
            String fileOutputPath = "D:\\nodoCatalogoZombie.jpg";
            System.out.println(fileInputPath);
            System.out.println(fileOutputPath);

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();
            //  System.out.println(tParam.charAt(0) + "pepepepepepepepepepe");
            rt.exec(cmd);
            File file = new File("D:\\nodoCatalogoZombie.jpg");
            Desktop.getDesktop().open(file);

        } catch (Exception ex) {
            System.out.println("erorororororor");
            ex.printStackTrace();

        } finally {
            JOptionPane.showMessageDialog(this, "Imagen generada con éxito en D:\\nodoCatalogoZombie.jpg");
        }
        /* File file = new File("nodoCatalogoPlanta.jpg");
         try {
         Desktop.getDesktop().open(file);
         } catch (IOException ex) {
         ex.printStackTrace();
         }*/
    }

    public void imprimirReporteCatalogoPlanta() {
        try {

            FileWriter fichero;
            //PrintWriter pw;
            fichero = new FileWriter("D:\\nodoCatalogoPlanta.txt");

            //pw = new PrintWriter(fichero);
            funciones nodoUsuario = new funciones();
            nodo usuario = nodoUsuarios;

            fichero.write("graph G {" + "\n"
                    + " node [fontsize=10,width=\".2\", height=\".2\", margin=0];"
                    + "node [shape=box];");

            fichero.write("nodeJugador[ label = \"" + usuario.Nombre + "\"];\n");
            int tamaño = colaPlanta.getTamaño();

            JOptionPane.showMessageDialog(null, "Este es el tamaño de la Cola: "+tamaño);
            nodoPlanta nodocatalogo = colaPlanta.getRaiz();
            for (int i = 0; i < tamaño; i++) {
                fichero.write("nodePlanta" + i + "[ label = \"Planta" + (i + 1) + "\"];\n");
                fichero.write("catalogoPlanta" + i + "[ label = \"" + nodocatalogo.Nombre + "\"];\n");
                fichero.write("catalogoAtaque" + i + "[ label = \"" + nodocatalogo.ataque + "\"];\n");
                fichero.write("catalogoPuntos" + i + "[ label = \"" + nodocatalogo.puntos + "\"];\n");
                fichero.write("\"nodePlanta" + i + "\" -- \"nodePlanta" + (i + 1) + "\";\n");
                fichero.write("\"nodePlanta" + i + "\" -- \"catalogoPlanta" + i + "\";\n");
                fichero.write("\"catalogoPlanta" + i + "\" -- \"catalogoAtaque" + i + "\";\n");
                fichero.write("\"catalogoAtaque" + i + "\" -- \"catalogoPuntos" + i + "\";\n");
                nodocatalogo = nodocatalogo.sig;
            }
            fichero.write("\"nodeJugador\" -- \"nodePlanta0" + "\";\n");

            fichero.write("}");

            fichero.close();

            JOptionPane.showMessageDialog(null, "Se creo el Reporte en la carpeta D:\\");
        } catch (Exception e) {
            e.printStackTrace();
        }
        crearImagenCatalogoPlanta();

    }

    public void crearImagenCatalogoPlanta() {
        try {

            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String fileInputPath = "D:\\nodoCatalogoPlanta.txt";
            String fileOutputPath = "D:\\nodoCatalogoPlanta.jpg";
            System.out.println(fileInputPath);
            System.out.println(fileOutputPath);

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();
            //  System.out.println(tParam.charAt(0) + "pepepepepepepepepepe");
            rt.exec(cmd);
            File file = new File("D:\\nodoCatalogoPlanta.jpg");
            Desktop.getDesktop().open(file);

        } catch (Exception ex) {
            System.out.println("erorororororor");
            ex.printStackTrace();

        } finally {
            JOptionPane.showMessageDialog(this, "Imagen generada con éxito en D:\\nodoCatalogoPlanta.jpg");
        }
        /* File file = new File("nodoCatalogoPlanta.jpg");
         try {
         Desktop.getDesktop().open(file);
         } catch (IOException ex) {
         ex.printStackTrace();
         }*/
    }

    public void imprimirReporteUsuarios() {
        try {

            FileWriter fichero;

            fichero = new FileWriter("D:\\nodoUsuario.txt");

            funciones nodoUsuario = new funciones();
            nodo usuario = nodoUsuarios;

            fichero.write("graph G {" + "\n"
                    + " node [fontsize=10,width=\".2\", height=\".2\", margin=0];"
                    + "node [shape=box];");
            //pw.println("node0[ label = " + '"' + "#" + '"' + "];" + "\n");
          /*  for (int i = 0; i < (nodoUsuario.getTamaño()-1); i++) {
             //System.out.println(ListaNodos.get(i) + " nodo actual...............");
             pw.println("node" + i + "[ label = " + '"' + usuario.Nombre + '"' + "];" + "\n");
             usuario = usuario.sig;

             }*/

            int tamaño = nodoUsuario.getTamaño();
            System.out.println("este es el tamaño actual del nodo ususario" + tamaño);
            //agregamos los nodos raiz

            fichero.write("nodeJugador[ label = \"Jugador\"];\n");
            fichero.write("nodePlanta[ label = \"Planta\"];\n");
            fichero.write("nodeZombie[ label = \"Zombie\"];\n");
            //segundo usuario
            fichero.write("nodePNombre[ label = \"" + usuario.Nombre + "\"];\n");

            fichero.write("nodePCantidad[ label = \"" + usuario.cantidad + "\"];\n");
            //enlzar nodos
            fichero.write("\"nodeJugador\" -- \"nodePlanta\";\n");
            fichero.write("\"nodeJugador\" -- \"nodeZombie\";\n");

            fichero.write("\"nodePlanta\" -- \"nodePNombre\";\n");
            fichero.write("\"nodePNombre\" -- \"nodePCantidad\";\n");
            if (usuario.Extra != 0) {
                fichero.write("nodePExtra[ label = \"" + usuario.Extra + "\"];\n");
                fichero.write("\"nodePCantidad\" -- \"nodePExtra\";\n");
            }
            usuario = usuario.sig;

            //primer usuario
            fichero.write("nodeZNombre[ label = \"" + usuario.Nombre + "\"];\n");

            fichero.write("nodeZCantidad[ label = \"" + usuario.cantidad + "\"];\n");

            fichero.write("\"nodeZombie\" -- \"nodeZNombre\";\n");
            fichero.write("\"nodeZNombre\" -- \"nodeZCantidad\";\n");

            if (usuario.Extra != 0) {
                fichero.write("nodeZExtra[ label = \"" + usuario.Extra + "\"];\n");
                fichero.write("\"nodeZCantidad\" -- \"nodeZExtra\";\n");
            }
            fichero.write("}");

            fichero.close();

            JOptionPane.showMessageDialog(null, "Se creo el Reporte en la carpeta principal");

        } catch (Exception e) {
            e.printStackTrace();
        }

        crearImagen();

    }

    public void crearImagen() {
        try {

            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

            String fileInputPath = "D:\\nodoUsuario.txt";
            String fileOutputPath = "D:\\nodoUsuario.jpg";
            System.out.println(fileInputPath);
            System.out.println(fileOutputPath);

            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();
            //  System.out.println(tParam.charAt(0) + "pepepepepepepepepepe");
            rt.exec(cmd);

            File file = new File("D:\\nodoUsuario.jpg");
            Desktop.getDesktop().open(file);
        } catch (Exception ex) {
            System.out.println("erorororororor");
            ex.printStackTrace();

        } finally {
            JOptionPane.showMessageDialog(this, "Imagen generada con éxito en D:\\nodoUsuario.jpg");

        }

    }

    Thread agregarPlantaCola = new Thread() {
        //declaramos el hilo
        @Override
        public void run() {
            try {
                while (true) {
                    agregarPlantaCola();
                    agregarPlantaCola.sleep(5000);

                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    };

    Thread agregarZombiePila = new Thread() {
        //declaramos el hilo
        @Override
        public void run() {
            try {
                while (true) {
                    agregarZombiePila();
                    agregarZombiePila.sleep(5000);

                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    };

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tableroPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tableroPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tableroPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tableroPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tableroPrincipal(null, null, null, 5, 5).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmunIteSlr;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmenArchivo;
    private javax.swing.JLabel lblContadorP;
    private javax.swing.JLabel lblContadorP1;
    private javax.swing.JLabel lblNombreP;
    private javax.swing.JLabel lblNombreP1;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDatos2;
    private javax.swing.JPanel pnlPlantas;
    private javax.swing.JPanel pnlTablero;
    private javax.swing.JPanel pnlZombie;
    private javax.swing.JMenuItem rptPlantas;
    private javax.swing.JMenuItem rptTablero;
    private javax.swing.JMenuItem rptUsuario;
    private javax.swing.JMenuItem rptZombie;
    private javax.swing.JLabel txtDisponibleP;
    private javax.swing.JLabel txtDisponibleP1;
    private javax.swing.JLabel txtnombreP;
    private javax.swing.JLabel txtnombreP1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
