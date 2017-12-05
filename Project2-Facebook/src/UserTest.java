import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class UserTest {

	@Test
	void testGenerateFriendsList() {
		ArrayList<String> empty = new ArrayList<String>();
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<String> friends = new ArrayList<String>();
		
		User user = new User("Giovanni Lirios", empty, false);
		users.add(new User("Carlos A", empty, false));
		users.add(new User("Carlos B", empty, false));
		users.add(new User("Carlos C", empty, false));
		users.add(new User("Jimmy A", empty, false));
		users.add(new User("Jimmy B", empty, false));
		users.add(new User("Jimmy C", empty, false));
		
		friends.add("Carlos A");
		friends.add("Jimmy B");
		
		user.generateFriendsList(users, friends);
		for (int i = 0; i < user.getFriends().size(); i++) {
			assertEquals(user.getFriends().get(i), friends.get(i));
		}
	}

	@Test
	void testGenerateFriendsList2() {
		ArrayList<String> empty = new ArrayList<String>();
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<String> friends = new ArrayList<String>();
		
		User user = new User("Giovanni Lirios", empty, false);
		users.add(new User("Carlos A", empty, false));
		users.add(new User("Carlos B", empty, false));
		users.add(new User("Carlos C", empty, false));
		users.add(new User("Jimmy A", empty, false));
		users.add(new User("Jimmy B", empty, false));
		users.add(new User("Jimmy C", empty, false));
		
		user.generateFriendsList(users, friends);
		for (int i = 0; i < user.getFriends().size(); i++) {
			assertEquals(user.getFriends().get(i), friends.get(i));
		}
	}

}
