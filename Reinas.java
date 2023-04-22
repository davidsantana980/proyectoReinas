public class Reinas{
    private Pila<int[][]> estadoDeLaTabla = new Pila<>();

    private int sizeDelTablero;

    Reinas(int sizeDelTablero){
        //crea un tablero del tamaño indicado en forma de una matriz bidimensional full de 0s
        final int[][] tabla = new int[sizeDelTablero][sizeDelTablero];
        for(int fila = 0; fila < sizeDelTablero; fila++){
            for(int columna = 0; columna < sizeDelTablero; columna++){
                tabla[fila][columna] = 0;
            }
        }

        //guarda el tablero recién creado en la pila
        estadoDeLaTabla.push(tabla);
        this.sizeDelTablero = sizeDelTablero;
    }

    public void resuelve() throws Exception {     
        try{
            if(this.sizeDelTablero != 8) throw new Exception();
            //comienza el proceso recursivo por la primera columna
            recursivaPorColumna(0);
        }catch(Exception e){
            throw new Exception("No se pudo resolver");
        }   
    }

    private boolean recursivaPorColumna(int columnaIterada) throws Exception {
        if (columnaIterada == this.sizeDelTablero) {
            return true; // condicion de parada: se llega a la ultima columna con una reina en cada una.
        }
    
        for (int fila = 0; fila < sizeDelTablero; fila++) {
            if (this.posicionSegura(fila, columnaIterada)) {
                // pone una reina en una de las filas de la columna iterada
                this.setTablero(fila, columnaIterada, 1);

                if (recursivaPorColumna(columnaIterada + 1)) {
                    return true;
                } else {
                    // backtracking: retrocede un paso y quita la reina si la posicion no es adecuada
                    this.setTablero(fila, columnaIterada, 0);
                }
            }
        }
    
        return false;
    }
        
    private boolean posicionSegura(int filaRevisada, int columnaRevisada) throws Exception {

        // ultimo estado del tablero
        int[][] board = getTablero();

        // hay reina en la misma fila?
        for (int columna = 0; columna < columnaRevisada; columna++) {
            if (board[filaRevisada][columna] == 1) {
                return false;
            }
        }
    
        // hay reina en el diagonal superior?
        for (int fila = filaRevisada, columna = columnaRevisada; fila >= 0 && columna >= 0; fila--, columna--) {
            if (board[fila][columna] == 1) {
                return false;
            }
        }
    
        // hay reina en el diagonal inferior?
        for (int fila = filaRevisada, columna = columnaRevisada; fila < this.sizeDelTablero && columna >= 0; fila++, columna--) {
            if (board[fila][columna] == 1) {
                return false;
            }
        }
    
        return true;
    }

    public void imprime() throws Exception{
        int x;
        String[] posiciones = {
            "A", "B", "C", "D", "E", "F", 
            "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X",
            "Y", "Z"
        };

        int[][] tablero = getTablero();

        //columnas representadas por letras
        System.out.print("    "+ posiciones[0]);
        for(int i=1; i < sizeDelTablero; i++) {
            System.out.print(" "+ posiciones[i]);
        }

        //filas
        for(int i=0; i<this.sizeDelTablero; i++) {
            //numero de fila (va en cuenta regresiva)
            x = sizeDelTablero-i;
            System.out.print("\n\n" + x + " - ");

            //contenido de la coordenada 
            for(int j=0;j<this.sizeDelTablero;j++) {
                System.out.print(tablero[i][j]+ " ");
            }

            //numero de fila (lado derecho)
            System.out.print(" - " + x);
        } 

        //columnas representadas por letras
        System.out.print("\n\n    "+ posiciones[0]);
        for(int i=1; i<this.sizeDelTablero; i++) {
            System.out.print(" "+ posiciones[i]);
        }

        // int[][] ultimoEstado = getTablero();

        // for (int fila = 0; fila < 8; fila++) {
        //     for (int columna = 0; columna < 8; columna++) {
        //         System.out.print(ultimoEstado[fila][columna] + " ");
        //     }
        //     System.out.println();
        // }
        
        // System.out.println();
    }

    private int[][] getTablero() throws Exception{
        try{
            if(!estadoDeLaTabla.vacia()){
                return estadoDeLaTabla.top();
            }
            throw new Error();
        }catch(Error e){
            throw new Exception("La pila esta vacia, no hay tablero");
        }
    }

    private void setTablero(int fila, int columna, int nuevoValor) throws Exception{
        //toma una copia del último estado del tablero y lo edita 
        int[][] tablero = getTablero();
        int[][] nuevoTablero = new int[this.sizeDelTablero][];
        for (int i = 0; i < this.sizeDelTablero; i++) {
            nuevoTablero[i] = tablero[i].clone();
        }
        nuevoTablero[fila][columna] = nuevoValor;

        // borra el viejo estado de la pila, añade el nuevo
        // estadoDeLaTabla.pop();
        estadoDeLaTabla.push(nuevoTablero);
    }
    
}