package DAO;

import java.sql.*;
import DB.DBConnection;

/**
* WorkDAO（勤務時間登録処理）
* @author フウン　ヴァンソン
*/
public class WorkDAO {

    public boolean checkWorkExistence(String emcode, String workday) {
    	//勤務時間が既に登録されるかどうか確認する
    	try (Connection conn = DBConnection.createConnection()) {
            String sql = "SELECT * FROM work WHERE emp_code = ? AND work_day = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, emcode);
                statement.setString(2, workday);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //勤務時間登録処理
    public boolean insertWork(String empcode,String workday, String workstart, String workfinish,  String worktime, String breaktime, String overtime ) {
        try (Connection conn = DBConnection.createConnection()) {
            // 社員番号や勤務日付が存在しない場合は挿入
            if (!checkWorkExistence(empcode, workday)) {
                String sql = "INSERT INTO work (emp_code, work_day, work_start, work_finish, work_time, break_time, over_time) VALUES (?,?,?,?,?,?,?)";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setString(1, empcode);
                    statement.setString(2, workday);
                    statement.setString(3, workstart);
                    statement.setString(4, workfinish);
                    statement.setString(5, worktime);
                    statement.setString(6, breaktime);
                    statement.setString(7, overtime);
                    int rowsAffected = statement.executeUpdate();

                    return rowsAffected > 0;
                }
            } else {
                // 社員番号や日付既に存在する場合は挿入せずにfalseを返す
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
