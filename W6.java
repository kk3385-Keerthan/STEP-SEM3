public class W6 {

    static class PlacementRecord {
        String studentName;
        String company;
        double packageLpa;

        PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    static class MessWallet {
        private double balance;

        MessWallet(double balance) {
            if (balance < 0) {
                System.out.println("Warning: Negative opening balance. Starting at 0.");
                this.balance = 0;
            } else {
                this.balance = balance;
            }
        }

        void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: amount must be positive");
            } else {
                balance += amount;
                System.out.println("Balance after top-up: " + balance);
            }
        }

        void deduct(double amount) {
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
            } else if (amount <= 0) {
                System.out.println("Deduct rejected: amount must be positive");
            } else {
                balance -= amount;
            }
        }

        double getBalance() {
            return balance;
        }
    }

    static class Course {
        String code;
        String title;
        int credits;
        int labCredits;

        Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        int totalCredits() {
            return credits + labCredits;
        }
    }

    static class IdCard {
        String name;
        int booksIssued;

        IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    static class Student {
        String name;
        int attendance;

        static String collegeName =
                "SRM Institute of Science and Technology";

        static int studentCount = 0;

        Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {

        // M1
        System.out.println("M1. Placement Record");

        PlacementRecord[] records = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        for (PlacementRecord record : records) {
            record.printRecord();
        }

        // M2
        System.out.println("\nM2. Mess Wallet");

        MessWallet wallet = new MessWallet(500);

        wallet.topUp(200);
        wallet.deduct(1000);

        System.out.println("Final balance: " + wallet.getBalance());

        // M3
        System.out.println("\nM3. Course Credit");

        Course c1 =
                new Course("21CSC201J", "Data Structures", 4);

        Course c2 =
                new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(
                c1.code + " total credits: " + c1.totalCredits());

        System.out.println(
                c2.code + " total credits: " + c2.totalCredits());

        // M4
        System.out.println("\nM4. Library ID Card");

        IdCard ravi = new IdCard("Ravi", 0);

        IdCard duplicate = ravi;

        duplicate.booksIssued = 3;

        IdCard separate = new IdCard("Ravi", 3);

        System.out.println(
                "Ravi's booksIssued (via first variable): "
                + ravi.booksIssued);

        System.out.println(
                "duplicate == ravi: " + (duplicate == ravi));

        System.out.println(
                "separate == ravi: " + (separate == ravi));

        // M5
        System.out.println("\nM5. Student and College");

        Student s1 = new Student("Ravi", 90);

        Student s2 = new Student("Anitha", 95);

        System.out.println("2 Student objects created");

        Student.printCollegeInfo();
    }
}