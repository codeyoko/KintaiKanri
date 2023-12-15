package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* EmpRegistForward（社員登録画面に繋ぐ）
* @author フウン　ヴァンソン
*/
@WebServlet("/EmpRegistForward")
public class EmpRegistForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpRegistForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Emp_Regist.jsp（社員登録）に転送する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forwardメソッドを使用し、指定されたEmp_Regist.jspに転送される
		RequestDispatcher rd = request.getRequestDispatcher("/View/Emp_Regist.jsp");
		rd.forward(request, response);
	}

	
}
