package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* HomePageForward（ホームページに繋ぐ）
* @author フウン　ヴァンソン
*/
@WebServlet("/HomePageForward")
public class HomePageForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * HomePage.jsp（管理者ログイン画面）に転送する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forwardメソッドを使用し、指定されたHomePage.jspに転送される
		RequestDispatcher rd = request.getRequestDispatcher("/View/HomePage.jsp");
		rd.forward(request, response);
		
	}



}
