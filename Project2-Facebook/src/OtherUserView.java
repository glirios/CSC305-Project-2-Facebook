import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class OtherUserView extends JFrame{
	private JLabel image = new JLabel();
	private JLabel name = new JLabel();
	private JButton back = new JButton("Back");
	private JButton follow = new JButton("Follow");
	private JButton unfollow = new JButton("Unfollow");
	
	private JPanel content = new JPanel();
	private JPanel header = new JPanel();
	private JPanel master = new JPanel();
	private JPanel myFeed = new JPanel();
	
	private PageModel model;
	
	OtherUserView(PageModel p_model) {
		model = p_model;


		master.setLayout(new GridLayout(2,2));
		
		content.setLayout(new FlowLayout());
		header.setLayout(new GridLayout(2, 1));
		myFeed.setLayout(new GridLayout(10,1));
		
		header.add(image);
		header.add(name);
		
		content.add(back);
		content.add(follow);
		content.add(unfollow);
		
		master.add(header);
		master.add(content);
		master.add(myFeed);
		
		this.setContentPane(master);
		this.pack();
		this.setTitle("User Profile");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	void setMyFeed(ArrayList<String> feed) {
		myFeed.removeAll();
		
		myFeed.setLayout(new GridLayout(feed.size() + 1, 1));
		myFeed.add(new JLabel("My Feed: "));
		for (String s : feed) {
			myFeed.add(new JLabel(s));
		}
		
		
	}
	
	void setImage() {
		String imageLoc = "dummyProfiles.jpg";
		System.out.println(imageLoc);
		ImageIcon imageIcon = new ImageIcon(imageLoc);
		image.setIcon(imageIcon);
	}
	
	void setAccountName(String value) {
		name.setText(value);;
	}
	
	void align() {
		this.pack();
	}
}