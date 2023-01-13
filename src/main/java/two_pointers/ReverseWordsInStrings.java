package two_pointers;

/**
 * Reverse Words in a String
 * <p>
 * Given a sentence, reverse the order of its words without affecting the order of letters within a given word.
 */
public class ReverseWordsInStrings {


    public static void main(String[] args) {
        // Test Case 1: positive scenario
        String sentence = "Hello World";
        String reversed = reverseWords(sentence);
        System.out.println("Test Case 1: Original Sentence: " + sentence);
        System.out.println("Test Case 1: Reversed Sentence: " + reversed);

        // Test Case 2: negative scenario
        String sentence2 = "";
        String reversed2 = reverseWords(sentence2);
        System.out.println("Test Case 2: Original Sentence: " + sentence2);
        System.out.println("Test Case 2: Reversed Sentence: " + reversed2);

    }

    public static String reverseWords(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static String reverseWordsBruteForce(String sentence) {
        // Split the sentence into an array of words
        String[] words = sentence.split("\\s+");
        // Initialize an empty string to hold the reversed sentence
        String reversed = "";
        // Iterate through the array of words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            // Append each word to the reversed string
            reversed += words[i] + " ";
        }
        // remove the last space
        return reversed.trim();
    }

}
