import javax.swing.JOptionPane;

public class Reinas{
    private Pila<int[][]> estadoDeLaTabla = new Pila<>();

    private int sizeDelTablero;

    Reinas(int sizeDelTablero){
        try {
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
        } catch (Exception e) {
            throw e;
        }
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

    private boolean recursivaPorColumna(int columnaIterada) throws Exception  {
        try {
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
        } catch (Exception e) {
            throw e;
        }
    }
        
    private boolean posicionSegura(int filaRevisada, int columnaRevisada) throws Exception {
        try {
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
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprime() throws Exception{
        try {
            int[][] ultimoEstado = getTablero();

            StringBuilder tablero = new StringBuilder();
            char lightSquare = '\u25FB'; // Cuadro claro
            char darkSquare = '\u25FC'; // Cuadro oscuro
            char queen = '\u265B'; // Reina
    
            String[] posiciones = {
                "A", "B", "C", "D", "E", "F", 
                "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X",
                "Y", "Z"
            };
    
    
            StringBuilder columnas = new StringBuilder();
            //columnas representadas por letras
            columnas.append(""+ posiciones[0]);
            for(int i=1; i < sizeDelTablero; i++) {
                columnas.append("  "+ posiciones[i]);
            }
    
            int numDeFila;
    
            
            for (int fila = 0; fila < 8; fila++) {
                numDeFila = sizeDelTablero-fila;
                tablero.append(numDeFila + " - ");
    
                for (int columna = 0; columna < 8; columna++) {
                    char cuadro = (fila + columna) % 2 == 0 ? lightSquare : darkSquare;
                    if (ultimoEstado[fila][columna] == 1) {
                        cuadro = queen;
                    }
                    tablero.append(cuadro).append(" ");
                }
                tablero.append("- " + numDeFila);
    
                tablero.append("\n               ");
            }
    
            String stringTablero = "                            Solucion:\n\n                    " + columnas.toString()+"\n               "+tablero.toString() + "     " + columnas.toString()+ "\n\n";
            
            JOptionPane.showMessageDialog(null, stringTablero, "Tablero",  JOptionPane.PLAIN_MESSAGE);    
        } catch (Exception e) {
            throw e;
        }

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
        try {

            //toma una copia del último estado del tablero y lo edita 
            int[][] tablero = getTablero();
            int[][] nuevoTablero = new int[this.sizeDelTablero][];
            for (int i = 0; i < this.sizeDelTablero; i++) {
                nuevoTablero[i] = tablero[i].clone();
            }
            nuevoTablero[fila][columna] = nuevoValor;

            // añade el nuevo estado de la pila
            estadoDeLaTabla.push(nuevoTablero);

        } catch (Exception e) {
            throw e;
        }
    }
    
}