package abc;

public class NotificationChannelFactory {
	   public NotificationChannel createChannel(String channelType) {
	        if (channelType.equalsIgnoreCase("Email")) {
	            return new EmailNotificationChannel();
	        } else if (channelType.equalsIgnoreCase("SMS")) {
	            return new SMSNotificationChannel();
	        }
	        throw new IllegalArgumentException("Unsupported notification channel");
	    }
	}

