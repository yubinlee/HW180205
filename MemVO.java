package bigdata.board.vo;

public class MemVO {
	private String memid;
	private String mempw;
	
	public MemVO() {
		;
	}
	
	public MemVO(String memid, String mempw) {
		super();
		this.memid = memid;
		this.mempw = mempw;
	}
	
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getMempw() {
		return mempw;
	}
	public void setMempw(String mempw) {
		this.mempw = mempw;
	}
	
}
