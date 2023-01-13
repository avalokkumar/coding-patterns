package sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Repeated DNA Sequences
 *
 */
public class RepeatedDNASequence {

    public static void main(String[] args) {
        // Test Case 1:
        String s = "ACGAATTCCGGGTTACGA";
        int k = 3;
        Set<String> result = repeatedDNASequences(s, k);
        System.out.println("Test Case 1: Repeated DNA sequences: " + result);

        // Test Case 2:
        String s2 = "ATGCATGC";
        int k2 = 4;
        Set<String> result2 = repeatedDNASequences(s2, k2);
        System.out.println("Test Case 2: Repeated DNA sequences: " + result2);
    }

    /**
     * we are using a HashSet to store the repeated DNA sequences, so we only have unique repeated DNA sequences. We also use a HashMap to store the count of each substring of length k in the given string. By iterating over the string and substring of length k and adding them to map. If the count of a substring becomes 2, it is added to the result set. This solution has O(n) time complexity and O(n) space complexity as it uses a HashMap to store the count of each substring.
     * @param s
     * @param k
     * @return
     */
    public static Set<String> repeatedDNASequences(String s, int k) {
        // create a set to store the repeated DNA sequences
        Set<String> result = new HashSet<>();
        // create a map to store the count of each substring of length k
        Map<String, Integer> map = new HashMap<>();
        // iterate over the string
        for (int i = 0; i <= s.length() - k; i++) {
            // get the substring of length k
            String sub = s.substring(i, i + k);
            // add the substring to the map and increase its count
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            // if the count of the substring becomes 2, add it to the result set
            if (map.get(sub) == 2) {
                result.add(sub);
            }
        }
        return result;
    }

}
