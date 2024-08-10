class Solution {
    public boolean check(int[][] grid, int row, int col) {
        int[] digits = new int[10];  
        
        for (int checkRow = 0; checkRow < 3; checkRow++) {
            for (int checkCol = 0; checkCol < 3; checkCol++) {
                int num = grid[row + checkRow][col + checkCol];
                if (num < 1 || num > 9 || digits[num] != 0) {
                    return false;
                }

                digits[num] = 1;
            }
        }
        
        int sum1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int sum2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int sum3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];
        int sum4 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int sum5 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int sum6 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];
        int sum7 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sum8 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        
        return sum1 == sum2 && sum2 == sum3 && sum3 == sum4 && sum4 == sum5 &&
               sum5 == sum6 && sum6 == sum7 && sum7 == sum8;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        
        for (int row = 0; row < grid.length - 2; row++) {
            for (int col = 0; col < grid[0].length - 2; col++) {
                if (check(grid, row, col)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
