import java.util.Scanner;
public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Subjects");
        int num_subjects = sc.nextInt();
        int total_marks=0;
        for(int i=1;i<=num_subjects;i++)
        {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = sc.nextInt();
            total_marks=total_marks+marks;
        }
        double average_percentage = (double) total_marks / (num_subjects * 100) * 100;
        char grade;
        if (average_percentage >= 90) {
            grade = 'A';
        } else if (average_percentage >= 80) {
            grade = 'B';
        } else if (average_percentage >= 70) {
            grade = 'C';
        } else if (average_percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Total Marks: " + total_marks);
        System.out.println("Average Percentage: " + average_percentage + "%");
        System.out.println("Grade: " + grade);
        sc.close();
    }
}