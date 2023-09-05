package abc;

public class NotificationSenderAdapter {
    private NotificationChannel channel;

    public NotificationSenderAdapter(NotificationChannel channel) {
        this.channel = channel;
    }

    public void sendNotification(String user, String subject, String message) {
        channel.sendNotification(user, subject, message);
    }
}