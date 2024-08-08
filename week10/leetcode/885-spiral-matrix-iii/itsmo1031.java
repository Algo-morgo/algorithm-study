class Solution {
	static int[][] DIR = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		int[][] answer = new int[rows * cols][2];

		int dirIdx = 0;
		int idx = 0;
		int steps = 1;

		int r = rStart, c = cStart;

		answer[idx][0] = r;
		answer[idx++][1] = c;

		while (idx < rows * cols) {
			for (int i = 0; i < 2; i++) {
				for (int s = 0; s < steps; s++) {
					r += DIR[dirIdx][0];
					c += DIR[dirIdx][1];

					if (0 <= r && r < rows && 0 <= c && c < cols) {
						answer[idx][0] = r;
						answer[idx++][1] = c;
					}
				}
				dirIdx = (dirIdx + 1) % 4;
			}
			steps++;
		}

		return answer;
	}
}
