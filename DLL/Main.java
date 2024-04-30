package DLL_Stack_Queue_Practice.DLL;

import java.util.Scanner;

class PageNode {
    String pageName;
    PageNode previous;
    PageNode next;

    public PageNode(String pageName) {
        this.pageName = pageName;
        this.previous = null;
        this.next = null;
    }
}

class BrowserHistory {
    PageNode currentPage;

    public BrowserHistory() {
        currentPage = null;
    }

    // Add a new page to the browsing history
    public void addPage(String pageName) {
        PageNode newPage = new PageNode(pageName);
        if (currentPage == null) {
            currentPage = newPage;
        } else {
            newPage.previous = currentPage;
            currentPage.next = newPage;
            currentPage = newPage;
        }
    }

    // Navigate back to the previous page
    public void goBack() {
        if (currentPage != null && currentPage.previous != null) {
            currentPage = currentPage.previous;
        } else {
            System.out.println("No previous page available.");
        }
    }

    // Navigate forward to the next page
    public void goForward() {
        if (currentPage != null && currentPage.next != null) {
            currentPage = currentPage.next;
        } else {
            System.out.println("No next page available.");
        }
    }

    // Clear all browsing history
    public void closeBrowser() {
        currentPage = null;
        System.out.println("Browser history cleared.");
    }

    // Print the browsing history
    public void printHistory() {
        if (currentPage == null) {
            System.out.println("No browsing history.");
            return;
        }

        PageNode temp = currentPage;
        while (temp.previous != null) {
            temp = temp.previous;
        }

        System.out.println("Browsing History:");
        while (temp != null) {
            System.out.println(temp.pageName);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        boolean browsing = true;

        while (browsing) {
            System.out.println("\nMenu:");
            System.out.println("1. Visit Page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. Print History");
            System.out.println("5. Close Browser");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter page name: ");
                    String pageName = scanner.nextLine();
                    history.addPage(pageName);
                    break;
                case 2:
                    history.goBack();
                    break;
                case 3:
                    history.goForward();
                    break;
                case 4:
                    history.printHistory();
                    break;
                case 5:
                    history.closeBrowser();
                    browsing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }

        scanner.close();
    }
}
