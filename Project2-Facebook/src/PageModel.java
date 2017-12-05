import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PageModel {
	private ArrayList<User> users;
	private User user;
	private FileInputStream file = null;
	private BufferedReader reader = null;
	private String imageLoc;
	private ArrayList<String> friends;
	private String[] userNames;
	
	public PageModel(String usersString, String userString, String friendString)	{
		users = parseUsers(usersString);
		user = parseUser(userString);
		friends = parseFriends(friendString);
		user.generateFriendsList(users, friends);
		userNames = setStringNames(users);
	}
	
	public String[] setStringNames(ArrayList<User> values) {
		String[] temp = new String[values.size()];
		for (int i = 0; i < values.size(); i++) {
			temp[i] = values.get(i).getName();
		}
		return temp;
	}
	
	public String[] getStringNames() {
		return userNames;
	}
	public void setUsers(ArrayList<User> values) {
		users = values;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public User getUser() {
		return user;
	}
	
	public String getImageString() {
		return imageLoc;
	}
	
	public ArrayList<User> parseUsers(String string) {
		ArrayList<String> feed;
		String name = "";
		boolean isFriend = false;
		int numUsers;
		String input;
		ArrayList<User> temp = new ArrayList<User>();
		
		openFile(string);
		try {
			numUsers = Integer.valueOf(reader.readLine());
			input = reader.readLine();
			for (int i = 0; i < numUsers; i++) {
				if (input.contains("Name: ")) {
					name = input.replace("Name: ", "");
				}
				else {
					System.out.println("Format was not followed for name. Please follow following format");
					System.out.println("Name: <String>");
					System.exit(1);
				}
				feed = new ArrayList<String>();
				while ((input = reader.readLine()) != null && input.contains("Feed: ")) {
					feed.add(input.replace("Feed: ", ""));
				} 
				temp.add(new User(name, feed, isFriend));
				
			} 
		} catch (IOException e) {
			System.out.println("Format was not followed for name. Please follow following format");
			System.out.println("<Number of Users>");
			System.exit(1);
		} 
		System.out.println(temp);
		return temp;
		
	}
	
	public ArrayList<String> parseFriends(String string) {
		ArrayList<String> friends = new ArrayList<String>();
		String input;
		
		openFile(string);
		
		try {
			while ((input = reader.readLine()) != null) {
				friends.add(input);
			}
		} catch (IOException e) {
			System.out.println("Format was not followed for name. Please follow following format");
			System.out.println("<Name>");
			System.exit(1);
		}
		return friends;
	}
	
	public User parseUser(String string) {
		ArrayList<String> feed = new ArrayList<String>();
		String name = "";
		boolean isFriend = true;
		String input;
		
		openFile(string);
		
		try {
			name = reader.readLine().replace("Name: ", "");
		} catch (IOException e) {
			System.out.println("Format was not followed for name. Please follow following format");
			System.out.println("Name: <Name>");
			System.exit(1);
		}
		
		try {
			imageLoc = reader.readLine().replace("Starting Image: ", "");
		} catch (IOException e) {
			System.out.println("Format was not followed for name. Please follow following format");
			System.out.println("Starting Image: <String>");
			System.exit(1);
		}
		
		try {
			while ((input = reader.readLine()) != null) {
				if (input.contains("Feed: ")) {
					feed.add(input.replace("Feed: ", ""));
				}
				else {
					System.out.println("Format was not followed for name. Please follow following format");
					System.out.println("Feed: <String>");
					System.exit(1);
				}
			}
		} catch (IOException e) {
			
		}
		return new User(name, feed, isFriend);
	}
	
	public String[] filterBy(String s) {
		ArrayList<User> res = new ArrayList<User>();
		
		if (!s.equals("")) {
			for (User u : users) {
				if (u.getName().toLowerCase().contains(s.toLowerCase())) {
					res.add(u);
				}
			}
			return setStringNames(res);
		}
		
		return userNames;
		
	}
	
	public void openFile(String s) {
		try {
			file = new FileInputStream(s);
			reader = new BufferedReader(new InputStreamReader(file));
			System.out.println("Now reading file " + s);
		} catch (FileNotFoundException ex) {
			System.out.println("File could not be found.");
			System.exit(1);
		}
	}
}
