import java.awt.event.*;

public class LoginController {

	private LoginModel m_model;
	private LoginView m_view;
	private PageView p_view;
	private NewFeed f_view;
	LoginController(LoginModel model, LoginView view, PageView pview, NewFeed fview) {
		m_model = model;
		m_view = view;
		p_view = pview;
		f_view = fview;
		
		m_view.addLoginActionListener(new LoginListener());
	}
	
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (m_view.getUsernameInput().equals(m_model.getUsername()) && 
					m_view.getPasswordInput().equals(m_model.getPassword())) {
				m_view.setVisible(false);
				p_view.setVisible(true);
				f_view.setVisible(true);
				m_view.reset();	
			}
			else {
				m_view.showError("Wrong Password/Username");
			}
		}
	}
}
