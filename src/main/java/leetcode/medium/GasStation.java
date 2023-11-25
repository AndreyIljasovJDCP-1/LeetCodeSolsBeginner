package leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/gas-station/description/">134. Gas Station</a>
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int totalTank = 0;
        int res = 0;
        for (int i = 0; i < gas.length;i++ ) {
            tank = tank + gas[i] - cost[i];
            totalTank = totalTank + gas[i] - cost[i];
            if(tank < 0) {
                tank = 0;
                res = i + 1;
            }
        }
        if(totalTank < 0) return -1;

        return res;
    }
}
