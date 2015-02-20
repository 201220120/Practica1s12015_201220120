package codigo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

/**
 *
 * @author Braian
 */
public class listassimples {

    public static void main(String[] args) {
        funciones fun = new funciones();
        while (true) {

            String mimenu = JOptionPane.showInputDialog("MENU DE LISTAS\n+"
                    + "1. agregar datos\n+"
                    + "2. imprimir datos\n+"
                    + "3. buscar\n+"
                    + "4. modificar registro\n+"
                    + "5. eliminar");
            switch (mimenu) {
                case "1":
                    String nombre = JOptionPane.showInputDialog("Ingrese un nombre");
                    int ataque = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
                    //estructura de los datos creados
                    nodo aux = new nodo();
                    aux.Nombre = nombre;
                    aux.cantidad = ataque;

                    fun.agregarLista(aux);
                    break;
                case "2":
                    fun.imprimir();
                    break;
                case "3":
                    int ataques = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
                   /* if (fun.buscar()) {
                        JOptionPane.showMessageDialog(null, "regisgtro encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "regisgtro no encontrado");
                    }*/
                    break;

                case "4":
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
                    String nombreNuevo = JOptionPane.showInputDialog("Ingrese un nombre");
                    int codigonew = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un codigo nuevo"));
                    if (fun.modificar(codigo, nombreNuevo, codigonew)) {
                        JOptionPane.showMessageDialog(null, "regisgtro modificado");
                    } else {
                        JOptionPane.showMessageDialog(null, "regisgtro no modificado");
                    }
                    break;
                case "5":
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero"));
                   fun.eliminar(cedula);
                    break;
                default:
                    System.exit(0);

            }

        }

    }
}
