package abc;

import java.util.*;

class SubscriptionManager {
    private Map<String, List<String>> subscribers;

    public SubscriptionManager() {
        subscribers = new HashMap<>();
    }

    public void subscribe(String user, String channel) {
        if (!subscribers.containsKey(channel)) {
            subscribers.put(channel, new ArrayList<>());
        }
        subscribers.get(channel).add(user);
    }

    public List<String> getSubscribers(String channel) {
        return subscribers.getOrDefault(channel, new ArrayList<>());
    }
}
