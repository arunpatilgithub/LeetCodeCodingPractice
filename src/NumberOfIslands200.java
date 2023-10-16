public class NumberOfIslands200 {

    public static void main(String[] args) {


        System.out.println(numIslands(new char[][]
                {
                    {'1','1','1','1','0'},
                    {'1','1','0','1','0'},
                    {'1','1','1','0','0'},
                    {'0','0','0','0','0'}
                }));

        System.out.println(numIslands(new char[][]
                {
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                }));

        System.out.println(numIslands(new char[][]
                {
                        {'1','1','1'},
                        {'0','1','0'},
                        {'1','1','1'}
                }));

    }

    private static int numIslands(char[][] grid) {

        int M = grid.length;
        int N = grid[0].length;

        boolean[][] visited = new boolean[M][N];

        int islands = 0;

        for (int r=0; r<M; r++) {
            for (int c=0; c<N; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    dfs(grid, visited, r, c);
                    islands++;
                }
            }
        }

        return islands;

    }

    private static void dfs(char[][] grid, boolean[][] visited, int r, int c) {

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }

        if (grid[r][c] == '0' || visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        dfs(grid, visited, r, c+1);
        dfs(grid, visited, r, c-1);
        dfs(grid, visited, r+1, c);
        dfs(grid, visited, r-1, c);

    }

}
