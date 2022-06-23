package kr.or.study.vo;

public class BoardVO {
	private int boardNo;
	private String boardTitle;
	private String memidWriter;
	private String boardContent;
	private String boardDate;
	private String boardHits;
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getMemidWriter() {
		return memidWriter;
	}
	public void setMemidWriter(String memidWriter) {
		this.memidWriter = memidWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardHits() {
		return boardHits;
	}
	public void setBoardHits(String boardHits) {
		this.boardHits = boardHits;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", memidWriter=" + memidWriter
				+ ", boardContent=" + boardContent + ", boardDate=" + boardDate + ", boardHits=" + boardHits + "]";
	}
	
	
}
