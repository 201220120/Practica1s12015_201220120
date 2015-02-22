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

    JLabel MatrizBotones[][];
    JLabel comprobarDatos[][];
    int Matriz2[][];

    String fila1;
    String columna1;
    int fila;
    int columna;

    public matrizEstrucutas(int filas) {
        this.fila = filas;
        columna = 1;
        MatrizBotones = new JLabel[fila][columna];
        Matriz2 = new int[fila][columna];
        comprobarDatos = new JLabel[fila][columna];

        for (int f = 0; f < fila; f++) {
            for (int c = 0; c < columna; c++) {
                this.setLayout(new GridLayout(6, 6, 0, 0));
                MatrizBotones[f][c] = new JLabel(String.valueOf(Matriz2[f][c]));
                getButton(f, c).setBackground(null);
                getButton(f, c).setText("Planta");
                getButton(f, c).setAlignmentX(CENTER_ALIGNMENT);
                getButton(f, c).setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, null, null, null, null));
                //getButton(f, c).setFocusPainted(false);
                Matriz2[f][c] = 0;
                if (Matriz2[f][c] != 0) {
                }
                this.add(getButton(f, c));
                // System.out.println(MatrizBotones[f][c]);
            }
        }
    }

    public JLabel getButton(int fila, int columna) {
        return MatrizBotones[fila][columna];
    }

    public void detenerJuego() {
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                getButton(i, j).removeMouseListener(null);
                getButton(i, j).setEnabled(false);
                getButton(i, j).addMouseListener(new java.awt.event.MouseAdapter() {
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
