public class W6assignment {

    // M1: Library Inventory Management
    static class BookInventory {
        String title, author;
        int copiesAvailable;

        BookInventory(String title, String author, int copiesAvailable) {
            this.title = title;
            this.author = author;
            this.copiesAvailable = copiesAvailable;
        }

        void printEntry() {
            System.out.println(title + " by " + author + " - "
                    + copiesAvailable + " copies available");
        }
    }

    // M2: Payroll Salary Management
    static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        public PayrollAccount(double basicSalary) {
            if (basicSalary < 0) {
                System.out.println("Invalid salary. Starting at Rs 0.0");
                this.basicSalary = 0;
            } else {
                this.basicSalary = basicSalary;
            }
            bonus = 0;
        }

        public void creditBonus(double amount) {
            if (amount <= 0)
                System.out.println("Bonus rejected");
            else {
                bonus += amount;
                System.out.println("Bonus credited: Rs " + amount);
            }
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100)
                System.out.println("Invalid tax percentage");
            else {
                basicSalary -= basicSalary * percent / 100;
                System.out.println("Tax deducted: " + percent + "%");
            }
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    // M3: Employee Profile Creation
    static class EmployeeProfile {
        String empId, empName;
        double salary;
        boolean isIntern;

        public EmployeeProfile(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        public EmployeeProfile(String empId, String empName) {
            this(empId, empName, 0);
            this.isIntern = true;
        }

        void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs "
                    + salary + " | Intern: " + isIntern);
        }
    }

    // M4: Exam Hall Ticket Reference Management
    static class HallTicket {
        String studentName;
        int seatNumber;

        HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    // M5: Employee and Company Information Management
    static class CompanyEmployee {
        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        CompanyEmployee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {

        // M1
        System.out.println("M1: Library Inventory");
        BookInventory[] books = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        for (BookInventory b : books)
            b.printEntry();

        // M2
        System.out.println("\nM2: Payroll Salary");
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());

        // M3
        System.out.println("\nM3: Employee Profile");
        EmployeeProfile e1 =
            new EmployeeProfile("E-101", "Divya", 65000);
        EmployeeProfile e2 =
            new EmployeeProfile("E-102", "Arjun");

        e1.printProfile();
        e2.printProfile();

        // M4
        System.out.println("\nM4: Hall Ticket");
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;

        copy.seatNumber = 45;

        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));

        // M5
        System.out.println("\nM5: Company Information");
        new CompanyEmployee("A", 50000);
        new CompanyEmployee("B", 60000);
        new CompanyEmployee("C", 70000);

        CompanyEmployee.printCompanyInfo();
    }
}