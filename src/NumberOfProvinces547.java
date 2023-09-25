import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfProvinces547 {

    public static void main(String[] args) {

        System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }

    private static int findCircleNum(int[][] isConnected) {

        int citiesCount = isConnected.length;
        boolean[] visited = new boolean[citiesCount];
        int provinces =  0;
        for (int i=0; i<citiesCount; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, i, visited);
            }

        }

        return provinces;

    }

    private static void dfs(int[][] isConnected, int i, boolean[] visited) {

        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (int currentCityTraverser = 0; currentCityTraverser< isConnected.length; currentCityTraverser++) {
            if (isConnected[i][currentCityTraverser] == 1) {
                dfs(isConnected, currentCityTraverser, visited);
            }
        }

    }
}
