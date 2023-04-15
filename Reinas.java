public class Reinas {
    //declara
    private int longitudDelTablero;
    private int[][] tablero;

    private Pila<Integer> pila = new Pila<Integer>(); // stack to store queen positions

    Reinas(int longitudDelTablero){
        try {
            this.longitudDelTablero = longitudDelTablero;
            this.tablero = new int[this.longitudDelTablero][this.longitudDelTablero];
            //llenado
            for(int i = 0; i< this.longitudDelTablero; i++){
                for(int j = 0; j<this.longitudDelTablero; j++) {
                    this.tablero[i][j] =0;
                }
            }
                        
        } catch (Exception e) {
            throw new Error("Entrada de datos incorrecta");
        }
    }

    public void getTablero(){
        try {
            int x;
            String[] posiciones = {
                "A", "B", "C", "D", "E", "F", 
                "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X",
                "Y", "Z"
            };
            //columnas representadas por letras
            System.out.print("    "+ posiciones[0]);
            for(int i=1; i<this.longitudDelTablero; i++) {
                System.out.print(" "+ posiciones[i]);
            }

            //filas
            for(int i=0; i<this.longitudDelTablero; i++) {
                //numero de fila (va en cuenta regresiva)
                x = longitudDelTablero-i;
                System.out.print("\n\n" + x + " - ");

                //contenido de la coordenada 
                for(int j=0;j<this.longitudDelTablero;j++) {
                    System.out.print(this.tablero[i][j]+ " ");
                }

                //numero de fila (lado derecho)
                System.out.print(" - " + x);
            } 

            //columnas representadas por letras
            System.out.print("\n\n    "+ posiciones[0]);
            for(int i=1; i<this.longitudDelTablero; i++) {
                System.out.print(" "+ posiciones[i]);
            }

            //arreglar
            System.out.print("\n\n");
            for(int i=0; i<this.longitudDelTablero; i++) {
                System.out.print("reina en fila " + (i+1 )+ " columna " + pila.elementAt(i) +"\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean esSeguro(int fila, int columna){
        try {
            //revisa la misma fila
            for (int i = 0; i < columna; i++) {
                if (this.tablero[fila][i] == 1) {
                    return false;
                }
            }

            //revisa el diiagonal superior
            for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
                if (this.tablero[i][j] == 1) {
                    return false;
                }
            }

            //revisa el diagonal inferior
            for (int i = fila, j = columna; i < this.longitudDelTablero && j >= 0; i++, j--) {
                if (this.tablero[i][j] == 1) {
                    return false;
                }
            }

            //si supera todas las pruebas de arriba...
            return true;
        }catch(Exception e){
            throw new Error("Indice inaccesible");
        }
    }

    public void resuelve(){
        try{
            this.resuelve(0);
        }catch(Exception e){
            throw new Error();
        }
    }
    private boolean resuelve(int columna) {
        //condicion de parada - solo se alcanza cuando
        //todas las reinas han sido colocadas
        if (columna >= longitudDelTablero) {
            return true;
        }
        
        //itera todos los espacios del tablero
        for (int fila = 0; fila < longitudDelTablero; fila++) {
            //si no hay una reina en el espacio iterado...
            if (esSeguro(fila, columna)) {

                //coloca una reina en ese espacio...
                tablero[fila][columna] = 1;
                pila.push(fila);

        
                //repite los anteriores pasos hasta la condicion de parada
                if (resuelve(columna + 1)) {
                    return true;
                }
        
            //de ser otro el caso, elimina la reina y vuelve a intentarlo en la siguiente posicion
                tablero[fila][columna] = 0;
                pila.pop();
            }
        }
        
        //si no se consigue un espacio disponible...
        return false;
    }

    public static void main(String args[]){
        try {
            try{
                Reinas ajedrez = new Reinas(8);
                ajedrez.getTablero();

                ajedrez.resuelve();
                
                System.out.print("\n\nSolucion:\n\n");
                
                ajedrez.getTablero();
            }catch(Error e){
                System.out.println("No se consiguio solucion alguna");
            }
          

        } catch (Error e) {
            System.out.println("\n\n" + e.getMessage());
        }
    }


}

