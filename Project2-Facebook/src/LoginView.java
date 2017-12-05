import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class LoginView extends JFrame{

	private JButton login = new JButton("Login");
	private JTextField txuser = new JTextField(15);
	private JPasswordField password = new JPasswordField(15);
	
	private LoginModel m_model;
	
	LoginView(LoginModel model) {
		m_model = model;
		
		JPanel content = new JPanel();
		content.setLayout(null);
		
		txuser.setBounds(70, 30, 150, 20);
		password.setBounds(70, 65, 150, 20);
		login.setBounds(110, 100, 80, 20);
		
		content.add(login);
		content.add(password);
		content.add(txuser);
		
		this.setContentPane(content);
		this.setTitle("Login Authentication");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		this.setLocation(500, 280);
		
	}
	
	String getUsernameInput() {
		return txuser.getText();
	}
	
	String getPasswordInput() {
		char[] chars = password.getPassword();
		String ret = "";
		
		for (Character c : chars) {
			ret += c.toString();
		}
		
		return ret;
	}
	
	void reset() {
		password.setText("");
		txuser.setText("");
	}
	
	void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
		reset();
		txuser.requestFocus();
	}
	
	void addLoginActionListener(ActionListener log) {
		login.addActionListener(log);
	}
	
}
