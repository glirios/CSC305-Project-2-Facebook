import java.awt.event.*;

public class LoginController {

	private LoginModel m_model;
	private LoginView m_view;
	private PageView p_view;
	private NewFeed f_view;
	private OtherUserView u_view;
	LoginController(LoginModel model, LoginView view, PageView pview, NewFeed fview, OtherUserView uview) {
		m_model = model;
		m_view = view;
		p_view = pview;
		f_view = fview;
		u_view = uview;
		
		m_view.addLoginActionListener(new LoginListener());
	}
	
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (m_view.getUsernameInput().equals(m_model.getUsername()) && 
					m_view.getPasswordInput().equals(m_model.getPassword())) {
				m_view.setVisible(false);
				p_view.setVisible(true);
				f_view.setVisible(true);
				u_view.setVisible(false);
				m_view.reset();	
			}
			else {
				m_view.showError("Wrong Password/Username");
			}
		}
	}
}
