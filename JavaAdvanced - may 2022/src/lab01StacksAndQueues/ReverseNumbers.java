package lab01StacksAndQueues;

/*
Write a program that reads N integers from the console and reverses them using a stack.
Use the ArrayDeque<Integer> class. Just put the input numbers in the stack and pop them.
Examples
Input	    Output
1 2 3 4 5	5 4 3 2 1
------------------------
1	        1
 */


import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbers {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }

        for (Integer number : stack) {
            System.out.print(stack.pop() + " ");
        }


    }


}
