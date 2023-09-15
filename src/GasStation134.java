public class GasStation134 {

    public static void main(String[] args) {

        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        //System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {


        int gasTotal = 0;
        int costTotal = 0;

        for (int k=0; k<gas.length; k++) {
            gasTotal = gasTotal + gas[k];
            costTotal = costTotal + cost[k];
        }

        if (gasTotal < costTotal) {
            return -1;
        }

        int remainsGas = 0, start = 0;

        for(int i = 0 ; i < gas.length; i++){

            remainsGas = remainsGas +gas[i] - cost[i];

            if(remainsGas < 0 ){
                start = i+1;
                remainsGas = 0;
            }
        }
        return start;
    }

}
