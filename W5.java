import java.util.Arrays;

public class W5 {

    // Q1. Hackathon Score Curve Booster
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scores[i] + bonus;
        }
    }

    // Q2. Duplicate Team Name Finder
    static String findDuplicateTeam(String[] teamNames) {

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {

                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    // Q3. Top-3 Podium Finder
    static int[] findTopThreeScores(int[] scores) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {

            if (score >= first) {
                third = second;
                second = first;
                first = score;

            } else if (score >= second) {
                third = second;
                second = score;

            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    // Q4. Hackathon Seating Grid Optimizer
    private static double rowAverage(int[] row) {

        int sum = 0;

        for (int score : row) {
            sum += score;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {

            double average = rowAverage(seatingScores[i]);

            if (average < threshold) {
                result.append("Row ")
                      .append(i)
                      .append(": Quiet Zone");
            } else {
                result.append("Row ")
                      .append(i)
                      .append(": Buzzing Zone");
            }

            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    // Q5. Placement Drive Shortlisting & Ranking Engine
    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // CGPA-only eligibility
        static boolean isEligible(double cgpa) {
            return cgpa >= 7.0;
        }

        // CGPA + coding score eligibility
        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        // Composite score
        double getCompositeScore() {
            return (cgpa * 10) + codingScore;
        }

        // Sort in descending order of composite score
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
            );
        }

        String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + " (" + getCompositeScore() + ")";
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];

        int count = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa) ||
                Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {

                shortlisted[count] = candidate;
                count++;
            }
        }

        // Create array containing only shortlisted candidates
        Candidate[] finalList = new Candidate[count];

        for (int i = 0; i < count; i++) {
            finalList[i] = shortlisted[i];
        }

        // Arrays.sort uses Candidate.compareTo()
        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < finalList.length; i++) {

            result.append(i + 1)
                  .append(". ")
                  .append(finalList[i].getName())
                  .append(" (")
                  .append(finalList[i].getCompositeScore())
                  .append(")");

            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("        W5 - CATEGORY C PROBLEMS");
        System.out.println("========================================");

        // Q1
        System.out.println("\n===== QUESTION 1 =====");

        int[] scores = {70, 85, 60};

        System.out.println("Original Scores: " + Arrays.toString(scores));

        curveScores(scores, 10);

        System.out.println("After Bonus: " + Arrays.toString(scores));

        // Q2
        System.out.println("\n===== QUESTION 2 =====");

        String[] teamNames = {
            "ByteForce",
            "CodeCrafters",
            "ByteForce"
        };

        System.out.println("Team Names: " + Arrays.toString(teamNames));
        System.out.println(findDuplicateTeam(teamNames));

        // Q3
        System.out.println("\n===== QUESTION 3 =====");

        int[] podiumScores = {
            45, 82, 79, 90, 33, 90, 61
        };

        System.out.println("Scores: " + Arrays.toString(podiumScores));
        System.out.println(
            "Top 3: " + Arrays.toString(findTopThreeScores(podiumScores))
        );

        // Q4
        System.out.println("\n===== QUESTION 4 =====");

        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };

        int threshold = 60;

        System.out.println("Threshold: " + threshold);
        System.out.println(
            classifyRows(seatingScores, threshold)
        );

        // Q5
        System.out.println("\n===== QUESTION 5 =====");

        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println("Shortlist & Ranking:");
        System.out.println(shortlistAndRank(candidates));

        System.out.println("\n========================================");
        System.out.println("       ALL 5 QUESTIONS COMPLETED");
        System.out.println("========================================");
    }
}