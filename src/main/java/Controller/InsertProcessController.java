package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Calendar;

import BEAN.Employee;
import DAO.ProcessDAO;
import DB.DBConnection;

/**
* InsertProcessController（社員登録）
* @author フウン　ヴァンソン
*/

@WebServlet("/InsertProcessController")
public class InsertProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertProcessController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 社員登録処理、登録成功の場合はEmpRegist_Succecss.jspに転送する
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//日本語を登録できるように設定
		response.setContentType("text/html; charset=UTF-8");

		//フォームから送信されたデータを取得
		String empcode = request.getParameter("emp_code");
		String startday = request.getParameter("start_day");
		String empname = request.getParameter("emp_name");
		String empbirthday = request.getParameter("emp_birthday");
		String lastday = request.getParameter("last_day");
		String depatment = request.getParameter("dept_name");
		
		//文字列検証用
		String stringRegex = "^[a-zA-Z\\u4e00-\\u9fa5ァ-ヶー]+$";

		 //退職日以外の項目に入力されるかチェック
		 if(!empcode.isEmpty() && !startday.isEmpty() && !empname.isEmpty() &&
				  !empbirthday.isEmpty() && !depatment.isEmpty()) {
			 
			 //名前と部署名に文字列かチェック
			 if(empname.matches(stringRegex) || depatment.matches(stringRegex)){
				 //年齢及び入社年数計算
				 Calendar cal = Calendar.getInstance();
				 int currentYear = cal.get(Calendar.YEAR);
				 String [] startday_str = startday.split("-");
				 String[] empbirthday_str = empbirthday.split("-");
				 
				 int start_year = Integer.parseInt(startday_str[0]);
				 int year_birth = Integer.parseInt(empbirthday_str[0]);
				 
				 //入社年数
				 int work_year = currentYear - start_year;
				 //年齢
				 int emp_age = currentYear -  year_birth;
				 
				 //Employeeに登録
				 Connection conn = DBConnection.createConnection(); 
				 Employee Emp = new Employee();
				 Emp.setEmpCode(empcode);
				 Emp.setStartDay(startday);
				 Emp.setWorkYears(work_year);
				 Emp.setEmpName(empname);
				 Emp.setEmpBirthDay(empbirthday);
				 Emp.setEmpAge(emp_age);
				 Emp.setLastDay(lastday);
				 Emp.setDepatment(depatment);
				
				 //DBに挿入処理
				 boolean flag = ProcessDAO.insertEmp(conn, Emp); 
				 if(flag) { 
					  //挿入完了
					  RequestDispatcher rd = request.getRequestDispatcher("View/EmpRegist_Succecss.jsp");  
					  rd.forward(request, response);
				 }else { 
					  //挿入できない場合はエラーメッセージが返す
					  request.setAttribute("errmgs1","社員番号が既に存在しています。");
					  RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Regist.jsp"); 
					  rd.forward(request,response); 
				 }
			 }else {
				  //名前と部署名に文字列でない場合エラーメッセージが返す
				  request.setAttribute("errmgs2", "名前と部署名に文字列を入力してください。");
				  RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Regist.jsp");
				  rd.forward(request,response);
			 }
			 	 
		  }else { 
			  //退職日以外の項目に入力されるない場合はエラーメッセージが返す
			  request.setAttribute("errmgs3", "退職日以外、全ての項目を入力してください。");
			  RequestDispatcher rd = request.getRequestDispatcher("View/Emp_Regist.jsp");
			  rd.forward(request,response);
		 }
	}
}
