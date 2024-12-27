class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        char board[][] = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        solve(0, board, solution, n);
        return solution;
    }

    private void solve(int row, char[][] board, List<List<String>> solution, int n){
        if(row == n){
            solution.add(constructBoard(board));
            return;
        }

        for(int col = 0; col < n; col++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q';
                solve(row + 1, board, solution, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char board[][], int row, int col, int n){
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q') return false;
        }

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
             if(board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> constructBoard(char[][] board){
        List<String> result = new ArrayList<>();
        for(char[] row : board){
            result.add(new String(row));
        }
        return result;
    }
}