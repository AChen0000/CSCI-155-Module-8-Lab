import java.util.Arrays;
import java.util.Scanner;

public class EmployeeHours {
public static void main(String[] args) {
        int[][] hours = {
            {2, 4, 3, 4, 5, 8, 8},
            {7, 3, 4, 3, 3, 4, 4},
            {3, 3, 4, 3, 3, 2, 2},
            {9, 3, 4, 7, 3, 4, 1},
            {3, 5, 4, 3, 6, 3, 8},
            {3, 4, 4, 6, 3, 4, 4},
            {3, 7, 4, 8, 3, 8, 4},
            {6, 3, 5, 9, 2, 7, 9}
        };

        // Print employee hours table
        System.out.println("Employee\tHours");
        for (int i = 0; i < hours.length; i++) {
            System.out.print("Employee " + i + "\t");
            for (int j = 0; j < hours[i].length; j++) {
                System.out.print(hours[i][j] + " ");
            }
            System.out.println();
        }

        // Calculate total hours
        int[] totalHours = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            int sum = 0;
            for (int j = 0; j < hours[i].length; j++) {
                sum += hours[i][j];
            }
            totalHours[i] = sum;
        }

        // Sort employees by total hours for display
        Integer[] indices = new Integer[hours.length];
        for (int i = 0; i < hours.length; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> totalHours[b] - totalHours[a]); // descending

        System.out.println("\nEmployee\tTotal Hours (sorted)");
        for (int i = 0; i < indices.length; i++) {
            System.out.println("Employee " + indices[i] + "\t" + totalHours[indices[i]]);
        }

        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter an employee number to see their hours (or -1 to quit): ");
            int emp = scanner.nextInt();

            if (emp == -1) {
                System.out.println("Exiting...");
                break;
            }

            if (emp >= 0 && emp < hours.length) {
                System.out.println("Employee " + emp + " daily hours:");
                for (int j = 0; j < hours[emp].length; j++) {
                    System.out.println("Day " + (j + 1) + ": " + hours[emp][j]);
                }
                System.out.println("Total hours: " + totalHours[emp]);
            } else { //Show when something is wrong/error
                System.out.println("Invalid employee number. Try again.");
            }
        }

        scanner.close();
    }
}
