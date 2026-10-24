class Solution {
    // This will be a BFS.
    public int cutOffTree(List<List<Integer>> forest) {        
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] grid = new int[m][n];
        PriorityQueue<Integer> treeSizes = new PriorityQueue<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                grid[row][col] = forest.get(row).get(col);
                if (grid[row][col] > 1) {
                    treeSizes.offer(grid[row][col]);
                }
            }
        }

        int steps = 0;
        int startRow = 0;
        int startCol = 0;
        while (! treeSizes.isEmpty()) {
            int[] treeSteps = bfs(grid, startRow, startCol, treeSizes.poll());
            if (treeSteps[2] == -1) {
                return -1;
            } else {
                steps += treeSteps[2];
                startRow = treeSteps[0];
                startCol = treeSteps[1];
            }
        }

        return steps;
    }

    private int[] bfs(int[][] grid, int startRow, int startCol, int tgtHeight) {    
        if (grid[startRow][startCol] == tgtHeight) {
            return new int[] {startRow, startCol, 0};
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Deque<int[]> nextMove = new LinkedList<>();
        nextMoves(startRow, startCol, visited, grid, nextMove);
        int ct = 0;
        while (! nextMove.isEmpty()) {
            int moveCt = nextMove.size();
            ct ++;
            for (int i = 0; i < moveCt; i++) {
                int[] move = nextMove.poll();
                int row = move[0];
                int col = move[1];
                if (grid[row][col] == tgtHeight) {
                    return new int[] {row, col, ct};
                }
                nextMoves(row, col, visited, grid, nextMove);
            }
        }
        return new int[] {-1, -1, -1};
    }

    private void nextMoves(int row, int col, boolean[][] visited, int[][] grid, Deque<int[]> q) {
        int m = visited.length;
        int n = visited[0].length;
        if (row < m-1 && !visited[row+1][col] && grid[row+1][col] != 0) {
            q.offer(new int[] {row+1, col});
            visited[row+1][col] = true;
        }
        if (row > 0 && !visited[row-1][col] && grid[row-1][col] != 0) {
            q.offer(new int[] {row-1, col});
            visited[row-1][col] = true;
        }
        if (col < n-1 && !visited[row][col+1] && grid[row][col+1] != 0) {
            q.offer(new int[] {row, col+1});
            visited[row][col+1] = true;
        }
        if (col > 0 && !visited[row][col-1] && grid[row][col-1] != 0) {
            q.offer(new int[] {row, col-1});
            visited[row][col-1] = true;
        }
    }
}