package Advanced;


/*
4.	Basic Queue Operations
You will be given an integer N representing the number of elements to enqueue (add),
an integer S representing the number of elements to dequeue (remove/poll) from the queue,
and finally an integer X, an element that you should check whether is present in the queue.
If it is - prints true on the console, if it is not - print the smallest element currently present in the queue.

Examples
Input	                Output
5 2 32
1 13 45 32 4	        true
	We have to push 5 elements.
Then we pop 2 of them.
Finally, we have to check whether 13 is present in the stack. Since it is, we print true.
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class ex04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToPush = firstLine[0];
        int elementsToPop = firstLine[1];
        int numberCheck = firstLine[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] secondLine = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        for (int i = 0; i < elementsToPush; i++) {
            queue.offer(secondLine[i]);
        }
        for (int i = 0; i < elementsToPop; i++) {
            queue.poll();
        }

        if (queue.size() == 0) {
            System.out.println(0);
        } else if (queue.contains(numberCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}

