import java.util.*;

class Solution {
    static final int SIZE = 50;
    String[][] table = new String[SIZE][SIZE];
    int[][] parent = new int[SIZE][SIZE];
    
    int find(int row, int col) {
        int pos = row * SIZE + col;
        
        if (parent[row][col] == pos) 
            return pos;
        
        return parent[row][col] = find(parent[row][col] / SIZE, parent[row][col] % SIZE);
    }

    void merge(int row1, int col1, int row2, int col2) {
        int root1 = find(row1, col1);
        int root2 = find(row2, col2);
        if (root1 != root2) {
            int root1Row = root1 / SIZE;
            int root1Col = root1 % SIZE;
            int root2Row = root2 / SIZE;
            int root2Col = root2 % SIZE;

            if (table[root1Row][root1Col] == null && table[root2Row][root2Col] != null) {
                parent[root1Row][root1Col] = root2;
            } else {
                parent[root2Row][root2Col] = root1;
            }
        }
    }

    void unmerge(int row, int col) {
        int root = find(row, col);
        int rootRow = root / SIZE;
        int rootCol = root % SIZE;
        String value = table[rootRow][rootCol];

        List<int[]> cellsToReset = new ArrayList<>();
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (find(r, c) == root) {
                    cellsToReset.add(new int[]{r, c});
                }
            }
        }

        for (int[] cell : cellsToReset) {
            parent[cell[0]][cell[1]] = cell[0] * SIZE + cell[1];
            table[cell[0]][cell[1]] = null;
        }

        table[row][col] = value;
    }

    public String[] solution(String[] commands) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                parent[row][col] = row * SIZE + col; // 셀의 부모를 자기 자신으로 초기화
            }
        }
        
        List<String> tmpList = new ArrayList<>();

        for (String command : commands) {
            String[] parts = command.split(" ");
            String action = parts[0];

            if (action.equals("UPDATE")) {
                if (parts.length == 4) {
                    int row = Integer.parseInt(parts[1]) - 1;
                    int col = Integer.parseInt(parts[2]) - 1;
                    String value = parts[3];
                    
                    int root = find(row, col);
                    int rootRow = root / SIZE;
                    int rootCol = root % SIZE;
                    
                    table[rootRow][rootCol] = value;
                } else if (parts.length == 3) {
                    String value1 = parts[1];
                    String value2 = parts[2];
                    
                    for (int row = 0; row < SIZE; row++) {
                        for (int col = 0; col < SIZE; col++) {
                            if (table[row][col] != null && table[row][col].equals(value1)) {
                                table[row][col] = value2;
                            }
                        }
                    }
                }
            } else if (action.equals("MERGE")) {
                int row1 = Integer.parseInt(parts[1]) - 1;
                int col1 = Integer.parseInt(parts[2]) - 1;
                int row2 = Integer.parseInt(parts[3]) - 1;
                int col2 = Integer.parseInt(parts[4]) - 1;
                merge(row1, col1, row2, col2);
            } else if (action.equals("UNMERGE")) {
                int row = Integer.parseInt(parts[1]) - 1;
                int col = Integer.parseInt(parts[2]) - 1;
                unmerge(row, col);
            } else if (action.equals("PRINT")) {
                int row = Integer.parseInt(parts[1]) - 1;
                int col = Integer.parseInt(parts[2]) - 1;
                
                int root = find(row, col);
                int rootRow = root / SIZE;
                int rootCol = root % SIZE;
                tmpList.add(table[rootRow][rootCol] != null ? table[rootRow][rootCol] : "EMPTY");
            }
        }
        
        String[] answer = new String[tmpList.size()];
        for(int idx = 0; idx < tmpList.size(); idx++) {
            answer[idx] = tmpList.get(idx);
        }

        return answer;
    }
}
