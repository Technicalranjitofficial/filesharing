import java.util.Scanner;

class Student {
    String rollNo;
    int marks[] = new int[3];

    public Student(String r, int m1, int m2, int m3) {
        rollNo = r;
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
    }
}

class CSEStudents {
    Student cse[] = new Student[10];
    int count = 0;

    public void addStudent(Student s) {
        cse[count++] = s;
    }
}

class ITStudents {
    Student it[] = new Student[10];
    int count = 0;

    public void addStudent(Student s) {
        it[count++] = s;
    }
}

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

class Main {

    static void checkMarks(int m1, int m2, int m3) throws MyException {
        if (m1 < 40 || m2 < 40 || m3 < 40) {
            throw new MyException("Candidate shall appear for an improvement");
        }
    }

    static void addData(CSEStudents s1, ITStudents s2, String rollNo, int m1, int m2, int m3) {
        Student s = new Student(rollNo, m1, m2, m3);
        if (rollNo.charAt(3) == '5') {
            System.out.println("Students Belongs to CSE");
            s1.addStudent(s);
        } else {
            System.out.println("Students Belongs to It");
            s2.addStudent(s);
        }

    }

    static void displayInfo(CSEStudents cseStudents, ITStudents itStudents) {
        System.out.println("CSE Students:");
        for (int i = 0; i < cseStudents.count; i++) {
            System.out.println("Roll No: " + cseStudents.cse[i].rollNo +
                    ", Marks: " + cseStudents.cse[i].marks[0]
                    + ", " + cseStudents.cse[i].marks[1] + ", " +
                    cseStudents.cse[i].marks[2]);
        }
        System.out.println("IT Students:");
        for (int i = 0; i < itStudents.count; i++) {
            System.out.println("Roll No: " + itStudents.it[i].rollNo +
                    ", Marks: " + itStudents.it[i].marks[0] + ", "

                    + itStudents.it[i].marks[1] + ", " +
                    itStudents.it[i].marks[2]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CSEStudents cseStudents = new CSEStudents();
        ITStudents itStudents = new ITStudents();

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter Roll Number of Student " + (i + 1) + ": ");
            String rollNo = scanner.nextLine();
            System.out.print("Enter Marks of Student " + (i + 1) + " (out of 100): ");
            int m1 = scanner.nextInt();
            int m2 = scanner.nextInt();
            int m3 = scanner.nextInt();

            scanner.nextLine();
            try {

                checkMarks(m1, m2, m3);
                addData(cseStudents, itStudents, rollNo, m1, m2, m3);

            } catch (MyException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Other Error: " + e.getMessage());
            }

        }
        displayInfo(cseStudents, itStudents);

        scanner.close();
    }
}
