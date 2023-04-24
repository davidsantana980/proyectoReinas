import javax.swing.JOptionPane;

public class MenuPrincipal {
    private static ejerciciosInstanciados e = new ejerciciosInstanciados();

    public void ejecutar(){
        JOptionPane.showMessageDialog(null, "Bienvenido al menu principal!");

        try{
            boolean deNuevo = true;
            while (deNuevo) {
                String input = JOptionPane.showInputDialog(null, "Escribe uno de los comandos: \n'1' para los numeros primos, \n'2' para calcular el factorial, \n'3' para sacar los comunes, \n'4' para usar las pilas, \n'5' para sacar el desglose de un billete, \n'6' para sacar una ecuacion, \n'7' para ver una solucion al problema de las 8 reinas, \n'8' para cerrar el programa:");
                switch (input) {
                    case "1":
                        e.ejercicioPrimos();
                        break;
                    case "3":
                        e.ejercicioMCM_MCD();
                        break;
                    case "4":
                        e.ejercicioPilas();
                        break;
                    case "5":
                        e.ejercicioDesglose();
                        break;
                    case "2":
                        e.ejercicioFactorial();
                        break;
                    case "6":
                        e.ejercicioEcuacion();
                        break;
                    case "7":
                        e.ejercicioReinas();
                        break;
                    case "8":
                        JOptionPane.showMessageDialog(null, "Hasta pronto! ");
                        deNuevo = false;
                        break;
                    default: 
                        JOptionPane.showMessageDialog(null, "Comando invalido! Escribe bien uno de los comandos indicados, o \'salir\', si quieres terminar: ");
                        break;
                }
            }
        }finally{
            System.exit(0);
        }
    }

 
}
