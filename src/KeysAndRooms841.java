import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class KeysAndRooms841 {

    public static void main(String[] args) {

        System.out.println(canVisitAllRooms(Arrays.stream(new int[][]{{1,3}, {3,0,1}, {2}, {0}})
                                                  .map(arr -> Arrays.stream(arr).boxed().collect(Collectors.toList()))
                                                  .collect(Collectors.toList())));

    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visitedRooms = new boolean[rooms.size()];

        visitedRooms[0] = true;
        dfs(rooms, 0, visitedRooms);

        for (boolean visited : visitedRooms) {
            if (!visited) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int currentRoom, boolean[] visitedRooms) {

        visitedRooms[currentRoom] = true;
       for(int keyToRoom : rooms.get(currentRoom)) {
           if (!visitedRooms[keyToRoom]) {
               dfs(rooms, keyToRoom, visitedRooms);
           }
       }

    }

}
