package ExamPreparation.June2021;

/*
You are hired to create a program that schedules the work of an OS and avoids tasks that could harm it.
On the first line, you will be given some tasks as integer values, separated by a comma and space ", ".
On the second line, you will be given some threads as integer values, separated by a single space.
On the third line, you will receive the integer value of a task that you need to kill. Your job is to stop
the work of the OS as soon as you get to this task, otherwise, your OS will crash. The thread that
gets first to this task, kills it.

The OS works in the following way:
•	It takes the first given thread value and the last given task value.
•	If the thread value is greater than or equal to the task value, the task and thread get removed.
•	If the thread value is less than the task value, the thread gets removed, but the task remains.

After you finish the needed task, print on a single line:
"Thread with value {thread} killed task {taskToBeKilled}"
Then print the remaining threads (including the one that killed the task) starting from the first
on a single line, separated by a single space.

Input
•	On the first line, you will receive the tasks, separated by ", ".
•	On the second line, you will the threads, separated by a single space.
•	On the third line, you will receive a single integer – a value of the task to be killed.

Output
•	Print the thread that killed the task and the task itself in the format given above.
•	Print the remaining threads starting from the first on a single line, separated by a single space.

Constraints
•	The needed task will always be with a unique value.
•	You will always have enough threads to get to the needed task.

Examples
Input	                                                            Output
20, 23, 54, 34, 90
150 64 20 34
54	                                                                Thread with value 20 killed task 54
                                                                    20 34
Comment
First, the thread with a value of 150 is taken and the task with a value of 90.
The thread has a bigger value, so both thread and task get removed.
Next, thread 64 finishes task 34 and both get removed.
Then thread 20 gets to task 54 and kills it.

 */

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _1_OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        ArrayDeque<Integer> treadQueue = new ArrayDeque<>();

        String[] line1 = scanner.nextLine().split(", ");
        for (String task : line1) {
            taskStack.push(Integer.parseInt(task));
        }

        String[] line2 = scanner.nextLine().split(" ");
        for (String tread : line2) {
            treadQueue.offer(Integer.parseInt(tread));
        }

        int value = Integer.parseInt(scanner.nextLine());
        int currentTread = -1;
        int currentTask = -1;
        int repetitions = treadQueue.size();
        for (int i = 0; i < repetitions; i++) {

            currentTread = treadQueue.poll();
            currentTask = taskStack.pop();

            if (currentTask == value) {
                break;
            } else {
                if (currentTask > currentTread) {
                    while (currentTask > currentTread) {
                        currentTread = treadQueue.poll();
                    }
                }
            }
        }

        System.out.println("Thread with value " + currentTread + " killed task " + currentTask);
        treadQueue.push(currentTread);
        System.out.println(treadQueue.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }
}
