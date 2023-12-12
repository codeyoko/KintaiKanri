package BEAN;

/**
* Admin定義クラス
* @author フウン　ヴァンソン
*/
public class Admin {
	private String userName;
	private String password;
	
	/**
     * userNameを取得する。
     * @return userName　
     */
	public String getUserName() {
		return userName;
	}
	/**
     * userNameを設定する。
     * @param userName　
     */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
     * passwordを取得する。
     * @return password　
     */
	public String getPassword() {
		return password;
	}
	/**
     * passwordを設定する。
     * @param password　
     */
	public void setPassword(String password) {
		this.password = password;
	}
}
