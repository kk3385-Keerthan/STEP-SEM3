import java.util.Arrays;

public class W5assignment {

    // Q1. Fantasy Team Score Multiplier
    static void applyMultipliers(double[] playerScores,
                                 int captainIndex,
                                 int viceCaptainIndex) {

        playerScores[captainIndex] =
                playerScores[captainIndex] * 2.0;

        playerScores[viceCaptainIndex] =
                playerScores[viceCaptainIndex] * 1.5;
    }

    // Q2. Duplicate Player Pick Checker
    static String findDuplicatePick(String[] playerNames) {

        for (int i = 0; i < playerNames.length; i++) {

            for (int j = i + 1; j < playerNames.length; j++) {

                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    // Q3. Top Performer Tracker
    static String findMinMaxSpread(int[] scores) {

        int min = scores[0];
        int max = scores[0];

        for (int i = 1; i < scores.length; i++) {

            if (scores[i] < min) {
                min = scores[i];
            }

            if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;

        return "Min: " + min
                + " | Max: " + max
                + " | Spread: " + spread;
    }

    // Q4. Match Day Grid Analyzer
    private static double rowAverage(int[] row) {

        int sum = 0;

        for (int value : row) {
            sum += value;
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {

            double average = rowAverage(runsPerOver[i]);

            if (average >= threshold) {
                result.append("Match ")
                      .append(i)
                      .append(": Power Surge");
            } else {
                result.append("Match ")
                      .append(i)
                      .append(": Normal");
            }

            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    // Q5. Fantasy League Auto-Draft Ranking Engine
    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name,
                      int matchesPlayed,
                      double battingAverage,
                      boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Experience-only rule
        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        // Combined matches + fitness rule
        static boolean isDraftable(int matchesPlayed,
                                    boolean injured) {

            return matchesPlayed >= 5 && !injured;
        }

        // Fantasy points
        double getFantasyPoints() {
            return battingAverage + matchesPlayed;
        }

        // Descending fantasy points
        @Override
        public int compareTo(Player other) {

            return Double.compare(
                    other.getFantasyPoints(),
                    this.getFantasyPoints()
            );
        }

        String getName() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (Player player : players) {

            if (Player.isDraftable(player.matchesPlayed)
                    || Player.isDraftable(
                            player.matchesPlayed,
                            player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        Player[] finalList = new Player[count];

        for (int i = 0; i < count; i++) {
            finalList[i] = draftable[i];
        }

        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < finalList.length; i++) {

            result.append(i + 1)
                  .append(". ")
                  .append(finalList[i].getName());

            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       W5 ASSIGNMENT - CATEGORY C");
        System.out.println("========================================");

        // Q1
        System.out.println("\n===== QUESTION 1 =====");

        double[] scores = {40, 55, 30, 62};

        System.out.println("Original Scores: "
                + Arrays.toString(scores));

        applyMultipliers(scores, 1, 3);

        System.out.println("Updated Scores: "
                + Arrays.toString(scores));

        // Q2
        System.out.println("\n===== QUESTION 2 =====");

        String[] playerNames = {
                "Kohli",
                "Bumrah",
                "Kohli",
                "Rohit"
        };

        System.out.println("Players: "
                + Arrays.toString(playerNames));

        System.out.println(findDuplicatePick(playerNames));

        // Q3
        System.out.println("\n===== QUESTION 3 =====");

        int[] playerScores = {
                45, 82, 79, 90, 33, 90, 61
        };

        System.out.println("Scores: "
                + Arrays.toString(playerScores));

        System.out.println(findMinMaxSpread(playerScores));

        // Q4
        System.out.println("\n===== QUESTION 4 =====");

        int[][] runsPerOver = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };

        int threshold = 8;

        System.out.println("Threshold: " + threshold);

        System.out.println(
                classifyMatches(runsPerOver, threshold)
        );

        // Q5
        System.out.println("\n===== QUESTION 5 =====");

        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println("Draft & Ranking:");

        System.out.println(
                draftAndRank(players)
        );

        System.out.println("\n========================================");
        System.out.println("       ALL 5 QUESTIONS COMPLETED");
        System.out.println("========================================");
    }
}