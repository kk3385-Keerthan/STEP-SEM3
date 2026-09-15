import java.util.*;

public class W1 {

    // =========================================================
    // 1. ROCK-PAPER-SCISSORS GAME
    // =========================================================

    static String playRound(String playerMove, String computerMove) {

        playerMove = playerMove.toLowerCase();
        computerMove = computerMove.toLowerCase();

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    static void rockPaperScissors(Scanner sc) {

        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[][] results = new String[5][4];

        System.out.println("\n===== ROCK-PAPER-SCISSORS GAME =====");

        for (int i = 0; i < 5; i++) {

            System.out.print("Round " + (i + 1) +
                    " - Enter Rock, Paper, or Scissors: ");

            String playerMove = sc.next();

            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            results[i][0] = String.valueOf(i + 1);
            results[i][1] = playerMove;
            results[i][2] = computerMove;
            results[i][3] = result;

            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("\n===== FINAL SUMMARY =====");
        System.out.println("Round\tPlayer Move\tComputer Move\tResult");

        for (int i = 0; i < 5; i++) {
            System.out.println(
                    results[i][0] + "\t" +
                    results[i][1] + "\t\t" +
                    results[i][2] + "\t\t" +
                    results[i][3]
            );
        }

        double winPercentage = (wins / 5.0) * 100;

        System.out.println("\nWins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.println("Win %  : " + winPercentage + "%");
    }


    // =========================================================
    // 2. PALINDROME CHECKER - 3 APPROACHES
    // =========================================================

    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(
                text.substring(1, text.length() - 1)
        );
    }

    static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();

        char[] reversed = text.toCharArray();

        int left = 0;
        int right = reversed.length - 1;

        while (left < right) {

            char temp = reversed[left];
            reversed[left] = reversed[right];
            reversed[right] = temp;

            left++;
            right--;
        }

        return Arrays.equals(original, reversed);
    }

    static void palindromeChecker(Scanner sc) {

        System.out.println("\n===== PALINDROME CHECKER =====");

        sc.nextLine();

        System.out.print("Enter a word or text: ");
        String text = sc.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean array = isPalindromeArrayReversal(text);

        System.out.println("\nIterative: " +
                (iterative ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (recursive ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (array ? "Palindrome" : "Not Palindrome"));

        if (iterative == recursive && recursive == array) {
            System.out.println("\nAll three approaches agree.");
        }
    }


    // =========================================================
    // 3. BMI CALCULATOR FOR A TEAM
    // =========================================================

    static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights,
                                    double[] weights) {

        System.out.println("\n===== BMI WELLNESS REPORT =====");

        System.out.printf(
                "%-10s %-15s %-15s %-10s %-15s%n",
                "Person", "Height(m)", "Weight(kg)", "BMI", "Status"
        );

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] /
                    (heights[i] * heights[i]);

            String status = getBmiStatus(bmi);

            System.out.printf(
                    "%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    status
            );
        }
    }

    static void bmiCalculator(Scanner sc) {

        System.out.println("\n===== BMI CALCULATOR =====");

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        double[] heights = new double[n];
        double[] weights = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter height of Person " +
                    (i + 1) + " in meters: ");
            heights[i] = sc.nextDouble();

            System.out.print("Enter weight of Person " +
                    (i + 1) + " in kg: ");
            weights[i] = sc.nextDouble();
        }

        printWellnessReport(heights, weights);
    }


    // =========================================================
    // 4. FIRST NON-REPEATING CHARACTER
    // =========================================================

    static char findFirstNonRepeatingChar(String text) {

        HashMap<Character, Integer> frequency =
                new HashMap<>();

        // Count frequency
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            frequency.put(
                    ch,
                    frequency.getOrDefault(ch, 0) + 1
            );
        }

        // Find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (frequency.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }

    static void firstNonRepeatingCharacter(Scanner sc) {

        System.out.println(
                "\n===== FIRST NON-REPEATING CHARACTER ====="
        );

        sc.nextLine();

        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println(
                    "No Non-Repeating Character Found"
            );
        } else {
            System.out.println(
                    "First Non-Repeating Character: '" +
                    result + "'"
            );
        }
    }


    // =========================================================
    // 5. REVERSE CUSTOMER NAME
    // =========================================================

    static String reverseCustomerName(String customerName) {

        char[] characters = customerName.toCharArray();

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {

            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left++;
            right--;
        }

        return new String(characters);
    }

    static void reverseName(Scanner sc) {

        System.out.println("\n===== REVERSE CUSTOMER NAME =====");

        sc.nextLine();

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        String reversedName =
                reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n==================================");
            System.out.println("       STEP SEM-3 - WEEK 1");
            System.out.println("==================================");

            System.out.println("1. Rock-Paper-Scissors Game");
            System.out.println("2. Palindrome Checker");
            System.out.println("3. BMI Calculator");
            System.out.println("4. First Non-Repeating Character");
            System.out.println("5. Reverse Customer Name");
            System.out.println("6. Run All Problems");
            System.out.println("0. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    rockPaperScissors(sc);
                    break;

                case 2:
                    palindromeChecker(sc);
                    break;

                case 3:
                    bmiCalculator(sc);
                    break;

                case 4:
                    firstNonRepeatingCharacter(sc);
                    break;

                case 5:
                    reverseName(sc);
                    break;

                case 6:

                    rockPaperScissors(sc);

                    palindromeChecker(sc);

                    bmiCalculator(sc);

                    firstNonRepeatingCharacter(sc);

                    reverseName(sc);

                    break;

                case 0:
                    System.out.println("Program Ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}