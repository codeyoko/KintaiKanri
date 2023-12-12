package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.Admin;
import BEAN.Employee;
import BEAN.SearchEmpAndWork;
import BEAN.Working;

/**
* ProcessDAO（データベースと問い合わせる）
* @author フウン　ヴァンソン
*/
public class ProcessDAO {
	
	//管理者のログインチェック
    public static boolean checkLogin(Connection conn, Admin ad) {
    	String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
    	try {
    		PreparedStatement pstm = conn.prepareStatement(sql);
            String userName = ad.getUserName();
            String password = ad.getPassword();
            pstm.setString(1, userName);
            pstm.setString(2, password);
            try (ResultSet resultSet = pstm.executeQuery()) {
                return resultSet.next();
            } 
    	}catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	//社員登録の処理
	public static boolean insertEmp(Connection conn, Employee Em) {
		
		boolean temp = true;
		
		String sql = "SELECT * FROM employee  WHERE emp_code = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			String empCode = Em.getEmpCode();
			pstm.setString(1, empCode);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				//社員番号が既に存在したらfalseが返す
				temp =  false;
			}else {
				
				String sql1 = "INSERT INTO employee (emp_code, start_date, work_year, emp_name, birthday, emp_age, last_date, depatment) VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql1);
				//String empCode   = Em.getEmpCode();
				String startDate = Em.getStartDay();
				int workYears = Em.getWorkYears();
				String empName   = Em.getEmpName();
				String birthDay  = Em.getEmpBirthDay();
				int empAge = Em.getEmpAge();
				String lastDate  = Em.getLastDay();
				String depatment =  Em.getDepatment();
				
				ps.setString(1, empCode);
				ps.setString(2, startDate);
				ps.setInt(3, workYears);
				ps.setString(4, empName);
				ps.setString(5, birthDay);
				ps.setInt(6, empAge);
				ps.setString(7, lastDate);
				ps.setString(8, depatment);
				
				int result = ps.executeUpdate();
				if(result != 0) {
					//登録出来たらtrueが返す
					temp =  true;
				}else {
					temp =  false;
				}
				ps.close();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	//勤務時間登録処理
	public static boolean insertWork(Connection conn, Working Work ) {
		
		String sql = "SELECT * FROM work WHERE emp_code = ? AND work_day = ?";
		try {
	
			PreparedStatement pstm = conn.prepareStatement(sql);
			String empcode = Work.getEmpCode();
			String workday = Work.getWorkDay();
			pstm.setString(1, empcode);
			pstm.setString(2, workday);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				//勤務時間が既に登録されたらfalseを返す	
				return  false;
			}else {
					
				//勤務時間を登録する
				String sql1 = "INSERT INTO work (emp_code, work_day, work_start, work_finish, work_time, break_time, over_time) VALUES (?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql1);
			
				String starthour = Work.getStartHour();
				String endhour = Work.getEndHour();
				String worktime = Work.getWorkTime();
				String breaktime = Work.getBreakTime();
				String overtime = Work.getOverTime();
				
				ps.setString(1, empcode);
				ps.setString(2, workday);
				ps.setString(3, starthour);
				ps.setString(4, endhour);
				ps.setString(5, worktime); 
				ps.setString(6, breaktime); 
				ps.setString(7, overtime); 
				
				int result = ps.executeUpdate();
				if(result > 0) {
					//登録出来たらtrueが返す
					return true;
				}
				ps.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;

	}
	
	
	//社員検索（年齢）
	public static List<Employee> displayAgeEmployee(Connection conn, int sea_key){
		
			List<Employee> list = new ArrayList<Employee>();
			
			String sql = " SELECT emp_code, start_date, work_year, emp_name, birthday, emp_age, last_date, depatment FROM employee WHERE emp_age = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, sea_key);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Employee Emp = new Employee();
					String empcode = rs.getString("emp_code");
					String startday = rs.getString("start_date");
					int workyear = rs.getInt("work_year");
					String empname = rs.getString("emp_name");
					String birthday = rs.getString("birthday");
					int empage = rs.getInt("emp_age");
					String lastday = rs.getString("last_date");
					String depatment = rs.getString("depatment");
					
					Emp.setEmpCode(empcode);
					Emp.setStartDay(startday);
					Emp.setWorkYears(workyear);
					Emp.setEmpName(empname);
					Emp.setEmpBirthDay(birthday);
					Emp.setEmpAge(empage);
					Emp.setLastDay(lastday);
					Emp.setDepatment(depatment);
					
					list.add(Emp);
				}
				 rs.close();
				 ps.close();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return list;
	}
	
	//社員検索（入社年数）
	public static List<Employee> displayWorkYearEmployee(Connection conn, int sea_key){
		
			List<Employee> list = new ArrayList<Employee>();
			
			String sql = " SELECT emp_code, start_date, work_year, emp_name, birthday, emp_age, last_date, depatment FROM employee WHERE work_year = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, sea_key);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Employee Emp = new Employee();
			
					String empcode = rs.getString("emp_code");
					String startday = rs.getString("start_date");
					int workyear = rs.getInt("work_year");
					String empname = rs.getString("emp_name");
					String birthday = rs.getString("birthday");
					int empage = rs.getInt("emp_age");
					String lastday = rs.getString("last_date");
					String depatment = rs.getString("depatment");
					
					Emp.setEmpCode(empcode);
					Emp.setStartDay(startday);
					Emp.setWorkYears(workyear);
					Emp.setEmpName(empname);
					Emp.setEmpBirthDay(birthday);
					Emp.setEmpAge(empage);
					Emp.setLastDay(lastday);
					Emp.setDepatment(depatment);
					
					list.add(Emp);
				}
				 rs.close();
				 ps.close();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return list;
	}
	
	//社員検索（部署名）
	public static List<Employee> displayDepatmentEmployee(Connection conn, String sea_key){
		
			List<Employee> list = new ArrayList<Employee>();
			
			String sql = " SELECT emp_code, start_date, work_year, emp_name, birthday, emp_age, last_date, depatment FROM employee WHERE depatment = ?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, sea_key);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Employee Emp = new Employee();
					String empcode = rs.getString("emp_code");
					String startday = rs.getString("start_date");
					int workyear = rs.getInt("work_year");
					String empname = rs.getString("emp_name");
					String birthday = rs.getString("birthday");
					int empage = rs.getInt("emp_age");
					String lastday = rs.getString("last_date");
					String depatment = rs.getString("depatment");
					
					Emp.setEmpCode(empcode);
					Emp.setStartDay(startday);
					Emp.setWorkYears(workyear);
					Emp.setEmpName(empname);
					Emp.setEmpBirthDay(birthday);
					Emp.setEmpAge(empage);
					Emp.setLastDay(lastday);
					Emp.setDepatment(depatment);
					
					list.add(Emp);
				}
				 rs.close();
				 ps.close();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return list;
	}
	
	//社員検索(退職者)
	public static List<Employee> displayRetireeEmployee(Connection conn, String sea_key){
		
		List<Employee> list = new ArrayList<Employee>();
		String sql = "SELECT emp_code, start_date, emp_name, birthday, last_date, depatment FROM employee WHERE emp_name = ? AND last_date IS NOT NULL";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sea_key);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee Emp = new Employee();
				String empcode = rs.getString("emp_code");
				String startday = rs.getString("start_date");
				String empname = rs.getString("emp_name");
				String birthday = rs.getString("birthday");
				String lastday = rs.getString("last_date");
				String depatment = rs.getString("depatment");
				
				Emp.setEmpCode(empcode);
				Emp.setStartDay(startday);
				Emp.setEmpName(empname);
				Emp.setEmpBirthDay(birthday);
				Emp.setLastDay(lastday);
				Emp.setDepatment(depatment);
				
				list.add(Emp);
			}
			 rs.close();
			 ps.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//勤務時間検索(部署名) 
    public static List<SearchEmpAndWork> displayDepatmentWork(Connection conn, String sea_key){
		
    	ArrayList<SearchEmpAndWork> list = new ArrayList<SearchEmpAndWork>();
		String sql = " SELECT e.emp_name, w.work_day, w.work_time, w.over_time FROM employee e JOIN work w ON e.emp_code = w.emp_code WHERE e.depatment LIKE ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sea_key);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SearchEmpAndWork WorkAndEmp = new SearchEmpAndWork();
				String empname = rs.getString("emp_name");
				String workdate = rs.getString("work_day");
				String worktime = rs.getString("work_time");
				String overtime = rs.getString("over_time");
				
				WorkAndEmp.setEmpName(empname);
				WorkAndEmp.setWorkDate(workdate);
				WorkAndEmp.setWorkTime(worktime);
				WorkAndEmp.setOverTime(overtime);
				
				
				list.add(WorkAndEmp);
			}
			 rs.close();
			 ps.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
    
	//勤務時間検索(日付) 
    public static List<SearchEmpAndWork> displayWorkDate(Connection conn, String sea_key){
		
		List<SearchEmpAndWork> list = new ArrayList<SearchEmpAndWork>();
		String sql = " SELECT e.emp_name, w.work_day, w.work_time, w.over_time FROM employee e JOIN work w ON e.emp_code = w.emp_code WHERE w.work_day LIKE ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sea_key);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SearchEmpAndWork WorkAndEmp = new SearchEmpAndWork();
				String empname = rs.getString("emp_name");
				String workdate = rs.getString("work_day");
				String worktime = rs.getString("work_time");
				String overtime = rs.getString("over_time");
				
				WorkAndEmp.setEmpName(empname);
				WorkAndEmp.setWorkDate(workdate);
				WorkAndEmp.setWorkTime(worktime);
				WorkAndEmp.setOverTime(overtime);
				
				list.add(WorkAndEmp);
			}
			 rs.close();
			 ps.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
