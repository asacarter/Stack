/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.Scanner;

/**
 *
 * @author asacarter
 */
public class StackApplication {

    public static String getText() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        return text;
    }

    public static void main(String[] args) {

        Stack<String> s1;
        Stack<String> s2;
        
        s1 = new ArrayStack<>();
        s2 = new LinkedStack<>();

        int choice;
        Scanner stdin = new Scanner(System.in);

        do {
            System.out.print("Next action (1 = Add item, " +
            "2 = Remove top item, 3 = Print top item, 0 = Exit): ");
            choice = stdin.nextInt();

            if (choice == 1) {
                String text = getText();
                s1.push(text);
                s2.push(text);
            }
            else if (choice == 2) {
                try {
                    s1.pop();
                    s2.pop();
                } catch (StackUnderflowException e) {
                     System.out.println("There are no items to remove.");
                }
            }
            else if (choice == 3) {
                try {
                    System.out.println( s1.top() );
                    System.out.println( s2.top() );
                } catch (StackUnderflowException e) {
                     System.out.println("There are no items to view.");
                }
            }
            else if (choice != 0) {
                System.out.println("Error: Valid choices are 0, 1, 2 or 3");
            }

            if (args.length != 0) {
                for (String arg : args) {
                    if ("test".equals(arg) && choice == 1 || choice == 2 || choice == 3) {
                        System.out.println( s1.toString() );
                        System.out.println( s2.toString() );
                    }
                }
            }
        } while (choice != 0);

        System.out.println("Goodbye");
    }
}