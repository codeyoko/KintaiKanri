package BEAN;

/**
* Working（勤務時間）定義クラス
* @author フウン　ヴァンソン
*/

public class Working {
	
	/** 社員番号 */
	private String empCode;
	
	/** 出勤日 */
	private String workDay;
	
	/** 出勤時刻 */
	private String startHour;
	
	/** 退勤時刻 */
	private String endHour;
	
	/** 労働時間 */
	private String workTime;
	
	/** 休憩時間 */
	private String breakTime;
	
	/** 残業時間 */
	private String overTime;
	
	
	
	/**
	 * 社員番号を取得する
	 * @return empCode　社員番号
	 */
	public String getEmpCode() {
		return empCode;
	}
	/**
	 * 社員番号を設定する
	 * @param empCode 社員番号
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	/**
	 * 出勤日を取得する
	 * @return workDay 出勤日
	 */
	public String getWorkDay() {
		return workDay;
	}
	/**
	 * 出勤日を設定する
	 * @param workDay 出勤日
	 */
	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}
	
	/**
	 * 出勤時刻を取得する
	 * @return startHour　出勤時刻
	 */
	public String getStartHour() {
		return startHour;
	}
	/**
	 * 出勤時刻を設定する
	 * @param startHour 出勤時刻
	 */
	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}
	
	/**
	 * 退勤時刻を取得する
	 * @return endHour　退勤時刻
	 */
	public String getEndHour() {
		return endHour;
	}
	/**
	 * 退勤時刻を設定する
	 * @param endHour 退勤時刻
	 */
	public void setEndHour(String endHour) {
		this.endHour = endHour;
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
	 * 休憩時間を取得する
	 * @return breakTime　休憩時間
	 */
	public String getBreakTime() {
		return breakTime;
	}
	/**
	 * 休憩時間を設定する
	 * @param breakTime 休憩時間
	 */
	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}
	
}
