package kr.or.study.vo;

public class MemberVO {

	private String memId;
	private String memName;
	private String memPassword;
	private String memJoinDate;
	private String memQuitDate;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemJoinDate() {
		return memJoinDate;
	}
	public void setMemJoinDate(String memJoinDate) {
		this.memJoinDate = memJoinDate;
	}
	public String getMemQuitDate() {
		return memQuitDate;
	}
	public void setMemQuitDate(String memQuitDate) {
		this.memQuitDate = memQuitDate;
	}
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memName=" + memName + ", memPassword=" + memPassword + ", memJoinDate="
				+ memJoinDate + "]";
	}
	
	
	
	
	
}
