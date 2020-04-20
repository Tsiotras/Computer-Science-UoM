import java.util.HashSet;

public class UserCatalog {

	private static HashSet<User> allUsers = new HashSet<User>();

	public static HashSet<User> getAllUsers() {
		return allUsers;
	}
	
	public static void addToallUsers(User aUser) {
		allUsers.add(aUser);
	}
	
}
