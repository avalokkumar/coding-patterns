package top_k_elements;

import java.util.*;

/**
 * Reorganize String
 * Given a string, rearrange it so that any two adjacent characters are not the same.
 * If such a reorganization of the characters is possible, output any possible valid arrangement. Otherwise, return an empty string.Ω
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        // Create a hashmap to store the frequency of each character in the input string.
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue that sorts the characters based on their frequency.
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> charFreq.get(b) - charFreq.get(a));
        pq.addAll(charFreq.keySet());

        // Create a string builder to build the output string.
        StringBuilder sb = new StringBuilder();

        // Alternately add the most frequent character and the second most frequent character to the output string.
        while (pq.size() > 1) {
            char first = pq.poll();
            char second = pq.poll();
            sb.append(first);
            sb.append(second);
            charFreq.put(first, charFreq.get(first) - 1);
            charFreq.put(second, charFreq.get(second) - 1);
            if (charFreq.get(first) > 0) {
                pq.offer(first);
            }
            if (charFreq.get(second) > 0) {
                pq.offer(second);
            }
        }

        // If there is only one character left in the priority queue, add it to the output string.
        if (!pq.isEmpty()) {
            char last = pq.poll();
            if (charFreq.get(last) > 1) {
                return "";
            }
            sb.append(last);
        }

        // Return an empty string if the length of the output string is less than the length of the input string.
        return sb.length() == s.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        ReorganizeString obj = new ReorganizeString();

        String s1 = "aab";
        String s2 = "aaab";
        String s3 = "abbabbaaab";
        String s4 = "abcdefg";
        String s5 = "aaaaaaabbbbcccc";

        System.out.println(obj.reorganizeString(s1)); // "aba"
        System.out.println(obj.reorganizeString(s2)); // ""
        System.out.println(obj.reorganizeString(s3)); // "abababababa"
        System.out.println(obj.reorganizeString(s4)); // "abcdefg"
        System.out.println(obj.reorganizeString(s5)); // "abacabcacabcabc"
    }

}
