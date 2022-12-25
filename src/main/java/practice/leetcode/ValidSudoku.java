package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public static void main(String[] args) {
        test(new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
        test(new char[][] {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
        test(new char[][] {{'5','3','.','3','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
//      ❌ 👇🏽
        test(new char[][] {{'.','.','.','9','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','3','.','.','.','.','.','1'},{'.','.','.','.','.','.','.','.','.'},{'1','.','.','.','.','.','3','.','.'},{'.','.','.','.','2','.','6','.','.'},{'.','9','.','.','.','.','.','7','.'},{'.','.','.','.','.','.','.','.','.'},{'8','.','.','8','.','.','.','.','.'}});
    }

    private static void test(char[][] board) {
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (areValidRows(board))
            if (areValidColumns(board))
                return areValidBoxes(board);
        return false;
    }

    private static boolean areValidColumns(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < board[i].length; j++) {
                if (board[j][i] != '.') {
                    if (!set.add(board[j][i]))
                        return false;
                }
            }
        }
        return true;
    }

    private static boolean areValidBoxes(char[][] board) {
        for (int i = 0; i < board.length; i+= 3) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < board[i].length; j += 3) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean areValidRows(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for(int j= i; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }
}
