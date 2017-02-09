//130. Surrounded Regions

public class SurroundedRegions {
    public void solve(char[][] board) {
        
        if(board==null || board.length==0) {
            return;
        }
        
        int rows=board.length, cols=board[0].length;
        
        //first column & last column
        for(int i=0; i<rows; i++) {
            
            if(board[i][0] == 'O') {
                DFS(board, i, 0);
            }
            if(cols>0 && board[i][cols-1]=='O') {
                DFS(board, i, cols-1);
            }
        }   
    
        //first row & last row
        for(int j=0; j<cols; j++) {
            
            if(board[0][j] == 'O') {
                DFS(board, 0, j);
            }
            if(rows>0 && board[rows-1][j] == 'O') {
                DFS(board, rows-1, j);
            }
        }
        
        for(int i=0; i<rows; i++) {
            
            for(int j=0; j<cols; j++) {
                
                if(board[i][j]=='#') {
                    board[i][j] ='O';
                } 
                else if(board[i][j] == 'O'){
                    board[i][j]='X';
                }
            }
        }
        
        return;
    }
    
    void DFS(char[][] board, int i, int j) {
        
        //System.out.println(i+","+j);
        //if i & j are out of boundaries
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) {
            return;
        }
        
        //check if the cell is already visited, if so return
        if(board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        
        board[i][j]='#';
        
        //left
        if(j > 1 && board[i][j-1] == 'O') {
            DFS(board, i, j-1); 
        }
        
        //right
        if(j+2<board[0].length && board[i][j+1] == 'O') {
            DFS(board, i, j+1);
        }
        
        //top
        if(i>1 && board[i-1][j]=='O') {
            DFS(board, i-1, j);
        }
        
        //bottom
        if(i+2<board.length && board[i+1][j] == 'O') {
            DFS(board, i+1, j);
        }
        
        return;
    }
}
