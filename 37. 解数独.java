/////////////////虽然不对，但仍然记录下自己的想法
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    public void solveSudoku(char[][] board) {
        ArrayList<Set<Character>> row = new ArrayList<>();
        ArrayList<Set<Character>> col = new ArrayList<>();
        ArrayList<Set<Character>> res = new ArrayList<>();
        
        // 初始化行、列和3x3子方格的集合
        for (int i = 0; i < 9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            res.add(new HashSet<>());
        }
        
        // 录入最初的状态
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    res.get(i / 3 * 3 + j / 3).add(board[i][j]);
                }
            }
        }
        
        boolean ifchange = true;
        while (ifchange) {
            ifchange = update(board, row, col, res);
        }
    }
    
    public boolean update(char[][] board, ArrayList<Set<Character>> row, ArrayList<Set<Character>> col, ArrayList<Set<Character>> res) {
        boolean ifchange = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    Set<Character> possibles = new HashSet<>();
                    for (int k = 1; k <= 9; k++) {
                        char c = Character.forDigit(k, 10);
                        if (!row.get(i).contains(c) && !col.get(j).contains(c) && !res.get(i / 3 * 3 + j / 3).contains(c)) {
                            possibles.add(c);
                        }
                    }
                    if (possibles.size() == 1) {
                        board[i][j] = possibles.iterator().next();
                        ifchange = true;
                        row.get(i).add(board[i][j]);
                        col.get(j).add(board[i][j]);
                        res.get(i / 3 * 3 + j / 3).add(board[i][j]);
                    }
                }
            }
        }
        return ifchange;
    }
}
