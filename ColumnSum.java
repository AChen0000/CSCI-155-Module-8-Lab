import java.util.Scanner;

public class ColumnSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[][] matrix = new double[3][4];

        System.out.println("Enter a 3-by-4 matrix row by row.");
        System.out.println("Type 'End' anytime to stop.");

        // Read matrix values from user
        for (int row = 0; row < 3; row++) {
            System.out.print("Row " + (row + 1) + ": ");

            for (int col = 0; col < 4; col++) {
                String value = input.next();

                // Stop when user types "End"
                if (value.equalsIgnoreCase("End")) {
                    System.out.println("\nProgram stopped by user.");
                    input.close();
                    return;  // Stop the whole program
                }

                // Convert a valid number to a double
                matrix[row][col] = Double.parseDouble(value);
            }
        }

        System.out.println();

        // Calculate and print column sums
        for (int col = 0; col < 4; col++) {
            double total = sumColumn(matrix, col);
            System.out.println("Sum of the elements at column " + col + " is " + total);
        }

        input.close();
    }

    // Method to sum a column
    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;

        for (int row = 0; row < m.length; row++) {
            sum += m[row][columnIndex];
        }

        return sum;
    }
}
