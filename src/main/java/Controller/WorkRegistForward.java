package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* WorkRegistForward（勤務時間登録画面に繋ぐ）
* @author フウン　ヴァンソン
*/
@WebServlet("/WorkRegistForward")
public class WorkRegistForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkRegistForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Work_Regist.jsp（勤務時間登録）に転送する
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forwardメソッドを使用し、指定されたWork_Regist.jspに転送される
		RequestDispatcher rd = request.getRequestDispatcher("/View/Work_Regist.jsp");
		rd.forward(request, response);
	}

	
}
