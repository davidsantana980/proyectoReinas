public class Numero {
    private int numero; 

    Numero(int entero){
        numero = entero;
    }

    public boolean esPrimo(){
        boolean primo = true;

        try {
            if(numero == 1) return primo;
            if(numero <= 0) throw new Exception("El numero es invalido");
    
            for (int i = 2; i < numero; i++) {
                if (numero % i == 0) {
                    primo = false;
                    break;
                }
            }
            return primo;
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public int getNumero(){
        return numero;
    }

    public void desgloseBillete() {        
            int billete, DesglosInt, aux; 
            float DesglosFloat;
    
            try {
                billete = numero;

                if (billete > 0 && billete != 100 && billete != 50 && billete != 20 && billete != 10 && billete != 5 && billete != 2 && billete != 1) {
                    throw new Exception("Error: un billete de tal valor no existe");
                }else{
                    System.out.println("Un billete de " + billete + " se puede desglosar en:");
            
                    if (billete > 50){
                        DesglosInt = billete / 50;
                        System.out.println(DesglosInt + " billetes de 50.");
                    }
                    
                    if (billete > 20){
                        DesglosFloat = billete / 20f;
                        if (DesglosFloat % 1 == 0){
                            aux =(int)DesglosFloat;
                            System.out.println(aux + " billetes de 20.");
                        } 
                    }
    
                    if (billete > 10){  
                        DesglosInt = billete / 10;
                        System.out.println(DesglosInt + " billetes de 10.");
                    }
                    
                    if (billete > 5){
                        DesglosInt = billete / 5;
                        System.out.println(DesglosInt + " billetes de 5.");
                    }
    
                    if (billete > 2){
                        DesglosFloat = billete / 2f;
                        if (DesglosFloat % 1 == 0){
                            aux =(int)DesglosFloat;
                            System.out.println(aux + " billetes de 2.");
                        }
                    }
    
                    if (billete > 1){
                        DesglosInt = billete / 1;
                        System.out.println(DesglosInt + " billetes de 1.");
                    }else{
                        System.out.println("Un billete de 1 es lo minimo, por lo tanto no se puede desglosar.");
                    }
                }
            } catch (Exception e) {
                throw new Error(e.getMessage());
            }
        }
        
        public void factorial() {
            int a = numero;
            double b = 1;
            try{
                if(a < 0) throw new Exception("Error: El numero debe ser mayor o igual a 0.");
                for (int i = a; i >= 1; i--) {
                    b = b * i;
                }
                System.out.printf("El factorial de " + a + " es: " + b);                                                             
            }catch(Exception e){
                throw new Error(e.getMessage());
            }
        }
    
}
