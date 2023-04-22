import javax.swing.JOptionPane;

public class facto {

    public static void main(String args[]) {
        String a;
        int num;
        double b = 1;
        try{	
        do {  
            a=JOptionPane.showInputDialog("Introduce el numero");
            num=Integer.parseInt(a);
        } while (num < 0);

        for (int i = num; i >= 1; i--) {
            b = b * i;
        }
		
        JOptionPane.showMessageDialog(null, "El factorial de " + num + " es: " + b);
        }
          catch(Exception e) { JOptionPane.showMessageDialog(null, "Error! Intoduzca un numero") ; }  
          finally{ JOptionPane.showMessageDialog(null, "\nLa ejecucion del programa a terminado."); }                                        
    }
}