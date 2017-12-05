import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class NewFeed extends JFrame{
	private JButton submit = new JButton("Submit");
	private JTextField feed = new JTextField(25);
	
	private JPanel content = new JPanel();
	
	NewFeed() {
		content.setLayout(new FlowLayout());
		
		content.add(feed);
		content.add(submit);
		
		this.setContentPane(content);
		this.setTitle("New Feed Input");
		this.pack();
	}
	
	String getFeedInput() {
		return feed.getText();
	}
	
	void addSubmitActionListener(ActionListener s) {
		submit.addActionListener(s);
	}
	
	void deleteText() {
		feed.setText("");
	}
	
	void visible() {
		this.setVisible(true);
	}
}
