package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* AdminLoginForward（管理者ログイン画面にに繋ぐ）
* @author フウン　ヴァンソン
*/
@WebServlet("/AdminLoginForward")
public class AdminLoginForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * AdminLogin.jsp（管理者ログイン画面）に転送する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forwardメソッドを使用し、指定されたAdminLogin.jspに転送される
		RequestDispatcher rd = request.getRequestDispatcher("/View/AdminLogin.jsp");
		rd.forward(request, response);
		
	}

	

}
