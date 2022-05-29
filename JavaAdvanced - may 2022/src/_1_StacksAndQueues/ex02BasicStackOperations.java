package _1_StacksAndQueues;
/*
2.	Basic Stack Operations
You will be given an integer N representing the number of elements to push into the stack,
an integer S representing the number of elements to pop from the stack, and finally an integer X,
an element that you should check whether is present in the stack. If it is, print "true" on the console.
If it’s not, print the smallest element currently present in the stack.

Input
•	On the first line, you will be given N, S, and X separated by a single space.
•	On the next line, you will be given a line of numbers separated by one or more white spaces.
Output
•	On a single line print, either "true" if X is present in the stack, otherwise print the smallest element in the stack.
•	If the stack is empty – print 0.

Examples
Input	                Output	Comments
5 2 13
1 13 45 32 4	         true	We have to push 5 elements. Then we pop 2 of them. Finally, we have to check whether 13 is present in the stack. Since it is, we print true.
4 1 666
420 69 13 666	          13	Pop one element (666) and then check if 666 is present in the stack. It's not, so print the smallest element (13).
3 3 90
90 90 90	              0

 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ex02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToPush = firstLine[0];
        int elementsToPop = firstLine[1];
        int numberCheck = firstLine[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] secondLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        for (int i = 0; i < elementsToPush; i++) {
            stack.push(secondLine[i]);
        }
        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if (stack.size() == 0) {
            System.out.println(0);
        } else if (stack.contains(numberCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
