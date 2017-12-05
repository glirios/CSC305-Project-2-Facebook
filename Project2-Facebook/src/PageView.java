import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class PageView extends JFrame{
	private JLabel image = new JLabel();
	private JLabel name = new JLabel();
	private JButton imageFile = new JButton("Change Image");
	private JButton logout = new JButton("Logout");
	private JComboBox<String> searchBar = new JComboBox<String>();
	
	private JPanel friendList = new JPanel();
	private JPanel content = new JPanel();
	private JPanel header = new JPanel();
	private JPanel newsFeed = new JPanel();
	private JPanel myFeed = new JPanel();
	private JPanel master = new JPanel();
	private JPanel feed = new JPanel();
	private PageModel model;
	
	PageView(PageModel p_model) {
		model = p_model;

		searchBar.setEditable(true);
		searchBar.setSelectedItem("");

		master.setLayout(new GridLayout(2,2));
		
		content.setLayout(new FlowLayout());
		friendList.setLayout(new GridLayout(10, 1));
		header.setLayout(new GridLayout(2, 1));
		feed.setLayout(new GridLayout(2,1));
		
		header.add(image);
		header.add(name);
		
		content.add(imageFile);
		content.add(searchBar);
		content.add(logout);
		
		master.add(header);
		master.add(content);
		master.add(friendList);
		
		feed.add(myFeed);
		feed.add(newsFeed);
		
		master.add(feed);
		
		this.setContentPane(master);
		this.pack();
		this.setTitle("User Profile");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	void initSearchBar(String[] vals) {
		String temp = searchBar.getEditor().getItem().toString();
		searchBar.getEditor().getItem().toString();
		searchBar.removeAllItems();
		
		for (String val : vals) {
			searchBar.addItem(val);
		}
		searchBar.setSelectedItem(temp);
	}
	
	void setMyFeed(ArrayList<String> feed) {
		myFeed.removeAll();
		
		myFeed.setLayout(new GridLayout(feed.size() + 1, 1));
		myFeed.add(new JLabel("My Feed: "));
		for (String s : feed) {
			myFeed.add(new JLabel(s));
		}
		
		
	}
	
	void addMoreFeed(String input) {
		newsFeed.add(new JLabel(input));
		this.pack();
	}
	
	String getSearchBarText() {
		return searchBar.getEditor().getItem().toString();
	}
	
	void setNewsFeed(ArrayList<User> list) {
		newsFeed.removeAll();
		newsFeed.setLayout(new GridLayout(list.size() * 2, 1));
		newsFeed.add(new JLabel("News Feed:"));
		for (User u : list) {
			if (u.getIsFriend()) {
				for (String feed : u.getFeed()) {
					System.out.println(feed);
					newsFeed.add(new JLabel(u.getName() + " : " + feed));
				}
			}
		}
	}
	
	void setFriendsList(ArrayList<String> list) {
		friendList.removeAll();
		
		for (String name: list) {
			friendList.add(new JButton(name));
		}
//		friendList.revalidate();
//		friendList.repaint();
	}
	
	void setImage(String imageLoc) {
		System.out.println(imageLoc);
		ImageIcon imageIcon = new ImageIcon(imageLoc);
		image.setIcon(imageIcon);
	}
	
	void setAccountName(String value) {
		name.setText(value);;
	}
	
	void addFileExpolerListener(ActionListener fileExp) {
		imageFile.addActionListener(fileExp);
	}
	
	void addLogoutListener(ActionListener exit) {
		logout.addActionListener(exit);
	}
	
	void addFilterListener(KeyListener key) {
		searchBar.getEditor().getEditorComponent().addKeyListener(key);
	}
	
	void align() {
		this.pack();
	}
	
	void terminate() {
		JOptionPane.showMessageDialog(this, "Loggin out of program. Please come again soon.");
		System.exit(0);
	}
}
