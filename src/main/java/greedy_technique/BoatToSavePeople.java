package greedy_technique;

import java.util.Arrays;

//Boats to Save People

/**
 * Statement
 A big ship with numerous passengers is sinking, and there is a need to evacuate these people with the minimum number of life-saving boats. Each boat can carry, at most, two persons however, the weight of the people cannot exceed the carrying weight limit of the boat.
 We are given an array, people, where people[i] is the weight of the i'th person, and an infinite number of boats, where each boat can carry a maximum weight, limit. Each boat carries, at most, two people at the same time. This is provided that the sum of the weight of these people is under or equal to the weight limit.
 You need to return the minimum number of boats to carry all persons in the array.

 Constraints:
 1≤ people.length ≤ 5×10^3
 1≤ people[i] ≤ limit ≤ 3×10^3

 Example 1:
 Input: people = [1,2], limit = 3
 Output: 1
 Explanation: The boat can carry both people with a total weight of 3.

 Example 2:
 Input: people = [3,2,2,1], limit = 3
 Output: 3
 Explanation: The boats can carry people with weights [1, 2], [2], and [3].
 */
public class BoatToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);    // sort the array
        int n = people.length;  // get the length of the array

        int left = 0;   // initialize left to 0. left is used to store the start index
        int right = n - 1;  // initialize right to n - 1. right is used to store the end index
        int boats = 0;  // initialize boats to 0. boats is used to store the number of boats

        while (left <= right) {     // iterate through the array
            if (people[left] + people[right] <= limit) {    // if the sum of the weights is less than or equal to the limit, then increment the left index
                left++;
            }

            right--;    // decrement the right index
            boats++;    // increment the boats
        }

        return boats;   // return the number of boats
    }

    public static void main(String[] args) {
        BoatToSavePeople boatToSavePeople = new BoatToSavePeople();
        System.out.println(boatToSavePeople.numRescueBoats(new int[]{1, 2}, 3));    // 1
        System.out.println(boatToSavePeople.numRescueBoats(new int[]{3, 2, 2, 1}, 3));    // 3
        System.out.println(boatToSavePeople.numRescueBoats(new int[]{3, 5, 3, 4}, 5));    // 4
    }
}

// Time Complexity: O(n log n) - n is the length of the array
// Space Complexity: O(1) - constant space is used
