import java.util.*;

public class RandomizedSet {

    List<Integer> intPositions;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        intPositions = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean retVal = false;

        if (!map.containsKey(val)) {
            int arrPos = intPositions.size();
            map.put(val,arrPos);
            intPositions.add(val);
            retVal = true;
        }

        return retVal;

    }

    public boolean remove(int val) {

        boolean retVal = false;
        if (map.containsKey(val)) {

            int arrPos = map.get(val);
            int lastElementPosInArray = intPositions.size()-1;

            intPositions.set(arrPos, intPositions.get(lastElementPosInArray));
            map.put(intPositions.get(lastElementPosInArray), arrPos);

            map.remove(val);
            intPositions.remove(lastElementPosInArray);

            retVal = true;
        }

        return retVal;

    }

    public int getRandom() {


        Random random = new Random();
        int randomIntPos = random.nextInt(intPositions.size());

        return intPositions.get(randomIntPos);

    }

}
