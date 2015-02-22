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
public class catalogoZombies extends javax.swing.JFrame {

    funcioneZombie fun = new funcioneZombie();
    funcionePlanta funPlant = new funcionePlanta();
    funciones fun2 = new funciones();

    /**
     * Creates new form catalogoPlantas
     */
    String nombre;
    int cantidad;
    boolean p1, p2, p3, p4;
    String nomAux = null;

    public catalogoZombies(String nombre, int cantidad, boolean p1, boolean p2, boolean p3, boolean p4, String nomAux) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.nomAux = nomAux;
        this.nombre = nombre;
        this.cantidad = cantidad;
        initComponents();
        desactivarPlanta();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void desactivarPlanta() {
        error.setVisible(false);
        if (p1 != false) {
            btn1.setEnabled(false);

        }
        if (p2 != false) {
            btn2.setEnabled(false);

        }
        if (p3 != false) {
            btn3.setEnabled(false);

        }
        if (p4 != false) {
            btn4.setEnabled(false);

        }
        if ((p1 & p2 & p3 & p4) == true) {
            error.setVisible(true);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zombi1.png"))); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zombi2.png"))); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zombi3.png"))); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zombi4.png"))); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btnsalir.setText("Regresar");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        error.setForeground(new java.awt.Color(255, 0, 0));
        error.setText("Todos los Zombies fueron agregados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn2)
                    .addComponent(btn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn4)
                    .addComponent(btn3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (nomAux != null) {

            fun.modificar(nomAux, "KRUEGER", "Aire", 20);

        } else {

            nodoZombie aux = new nodoZombie();
            aux.Nombre = "KRUEGER";
            aux.ataque = "Aire";
            aux.puntos = 20;

            fun.agregarLista(aux);
        }
        nodoZombie nodoCatalogo = fun.getRaiz();
        nodo nodoUsuarios = fun2.getRaiz();
        
         nodoPlanta nodoPlant = funPlant.getRaiz();


        frameZombies frame = new frameZombies(nombre, cantidad, nodoUsuarios, nodoCatalogo,nodoPlant);

        frame.setVisible(true);
        this.setVisible(false);

// TODO add your handling code here:
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed

        //estructura de los datos creados
        if (nomAux != null) {

            fun.modificar(nomAux, "PATIÑO", "Golpe", 20);

        } else {
            nodoZombie aux = new nodoZombie();
            aux.Nombre = "PATIÑO";
            aux.ataque = "Golpe";
            aux.puntos = 20;

            fun.agregarLista(aux);
        }
        nodoZombie nodoCatalogo = fun.getRaiz();
        nodo nodoUsuarios = fun2.getRaiz();
 nodoPlanta nodoPlant = funPlant.getRaiz();

        frameZombies frame = new frameZombies(nombre, cantidad, nodoUsuarios, nodoCatalogo,nodoPlant);

        frame.setVisible(true);
        this.setVisible(false);

// TODO add your handling code here:
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed

        if (nomAux != null) {

            fun.modificar(nomAux, "SEPHIROT", "Disparo", 20);

        } else {
            nodoZombie aux = new nodoZombie();
            aux.Nombre = "SEPHIROT";
            aux.ataque = "Disparo";
            aux.puntos = 5;

            fun.agregarLista(aux);
        }
        nodoZombie nodoCatalogo = fun.getRaiz();
        nodo nodoUsuarios = fun2.getRaiz();
 nodoPlanta nodoPlant = funPlant.getRaiz();
        frameZombies frame = new frameZombies(nombre, cantidad, nodoUsuarios, nodoCatalogo,nodoPlant);

        frame.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (nomAux != null) {

            fun.modificar(nomAux, "SEVERUS", "Magic", 20);

        } else {

            nodoZombie aux = new nodoZombie();
            aux.Nombre = "SEVERUS";
            aux.ataque = "Magic";
            aux.puntos = 20;

            fun.agregarLista(aux);

        }

        nodoZombie nodoCatalogo = fun.getRaiz();
        nodo nodoUsuarios = fun2.getRaiz();
         nodoPlanta nodoPlant = funPlant.getRaiz();
        frameZombies frame = new frameZombies(nombre, cantidad, nodoUsuarios, nodoCatalogo,nodoPlant);

        frame.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btn4ActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed

        nodoZombie nodoCatalogo = fun.getRaiz();
        nodo nodoUsuarios = fun2.getRaiz();
        nodoPlanta nodoPlant = funPlant.getRaiz();
        frameZombies frame = new frameZombies(nombre, cantidad, nodoUsuarios, nodoCatalogo,nodoPlant);

        frame.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsalirActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(catalogoZombies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(catalogoZombies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(catalogoZombies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(catalogoZombies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new catalogoZombies("", 0, false, false, false, false, "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel error;
    // End of variables declaration//GEN-END:variables
}
