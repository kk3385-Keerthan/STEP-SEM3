import java.util.Scanner;

public class W1assignment {

    // =====================================================
    // 1. EXAM HALL SEAT DUPLICATION CHECKER
    // =====================================================

    static void checkDuplicateSeats(int[] seatNumbers) {

        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {

            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {

                    boolean alreadyPrinted = false;

                    // Avoid printing the same duplicate multiple times
                    for (int k = 0; k < i; k++) {
                        if (seatNumbers[k] == seatNumbers[i]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }

                    if (!alreadyPrinted) {
                        System.out.println(
                            "Duplicate Seat Number Found: "
                            + seatNumbers[i]
                        );
                        duplicateFound = true;
                    }
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }


    // =====================================================
    // 2. TYPING SPEED TEST ACCURACY CHECKER
    // =====================================================

    static void checkTypingAccuracy(String original, String typed) {

        int total = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < total; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // Handle different lengths
        if (original.length() != typed.length()) {

            if (firstMismatch == -1) {
                firstMismatch = total;
            }
        }

        int totalCharacters = Math.max(
            original.length(),
            typed.length()
        );

        double accuracy;

        if (totalCharacters == 0) {
            accuracy = 100.0;
        } else {
            accuracy = (matched * 100.0) / totalCharacters;
        }

        System.out.printf(
            "Matched: %d/%d | Accuracy: %.2f%%",
            matched,
            totalCharacters,
            accuracy
        );

        if (firstMismatch == -1) {

            System.out.println(" | No Mismatches");

        } else {

            char originalChar =
                firstMismatch < original.length()
                ? original.charAt(firstMismatch)
                : '-';

            char typedChar =
                firstMismatch < typed.length()
                ? typed.charAt(firstMismatch)
                : '-';

            System.out.println(
                " | First Mismatch at position "
                + (firstMismatch + 1)
                + " ('" + originalChar
                + "' vs '" + typedChar + "')"
            );
        }
    }


    // =====================================================
    // 3. TRAFFIC SIGNAL STREAK ANALYZER
    // =====================================================

    static void findLongestStreak(String signalLog) {

        if (signalLog.length() == 0) {
            System.out.println("Signal log is empty.");
            return;
        }

        char longestColor = signalLog.charAt(0);

        int longestLength = 1;
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) ==
                signalLog.charAt(i - 1)) {

                currentLength++;

            } else {

                currentLength = 1;
            }

            if (currentLength > longestLength) {

                longestLength = currentLength;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println(
            "Longest Streak: '"
            + longestColor
            + "' repeated "
            + longestLength
            + " times"
        );
    }


    // =====================================================
    // 4. WAREHOUSE INVENTORY BALANCER
    // =====================================================

    static void analyzeInventory(
        int[] sectionA,
        int[] sectionB
    ) {

        int totalA = 0;
        int totalB = 0;

        // Calculate Section A total
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
        }

        // Calculate Section B total
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
        }

        String status;

        if (totalA == totalB) {
            status = "Balanced";
        } else {
            status = "Not Balanced";
        }

        // Find highest quantity
        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        // Check Section A
        for (int i = 0; i < sectionA.length; i++) {

            if (sectionA[i] > highestQuantity) {

                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        // Check Section B
        for (int i = 0; i < sectionB.length; i++) {

            if (sectionB[i] > highestQuantity) {

                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println(
            "Section A Total: " + totalA
            + " | Section B Total: " + totalB
            + " | Status: " + status
        );

        System.out.println(
            "Highest Quantity: "
            + highestQuantity
            + " (" + highestSection
            + ", Item " + (highestIndex + 1) + ")"
        );
    }


    // =====================================================
    // 5. MOVIE REVIEW WORD LENGTH PROFILER
    // =====================================================

    static void classifyWordLengths(String review) {

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        String[] words = review.trim().split("\\s+");

        for (String word : words) {

            // Remove punctuation from beginning/end
            word = word.replaceAll(
                "^[^a-zA-Z]+|[^a-zA-Z]+$",
                ""
            );

            int length = word.length();

            if (length >= 1 && length <= 4) {

                shortWords++;

            } else if (length >= 5 && length <= 8) {

                mediumWords++;

            } else if (length >= 9) {

                longWords++;
            }
        }

        System.out.println(
            "Short: " + shortWords
            + " | Medium: " + mediumWords
            + " | Long: " + longWords
        );
    }


    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("       W1 ASSIGNMENT - WEEK 1");
        System.out.println("====================================");

        // -------------------------------------------------
        // QUESTION 1
        // -------------------------------------------------

        System.out.println("\n===== QUESTION 1 =====");

        int[] seats = {101, 102, 103, 102, 105};

        System.out.print("Seat Numbers: ");

        for (int seat : seats) {
            System.out.print(seat + " ");
        }

        System.out.println();

        checkDuplicateSeats(seats);


        // -------------------------------------------------
        // QUESTION 2
        // -------------------------------------------------

        System.out.println("\n===== QUESTION 2 =====");

        String original = "hello world";
        String typed = "hello worlt";

        System.out.println("Original: " + original);
        System.out.println("Typed   : " + typed);

        checkTypingAccuracy(original, typed);


        // -------------------------------------------------
        // QUESTION 3
        // -------------------------------------------------

        System.out.println("\n\n===== QUESTION 3 =====");

        String signalLog = "RRGGGYRR";

        System.out.println("Signal Log: " + signalLog);

        findLongestStreak(signalLog);


        // -------------------------------------------------
        // QUESTION 4
        // -------------------------------------------------

        System.out.println("\n===== QUESTION 4 =====");

        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        System.out.print("Section A: ");

        for (int value : sectionA) {
            System.out.print(value + " ");
        }

        System.out.println();

        System.out.print("Section B: ");

        for (int value : sectionB) {
            System.out.print(value + " ");
        }

        System.out.println();

        analyzeInventory(sectionA, sectionB);


        // -------------------------------------------------
        // QUESTION 5
        // -------------------------------------------------

        System.out.println("\n===== QUESTION 5 =====");

        String review =
            "This movie was absolutely fantastic and thrilling";

        System.out.println("Review: " + review);

        classifyWordLengths(review);


        // -------------------------------------------------

        System.out.println("\n====================================");
        System.out.println("       ALL QUESTIONS COMPLETED");
        System.out.println("====================================");

        sc.close();
    }
}