import javax.swing.JOptionPane;

public class ejerciciosInstanciados {
    private static MenuPrincipal menu = new MenuPrincipal();

    public int numeroEntero() {
        int numero = 0;
        boolean deNuevo = true;

        while (deNuevo) {
            try {
                String input = JOptionPane.showInputDialog(null, "Introduce un numero entero:");
                numero = Integer.parseInt(input);
                deNuevo = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No introduciste un número! Introduce un numero entero:");
            }
        }
        return numero;
    }

    public double numeroDoble() {
        double numero = 0;
        boolean deNuevo = true;

        while (deNuevo) {
            try {
                String input = JOptionPane.showInputDialog(null, "Introduce un numero:");
                numero = Double.parseDouble(input);
                deNuevo = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No introduciste un numero! Introduce un numero:");
            }
        }
        return numero;
    }

    public void ejercicioPrimos(){
        JOptionPane.showMessageDialog(null, "\nIntroduce un numero para determinar si es primo o compuesto:");
        Numero numero = new Numero(numeroEntero());

        try{
            String primoOCompuesto =  numero.esPrimo() ? numero.getNumero() + " es un numero primo" : numero.getNumero() + " es un numero compuesto";
            JOptionPane.showMessageDialog(null, primoOCompuesto);
        }catch(Error e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{ JOptionPane.showMessageDialog(null, "\nAun quedan mas opciones para usar en el programa! ");
            menu.ejecutar();
        }
    }


    public void ejercicioMCM_MCD(){
        JOptionPane.showMessageDialog(null, "Introduce tres numeros:\n");
        int primerTermino = numeroEntero();;
        int segundoTermino = numeroEntero();
        int tercerTermino = numeroEntero();
        Numeros numeros = new Numeros(primerTermino, segundoTermino, tercerTermino);

        try{
            int mcd = numeros.mcd();
            JOptionPane.showMessageDialog(null, "\nEl maximo comun divisor de " + primerTermino + ", "+segundoTermino+" y " + tercerTermino + " es " + mcd);

            int mcm = numeros.mcm();
            JOptionPane.showMessageDialog(null, "\nEl minimo comun multiplo de " + primerTermino + ", "+segundoTermino+" y " + tercerTermino + " es " + mcm);
        }catch(Error e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{ JOptionPane.showMessageDialog(null, "Aun quedan mas opciones para usar en el programa! ");
            menu.ejecutar();
        }
    }

    public void ejercicioDesglose(){
        JOptionPane.showMessageDialog(null, "Ingrese el valor del billete");
        Numero billete = new Numero(numeroEntero());

        try{
          billete.desgloseBillete();      
        }catch(Error e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{ JOptionPane.showMessageDialog(null, "Aun quedan mas opciones para usar en el programa! ");
            menu.ejecutar();
        }
    }

    public void ejercicioFactorial(){
        JOptionPane.showMessageDialog(null, "Introduce un numero entero mayor o igual a 0: ");

        Numero numero = new Numero(numeroEntero());

        try{
            numero.factorial();
        }catch(Error e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{ JOptionPane.showMessageDialog(null, "Aun quedan mas opciones para usar en el programa! ");
            menu.ejecutar();
        }
    }

    public void ejercicioEcuacion(){
        JOptionPane.showMessageDialog(null, "Introduzca la variable a");
        double a = numeroDoble();
        JOptionPane.showMessageDialog(null, "Introduzca la variable b");
        double b = numeroDoble();
        JOptionPane.showMessageDialog(null, "Introduzca la variable c");
        double c = numeroDoble();

        Numeros numeros = new Numeros(a, b, c);

        try{
        numeros.ecuacionCuadratica();
        }catch(Error e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{ JOptionPane.showMessageDialog(null, "Aun quedan mas opciones para usar en el programa! ");
            menu.ejecutar();
        }
    }

    public void ejercicioPilas(){
        Pila<Integer> pila = new Pila<>();
        try {
            pila.menu();
        } catch (Exception e) {
            throw e;
        }finally{
            menu.ejecutar();
        }
    }

    public void ejercicioReinas(){
        try {
            Reinas ajedrez = new Reinas(8);
            ajedrez.resuelve();
            ajedrez.imprime();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "\n\n" + e.getMessage());
        }finally{ JOptionPane.showMessageDialog(null, "Aun quedan mas opciones para usar en el programa! ");
            menu.ejecutar();
        }
    }

}
