package abc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NotificationSystemFacade facade = new NotificationSystemFacade();

        // Mock users
        facade.addSubscriber("user1", "Email");
        facade.addSubscriber("user2", "SMS");
        facade.addSubscriber("user3", "Email");
        facade.addSubscriber("user4", "SMS");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter notification channel: ");
        String channel = scanner.nextLine();
        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();
        System.out.print("Enter Message  ");
        String message = scanner.nextLine();

        facade.sendNotifications(channel, subject, message);
    }
}
