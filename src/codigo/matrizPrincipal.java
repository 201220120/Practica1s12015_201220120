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
public class matrizPrincipal extends JPanel {

    JLabel MatrizBotones[][];
    JLabel comprobarDatos[][];
    int Matriz2[][];

    String fila1;
    String columna1;
    int fila;
    int columna;
    tableroPrincipal obj;

    public matrizPrincipal(int filas, int columnas, tableroPrincipal obj) {
        this.obj = obj;
        this.fila = filas;
        this.columna = columnas;
        System.out.println("filas tiene " + fila + "esta columna");

        MatrizBotones = new JLabel[fila][columna];
        Matriz2 = new int[fila][columna];
        comprobarDatos = new JLabel[fila][columna];

        for (int f = 0; f < fila; f++) {
            for (int c = 0; c < columna; c++) {
                this.setLayout(new GridLayout(6, 6, 0, 0));
                MatrizBotones[f][c] = new JLabel(String.valueOf(Matriz2[f][c]));
                getButton(f, c).setBackground(null);
                getButton(f, c).setText("");
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

    /* public static void main(String[] args) {
     matrizBotones tab = new matrizBotones();
     tab.setVisible(true);

     }*/
}
