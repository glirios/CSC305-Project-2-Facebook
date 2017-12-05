
public class LoginTester {

	public static void main(String[] args) {
		NewFeed f_view = new NewFeed();
		LoginModel l_model = new LoginModel();
		LoginView l_view = new LoginView(l_model);
		PageModel p_model = new PageModel("Friends.txt", "Account.txt", "FriendList.txt");
		PageView p_view = new PageView(p_model);
		OtherUserView u_view = new OtherUserView(p_model);
		LoginController loginController = new LoginController(l_model, l_view, p_view, f_view, u_view);
		PageController pageController = new PageController(p_model, p_view, l_model, l_view, f_view);
		l_view.setVisible(true);
	}
}
