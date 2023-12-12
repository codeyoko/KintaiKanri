package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import BEAN.SearchEmpAndWork;
import DAO.ProcessDAO;
import DB.DBConnection;

/**
* SearchWorkController（勤務時間情報検索）
* @author フウン　ヴァンソン
*/
@WebServlet("/SearchWorkController")
public class SearchWorkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchWorkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//日本語を登録できるように設定
		response.setContentType("text/html; charset=UTF-8");
		
		//フォームから送信されたデータを取得
		String optionValue = request.getParameter("selectOption");
		String searchKey = request.getParameter("search_key");
		
		//BD定義
		Connection conn = DBConnection.createConnection();
		
		//全ての項目に入力されるかチェック
		if(!optionValue.isEmpty() && !searchKey.isEmpty()) {
			
	        // 数字、日付、または文字列の検証 正規表現
	        String numericRegex = "^[0-9]+$";
	        String dateRegex = "\\d{4}-\\d{2}-\\d{2}|\\d{4}/\\d{2}/\\d{2}|\\d{4}年\\d{1,2}月\\d{1,2}日";
	        String stringRegex = "^[a-zA-Z\\u4e00-\\u9fa5ァ-ヶー]+$";
			
			 //部署名検索処理
			 if(optionValue.equals("depatment")) {
				 //文字列検証
				 if(searchKey.matches(stringRegex)) {
					 List<SearchEmpAndWork> WorkEmpList = ProcessDAO.displayDepatmentWork(conn, searchKey);
					 request.setAttribute("WorkingList", WorkEmpList);
					 RequestDispatcher rd = request.getRequestDispatcher("View/Work_Search.jsp");
					 rd.forward(request,response); 
				 }else {
					 //入力されたデータは文字列でない場合はエラーメッセージが返す
					 request.setAttribute("errmgs4", "条件に部署名を入力してください。");
					 RequestDispatcher rd = request.getRequestDispatcher("View/Work_Search.jsp");
					 rd.forward(request,response); 
				 }
					
			 }
			 
			 //日付検索処理
			 if(optionValue.equals("workdate")) {
				 //日付検証
				 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				 try {
					 LocalDate loDate = LocalDate.parse(searchKey, dateFormatter);
					 List<SearchEmpAndWork> WorkEmpList = ProcessDAO.displayWorkDate(conn, searchKey);
					 request.setAttribute("WorkingList", WorkEmpList);
					 RequestDispatcher rd = request.getRequestDispatcher("View/Work_Search.jsp");
					 rd.forward(request,response); 
					 
				 }catch(DateTimeParseException e) {
					//入力されたデータは日付でない場合はエラーメッセージが返す
					 request.setAttribute("errmgs4", "条件に日付を入力してください。");
					 RequestDispatcher rd = request.getRequestDispatcher("View/Work_Search.jsp");
					 rd.forward(request,response); 
				 }   	
			 }
			
		}else {
			//全ての項目に入力されない場合はエラーメッセージが返す
			request.setAttribute("errmgs4", "条件を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("View/Work_Search.jsp");
			rd.forward(request,response);
		}
	}
}
