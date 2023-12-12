package DB;

/**
* DBConnection（データベースに接続）定義クラス
* @author フウン　ヴァンソン
*/
import java.sql.*;

public class DBConnection {
	
	   /**
	   * createConnectionメソッド
	   * データベース接続して返す
	   * @return　conn　データベース接続結果
	   */
	public static Connection createConnection() {
		
		
		Connection conn = null;
		
		//DBのpatch、ユーザー名、パスワードを定義する
		String url = "jdbc:mysql://localhost:3306/kintaikanri";
		String user = "root";
		String pass = "";
		
		
		try {
			//データベースに接続する
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//結果を返す
		return conn;
	}
}
