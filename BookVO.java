
public class BookVO {
	private int bookNo;
	private String title;
	private int cost;
	private String genre;
	
	public BookVO(){
		;
	}
	
	public BookVO(int bookNo, String title, int cost, String genre) {
		this.bookNo = bookNo;
		this.title = title;
		this.cost = cost;
		this.genre = genre;
	}
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
