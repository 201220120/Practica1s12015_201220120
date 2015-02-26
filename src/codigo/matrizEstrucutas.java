    /*UNIVERSIDAD DE SAN CARLOS DE GUATEMALA
 * FACULTAD DE INGENIERIA
 * CIENCIAS Y SISTEMAS
 * INTRODUCCION A LA PROGRAMACIÒN Y COMPUTACIÒN I
 * SECCION "C"
 * BRAIAN STAIMER FLORIAN MONTENEGRO
 * CARNE: 2012-20120
 */
package codigo;

/**
 *
 * @author Dark
 */
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Dark
 */
public class matrizEstrucutas extends JPanel {

    JLabel MatrizBotones[];
    JLabel comprobarDatos[];
    int Matriz2[];

    String fila1;
    String columna1;
    int fila;
    int columna;
    tableroPrincipal obj;

    public matrizEstrucutas(int filas, tableroPrincipal obj) {
        this.obj = obj;
        this.fila = filas;
        System.out.println("filas tiene " + fila);
        columna = 1;
        MatrizBotones = new JLabel[fila];
        Matriz2 = new int[fila];
        comprobarDatos = new JLabel[fila];

        for (int f = 0; f < fila; f++) {
            {
                this.setLayout(new GridLayout(6, 6, 0, 0));
                MatrizBotones[f] = new JLabel(String.valueOf(Matriz2[f]));
                getButton(f).setBackground(null);
                getButton(f).setText("");
                getButton(f).setAlignmentX(CENTER_ALIGNMENT);
                getButton(f).setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null));
                //getButton(f, c).setFocusPainted(false);
                Matriz2[f] = 0;
                if (Matriz2[f] != 0) {
                }
                this.add(getButton(f));
                // System.out.println(MatrizBotones[f][c]);
            }
        }
    }

    public JLabel getButton(int fila) {
        return MatrizBotones[fila];
    }

    public void detenerJuego() {
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                getButton(i).removeMouseListener(null);
                getButton(i).setEnabled(false);
                getButton(i).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                    }
                });
                //  getButton(i, j).setBackground(null);
            }
        }
    }

    /* public static void main(String[] args) {
     matrizBotones tab = new matrizBotones();
     tab.setVisible(true);

     }*/
}
