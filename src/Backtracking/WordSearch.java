package Backtracking;

public class WordSearch {

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j]==word.charAt(0) && ifWordExists(i, j, board, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ifWordExists(int i, int j, char[][] board, int index, String word) {
        int row = board.length;
        int col = board[0].length;

        if (index >= word.length()) {
            return true;
        }
        if (i >= row || j >= col || i<0 || j<0 || board[i][j]!=word.charAt(index)) {
            return false;
        }

        char c = board[i][j];
        board[i][j] = '.';
        for (int[] direction: directions) {
            if (ifWordExists(i+direction[0], j+direction[1], board, index+1, word)) {
                return true;
            }
        }
        board[i][j] = c;
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(wordSearch.exist(board, word));
    }

}
