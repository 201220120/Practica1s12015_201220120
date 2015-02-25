package codigo;

import graphViz.*;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Walter Mendoza
 */
public class MatrizOrtogonal2 extends JPanel {

    private int x, y;
    private JFrame frame;
    private NodoM<Cuadrante> origen, fin;
    private GraphViz gv;

    public MatrizOrtogonal2(int x, int y,JFrame panel) {
        this.x = x;
        this.y = y;
        origen = null;
        this.frame = panel;
        inicializaMatriz();
    }

    private void inicializaMatriz() {
        NodoM<Cuadrante> aux1 = null, nuevo, aux2;
        String dato = "D";
        int k = 0;

        for (int i = 0; i < x; i++) {

            k++;

            Cuadrante cua = new Cuadrante(i, 0, dato + k);
            frame.add(cua);
            nuevo = new NodoM<>(cua);
            if (fin != null) {
                fin.setSiguiente(nuevo);
                nuevo.setAnterior(fin);
                fin = nuevo;
            } else {
                origen = fin = nuevo;
            }

        }

        int i = 0;
        aux1 = aux2 = origen;
        for (int j = 1; j < y; j++) {

            for (i = 0; i < x; i++) {
                k++;
                Cuadrante cua = new Cuadrante(i, j, dato + k);
                frame.add(cua);
                nuevo = new NodoM<>(cua);
                if (i != 0) {

                    fin.setSiguiente(nuevo);
                    nuevo.setAnterior(fin);
                    nuevo.setArriba(aux1);
                    aux1.setAbajo(nuevo);
                    fin = nuevo;

                } else {
                    aux1.setAbajo(nuevo);
                    nuevo.setArriba(aux1);
                    fin = nuevo;
                }

                if (aux1.getSiguiente() != null) {
                    aux1 = aux1.getSiguiente();
                }
            }
            aux2 = aux2.getAbajo();
            aux1 = aux2;
        }

    }

    public NodoM getCoordenada(int x, int y) {
        NodoM aux = null;

        // System.out.println("x:" + x+",y:" + y);
        if (xValida(x) && yValida(y)) {
            aux = origen;
            int i = 0, j = 0;
            while (i != x) {
                aux = aux.getSiguiente();
                i++;
            }

            while (j != y) {
                aux = aux.getAbajo();
                j++;
            }
        }

        return aux;
    }

    public boolean Vacia() {
        return origen == null;
    }

    private boolean xValida(int x) {
        return x >= 0 && x < this.x + 1;
    }

    private boolean yValida(int y) {
        return y >= 0 && y < this.y + 1;
    }

    public void print() {
        NodoM aux = origen;
        int k = 0;
        for (int j = 0; j < y; j++) {

            for (int i = 0; i < x; i++) {
               // System.out.print(aux.getValor()+"|");

                if (k % 2 == 0) {
                    if (aux.getSiguiente() != null) {
                        aux = aux.getSiguiente();
                    }
                } else if (aux.getAnterior() != null) {
                    aux = aux.getAnterior();
                }
            }

            //System.out.println("");
            aux = aux.getAbajo();
            k++;
        }

    }

    public void graficar() {
        gv = new GraphViz();
        gv.addln(gv.start_graph());
        gv.addln("rankdir = TB;");
        gv.addln("rank=same;");
        NodoM<Cuadrante> aux = origen;
        NodoM<Cuadrante> aux2;
        aux2 = origen;
        int i = 0;
        //int k=0;
        if (origen != null) {

            //gv.addln("top [label= \""+aux.getValue().toString()+ "\"];");
            aux = origen;

            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (j == 0 && k == 0) {
                        gv.addln("n0 [label= \"" + aux.getValue().toString() + "\"];");
                    } else {
                        gv.addln("n" + i + "[label=\"" + aux.getValue().toString() + "\"];");

                    }
                    i++;
                    aux = aux.getSiguiente();
                }
                aux2 = aux2.getAbajo();
                aux = aux2;
            }

            addPunterosSi();
            addPunterosAn();
            addPunteroAb();
            addPunteroAr();
            //modificar para terminar

            gv.add(";");

            gv.addln(gv.end_graph());
            File ext = new File("MatrizOrtogonal.gif");
            // gv.writeGraphToFile(gv.getGraph(gv.getDotSource(),"gif"), ext);
        }
    }

    private void addPunterosSi() {
        int i = 0;
        NodoM<Cuadrante> aux, aux2;
        aux = aux2 = origen;
        //gv.add("top");
        for (int j = 0; j < y; j++) {
            gv.addln("subgraph sg" + j + "{");
            if (i < x * y && i > 0) {
                gv.add("n" + i);
            }
            for (int k = 0; k < x; k++) {
                if (j == 0 && k == 0) {
                    gv.add("n0");
                } else {
                    if (i % x != 0) {
                        gv.add("->n" + i);

                    }

                }
                i++;
                aux = aux.getSiguiente();
            }
            gv.addln(";}");

            aux2 = aux2.getAbajo();
            aux = aux2;
        }
    }

    private void addPunterosAn() {
        int i = x * y - 1;

        NodoM<Cuadrante> aux, aux2;
        aux = aux2 = fin;
        gv.add(";n" + i);

        for (int j = y; j > 0; j--) {
            for (int k = x; k > 0; k--) {
                i--;
                if (i > 0 && aux.getAnterior() != null) {
                    gv.add("->n" + i);

                } else if (i == 0) {
                    gv.add("->n0");
                }

                aux = aux.getAnterior();
            }

            if (i > 0) {
                gv.add(";n" + (i));
                System.out.println(i);
            }
            aux2 = aux2.getArriba();
            aux = aux2;
        }
    }

    private void addPunteroAb() {
        NodoM<Cuadrante> aux1, aux2;
        int i = 0, s = 0;
        aux1 = aux2 = origen;
        gv.add(";n0");

        for (int j = 0; j < x; j++) {
            for (int k = 0; k < y - 1; k++) {
                if (j == 0 && k == 0) {
                    gv.add("->n" + (i + x));
                } else {
                    gv.add("->n" + (i + x));
                }
                i += x;

                aux1 = aux1.getAbajo();
            }
            s++;
            i = s;
            if (i < x * y) {
                gv.add(";n" + i);
            }
            aux2 = aux2.getSiguiente();
            aux1 = aux2;
        }
            //gv.add(";");

    }

    private void addPunteroAr() {
        int i, s;
        i = x * y - 1;
        s = i;
        NodoM<Cuadrante> aux1, aux2;
        aux1 = aux2 = fin;
        gv.add(";n" + i);

        for (int j = 0; j < x; j++) {
            for (int k = 0; k < y - 1; k++) {
                i -= x;
                if (i > 0) {
                    gv.add("->n" + i);
                    aux1 = aux1.getArriba();
                } else {
                    gv.add("->n0");
                }
            }
            aux2 = aux2.getAnterior();
            aux1 = aux2;
            s--;
            gv.add(";n" + s);
            i = s;
        }
    }
}
