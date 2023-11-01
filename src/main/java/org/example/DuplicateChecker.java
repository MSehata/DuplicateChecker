package org.example;

import java.util.*;

public class DuplicateChecker {

    public static void checkForDuplicates(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("Duplicate number found: " + number);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a list of integers (space-separated): ");
        String input = scanner.nextLine();

        String[] inputArray = input.split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        try {
            for (String str : inputArray) {
                int num = Integer.parseInt(str);
                numbers.add(num);
            }

            checkForDuplicates(numbers);
            System.out.println("No duplicates found.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter integers only.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
