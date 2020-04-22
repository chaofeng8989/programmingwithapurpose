public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        char[][] board = new char[m][n];
        int i = 0;
        while (i < k) {
            int random = (int) Math.floor(Math.random() * m * n);
            int x = random / n;
            int y = random % n;
            if (board[x][y] == '*') continue;
            board[x][y] = '*';
            i++;
        }
        int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (board[x][y] == '*') {
                    System.out.print("*  ");
                    continue;
                }
                int all = 0;
                for (int[] e : directions) {
                    int xx = x + e[0], yy = y + e[1];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || board[xx][yy] != '*') continue;
                    all ++;
                }
                board[x][y] = (char) ('0' + all);
                System.out.print(board[x][y] + "  ");
            }
            System.out.println();
        }



    }
}
