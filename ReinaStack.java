public class ReinaStack {
    private int SIZE = 8; // size of the chessboard
    private int[][] board = new int[SIZE][SIZE]; // chessboard
    private Pila<Integer> queenStack = new Pila<Integer>(); // stack to store queen positions
    
    ReinaStack(int longitudDelTablero){
        this.SIZE = longitudDelTablero;
    }
    public static void main(String[] args) {
        ReinaStack tab = new ReinaStack(8);

        tab.placeQueens(0);
        tab.printQueens();
    }
    
    // function to place queens on the chessboard using backtracking
    private boolean placeQueens(int row) {
        if (row == SIZE) { // all queens have been placed
            return true;
        }
        
        for (int col = 0; col < SIZE; col++) {
            if (isValidPosition(row, col)) {
                board[row][col] = 1; // place queen
                queenStack.push(col);
                
                if (placeQueens(row + 1)) {
                    return true;
                }
                
                board[row][col] = 0; // backtrack
                queenStack.pop();
            }
        }
        
        return false; // cannot place queen in this row
    }
    
    // function to check if a queen can be placed at (row, col)
    private boolean isValidPosition(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) { // queen already in same column
                return false;
            }
            
            int colDiff = Math.abs(col - queenStack.indice(i));
            int rowDiff = row - i;
            
            if (colDiff == 0 || colDiff == rowDiff) { // queen in same diagonal
                return false;
            }
        }
        
        return true;
    }

    // function to print the chessboard with queens
    private void printQueens() {
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
                for(int i=1; i<this.SIZE; i++) {
                    System.out.print(" "+ posiciones[i]);
                }
    
                //filas
                for (int row = 0; row < SIZE; row++) {
                    //numero de fila (va en cuenta regresiva)
                    x = SIZE-row;
                    System.out.print("\n\n" + x + " - ");
    
                    for (int col = 0; col < SIZE; col++) {
                        if (board[row][col] == 1) {
                            System.out.print("1 ");
                        } else {
                            System.out.print("0 ");
                        }
                    }

                    //numero de fila (lado derecho)
                    System.out.print(" - " + x);
                }

                
                //columnas representadas por letras
                System.out.print("\n\n    "+ posiciones[0]);
                for(int i=1; i<this.SIZE; i++) {
                    System.out.print(" "+ posiciones[i]);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }    
    }
}
