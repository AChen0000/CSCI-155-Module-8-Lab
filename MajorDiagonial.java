import java.util.Scanner;

public class MajorDiagonal {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            double[][] matrix = new double[4][4];

            System.out.println("Enter a 4-by-4 matrix row by row:");
            System.out.println("Type 'End' anytime to stop.");

            // Read matrix values
            boolean stopEarly = false;
            for (int row = 0; row < 4 && !stopEarly; row++) {
                System.out.print("Row " + (row + 1) + ": ");
                for (int col = 0; col < 4; col++) {
                    String value = input.next();

                    if (value.equalsIgnoreCase("End")) {
                        stopEarly = true;
                        keepRunning = false;
                        break;
                    }

                    matrix[row][col] = Double.parseDouble(value);
                }
            }

            if (!stopEarly) {
                // Calculate and display diagonal sum
                double total = sumMajorDiagonal(matrix);
                System.out.println("Sum of the elements in the major diagonal is " + total);
                System.out.println(); // extra space before next input
            }
        }

        System.out.println("Program exited.");
        input.close();
    }

    // Method to sum the major diagonal
    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }
}
