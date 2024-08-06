import java.util.*;

class Solution {
    int size;
    int[][] map;
    int[] deltaRow = {-1, 1, 0, 0};
    int[] deltaCol = {0, 0, -1, 1};
    int answer;

    void bfs() {
        boolean[][][] visited = new boolean[2][size][size];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 1, 0, 0}); // {row1, col1, row2, col2, status, moveCnt}
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row1 = current[0], col1 = current[1];
            int row2 = current[2], col2 = current[3];
            int status = current[4], moveCnt = current[5];

            if ((row1 == size - 1 && col1 == size - 1) || (row2 == size - 1 && col2 == size - 1)) {
                answer = moveCnt;
                return;
            }

            for (int deltaIdx = 0; deltaIdx < 4; deltaIdx++) {
                int nextRow1 = row1 + deltaRow[deltaIdx];
                int nextCol1 = col1 + deltaCol[deltaIdx];
                int nextRow2 = row2 + deltaRow[deltaIdx];
                int nextCol2 = col2 + deltaCol[deltaIdx];

                if (isValid(nextRow1, nextCol1, nextRow2, nextCol2)) {
                    if (!visited[status][nextRow1][nextCol1] || !visited[status][nextRow2][nextCol2]) {
                        visited[status][nextRow1][nextCol1] = true;
                        visited[status][nextRow2][nextCol2] = true;
                        queue.offer(new int[]{nextRow1, nextCol1, nextRow2, nextCol2, status, moveCnt + 1});
                    }
                }
            }

            if (status == 0) { // 가로에서 세로로 회전
                if (row1 > 0 && row2 > 0 && map[row1 - 1][col1] == 0 && map[row2 - 1][col2] == 0) {
                    if (!visited[1][row1 - 1][col1] || !visited[1][row2 - 1][col2]) {
                        visited[1][row1 - 1][col1] = true;
                        visited[1][row2 - 1][col2] = true;
                        queue.offer(new int[]{row1 - 1, col1, row1, col1, 1, moveCnt + 1});
                        queue.offer(new int[]{row2 - 1, col2, row2, col2, 1, moveCnt + 1});
                    }
                }
                if (row1 < size - 1 && row2 < size - 1 && map[row1 + 1][col1] == 0 && map[row2 + 1][col2] == 0) {
                    if (!visited[1][row1][col1] || !visited[1][row2][col2]) {
                        visited[1][row1][col1] = true;
                        visited[1][row2][col2] = true;
                        queue.offer(new int[]{row1, col1, row1 + 1, col1, 1, moveCnt + 1});
                        queue.offer(new int[]{row2, col2, row2 + 1, col2, 1, moveCnt + 1});
                    }
                }
            } else { // 세로에서 가로로 회전
                if (col1 > 0 && col2 > 0 && map[row1][col1 - 1] == 0 && map[row2][col2 - 1] == 0) {
                    if (!visited[0][row1][col1 - 1] || !visited[0][row2][col2 - 1]) {
                        visited[0][row1][col1 - 1] = true;
                        visited[0][row2][col2 - 1] = true;
                        queue.offer(new int[]{row1, col1 - 1, row1, col1, 0, moveCnt + 1});
                        queue.offer(new int[]{row2, col2 - 1, row2, col2, 0, moveCnt + 1});
                    }
                }
                if (col1 < size - 1 && col2 < size - 1 && map[row1][col1 + 1] == 0 && map[row2][col2 + 1] == 0) {
                    if (!visited[0][row1][col1] || !visited[0][row2][col2]) {
                        visited[0][row1][col1] = true;
                        visited[0][row2][col2] = true;
                        queue.offer(new int[]{row1, col1, row1, col1 + 1, 0, moveCnt + 1});
                        queue.offer(new int[]{row2, col2, row2, col2 + 1, 0, moveCnt + 1});
                    }
                }
            }
        }
    }

    boolean isValid(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row1 >= size || col1 < 0 || col1 >= size || row2 < 0 || row2 >= size || col2 < 0 || col2 >= size 
            || map[row1][col1] == 1 || map[row2][col2] == 1)
            return false;
        
        return true;
    }

    public int solution(int[][] board) {
        size = board.length;
        map = board;

        answer = 0;
        bfs();

        return answer;
    }
}
