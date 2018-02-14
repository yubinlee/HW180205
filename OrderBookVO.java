
public class OrderBookVO {
	private int bookNo;
	private int amount;
	private int orderNo;
	
	public OrderBookVO(){
		;
	}
	
	public OrderBookVO(BookVO b_vo, int amount, OrderVO o_vo) {
		this.bookNo = b_vo.getBookNo();
		this.amount = amount;
		this.orderNo = o_vo.getOrderNo();
	}
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
}
