package abc;

import java.util.HashSet;
import java.util.Set;

class UsersList {
	 private static UsersList instance = new UsersList();
	    private Set<String> users;

	    private UsersList() {
	        users = new HashSet<>();
	        users.add("user1");
	        users.add("user2");
	        users.add("user3");
	        users.add("user4");
	    }

	    public static UsersList getInstance() {
	        return instance;
	    }

	    public Set<String> getUsers() {
	        return users;
	    }
	}