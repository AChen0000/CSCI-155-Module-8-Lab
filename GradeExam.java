import java.util.Scanner;

public class GradeExam {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // The correct answer key
        String[] key = {"T", "F", "T", "T", "F", "T", "F", "F", "T", "F"};

        System.out.println("Enter each student's answers (10 T/F values).");
        System.out.println("Type End to stop.");

        int studentNumber = 1;

        while (true) {
            System.out.print("\nStudent " + studentNumber + " answers: ");

            String line = input.nextLine().trim();

            // Stop the loop
            if (line.equalsIgnoreCase("End")) {
                System.out.println("\nBye!~");
                break;
            }

            // Split into answers
            String[] answers = line.split("\\s+");

            // Check if exactly 10 answers were entered
            if (answers.length != 10) {
                System.out.println("Error: please enter EXACTLY 10 answers (T or F). Try again.");
                continue; // ask again
            }

            // Grade the student
            int score = 0;

            for (int i = 0; i < key.length; i++) {
                if (answers[i].equalsIgnoreCase(key[i])) {
                    score++;
                }
            }

            // Print the results
            System.out.println("Student " + studentNumber + " got " + score + " correct.");
            studentNumber++;
        }

        input.close();
    }
}
