import java.io.*;
import java.util.Scanner;

public class StudentRecord {
    static StudentData[] studentData = new StudentData[1000];
    static int studentCount = 0;
    static Scanner scan = new Scanner(System.in);
    static final String FILE_NAME = "BSIT.txt";
    static int baseId = 2024001;

    public static void main(String[] args) {

        loadStudentData();

        int choice;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Create Student Record.");
            System.out.println("2. Read All Students Data.");
            System.out.println("3. Update Student Data/Records.");
            System.out.println("4. Delete Student Data/Records.");
            System.out.println("5. Exit.");

            System.out.println("\nEnter your choice from 1-5: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    readStudentData();
                    break;
                case 3:
                    updateStudentData();
                    break;
                case 4:
                    deleteStudentData();
                    break;
                case 5:
                    System.out.println("Exiting....");

                    saveStudentData();
                    break;
                default:
                    System.out.println("Invalid choice. Please Try Again...");
            }
        } while (choice != 5);
    }

    static void createStudent() {
        System.out.println("Student Name: ");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.println("Gender: ");
        String gender = scan.nextLine();
        System.out.println("Nationality: ");
        String nationality = scan.nextLine();
        System.out.println("Course: ");
        String course = scan.nextLine();
        System.out.println("Age: ");
        int age = scan.nextInt();

        StudentData studentDetails = new StudentData(baseId + studentCount, name, gender, nationality, course, age);
        studentData[studentCount] = studentDetails;
        studentCount++;

        System.out.println("\nStudent data created successfully...");
    }

    static void readStudentData() {
        if (studentCount == 0) {
            System.out.println("There's no Student Data/Records that has been made or created.");
            return;
        }

        System.out.println("\nStudent Data/Records:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(studentData[i]);
        }
    }

    static void updateStudentData() {
        if (studentCount == 0) {
            System.out.println("There's no student data/records that has been made or created.");
            return;
        }

        System.out.println("Enter Student ID to update: ");
        int id = scan.nextInt();

        if (id < baseId || id >= baseId + studentCount) {
            System.out.println("Invalid ID. Please Try Again....");
            return;
        }

        StudentData student = studentData[id - baseId];

        System.out.println("Enter New Name: ");
        scan.nextLine();
        String newName = scan.nextLine();
        System.out.println("Gender: ");
        String newGen = scan.nextLine();
        System.out.println("Nationality: ");
        String newNL = scan.nextLine();
        System.out.println("Course: ");
        String newCourse = scan.nextLine();
        System.out.println("Age: ");
        int newAge = scan.nextInt();

        student.setName(newName);
        student.setGender(newGen);
        student.setNationality(newNL);
        student.setCourse(newCourse);
        student.setAge(newAge);

        System.out.println("\nStudent's Data updated successfully...");
    }

    static void deleteStudentData() {
        if (studentCount == 0) {
            System.out.println("There's no Student Data/Records that has been made or created.");
            return;
        }

        System.out.println("Enter student ID to delete:");
        int id = scan.nextInt();

        if (id < baseId || id >= baseId + studentCount) {
            System.out.println("Invalid ID. Please Try Again....");
            return;
        }

        for (int i = id - baseId; i < studentCount - 1; i++) {
            studentData[i] = studentData[i + 1];
        }
        studentCount--;

        System.out.println("Student's Data/Records has been deleted successfully.");
    }

    static void loadStudentData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String gender = data[2];
                String nationality = data[3];
                String course = data[4];
                int age = Integer.parseInt(data[5]);

                StudentData student = new StudentData(id, name, gender, nationality, course, age);
                studentData[studentCount] = student;
                studentCount++;
            }
        } catch (IOException e) {
            System.out.println("Error loading student data: " + e.getMessage());
        }
    }

    static void saveStudentData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < studentCount; i++) {
                StudentData student = studentData[i];
                bw.write(student.getId() + "," + student.getName() + "," + student.getGender() + "," +
                        student.getNationality() + "," + student.getCourse() + "," + student.getAge());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }
}
