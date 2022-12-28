package practice.leetcode;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public static void main(String[] args) {
        test(new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
        test(new char[][] {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
        test(new char[][] {{'5','3','.','3','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});
        test(new char[][] {{'.','.','.','9','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','3','.','.','.','.','.','1'},{'.','.','.','.','.','.','.','.','.'},{'1','.','.','.','.','.','3','.','.'},{'.','.','.','.','2','.','6','.','.'},{'.','9','.','.','.','.','.','7','.'},{'.','.','.','.','.','.','.','.','.'},{'8','.','.','8','.','.','.','.','.'}});
        test(new char[][] {{'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}});
    }

    private static void test(char[][] board) {
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        printBoard(board);
        if (areValidRows(board))
            if (areValidColumns(board))
                return areValidBoxes(board);
        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < board.length; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }

    private static boolean areValidColumns(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
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
            for (int j = 0; j < board[i].length; j += 3) {
                boolean isBlockValid = isBlockValid(i, j, board);
                if (!isBlockValid) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBlockValid(int iIdx, int jIdx, char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = iIdx; i < 3 + iIdx; i++) {
            for (int j = jIdx; j < 3 + jIdx; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }

    private static boolean areValidRows(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }
}
