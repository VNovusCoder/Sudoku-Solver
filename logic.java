

public class logic {

    static int[][] board = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    static Boolean isSafe(int[][] board ,  int row , int col , int num ){

        // row
        for(int i =0 ; i<board[0].length  ; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        // col
        for(int i = 0 ; i< board.length ; i++){
            if(board[i][col] == num){
                return false;
            }
        }
        
        int st = (row/3)*3;
        int end = st + 3;


        int stc = (col/3)*3;
        int endc = stc + 3;

        for(int i = st ; i<end ; i++){
            for(int j = stc ; j<endc ; j++){
                if(board[i][j] == num){
                    return false;

                }
            }
        }
        // grid

        return true;    
    }

    static boolean solve(int[][] board , int row , int col ){
 

        if ( row == 9){
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;

        if(nextCol == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        if(board[row][col] != 0){
            return solve(board, nextRow, nextCol);
        }

        for(int i =1 ; i<=9 ; i++){

            if(isSafe(board, row, col, i)){
                board[row][col] = i;
                
                if(solve(board , nextRow , nextCol)){
                
                    return true;
                    
                }
                board[row][col] = 0;
            }            
        }
        
        return false;
    } 


    static void printBoard(int[][] board) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");

                if ((j + 1) % 3 == 0 && j < 8) {
                    System.out.print("| ");
                }
            }

            System.out.println();

            if ((i + 1) % 3 == 0 && i < 8) {
                System.out.println("------+-------+------");
            }
        }
    }
    public static void main(String[] args) {

        solve(board ,0 , 0);
        printBoard(board);
    }
}
