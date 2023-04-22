import javax.swing.JOptionPane;

final class Proyecto {
    private static int numeroEntero() {
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

    private static double numeroDoble() {
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

    private static void ejercicioPrimos(){
        JOptionPane.showMessageDialog(null, "\nIntroduce un numero para determinar si es primo o compuesto:");
        Numero numero = new Numero(numeroEntero());

        try{
            String primoOCompuesto =  numero.esPrimo() ? numero.getNumero() + " es un numero primo" : numero.getNumero() + " es un numero compuesto";
            JOptionPane.showMessageDialog(null, primoOCompuesto);
        }catch(Error e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{ JOptionPane.showMessageDialog(null, "\nAun quedan mas opciones para usar en el programa! ");
            menu();
        }
    }


    private static void ejercicioMCM_MCD(){
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
            menu();
        }
    }

    private static void ejercicioDesglose(){
        JOptionPane.showMessageDialog(null, "Ingrese el valor del billete");
        Numero billete = new Numero(numeroEntero());

        try{
          billete.desgloseBillete();      
        }catch(Error e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{ JOptionPane.showMessageDialog(null, "Aun quedan mas opciones para usar en el programa! ");
            menu();
        }
    }

    private static void ejercicioFactorial(){
        JOptionPane.showMessageDialog(null, "Introduce un numero entero mayor o igual a 0: ");

        Numero numero = new Numero(numeroEntero());

        try{
            numero.factorial();
        }catch(Error e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{ JOptionPane.showMessageDialog(null, "Aun quedan mas opciones para usar en el programa! ");
            menu();
        }
    }

    private static void ejercicioEcuacion(){
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
            menu();
        }
    }

    private static void ejercicioPilas(){
            Pila<Integer> pila = new Pila<>();

            String mensaje = "";

        boolean deNuevo = true;
        while(deNuevo){
            
            String opcion = JOptionPane.showInputDialog("Escribe uno de los comandos: \'estado\', \'llenar\', \'cantidad\', \'top\', \'reinas\', \'elimina\', \'contenido\', \'modifica\' o \'salir\', para cerrar el menu pilas: ");

                switch(opcion){
                    case "contenido": 

                        if(!pila.vacia()){
                            JOptionPane.showMessageDialog(null, "\nEl contenido de la pila es: \n");
                            pila.muestraTodo();
                        }else{
                            JOptionPane.showMessageDialog(null, "\nNo hay contenido que ver");
                        }

                        break;
                    case "estado": 

                        String vacia = pila.vacia() ? "esta vacia" : "no esta vacia" ;
                        System.out.println("\nLa pila "+ vacia);

                        break;
                    case "llenar":

                        mensaje = "Introduce numeros a la pila, o introduce cualquier otro caracter para terminar: ";
                        boolean leer = true;
                        while(leer){
                              try {
                                   String input = JOptionPane.showInputDialog(null, mensaje);
                                   int numero = Integer.parseInt(input); 
                                   pila.push(numero);
                              } catch (NumberFormatException e) {     
                              leer = false;
                       }
                }

                        break;
                   case "cantidad":

                       mensaje = "Hay "+ pila.cantidadDeElementos() + " elementos en la lista.";
                       JOptionPane.showMessageDialog(null, mensaje);

                        break;
                    case "top":

                       mensaje = "\nEl ultimo elemento de la lista es nulo";
                       if(!pila.vacia()){
                            mensaje = "El pico de la pila es " +  pila.top();
                       }     
                       JOptionPane.showMessageDialog(null, mensaje);

                       break;
                    case "pop":

                            mensaje = "No hay elementos que eliminar";

                            if(!pila.vacia()){
                                mensaje = "\nEl numero sacado es: " + pila.pop();
                            }                        
                    
                        JOptionPane.showMessageDialog(null, mensaje);

                        break;
                    case "modifica":
                        mensaje = "\nLa pila esta vacia";

                        if(!pila.vacia()){
                            JOptionPane.showMessageDialog(null, "Escribe el indice del numero que quieres cambiar: ");
                            int index = numeroEntero();

                            while(index >= pila.cantidadDeElementos() || index < 0){
                                JOptionPane.showMessageDialog(null, "Ese indice es invalido! Intenta de nuevo:");
                                index = numeroEntero();
                            }

                        JOptionPane.showMessageDialog(null, "Escribe el numero por el que quieres sustituir el elemento en el indice " + index + " (el valor actual en ese indice es "+ pila.elementAt(index)+"): ");
                        int nuevoNumero = numeroEntero();    

                            pila.modifica(index, nuevoNumero);

                            mensaje = "\nElemento correctamente modificado. Nuevo valor: " + nuevoNumero;
                        }     

                        JOptionPane.showMessageDialog(null, mensaje);    
                        break;
                    case "elimina":
                        mensaje = "\nNo hay elementos que eliminar";

                        if(!pila.vacia()){
                            JOptionPane.showMessageDialog(null, "\nEscribe el indice del numero que quieres cambiar: ");
                            int index = numeroEntero();

                            while(index >= pila.cantidadDeElementos() || index < 0){
                                JOptionPane.showMessageDialog(null, "Ese indice es invalido! Intenta de nuevo:");
                                index = numeroEntero();
                            }

                            pila.pop(index);
                            mensaje = "\nEl numero ha sido eliminado.";
                        }                        
                    
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                case "busca":
                    mensaje = "\nNo hay elementos";

                    if(!pila.vacia()){
                        JOptionPane.showMessageDialog(null, "\nEscribe el indice del numero que buscas: ");
                        int index = numeroEntero();

                        while(index >= pila.cantidadDeElementos() || index < 0){
                            JOptionPane.showMessageDialog(null, "Ese indice es invalido! Intenta de nuevo:");
                            index = numeroEntero();
                        }

                        
                        mensaje = "\nEl numero es: " + pila.elementAt(index);
                    }                        
                    
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "salir":

                        JOptionPane.showMessageDialog(null, "\nHasta pronto! ");
                        deNuevo = false;

                        break;
                }
            }
            
            menu();
    }

    private static void ejercicioReinas(){
        try {
            Reinas ajedrez = new Reinas(8);

            ajedrez.resuelve();
            
            JOptionPane.showMessageDialog(null, "\n\nSolucion:\n\n");
            
            ajedrez.imprime();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "\n\n" + e.getMessage());
        }finally{ JOptionPane.showMessageDialog(null, "Aun quedan mas opciones para usar en el programa! ");
            menu();
        }
    }

    private static void menu(){
        JOptionPane.showMessageDialog(null, "Bienvenido al menu principal!");

        try{
          boolean deNuevo = true;
          while (deNuevo) {
              String input = JOptionPane.showInputDialog(null, "Escribe uno de los comandos: '1' para los numeros primos, '2' para calcular el factorial, '3' para sacar los comunes, '4' para usar las pilas, '5' para sacar el desglose de un billete, '6' para sacar una ecuacion, '7' para ingresar al ejercicio de las 8 reinas o 'salir' para cerrar el programa:");
              switch (input) {
                    case "1":
                        ejercicioPrimos();
                        break;
                    case "3":
                        ejercicioMCM_MCD();
                        break;
                    case "4":
                        ejercicioPilas();
                        break;
                    case "5":
                        ejercicioDesglose();
                        break;
                    case "2":
                        ejercicioFactorial();
                        break;
                    case "6":
                        ejercicioEcuacion();
                        break;
                    case "7":
                        ejercicioReinas();
                        break;
                    case "salir":
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
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido Usuario, introduzca su usuario y clave:");
        
        try {
            for(int intentos = 0; intentos < 3; intentos++){
                String usuario = JOptionPane.showInputDialog("Usuario:");
                String clave = JOptionPane.showInputDialog("Clave:");
                
                if (usuario.isEmpty() || clave.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se han ingresado datos, por favor vuelva a intentarlo");
                } else {
                    if (usuario.equals("papu")  && clave.equals("mortadela")) {
                        menu();
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