package DLL_Stack_Queue_Practice.Stack;

import java.util.Scanner;
import java.util.Stack;

public class BookStackExample {
    public static void main(String[] args) {
        Stack<String> bookStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBook Stack Menu:");
            System.out.println("1. Add a book to the stack");
            System.out.println("2. Take out a book from the stack");
            System.out.println("3. View all books in the stack");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the book to add: ");
                    scanner.nextLine(); // Consume the newline character
                    String newBook = scanner.nextLine();
                    bookStack.push(newBook);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    if (bookStack.isEmpty()) {
                        System.out.println("Stack is empty. No book to take out.");
                    } else {
                        String removedBook = bookStack.pop();
                        System.out.println("Removed book: " + removedBook);
                    }
                    break;
                case 3:
                    if (bookStack.isEmpty()) {
                        System.out.println("Stack is empty. No books to display.");
                    } else {
                        System.out.println("Books in the stack:");
                        System.out.println(bookStack);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
