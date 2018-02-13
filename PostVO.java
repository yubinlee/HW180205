package bigdata.board.vo;

import java.util.Date;

public class PostVO {
	private int postno;
	private String title;
	private String content;
	private Date regdate;
	private String memid;
	
	public PostVO() {
		;
	}
	
	public PostVO(int postno, String title, String content, Date regdate, String memid) {
		super();
		this.postno = postno;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.memid = memid;
	}
	
	public int getPostno() {
		return postno;
	}
	public void setPostno(int postno) {
		this.postno = postno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	
	
}
