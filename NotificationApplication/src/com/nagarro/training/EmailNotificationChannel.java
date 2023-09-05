package abc;

public class EmailNotificationChannel implements NotificationChannel {

	@Override
	public void sendNotification(String user, String subject, String message) {
		 System.out.println("Sending mail to " + user + "\nSubject: " + subject + "\nMessage: " + message);
    
	}

}
