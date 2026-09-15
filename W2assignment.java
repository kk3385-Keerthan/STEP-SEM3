import java.util.*;

public class W2assignment {

    // =====================================================
    // 1. ATM PIN LENGTH VALIDATOR
    // =====================================================

    static void checkPinLength(String pin) {

        if (pin.length() != 4) {
            System.out.println(
                "Invalid PIN — must be exactly 4 digits."
            );
        } else {
            System.out.println("PIN length OK.");
        }
    }


    // =====================================================
    // 2. WORD REVERSAL ENCODER
    // =====================================================

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder reversed =
                new StringBuilder(words[i]);

            reversed.reverse();

            result.append(reversed);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }


    // =====================================================
    // 3. PRODUCT INVENTORY CSV PARSER
    // =====================================================

    static void parseInventoryRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {

            System.out.println("Invalid Record");
            return;
        }

        System.out.println(
            "Product: " + fields[0]
            + " | SKU: " + fields[1]
            + " | Qty: " + fields[2]
        );
    }


    // =====================================================
    // 4. LIBRARY ISBN NORMALIZER & VALIDATOR
    // =====================================================

    static String normalizeCode(String raw) {

        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        String publisherCode =
            code.substring(0, 3).toUpperCase();

        String remaining =
            code.substring(3);

        return publisherCode + remaining;
    }


    static String validateAndFormat(String code) {

        // Check total length
        if (code.length() != 13) {

            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {

                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {

                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode =
            code.substring(0, 3);

        String year =
            code.substring(3, 7);

        String catalog =
            code.substring(7, 13);

        StringBuilder result =
            new StringBuilder();

        result.append("[")
              .append(publisherCode)
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);

        return result.toString();
    }


    // =====================================================
    // 5. STOP-WORD-FILTERED WORD FREQUENCY REPORT
    // =====================================================

    static void printFilteredWordFrequency(String feedback) {

        // Stop words
        String[] stopWords = {
            "the", "was", "and", "a",
            "is", "of", "in"
        };

        // Convert to lowercase
        String cleanedText =
            feedback.toLowerCase();

        // Remove punctuation
        cleanedText =
            cleanedText.replace(".", "");

        cleanedText =
            cleanedText.replace(",", "");

        // Split into words
        String[] words =
            cleanedText.split("\\s+");

        // Store word frequencies
        HashMap<String, Integer> frequency =
            new HashMap<>();

        for (String word : words) {

            // Skip empty words
            if (word.length() == 0) {
                continue;
            }

            // Check whether word is a stop word
            boolean isStopWord = false;

            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (isStopWord) {
                continue;
            }

            frequency.put(
                word,
                frequency.getOrDefault(word, 0) + 1
            );
        }

        // Convert map entries to list
        ArrayList<Map.Entry<String, Integer>> entries =
            new ArrayList<>(frequency.entrySet());

        // Sort by frequency in descending order
        entries.sort(
            (a, b) -> b.getValue() - a.getValue()
        );

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }


    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       W2 ASSIGNMENT - WEEK 2");
        System.out.println("========================================");


        // =================================================
        // QUESTION 1
        // =================================================

        System.out.println("\n===== QUESTION 1 =====");

        String pin = "4820";

        System.out.println("PIN: " + pin);

        checkPinLength(pin);


        // =================================================
        // QUESTION 2
        // =================================================

        System.out.println("\n===== QUESTION 2 =====");

        String sentence = "hello club";

        System.out.println("Original: " + sentence);

        System.out.println(
            "Reversed: " + reverseEachWord(sentence)
        );


        // =================================================
        // QUESTION 3
        // =================================================

        System.out.println("\n===== QUESTION 3 =====");

        String csvLine =
            "Wireless Mouse,WM-2201,150";

        System.out.println("CSV: " + csvLine);

        parseInventoryRecord(csvLine);


        // =================================================
        // QUESTION 4
        // =================================================

        System.out.println("\n===== QUESTION 4 =====");

        String rawCode =
            " pen2026004251 ";

        System.out.println(
            "Raw Code: " + rawCode
        );

        String normalizedCode =
            normalizeCode(rawCode);

        System.out.println(
            "Normalized Code: " + normalizedCode
        );

        System.out.println(
            validateAndFormat(normalizedCode)
        );


        // =================================================
        // QUESTION 5
        // =================================================

        System.out.println("\n===== QUESTION 5 =====");

        String feedback =
            "The mentor was great, the session was great and clear.";

        System.out.println("Feedback: " + feedback);

        System.out.println("\nWord Frequency:");

        printFilteredWordFrequency(feedback);


        // =================================================

        System.out.println("\n========================================");
        System.out.println("       ALL QUESTIONS COMPLETED");
        System.out.println("========================================");
    }
}