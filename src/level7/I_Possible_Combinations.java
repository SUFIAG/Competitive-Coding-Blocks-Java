package level7;

import java.util.Scanner;

public class I_Possible_Combinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String string = scanner.nextLine();
        print_Combinations(string, "");
    }

    public static void print_Combinations(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < ques.length(); i++) {
            char firstChar = ques.charAt(i);
            String s1 = ques.substring(0, i);
            String s2 = ques.substring(i + 1);
            print_Combinations(s1 + s2, ans + firstChar);
        }
    }
}
