package Costigan;

import java.util.ArrayList;
import java.util.Scanner;

public class LetterGenerator {
    private ArrayList<Account> accounts;
    private String formLetter;

    public LetterGenerator() {
        accounts = new ArrayList<Account>();
        formLetter = "Dear [name], its been [days] since your last purchase " +
                "of the [purchase].  We hope to see you again soon!";
    }

    public void addAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter last item purchased: ");
        String item = scanner.nextLine();
        System.out.print("Enter days since last purchase: ");
        int days = Integer.parseInt(scanner.nextLine());

        Account account = new Account(name, item, days);
        accounts.add(account);
    }

    public void generateLetters() {
        for (Account currAccount : accounts) {
            String letter = formLetter.replace("[name]", currAccount.getName());
            letter = letter.replace("[days]", String.valueOf(currAccount.getDaysSincePurchase()));
            letter = letter.replace("[purchase]", currAccount.getLastPurchase());
            System.out.println(letter);
            System.out.println();
        }
    }

    public static void main(String [] args) {
        LetterGenerator letterGenerator = new LetterGenerator();
        letterGenerator.addAccount();
        letterGenerator.addAccount();
        letterGenerator.addAccount();
        letterGenerator.generateLetters();
    }
}
