import javax.swing.JOptionPane;

final class Proyecto {
    private static int numeroEntero() {
        int numero = 0;
        boolean deNuevo = true;

        while (deNuevo) {
            try {
                String input = JOptionPane.showInputDialog(null, "Introduce un número entero:");
                numero = Integer.parseInt(input);
                deNuevo = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No introduciste un número! Introduce un número entero:");
            }
        }
        return numero;
    }

    private static double numeroDoble() {
        double numero = 0;
        boolean deNuevo = true;

        while (deNuevo) {
            try {
                String input = JOptionPane.showInputDialog(null, "Introduce un número:");
                numero = Double.parseDouble(input);
                deNuevo = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "No introduciste un número! Introduce un número:");
            }
        }
        return numero;
    }

    private static void ejercicioPrimos(){
        System.out.println("\nIntroduce un numero para determinar si es primo o compuesto:");
        Numero numero = new Numero(numeroEntero());

        try{
            String primoOCompuesto =  numero.esPrimo() ? numero.getNumero() + " es un numero primo" : numero.getNumero() + " es un numero compuesto";
            System.out.println(primoOCompuesto);
        }catch(Error e){
            System.out.println(e.getMessage());
        }finally{ System.out.println("Aun quedan mas opciones para usar en el programa! ");
            menu();
        }
    }


    private static void ejercicioMCM_MCD(){
        System.out.println("Introduce tres numeros:\n");
        int primerTermino = numeroEntero();;
        int segundoTermino = numeroEntero();
        int tercerTermino = numeroEntero();
        Numeros numeros = new Numeros(primerTermino, segundoTermino, tercerTermino);

        try{
        int mcd = numeros.mcd();
        System.out.println("\nEl maximo comun divisor de " + primerTermino + ", "+segundoTermino+" y " + tercerTermino + " es " + mcd);

        int mcm = numeros.mcm();
        System.out.println("\nEl minimo comun multiplo de " + primerTermino + ", "+segundoTermino+" y " + tercerTermino + " es " + mcm);
        }catch(Error e){
            System.out.println(e.getMessage());
        }finally{ System.out.println("Aun quedan mas opciones para usar en el programa! ");
            menu();
        }
    }

    private static void ejercicioDesglose(){
        System.out.println("Ingrese el valor del billete");
        Numero billete = new Numero(numeroEntero());

        try{
          billete.desgloseBillete();      
        }catch(Error e){
            System.out.println(e.getMessage());
        }finally{ System.out.println("Aun quedan mas opciones para usar en el programa! ");
            menu();
        }
    }

    private static void ejercicioFactorial(){
        System.out.print("Introduce un numero entero mayor o igual a 0: ");

        Numero numero = new Numero(numeroEntero());

        try{
            numero.factorial();
        }catch(Error e){
            System.out.println(e.getMessage());
        }finally{ System.out.println("Aun quedan mas opciones para usar en el programa! ");
            menu();
        }
    }

    private static void ejercicioEcuacion(){
        System.out.println("Introduzca la variable a");
        double a = numeroDoble();
        System.out.println("Introduzca la variable b");
        double b = numeroDoble();
        System.out.println("Introduzca la variable c");
        double c = numeroDoble();

        Numeros numeros = new Numeros(a, b, c);

        try{
        numeros.ecuacionCuadratica();
        }catch(Error e){
            System.out.println(e.getMessage());
        }finally{ System.out.println("Aun quedan mas opciones para usar en el programa! ");
            menu();
        }
    }

    private static void ejercicioPilas(){
            Pila<Integer> pila = new Pila<>();

            String mensaje = "";

        boolean deNuevo = true;
        while(deNuevo){
            
            String opcion = JOptionPane.showInputDialog("Escribe uno de los comandos: \'estado\', \'llenar\', \'cantidad\', \'top\', \'elimina\', \'contenido\', \'modifica\' o \'salir\', para cerrar el menu pilas: ");

                switch(opcion){
                    case "contenido": 

                        if(!pila.vacia()){
                            System.out.println("\nEl contenido de la pila es: \n");
                            pila.muestraTodo();
                        }else{
                            System.out.println("\nNo hay contenido que ver");
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
                    
                        System.out.println(mensaje);

                        break;
                    case "modifica":
                        mensaje = "\nLa pila esta vacia";

                        if(!pila.vacia()){
                            System.out.println("Escribe el indice del numero que quieres cambiar: ");
                            int index = numeroEntero();

                            while(index >= pila.cantidadDeElementos() || index < 0){
                                System.out.println("Ese indice es invalido! Intenta de nuevo:");
                                index = numeroEntero();
                            }

                        System.out.println("Escribe el numero por el que quieres sustituir el elemento en el indice " + index + " (el valor actual en ese indice es "+ pila.elementAt(index)+"): ");
                        int nuevoNumero = numeroEntero();    

                            pila.modifica(index, nuevoNumero);

                            mensaje = "\nElemento correctamente modificado. Nuevo valor: " + nuevoNumero;
                        }     

                        System.out.println(mensaje);    
                        break;
                    case "elimina":
                        mensaje = "\nNo hay elementos que eliminar";

                        if(!pila.vacia()){
                            System.out.println("\nEscribe el indice del numero que quieres cambiar: ");
                            int index = numeroEntero();

                            while(index >= pila.cantidadDeElementos() || index < 0){
                                System.out.println("Ese indice es invalido! Intenta de nuevo:");
                                index = numeroEntero();
                            }

                            pila.pop(index);
                            mensaje = "\nEl numero ha sido eliminado.";
                        }                        
                    
                    System.out.println(mensaje);
                    break;
                case "busca":
                    mensaje = "\nNo hay elementos";

                    if(!pila.vacia()){
                        System.out.println("\nEscribe el indice del numero que buscas: ");
                        int index = numeroEntero();

                        while(index >= pila.cantidadDeElementos() || index < 0){
                            System.out.println("Ese indice es invalido! Intenta de nuevo:");
                            index = numeroEntero();
                        }

                        
                        mensaje = "\nEl numero es: " + pila.elementAt(index);
                    }                        
                    
                    System.out.println(mensaje);
                    break;

                case "salir":

                        System.out.println("\nHasta pronto! ");
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
            
            System.out.print("\n\nSolucion:\n\n");
            
            ajedrez.imprime();
        } catch (Exception e) {
            System.out.println("\n\n" + e.getMessage());
        }finally{
            menu();
        }
    }

    private static void menu(){
        JOptionPane.showMessageDialog(null, "Bienvenido de vuelta al menu principal!");

        try{
          boolean deNuevo = true;
          while (deNuevo) {
              String input = JOptionPane.showInputDialog(null, "Escribe uno de los comandos: 'primos', 'factorial', 'comunes', 'reinas', 'pilas', 'desglose', 'ecuacion' o 'salir' para cerrar el programa:");
              switch (input) {
                    case "primos":
                        ejercicioPrimos();
                        break;
                    case "comunes":
                        ejercicioMCM_MCD();
                        break;
                    case "pilas":
                        ejercicioPilas();
                        break;
                    case "desglose":
                        ejercicioDesglose();
                        break;
                    case "factorial":
                        ejercicioFactorial();
                        break;
                    case "ecuacion":
                        ejercicioEcuacion();
                        break;
                    case "reinas":
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
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}