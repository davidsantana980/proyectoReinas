import javax.swing.JOptionPane;

public class Numeros {
    private int primerTermino;
    private int segundoTermino; 
    private int tercerTermino;

    private double primerTerminoDoble;
    private double segundoTerminoDoble; 
    private double tercerTerminoDoble;

    Numeros(int num1, int num2, int num3){
        primerTermino = num1;
        segundoTermino = num2; 
        tercerTermino = num3;
    }
    Numeros(double num1, double num2, double num3){
        primerTerminoDoble = num1;
        segundoTerminoDoble = num2; 
        tercerTerminoDoble = num3;
    }

    //función sobrecargada; al recibir 3 argumentos se ejecutará la versión que en realidad toma los dos primeros, 
    //saca su MCD con la version de 2 parámetros y luego saca con la misma función ( de 2 parámetros ) el MCD del primer par y el tercer número. 
  
    public int mcd(){
        try {
          return mcd(primerTermino, segundoTermino, tercerTermino);
        }catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e.getMessage()); 
            return -1;
        }
    }

    private int mcd(int primerTermino, int segundoTermino, int tercerTermino){
        try{
          int primerMCD = mcd(primerTermino, segundoTermino);
          return mcd(primerMCD, tercerTermino);
        }catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e.getMessage()); 
            return -1;
        }
    
    }

    private int mcd(int dividendo, int divisor) {
        if(divisor == 0){
            return dividendo;
        }
        int resto = (dividendo % divisor);
        return mcd(divisor, resto);
    }

    public int mcm(){ 
        try{
           return mcm(primerTermino, segundoTermino, tercerTermino);
        }catch (Exception e) { 
           JOptionPane.showMessageDialog(null, e.getMessage()); 
           return -1;
        }
    }

    private int mcm(int primerTermino, int segundoTermino, int tercerTermino){
        try{
          int primerMCM = mcm(primerTermino, segundoTermino);
          return mcm(primerMCM, tercerTermino);
        }catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e.getMessage()); 
            return -1;
        }
    }

    private int mcm(int primerTermino, int segundoTermino){
        int minimo = (primerTermino > segundoTermino) ? primerTermino : segundoTermino;

        while (true) {
            if (minimo % primerTermino == 0 && minimo % segundoTermino == 0) { 
                return minimo;
            }
            minimo++;
        }   
    }

    public void ecuacionCuadratica() {
      try{
        double a, b, c, e1, e2, aux, nr, ni;

        a = primerTerminoDoble;
        b = segundoTerminoDoble;
        c = tercerTerminoDoble;

        if(a != 0){
            aux = b * b -4 * a * c;
            e1 = (-b + Math.sqrt(aux) ) / (2 * a);
            e2 = (-b - Math.sqrt(aux) ) / (2 * a);

            nr = -b / (2 * a);
            ni = Math.sqrt(-aux) / (2 * a);
    
            if(aux >= 0) {
                JOptionPane.showMessageDialog(null, "Los numeros reales son: " + nr);
                JOptionPane.showMessageDialog(null, "Solucion de la ecuacion positiva: " + e1);
                JOptionPane.showMessageDialog(null, "Solucion de la ecuacion negativa: " + e2);
                JOptionPane.showMessageDialog(null, "El resultado de su ecuacion es real, no hay numeros imaginarios... ");
            } else {
                JOptionPane.showMessageDialog(null, "Los numeros reales son: " + nr);
                JOptionPane.showMessageDialog(null, "Los numeros imaginarios son: " + ni);
                JOptionPane.showMessageDialog(null, "La raiz es negativa, no hay resultado");
            }	  
        }else{
            JOptionPane.showMessageDialog(null, "\nERROR: El termino \'a\' no puede ser 0 en una variable de segundo grado.");
        }   
      }catch(Error e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
      }                               
    }      
}