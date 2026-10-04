class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];

        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }
        reveal(board, r, c);
        return board;
    }
    private void reveal(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
                || board[r][c] != 'E') {
            return;
        }

        int mines = countMines(board, r, c);

        if (mines > 0) {
            board[r][c] = (char) ('0' + mines);
            return;
        }
        board[r][c] = 'B';
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr != 0 || dc != 0) {
                    reveal(board, r + dr, c + dc);
                }
            }
        }
    }
    private int countMines(char[][] board, int r, int c) {
        int count = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = r + dr;
                int nc = c + dc;

                if (nr >= 0 && nr < board.length &&
                    nc >= 0 && nc < board[0].length &&
                    board[nr][nc] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}
