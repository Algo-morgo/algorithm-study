class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] answer = new int[rows * cols][2];
        int[] deltaRow = {0, 1, 0, -1}; 
        int[] deltaCol = {1, 0, -1, 0}; 
        
        int row = rStart;
        int col = cStart;
        int idx = 0;
        answer[idx++] = new int[]{row, col}; 
        
        int step = 0;
        int direction = 0; 
        while (idx < rows * cols) {
            if (direction == 0 || direction == 2) { 
                step++;
            }

            for (int move = 0; move < step; move++) {
                row += deltaRow[direction];
                col += deltaCol[direction];

                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    answer[idx++] = new int[]{row, col};
                }
            }

            direction = (direction + 1) % 4;
        }
        
        return answer;
    }
}
