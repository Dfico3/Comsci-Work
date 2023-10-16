
import java.util.Arrays;

public class Frequencies {
    public static void main(String[] args) {
        // Array of words
        String[] allWords = {
                "The", "Man", "Went", "On", "A", "Hike", "With", "His", "Dog", "And",
                "On", "This", "Hike", "The", "Man", "And", "The", "Dog", "Got", "To",
                "The", "Top", "And", "Then", "Went", "Back", "Down"
        };

        // Initialize the arrays so that they store the unique words and their frequencies
        int arrayLength = allWords.length;
        String[] uniqueStr = new String[arrayLength];
        int[] frequencies = new int[arrayLength];
        int uniqueWordCount = 0;

        // Calculate the frequency of the words and store the unique words(if the word hasn't been added to the array yet)
        for (int i = 0; i < arrayLength; i++) {
            boolean repetition = false;
            String current = allWords[i];

            // Checks to see if the word is already inside the uniqueStr array.
            for (int j = 0; j < uniqueWordCount; j++) {
                if (uniqueStr[j] != null && uniqueStr[j].equals(current)) {
                    // If there is a prior occurrence of the word then it will add the frequency to frequencies array.
                    frequencies[j]++;
                    repetition = true;
                    break;
                }
            }

            if (!repetition) {
                // If the word is not found within the uniqueStr array, then add the word to the array and declare its frequency as 1 in the frequencies array
                uniqueStr[uniqueWordCount] = current;
                frequencies[uniqueWordCount] = 1;
                uniqueWordCount++;
            }
        }

        // Then sort the unique words in descending order by frequency. For the instances of equal frequencies, it would then be sorted by alphabetic order(again descending)
        for (int i = 0; i < uniqueWordCount - 1; i++) {
            for (int j = 0; j < uniqueWordCount - i - 1; j++) {
                if (frequencies[j] < frequencies[j + 1] ||
                        (frequencies[j] == frequencies[j + 1] && uniqueStr[j].compareTo(uniqueStr[j + 1]) > 0)) {

                    // Repositions the words and frequencies in the array to fall into the order defined above
                    int specificFreq = frequencies[j];
                    frequencies[j] = frequencies[j + 1];
                    frequencies[j + 1] = specificFreq;

                    String specificWord = uniqueStr[j];
                    uniqueStr[j] = uniqueStr[j + 1];
                    uniqueStr[j + 1] = specificWord;
                }
            }
        }

        // Prints the word and the corresponding frequency for both the arrays.
        for (int i = 0; i < uniqueWordCount; i++) {
            String printStr = uniqueStr[i];
            int printFreq = frequencies[i];
            System.out.println(printStr + " (" + printFreq + ")");
        }
    }
}
