package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* WorkSearchForward（勤務時間検索画面に繋ぐ）
* @author フウン　ヴァンソン
*/
@WebServlet("/WorkSearchForward")
public class WorkSearchForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkSearchForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Work_Search.jsp（勤務時間検索）に転送する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forwardメソッドを使用し、指定されたWork_Search.jspに転送される
		RequestDispatcher rd = request.getRequestDispatcher("/View/Work_Search.jsp");
		rd.forward(request, response);
	}

	

}
