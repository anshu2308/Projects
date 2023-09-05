package abc;

import java.util.List;

public class NotificationSystemFacade {
	 private UsersList usersDatabase;
	    private NotificationChannelFactory channelFactory;
	    private SubscriptionManager subscriptionManager;

	    public NotificationSystemFacade() {
	        usersDatabase = UsersList.getInstance();
	        channelFactory = new NotificationChannelFactory();
	        subscriptionManager = new SubscriptionManager();
	    }

	    public void addSubscriber(String user, String channel) {
	        subscriptionManager.subscribe(user, channel);
	    }

	    public void sendNotifications(String channel, String subject, String message) {
	        List<String> subscribers = subscriptionManager.getSubscribers(channel);
	        NotificationChannel notificationChannel = channelFactory.createChannel(channel);
	        NotificationSenderAdapter senderAdapter = new NotificationSenderAdapter(notificationChannel);

	        for (String user : subscribers) {
	            senderAdapter.sendNotification(user, subject, message);
	        }
	    }
}
