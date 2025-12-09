import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradeExam {
    public static void main(String[] args) {
        // The answer key (10 True/False answers)
        String[] key = {"T", "F", "T", "T", "F", "T", "F", "F", "T", "F"};

        File file = new File("answers.txt");
        Scanner input;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: answers.txt not found. Put the file in the same folder as this program.");
            return;
        }

        int studentNumber = 1;

        // Read each student (one line per student)
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();

            // skip empty lines
            if (line.isEmpty()) {
                continue;
            }

            // Split on any whitespace 
            String[] answers = line.split("\\s+");

            // Basic validation
            if (answers.length < key.length) {
                System.out.println("Student " + studentNumber + ": ERROR - missing answers (found " +
                                   answers.length + ", expected " + key.length + ").");
                studentNumber++;
                continue;
            }

            // Grade the exam
            int score = 0;
            for (int i = 0; i < key.length; i++) {
                if (answers[i].equalsIgnoreCase(key[i])) {
                    score++;
                }
            }

            // Print the result
            System.out.println("Student " + studentNumber + ": " + score + " correct");
            studentNumber++;
        }

        input.close();
    }
}
