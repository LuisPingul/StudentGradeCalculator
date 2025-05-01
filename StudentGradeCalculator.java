import java.io.*;
import java.util.*;

public class StudentGradeCalculator {

    // Method to calculate average grade
    public static double calculateAverageGrade(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        double total = 0;
        int count = 0;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                int grade = Integer.parseInt(parts[1]);
                total += grade;
                count++;
            }
        }

        reader.close();
        return count > 0 ? total / count : 0;
    }

    // Method to print student names and grades
    public static void printStudentGrades(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        System.out.println("Student Grades:");
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                System.out.println(parts[0] + ": " + parts[1]);
            }
        }

        reader.close();
    }

    public static void main(String[] args) {
        String filename = "/Users/luispingul/StudentGradeCalculator/grades.txt";


        try {
            printStudentGrades(filename);
            double average = calculateAverageGrade(filename);
            System.out.printf("\nAverage Grade: %.2f\n", average);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
