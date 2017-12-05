import java.util.ArrayList;

public class User {
	private String name;
	private ArrayList<String> feed;
	private boolean isFriend;
	private ArrayList<String> friends;
	
	public User(String name, ArrayList<String> feed, boolean isFriend) {
		this.name = name;
		this.feed = feed;
		this.isFriend = isFriend;
		friends = new ArrayList<String>();
	}
	
	public void addToFeed(String text) {
		feed.add(text);
	}
	
	public boolean getIsFriend() {
		return isFriend;
	}
	
	public ArrayList<String> getFeed() {
		return feed;
	}
	
	public String getName() {
		return name;
	}
	
	public void setIsFriend(boolean value) {
		isFriend = value;
	}
	
	public void generateFriendsList(ArrayList<User> users, ArrayList<String> friendList) {
		this.friends = new ArrayList<String>();
		for (String friend : friendList) {
			for (User u : users) {
				if (u.getName().equals(friend)) {
					this.friends.add(friend);
					u.setIsFriend(true);
				}
			}
		}
	}
	
	public ArrayList<String> getFriends() {
		//System.out.println(friends);
		return friends;
	}
	
	public void setFriends(ArrayList<String> values) {
		friends = values;
	}
}