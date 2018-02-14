import java.util.*;

public class OrderVO {
	
	private int orderNo;
	private String id;
	private String name;
	private String email;
	private int costSum;
	private String address;
	
	public static int[] orderNoArr = new int[9999];
	public static int orderCount = 0;
	
	public OrderVO() {
		;
	}

	public OrderVO(MemberVO vo, int costSum, String address) {
		this.id = vo.getId();
		this.name = vo.getName();
		this.email = vo.getEmail();
		this.orderNo = makeOrderNo();
		this.costSum = costSum;
		this.address = address;
		orderCount++;
	}

	public int makeOrderNo(){
		Random r = new Random();
		int randomNo = 0;
		boolean flag = true;
		while (flag) {
			randomNo = Math.abs(r.nextInt()%9999)+1;
			int i = 0;
			for (i = 0; i < orderCount; i++){
				if (orderNoArr[i] == randomNo){
					break;
				}
			}
			if (i == orderCount){
				orderNoArr[orderCount] = randomNo;
				flag = false;
			}
		}
		return randomNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCostSum() {
		return costSum;
	}

	public void setCostSum(int costSum) {
		this.costSum = costSum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
