package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import org.apache.tomcat.jakartaee.commons.lang3.math.NumberUtils;

import BEAN.Employee;
import DAO.ProcessDAO;
import DB.DBConnection;

/**
* SearchEmController（社員情報検索）定義
* @author フウン　ヴァンソン
*/
@WebServlet("/SearchEmController")
public class SearchEmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
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
			
	        //数字、日付、または文字列の検証
	        String numericRegex = "^[0-9]+$";
	        String dateRegex = "\\d{4}-\\d{2}-\\d{2}|\\d{4}/\\d{2}/\\d{2}|\\d{4}年\\d{1,2}月\\d{1,2}日";
	        String stringRegex = "^[a-zA-Zぁ-んァ-ン一-龯々ー]+$";
	        
			 //年齢検索処理
			 if(optionValue.equals("age")) {	
				// 数字検証
		    	if(NumberUtils.isCreatable(searchKey)) {
		    		int key = Integer.parseInt(searchKey);
					List<Employee> EmpList = ProcessDAO.displayAgeEmployee(conn, key);
					request.setAttribute("EmployeeList", EmpList);
					RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Search.jsp");
					rd.forward(request,response);
		    	}else {
		    		//入力されたデータは数字でない場合はエラーメッセージが返す
		    		request.setAttribute("errmgs3", "条件に年齢の数字を入力してください。");
					RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Search.jsp");
					rd.forward(request,response);
		    	}	
			 }
			 
			 //入社年数検索処理
			 if(optionValue.equals("workYear")) {
				 // 数字検証
				 if(NumberUtils.isCreatable(searchKey)) {
					 int key = Integer.parseInt(searchKey);
					 List<Employee> EmpList = ProcessDAO.displayWorkYearEmployee(conn, key);
					 request.setAttribute("EmployeeList", EmpList);
					 RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Search.jsp");
					 rd.forward(request,response);
					  
				 }else {
					 //入力されたデータは数字でない場合はエラーメッセージが返す
					 request.setAttribute("errmgs3", "条件に入社年数の数字を入力してください。");
					 RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Search.jsp");
					 rd.forward(request,response);
					 
				 } 			
		    }
			 
			 //退職者検索処理
			 if(optionValue.equals("retiree")) {
				 //文字列検証   
				 if(searchKey.matches(stringRegex)) {
					 List<Employee> EmpList = ProcessDAO.displayRetireeEmployee(conn, searchKey);
					 request.setAttribute("EmployeeList", EmpList);
					 RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Search.jsp");
					 rd.forward(request,response); 
					 
				 }else {
					 //入力されたデータは文字列でない場合はエラーメッセージが返す
					 request.setAttribute("errmgs3", "条件に退職者の名前を入力してください。");
					 RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Search.jsp");
					 rd.forward(request,response); 
				 }
					
			 }
			 
			 //部署名検索処理
			 if(optionValue.equals("depatment")) {
				 //文字列検証 
				 if(searchKey.matches(stringRegex)) {
					 List<Employee> EmpList = ProcessDAO.displayDepatmentEmployee(conn, searchKey);
					 request.setAttribute("EmployeeList", EmpList);
					 RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Search.jsp");
					 rd.forward(request,response); 
				 }else {
					 //入力されたデータは文字列でない場合はエラーメッセージが返す
					 request.setAttribute("errmgs3", "条件に部署名を入力してください。");
					 RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Search.jsp");
					 rd.forward(request,response); 
				 }
			 }
			
		}else {
			//全ての項目に入力されない場合はエラーメッセージが返す
			request.setAttribute("errmgs3", "条件を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Search.jsp");
			rd.forward(request,response);
		}	
	}

}
