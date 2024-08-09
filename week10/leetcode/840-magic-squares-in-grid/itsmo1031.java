class Solution {
	public int numMagicSquaresInside(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;

		if (height < 3 || width < 3) {
			return 0;
		}

		int answer = 0;

		for (int i = 0; i <= height - 3; i++) {
			for (int j = 0; j <= width - 3; j++) {
				if (check(grid, i, j)) {
					answer += 1;
				}
			}
		}

		return answer;
	}

	boolean check(int[][] grid, int rowStart, int colStart) {
		boolean[] checked = new boolean[10];

		for (int r = rowStart; r < rowStart + 3; r++) {
			int rowSum = 0;
			for (int c = colStart; c < colStart + 3; c++) {
				if (grid[r][c] < 1 || grid[r][c] > 9) {
					return false;
				}
				if (checked[grid[r][c]]) {
					return false;
				}
				checked[grid[r][c]] = true;
				rowSum += grid[r][c];
			}
			if (rowSum != 15) {
				return false;
			}
		}

		int digSum1 = 0;
		int digSum2 = 0;

		for (int i = 0; i < 3; i++) {
			digSum1 += grid[rowStart + i][colStart + i];
			digSum2 += grid[rowStart + i][colStart + 2 - i];
		}

		if (digSum1 != 15 || digSum2 != 15) {
			return false;
		}

		for (int c = colStart; c < colStart + 3; c++) {
			int colSum = 0;
			for (int r = rowStart; r < rowStart + 3; r++) {
				colSum += grid[r][c];
			}
			if (colSum != 15) {
				return false;
			}
		}

		return true;
	}
}
