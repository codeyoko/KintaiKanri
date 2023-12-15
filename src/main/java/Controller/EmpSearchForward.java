package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* EmpSearchForward（社員検索画面に繋ぐ）
* @author フウン　ヴァンソン
*/
@WebServlet("/EmpSearchForward")
public class EmpSearchForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearchForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Emp_Search.jsp（社会検索）に転送する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forwardメソッドを使用し、指定されたEmp_Search.jspに転送される
		RequestDispatcher rd = request.getRequestDispatcher("/View/Emp_Search.jsp");
		rd.forward(request, response);
	}

	

}
