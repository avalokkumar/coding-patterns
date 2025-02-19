package greedy_technique.greedy_technique;

//Gas Station

/**There are nn gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 We have a car with an unlimited gas tank, and it costs cost[i] of gas to travel from the ith station to the next (i+1)th station. We begin the journey with an empty tank at one of the gas stations.
 Find the index of the gas station in the integer array gas such that if we start from that index we may return to the same index by traversing through all the elements, collecting gas[i] and consuming cost[i].
 • If it is not possible, return -1.
 • If there exists such index, it is guaranteed to be unique.

 Constraints:
 • gas.length == cost.length
 • 1 ≤ gas.length, cost.length ≤ 10^3
 • 0 ≤ gas[i], cost[i] ≤10^3

 Example 1:
 Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 Output: 3
 Explanation: The car can start from gas station 3 and travel to the next gas station 4, 0, 1, and 2. The car will return to gas station 3 after consuming all the gas.

 Example 2:
 Input: gas = [2,3,4], cost = [3,4,3]
 Output: -1
 Explanation: The car cannot return to the starting gas station.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;    // get the length of the array
        int total = 0;  // initialize total to 0. total is used to store the total gas
        int tank = 0;   // initialize tank to 0. tank is used to store the gas in the tank
        int start = 0;  // initialize start to 0. start is used to store the starting index

        for (int i = 0; i < n; i++) {   // iterate through the array
            total += gas[i] - cost[i];  // calculate the total gas

            tank += gas[i] - cost[i];   // calculate the gas in the tank

            if (tank < 0) {     // if the gas in the tank is less than 0, then update the tank and start index
                tank = 0;
                start = i + 1;
            }
        }

        return total >= 0 ? start : -1;     // return the start index if the total gas is greater than or equal to 0, otherwise return -1
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));    // 3
        System.out.println(gasStation.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));    // -1
        System.out.println(gasStation.canCompleteCircuit(new int[]{3, 5, 3, 4}, new int[]{5, 4, 3, 3}));    // 2
    }
}

// Time Complexity: O(n) - n is the length of the array
// Space Complexity: O(1) - no extra space used
