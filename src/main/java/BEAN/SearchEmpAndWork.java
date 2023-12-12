package BEAN;

/**
* SearchEmpAndWork（社員情報検索と勤務時間検索）定義クラス
* @author フウン　ヴァンソン
*/

public class SearchEmpAndWork {
	/** 氏名 */
	private String empName;
	/** 出勤日 */
	private String workDate;
	/** 労働時間 */
	private String workTime;
	/** 残業時間 */
	private String overTime;
	
	
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
	 * 出勤日を取得する
	 * @return workDate 出勤日
	 */
	public String getWorkDate() {
		return workDate;
	}
	/**
	 * 出勤日を設定する
	 * @param workDate 出勤日
	 */
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	
	/**
	 *　労働時間を取得する
	 * @return workTime　労働時間
	 */
	public String getWorkTime() {
		return workTime;
	}
	/**
	 * 労働時間を設定する
	 * @param workTime 労働時間
	 */
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	/**
	 * 残業時間を取得する
	 * @return overTime　残業時間
	 */
	public String getOverTime() {
		return overTime;
	}
	/**
	 * 残業時間を設定する
	 * @param overTime 残業時間
	 */
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	
}
