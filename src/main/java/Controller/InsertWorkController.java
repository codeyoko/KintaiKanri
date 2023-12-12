package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import DAO.WorkDAO;


/**
* InsertWorkController（勤務時間登録）
* @author フウン　ヴァンソン
*/

@WebServlet("/InsertWorkController")
public class InsertWorkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertWorkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//日本語を登録できるように設定
		response.setContentType("text/html; charset=UTF-8");
		
		//フォームから送信されたデータを取得
		String workday = request.getParameter("work_day");
		String empcode = request.getParameter("emp_code");
		String starthour = request.getParameter("start_hour");
		String endhour = request.getParameter("end_hour");
		
		//全ての項目に入力されるかチェック
		if(!workday.isEmpty() && !empcode.isEmpty() && !starthour.isEmpty() && !endhour.isEmpty()) {
			
			//労働時間、休憩時間、残業時間の計算
			String breakTime = "01:00"; //休憩時間は1時間設定
			String workTime = calculateWorkTime(starthour, endhour);
			String overTime = calculateOverTime(starthour, endhour);
			
			//DBに挿入処理
			WorkDAO workDAO = new WorkDAO();
			boolean registWorkResult = workDAO.insertWork(empcode, workday, starthour, endhour, workTime, breakTime, overTime );
			
			if(registWorkResult) { 
				  //挿入完了
				  RequestDispatcher rd = request.getRequestDispatcher("View/WorkRegist_Success.jsp");  
				  rd.forward(request, response);
			 }else { 
				  //挿入できない場合はエラーメッセージが返す
				  request.setAttribute("errmgs3","社員番号が存在しないか、勤務時間が既に登録されています。");
				  RequestDispatcher rd = request.getRequestDispatcher("View/Work_Regist.jsp"); 
				  rd.forward(request,response); 
			 }
			
		}else {
			//全ての項目に入力されない場合はエラーメッセージが返す
			request.setAttribute("errmgs4", "全ての項目を入力してください。");
		    RequestDispatcher rd = request.getRequestDispatcher("View/Work_Regist.jsp");
		    rd.forward(request,response);
		}
		
		
	}
	
	//労働時間計算
	private String calculateWorkTime(String startHour, String endHour) {
        // 休憩時間を差し引いた労働時間を計算
        int workTimeHours = calculateHoursBetween(startHour, endHour) - 1;
        return formatTime(workTimeHours, 0);
    }

    private int calculateHoursBetween(String startHour, String endHour) {
        // 時間の差を計算
        int startMinutes = Integer.parseInt(startHour.split(":")[0]) * 60 + Integer.parseInt(startHour.split(":")[1]);
        int endMinutes = Integer.parseInt(endHour.split(":")[0]) * 60 + Integer.parseInt(endHour.split(":")[1]);
        //総労働時間
        return (endMinutes - startMinutes) / 60;
    }
    
    
    //残業時間計算
    private String calculateOverTime(String startHour, String endHour) {
    	
		String []startHourStr = startHour.split(":");
		String []endHourStr = endHour.split(":");
		
		String start_Hour = startHourStr[0];
		String start_Minute = startHourStr[1];
		
		String end_Hour = endHourStr[0];
		String endM_inute = endHourStr[1];
    	
		// 文字列をLocalTimeに変換
        LocalTime startTime = LocalTime.of(Integer.parseInt(start_Hour), Integer.parseInt(start_Minute));
        LocalTime endTime = LocalTime.of(Integer.parseInt(end_Hour), Integer.parseInt(endM_inute));
		
        // 通常労働時間と休憩時間を設定（8時間労働と1時間休憩を設定）
        int normalWorkingHours = 8;
        int breakTime = 60; // 休憩時間（分）
        
        // 始業から終業までの労働時間を計算
        int workingHours = endTime.getHour() - startTime.getHour();
        int workingMinutes = endTime.getMinute() - startTime.getMinute();
        int totalWorkingMinutes = workingHours * 60 + workingMinutes;
        
        // 休憩時間を差し引く
        int netWorkingMinutes = totalWorkingMinutes - breakTime;
        
        // 残業時間を計算
        int overtimeMinutes = netWorkingMinutes - normalWorkingHours * 60;
        
        if (overtimeMinutes <= 0) {
            // 労働時間が休憩時間を含めて8時間以下の場合は残業なし
            return "00:00";
        }
        
        // 8時間を超えた場合に残業時間を計算
        int overTimeHours = overtimeMinutes / 60;
        int overTimeMinutes = overtimeMinutes % 60;
        
        return formatTime(overTimeHours, overTimeMinutes);
    }
    
    private String formatTime(int hours, int minutes) {
        // hh:mm形式にフォーマットする
        return String.format("%02d:%02d", hours, minutes);
    }
    
}
