class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0);
        int[][] records = new int[board.length][board[0].length];
        int[][] directions = new int[][]{{-1,-1}, {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0 ;j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    for(int k = 0; k < directions.length; k++) {
                        int i2 = i + directions[k][0];
                        int j2 = j + directions[k][1];
                        if(i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                            if(board[i2][j2] == 1)
                            records[i2][j2]+=1;
                        }
                    }
                }
            }
        }
         for(int i = 0; i < board.length; i++) {
            for(int j = 0 ;j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    if(records[i][j] < 2 || records[i][j] > 3) board[i][j] = 0;
                }else {
                    if(records[i][j] == 3) board[i][j] = 1;
                }
            }
         }
    }
    
//     public void gameOfLife(int[][] board) {
//         if (board == null || board.length == 0) return;
//         int m = board.length, n = board[0].length;

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 int lives = liveNeighbors(board, m, n, i, j);
//                 // In the beginning, every 2nd bit is 0;
//                 // So we only need to care about when will the 2nd bit become 1.
//                 if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
//                     board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
//                 }
//                 if (board[i][j] == 0 && lives == 3) {
//                     board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
//                 }
//             }
//         }

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 board[i][j] >>= 1;  // Get the 2nd state.
//             }
//         }
//     }

//     public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
//         int lives = 0;
//         for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
//             for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
//                 lives += board[x][y] & 1;
//             }
//         }
//         lives -= board[i][j] & 1;
//         return lives;
//     }
}
