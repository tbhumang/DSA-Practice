class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return build(grid, 0, 0, n);
    }
    private Node build(int[][] grid, int row, int col, int size){
        boolean same = true;
        int value = grid[row][col];
        for(int i = row; i < row + size; i++){
            for(int j = col; j < col +  size; j++){
                if(grid[i][j] != value){
                    same = false;
                    break;
                }
        }
        if(!same){
            break;
        }
    }
    if(same) {
        return new Node(value == 1, true);
    }
    int half = size / 2;

    Node topLeft = build(grid, row, col, half);
    Node topRight = build(grid, row, col + half, half);
    Node bottomLeft = build(grid, row + half, col, half);
    Node bottomRight = build(grid, row + half, col + half, half);
    return new Node(
        true,
        false,
        topLeft,
        topRight,
        bottomLeft,
        bottomRight
    );
}
}