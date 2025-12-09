import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

public class FileTasks2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a filename (or type 'End' to quit): ");
            String filename = input.nextLine();

            if (filename.equalsIgnoreCase("End")) {
                System.out.println("Program ended.");
                break;
            }

            File file = new File(filename);

            // Create the file if it doesn't exist
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + filename);

                    // Let user enter initial content
                    System.out.println("Enter content for the file (type 'done' on a new line to finish):");
                    try (FileWriter writer = new FileWriter(file)) {
                        while (true) {
                            String line = input.nextLine();
                            if (line.equalsIgnoreCase("done")) break;
                            writer.write(line + "\n");
                        }
                    }
                } else {
                    System.out.println("File already exists: " + filename);
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                continue;
            }

            // Print file attributes, all at once
            System.out.println("\n--- File Attributes ---");
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("File size: " + file.length() + " bytes");
            System.out.println("Last modified: " + new Date(file.lastModified()));

            // Print file contents
            System.out.println("\n--- File Contents ---");
            try (Scanner fileReader = new Scanner(file)) {
                if (!fileReader.hasNextLine()) System.out.println("(File is empty)");
                while (fileReader.hasNextLine()) {
                    System.out.println(fileReader.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            // Ask user for string to remove
            System.out.print("\nEnter a string to remove from the file (or leave empty to skip): ");
            String stringToRemove = input.nextLine();

            if (!stringToRemove.isEmpty()) {
                // Remove all occurrences
                StringBuilder content = new StringBuilder();
                try (Scanner fileReader = new Scanner(file)) {
                    while (fileReader.hasNextLine()) {
                        String line = fileReader.nextLine();
                        line = line.replace(stringToRemove, "");
                        content.append(line).append("\n");
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }

                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(content.toString());
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }

                // Show file after removal
                System.out.println("\n--- File Contents After Removing \"" + stringToRemove + "\" ---");
                try (Scanner fileReader = new Scanner(file)) {
                    while (fileReader.hasNextLine()) {
                        System.out.println(fileReader.nextLine());
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            }

            // Append last line
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write("The file has been modified by Ann\n");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }

            // Print final updated contents
            System.out.println("\n--- Final File Contents ---");
            try (Scanner fileReader = new Scanner(file)) {
                while (fileReader.hasNextLine()) {
                    System.out.println(fileReader.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

            System.out.println("\n============================\n");
        }

        input.close();
    }
}
