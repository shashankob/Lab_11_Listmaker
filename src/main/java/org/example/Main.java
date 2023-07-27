import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        char optionChoice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("A – Add an item to the list");
            System.out.println("D – Delete an item from the list");
            System.out.println("P – Print the list");
            System.out.println("Q – Quit the program");
            optionChoice = scanner.nextLine().toUpperCase().charAt(0);

            if(optionChoice == 'A') {
                System.out.println("Enter the string to add:");
                String itemToAdd = scanner.nextLine();
                myList.add(itemToAdd);
            } else if(optionChoice == 'D') {
                if (myList.isEmpty()) {
                    System.out.println("List is empty.");
                } else {
                    System.out.println("Enter the index of item to remove:");
                    int indexToRemove = getRangedInt(0, myList.size() - 1);
                    myList.remove(indexToRemove);
                }
            } else if(optionChoice == 'P') {
                System.out.println(myList);
            } else if(optionChoice == 'Q') {
                System.out.println("Are you sure you want to quit? (Y/N)");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("Y")) {
                    return;
                }
            }
        } while(true);
    }

    private static int getRangedInt(int minNum, int maxNum) {
        Scanner scanner = new Scanner(System.in);
        int inputChoice;
        do {
            System.out.println("Enter a number between " + minNum + " and " + maxNum);
            while (!scanner.hasNextInt()) {
                System.out.println("Try again");
                scanner.next();
            }
            inputChoice = scanner.nextInt();
        } while (inputChoice < minNum || inputChoice > maxNum);
        return inputChoice;
    }
}
