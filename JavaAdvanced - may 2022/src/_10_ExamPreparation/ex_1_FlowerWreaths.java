package _10_ExamPreparation;


/*
Link: https://judge.softuni.org/Contests/Practice/Index/2531#0
You want to go on a flowers wreath competition but to participate you have to make at least 5 flower wreaths.
You will be given two sequences of integers, representing roses and lilies. You need to start making wreaths
knowing that one wreath needs 15 flowers. Your goal is to make at least 5 flower wreaths.
You will start crafting from the last lilies and the first roses. If the sum of their values is equal to 15 –
create one wreath and remove them. If the sum is bigger than 15, just decrease the value of the lilies by 2.
If the sum is less than 15 you have to store them for later and remove them. You need to stop combining when
you have no more roses or lilies. In the end, if you have any stored flowers you should make as many wreaths
as you can with them.

Input
•	On the first line, you will receive the integers representing the lilies, separated by ", ".
•	On the second line, you will receive the integers representing the roses, separated by ", ".

Output
•	Print whether you have succeeded making at least 5 wreaths:
o	"You made it, you are going to the competition with {count of wreaths} wreaths!"
o	"You didn't make it, you need {wreaths needed} wreaths more!"

Constraints
•	All of the given numbers will be valid integers in the range [0, 120].
•	Don't have situation with negative number.

Examples
Input	                                                    Output
10, 15, 2, 7, 9, 13
2, 10, 8, 12, 0, 5
	                                                        You made it, you are going to the competition with 5 wreaths!

Comment
We start with the last lilies (13) and the first roses (2) -> 13 + 2 = 15 -> 15 = 15 So we create one wreath and remove them bouth.
Next we have 9 + 10 = 19 -> 19 > 15 so we decrease the lilies by 2 -> 7 + 10 = 17 and we decrease the liles by 2 -> 5 + 10 = 15 and we create one more wreath and remove them.
Next, we have 7 + 8 = 15. We create one more wreaht and remove them.
Next, we have  2 + 12 = 14 -> 14 < 15 so we have to store theire sum for later and remove theme.
Next, we have 15 + 0 = 15 so we create one more wreath.
And last we have 10 + 5 = 15, we create one more wreath and stop mixing because we don’t have any flowers left.
Now we have a tottal of 5 wreaths and we also have 14 flowers left but we cant create wreath because 14 < 15.

 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ex_1_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        List<Integer> firstLine = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        firstLine.forEach(lilies::push);

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        List<Integer> secondLine = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        secondLine.forEach(roses::offer);


        int sum = 0;
        int wreaths = 0;
        int flowersLeft = 0;

        while (!roses.isEmpty() && !lilies.isEmpty()) {
            sum = roses.poll() + lilies.pop();

            while (sum >= 15) {

                if (sum == 15) {
                    wreaths++;
                    break;

                } else if (sum > 15) {
                    sum -= 2;
                }
            }

            if (sum < 15) {
                flowersLeft += sum;
            }
        }

        if (wreaths < 5) {
            wreaths += flowersLeft / 15;
        }

        if (wreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreaths + " wreaths!");

        } else {
            System.out.println("You didn't make it, you need " + (5 - wreaths) + " wreaths more!");
        }


    }
}
