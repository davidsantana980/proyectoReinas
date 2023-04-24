/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoreinasbeans;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Main {
    private static MenuPrincipal menu = new MenuPrincipal();    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido usuario, introduzca su usuario y clave:");
        try {
            for(int intentos = 0; intentos < 3; intentos++){
                String usuario = JOptionPane.showInputDialog("Usuario:");
                String clave = JOptionPane.showInputDialog("Clave:");
                
                if (usuario.isEmpty() || clave.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se han ingresado datos, por favor vuelva a intentarlo");
                } else {
                    if (usuario.equals("papu")  && clave.equals("mortadela")) {
                        menu.ejecutar();
                        break;
                    } else {
                         JOptionPane.showMessageDialog(null, "Lo siento, parece ser que los datos introducidos no son correctos");
                    }
                    if (intentos == 2) throw new Exception("Ha superado el numero maximo de intentos permitidos");
                }
            } 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }
}
