public class W2 {

    // =====================================================
    // 1. VOWEL & CONSONANT COUNTER
    // =====================================================

    static void countVowelsAndConsonants(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch == ' ') {
                continue;
            }

            ch = Character.toLowerCase(ch);

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {

                vowels++;

            } else {
                consonants++;
            }
        }

        System.out.println(
                "Vowels: " + vowels
                + " | Consonants: " + consonants
        );
    }


    // =====================================================
    // 2. CSV STUDENT RECORD PARSER
    // =====================================================

    static void parseStudentRecord(String csvLine) {

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {

            System.out.println("Invalid Record");
            return;
        }

        System.out.println(
                "Name: " + fields[0]
                + " | Roll No: " + fields[1]
                + " | Dept: " + fields[2]
        );
    }


    // =====================================================
    // 3. FILE EXTENSION VALIDATOR
    // =====================================================

    static String validateFileExtension(String filename) {

        int dotIndex = filename.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension =
                filename.substring(dotIndex + 1);

        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {

            return "Accepted";
        }

        return "Rejected — invalid file type";
    }


    // =====================================================
    // 4. MASKED PHONE NUMBER FORMATTER
    // =====================================================

    static String maskPhoneNumber(String phone) {

        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate that every character is a digit
        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFourDigits =
                phone.substring(6);

        StringBuilder result =
                new StringBuilder("XXXXXX");

        result.insert(6, "-");

        result.append(lastFourDigits);

        return result.toString();
    }


    // =====================================================
    // 5. BANK TRANSACTION REFERENCE GENERATOR & VALIDATOR
    // =====================================================

    static String normalizeReference(String raw) {

        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference;
        }

        String bankCode =
                reference.substring(0, 3).toUpperCase();

        String remaining =
                reference.substring(3);

        return bankCode + remaining;
    }


    static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {

            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {

                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {

                return "Invalid: body must contain only digits";
            }
        }

        String bankCode =
                reference.substring(0, 3);

        String date =
                reference.substring(3, 9);

        String sequence =
                reference.substring(9, 14);

        // Date format: ddMMyy -> dd/MM/yy
        String formattedDate =
                date.substring(0, 2)
                + "/"
                + date.substring(2, 4)
                + "/"
                + date.substring(4, 6);

        StringBuilder result =
                new StringBuilder();

        result.append("[")
                .append(bankCode)
                .append("] DATE: ")
                .append(formattedDate)
                .append(" | SEQ: ")
                .append(sequence);

        return result.toString();
    }


    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("          W2 - WEEK 2 PROBLEMS");
        System.out.println("========================================");


        // =================================================
        // QUESTION 1
        // =================================================

        System.out.println("\n===== QUESTION 1 =====");

        String title = "Java Programming";

        System.out.println("Input: " + title);

        countVowelsAndConsonants(title);


        // =================================================
        // QUESTION 2
        // =================================================

        System.out.println("\n===== QUESTION 2 =====");

        String csvLine =
                "Ananya Verma,RA2211003010123,CSE";

        System.out.println("Input: " + csvLine);

        parseStudentRecord(csvLine);


        // =================================================
        // QUESTION 3
        // =================================================

        System.out.println("\n===== QUESTION 3 =====");

        String filename = "Assignment1.PDF";

        System.out.println("Filename: " + filename);

        System.out.println(
                validateFileExtension(filename)
        );


        // =================================================
        // QUESTION 4
        // =================================================

        System.out.println("\n===== QUESTION 4 =====");

        String phone = "9876543210";

        System.out.println("Phone: " + phone);

        System.out.println(
                maskPhoneNumber(phone)
        );


        // =================================================
        // QUESTION 5
        // =================================================

        System.out.println("\n===== QUESTION 5 =====");

        String rawReference =
                " hdf03022600042 ";

        System.out.println(
                "Raw Reference: " + rawReference
        );

        String normalized =
                normalizeReference(rawReference);

        System.out.println(
                "Normalized Reference: " + normalized
        );

        System.out.println(
                validateAndFormat(normalized)
        );


        // =================================================

        System.out.println("\n========================================");
        System.out.println("       ALL WEEK 2 PROBLEMS COMPLETED");
        System.out.println("========================================");
    }
}