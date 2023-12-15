package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import BEAN.Admin;
import DAO.ProcessDAO;
import DB.DBConnection;

/**
* LoginController（管理者ログイン）
* @author フウン　ヴァンソン
*/
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 管理者ログイン処理、ログイン成功の場合はHomePage.jspに転送する
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//日本語を登録できるように設定
		response.setContentType("text/html; charset=UTF-8");
		
		//フォームから送信されたデータを取得
		String username = request.getParameter("userName");
		String pass = request.getParameter("password");

		//全ての項目に入力されるかチェック
		if(!username.isEmpty() && !pass.isEmpty()) {	
			
			Admin admin = new Admin();
			admin.setUserName(username);
			admin.setPassword(pass);
			
			Connection conn = DBConnection.createConnection();
			boolean flag = ProcessDAO.checkLogin(conn, admin);
			if(flag) {
				  //UserName, PasswordがOK
				  RequestDispatcher rd = request.getRequestDispatcher("View/HomePage.jsp");
				  rd.forward(request,response);
				
			}else {
				  //UserName, Passwordが不正な場合はエラーメッセージが返す
				  request.setAttribute("errmgsLogin", "IDかパスワードが違います。");
				  RequestDispatcher rd = request.getRequestDispatcher("View/AdminLogin.jsp");
				  rd.forward(request,response);
			}
			
		}else {
			  //全ての項目に入力されるない場合はエラーメッセージが返す
			  request.setAttribute("errmgsLogin", "IDとパスワードを入力してください。");
			  RequestDispatcher rd = request.getRequestDispatcher("View/AdminLogin.jsp");
			  rd.forward(request,response);
		}
	}

}
