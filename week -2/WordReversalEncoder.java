public class WordReversalEncoder {

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        String result = "";

        for (String word : words) {

            StringBuilder reverse = new StringBuilder(word);
            reverse.reverse();

            result = result + reverse + " ";
        }

        return result;
    }

    public static void main(String[] args) {

        String sentence = "hello club";

        System.out.println(reverseEachWord(sentence));
    }
}
