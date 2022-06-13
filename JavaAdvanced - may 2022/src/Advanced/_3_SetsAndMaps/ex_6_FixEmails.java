package Advanced._3_SetsAndMaps;

/*
You are given a sequence of strings, each on a new line until you receive
the "stop" command. The first string is a name of a person. On the second line,
you receive his email. Your task is to collect their names and emails and
remove emails whose domain ends with "us", "uk" or "com" (case insensitive).
Print in the following format:
"{name} – > {email}"


Examples
Input	                                    Output
John                                        John -> johnDoe@softuni.org
johnDoe@softuni.org                         Peter Smith -> smith.peter@softuni.org
Peter Smith
smith.peter@softuni.org
Taylor Baker
baker@gmail.com
stop
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex_6_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> info = new LinkedHashMap<>();

        Pattern invalidEmail = Pattern.compile("(com)$|(uk)$|(us)$");

        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            Matcher validEmail = invalidEmail.matcher(email);
            if (!validEmail.find()) {
                info.putIfAbsent(name, "");
                info.put(name, email);
            }


            name = scanner.nextLine();
        }

        info.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
