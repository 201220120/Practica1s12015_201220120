/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import static codigo.creacionPlantas.auxiliar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
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
    matrizEstrucutas EDDCola;
    matrizEstrucutas EDDPila;
    funcionePlanta funPlanta = new funcionePlanta();

    public tableroPrincipal(nodo nodoUsuarios, nodoPlanta catalogoPlanta, nodoZombie catalogoZombie) {
        this.nodoUsuarios = nodoUsuarios;
        this.catalogoPlanta = catalogoPlanta;
        this.catalogoZombie = catalogoZombie;
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

        //this.setResizable(false);
        // this.setSize(1200, 700);
    }
    int random;
    Cola contenidoCola;

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
        System.out.println("el auiliar tiene esto dd" + aux);
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
            int aux = auxiliar;

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
    funcionePlanta fun = new funcionePlanta();

    public void agregarDatos() {

        lblNombreP.setText(nJugador1);

        lblContadorP.setText(String.valueOf(contador1));
        //Jugador dos

        lblNombreP1.setText(nJugador2);
        lblContadorP1.setText(String.valueOf(contador2));

        EDDPila.setBounds(15, 20, 150, 400);
        EDDPila.setBackground(Color.RED);
        EDDPila.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null));
        pnlZombie.add(EDDPila);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatos = new javax.swing.JPanel();
        txtnombreP = new javax.swing.JLabel();
        lblNombreP = new javax.swing.JLabel();
        txtDisponibleP = new javax.swing.JLabel();
        lblContadorP = new javax.swing.JLabel();
        pnlPlantas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlDatos2 = new javax.swing.JPanel();
        txtnombreP1 = new javax.swing.JLabel();
        lblNombreP1 = new javax.swing.JLabel();
        txtDisponibleP1 = new javax.swing.JLabel();
        lblContadorP1 = new javax.swing.JLabel();
        pnlZombie = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenArchivo = new javax.swing.JMenu();
        JmunIteSlr = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tabPrincipal.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(861, 581));
        jLabel1.setPreferredSize(new java.awt.Dimension(861, 581));

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

        jmenArchivo.setText("Archivo");

        JmunIteSlr.setText("Salir");
        JmunIteSlr.setActionCommand("");
        jmenArchivo.add(JmunIteSlr);

        jMenuBar1.add(jmenArchivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(53, 53, 53)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlZombie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlPlantas, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(12, 12, 12)))
                        .addContainerGap(93, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarPlantaCola();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
                new tableroPrincipal(null, null, null).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmunIteSlr;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmenArchivo;
    private javax.swing.JLabel lblContadorP;
    private javax.swing.JLabel lblContadorP1;
    private javax.swing.JLabel lblNombreP;
    private javax.swing.JLabel lblNombreP1;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDatos2;
    private javax.swing.JPanel pnlPlantas;
    private javax.swing.JPanel pnlZombie;
    private javax.swing.JLabel txtDisponibleP;
    private javax.swing.JLabel txtDisponibleP1;
    private javax.swing.JLabel txtnombreP;
    private javax.swing.JLabel txtnombreP1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
