import java.util.ArrayList;
import java.util.Scanner;

public class GradeAnalyzer {
    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student grades. Type 'done' when you are finished:");

        
        while (true) {
            System.out.print("Enter grade (or 'done' to finish): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                double grade = Double.parseDouble(input);
                if (grade < 0) {
                    System.out.println("Grade cannot be negative. Please enter a valid grade.");
                } else {
                    grades.add(grade);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
            return;
        }

        // Calculate average, highest, and lowest scores
        double total = 0;
        double highest = grades.get(0);
        double lowest = grades.get(0);

        for (double grade : grades) {
            total += grade;
            if (grade > highest) {
                highest = grade;
            }
            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = total / grades.size();

        // Display results
        System.out.printf("Average score: %.2f%n", average);
        System.out.printf("Highest score: %.2f%n", highest);
        System.out.printf("Lowest score: %.2f%n", lowest);

        scanner.close();
    }
}