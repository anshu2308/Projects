package abc;

public class SMSNotificationChannel implements NotificationChannel{
    public void sendNotification(String user, String subject, String message) {
        System.out.println("Sending SMS to " + user + "\nSubject: " + subject + "\nMessage: " + message);
    }
}