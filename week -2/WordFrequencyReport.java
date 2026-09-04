import java.util.*;

public class WordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        feedback = feedback.toLowerCase();

        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {

            boolean stopWord = false;

            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    stopWord = true;
                    break;
                }
            }

            if (!stopWord) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<String> wordsList = new ArrayList<>(map.keySet());

        wordsList.sort((a, b) -> map.get(b) - map.get(a));

        for (String word : wordsList) {
            System.out.println(word + ": " + map.get(word));
        }
    }

    public static void main(String[] args) {

        String feedback = "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}