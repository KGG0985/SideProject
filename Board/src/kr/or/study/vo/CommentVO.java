package kr.or.study.vo;

public class CommentVO {
	private String comNo;
	private String comContent;
	private String comDate;
	private String boardCno;
	private String memCid;
	
	public String getComNo() {
		return comNo;
	}
	public void setComNo(String comNo) {
		this.comNo = comNo;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public String getComDate() {
		return comDate;
	}
	public void setComDate(String comDate) {
		this.comDate = comDate;
	}
	public String getBoardCno() {
		return boardCno;
	}
	public void setBoardCno(String boardCno) {
		this.boardCno = boardCno;
	}
	public String getMemCid() {
		return memCid;
	}
	public void setMemCid(String memCid) {
		this.memCid = memCid;
	}
	@Override
	public String toString() {
		return "CommentVO [comNo=" + comNo + ", comContent=" + comContent + ", comDate=" + comDate + ", boardCno="
				+ boardCno + ", memCid=" + memCid + "]";
	}
	
}
