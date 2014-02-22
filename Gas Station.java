public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = gas.length;
        int curStart = 0, curGas = 0;
        for (int i = 0; i < n; i++) {
            curGas += gas[i] - cost[i];
            curStart = curGas < 0 && gas[i] - cost[i] < 0 ? i+1 : curStart;
        }
        if (curGas >= 0)
            return curStart;
        else return -1;
    }
}