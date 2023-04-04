public class Reinas {
    //declara
    int size;
    private int[][] tablero;

    Reinas(int size){
        try {
            this.size = size;
            this.tablero = new int[this.size][this.size];
            //llenado
            for(int i = 0; i< this.size; i++){
                for(int j = 0; j<this.size; j++) {
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
            for(int i=1; i<this.size; i++) {
                System.out.print(" "+ posiciones[i]);
            }

            //filas
            for(int i=0; i<this.size; i++) {
                //numero de fila (va en cuenta regresiva)
                x = size-i;
                System.out.print("\n\n" + x + " - ");

                //contenido de la coordenada 
                for(int j=0;j<this.size;j++) {
                    System.out.print(this.tablero[i][j]+ " ");
                }

                //numero de fila (lado derecho)
                System.out.print(" - " + x);
            } 

            //columnas representadas por letras
            System.out.print("\n\n    "+ posiciones[0]);
            for(int i=1; i<this.size; i++) {
                System.out.print(" "+ posiciones[i]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isSafe(int fila, int columna){
        try {
            //revisa la misma fila
            for (int i = 0; i < columna; i++) {
                if (this.tablero[fila][i] == 1) {
                return false;
                }
            }

            //revisa el diagonal superior
            for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
                if (this.tablero[i][j] == 1) {
                    return false;
                }
            }

            //revisa el diagonal inferior
            for (int i = fila, j = columna; i < this.size && j >= 0; i++, j--) {
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

    public void solve(){
        try{
            this.solve(0);
        }catch(Exception e){
            throw new Error();
        }
    }
    private boolean solve(int columna) {
        //condicion de parada - solo se alcanza cuando
        //todas las reinas han sido colocadas
        if (columna >= size) {
            return true;
        }
        
        //itera todos los espacios del tablero
        for (int fila = 0; fila < size; fila++) {
            //si no hay una reina en el espacio iterado...
            if (isSafe(fila, columna)) {

                //coloca una reina en ese espacio...
                tablero[fila][columna] = 1;
        
                //repite los anteriores pasos hasta la condicion de parada
                if (solve(columna + 1)) {
                    return true;
                }
        
            //de ser otro el caso, elimina la reina y vuelve a intentarlo en la siguiente posicion
                tablero[fila][columna] = 0;
            }
        }
        
        //si no se consigue un espacio disponible...
        return false;
    }

    public static void main(String[] args){
        try {
            Reinas ajedrez = new Reinas(8);
            ajedrez.getTablero();

            try{
                ajedrez.solve();
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
