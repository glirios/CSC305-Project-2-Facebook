import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.util.ArrayList;

public class PageController {
	private PageModel p_model;
	private PageView p_view;
	private LoginView l_view;
	private LoginModel l_model;
	private NewFeed f_view;
	
	PageController(PageModel p_model, PageView p_view, LoginModel l_model, LoginView l_view, NewFeed f_view) {
		this.p_model = p_model;
		this.p_view = p_view;
		this.l_view = l_view;
		this.l_model = l_model;
		this.f_view = f_view;
		
		p_view.setAccountName(p_model.getUser().getName());
		p_view.setImage(p_model.getImageString());
		p_view.setFriendsList(p_model.getUser().getFriends());
		p_view.setNewsFeed(p_model.getUsers());
		p_view.setMyFeed(p_model.getUser().getFeed());
		p_view.initSearchBar(p_model.getStringNames());
		
		p_view.addFilterListener(new SearchBarListener());
		p_view.addFileExpolerListener(new ChangeProfileImageListener());
		p_view.addLogoutListener(new LogoutListener());
		f_view.addSubmitActionListener(new SubmitListener());
		p_view.align();
	}
	
	class ChangeProfileImageListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setCurrentDirectory(new File("~/sbh"));
			int result = jFileChooser.showOpenDialog(new JFrame());
			
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jFileChooser.getSelectedFile();
				System.out.println(selectedFile.getAbsolutePath());
				p_view.setImage(selectedFile.getAbsolutePath());
				p_view.align();
			}
		}
	}
	
	class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			p_view.terminate();
		}
	}
	
	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			p_view.addMoreFeed(f_view.getFeedInput());
			f_view.deleteText();
		}
	}

	class SearchBarListener implements KeyListener {
		public void keyPressed(KeyEvent key) {
			p_view.initSearchBar(p_model.filterBy(p_view.getSearchBarText()));
		}
		public void keyReleased(KeyEvent key) {
			
		}
		public void keyTyped(KeyEvent key) {
			
		}
	}
}
