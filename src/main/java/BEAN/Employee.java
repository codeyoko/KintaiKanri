package BEAN;

/**
* Employee（社員）定義クラス
* @author フウン　ヴァンソン
*/
public class Employee {
	
	/** 社員番号 */
	private String empCode;
	
	/** 入社日 */
	private String startDay;
	
	/** 入社年数 */
	private int workYears;
	
	/** 氏名 */
	private String empName;
	
	/** 生年月日 */
	private String empBirthDay;
	
	/** 年齢 */
	private int empAge;
	
	/** 退職日 */
	private String lastDay;
	
	/** 部署名 */
	private String depatment;
	
	
	
	/**
     * 社員番号を取得する。
     * @return empCode　社員番号
     */
	public String getEmpCode() {
		return empCode;
	}
	
	/**
     * 社員番号を設定する。
     * @param empCode　社員番号
     */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	/**
     * 入社日を取得する。
     * @return startDay　入社日
     */
	public String getStartDay() {
		return startDay;
	}
	
	/**
     * 入社日を設定する。
     * @param startDay　入社日
     */
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	
	/**
     * 入社年数を取得する。
     * @return workYears　入社年数
     */
	public int getWorkYears() {
		return workYears;
	}
	
	/**
     * 入社年数を設定する。
     * @param workYears　入社年数
     */
	public void setWorkYears(int workYears) {
		this.workYears = workYears;
	}
	
	
	/**
     * 氏名を取得する。
     * @return empName　氏名
     */
	public String getEmpName() {
		return empName;
	}
	
	/**
     * 氏名を設定する。
     * @param empName 氏名
     */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	/**
     * 生年月日を取得する。
     * @return empBirthDay　生年月日
     */
	public String getEmpBirthDay() {
		return empBirthDay;
	}
	
	/**
    * 生年月日を設定する。
    * @param empBirthDay 生年月日
    */
	public void setEmpBirthDay(String empBirthDay) {
		this.empBirthDay = empBirthDay;
	}
	
	/**
     * 年齢を取得する。
     * @return empAge　年齢
     */
	public int getEmpAge() {
		return empAge;
	}
	
	/**
     * 年齢を設定する。
     * @param empAge　年齢
     */
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	
	
	/**
     * 退職日を取得する。
     * @return lastDay　退職日
     */
	public String getLastDay() {
		return lastDay;
	}
	
	/**
    * 退職日を設定する。
    * @param lastDay 退職日
    */
	public void setLastDay(String lastDay) {
		this.lastDay = lastDay;
	}
	
	/**
     * 部署名を取得する。
     * @return depatment　部署名
     */
	public String getDepatment() {
		return depatment;
	}
	
	/**
    * 部署名を設定する。
    * @param depatment 部署名
    */
	public void setDepatment(String depatment) {
		this.depatment = depatment;
	}
	
}
