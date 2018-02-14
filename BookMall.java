import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BookMall {
	
	public static Scanner scan = new Scanner(System.in); //숫자
	public static Scanner scan2 = new Scanner(System.in); //문자열
	
	public static void showBookMallMenu() {
		System.out.println("1. 회원");
		System.out.println("2. 카테고리");
		System.out.println("3. 상품");
		System.out.println("4. 카트");
		System.out.println("5. 주문");
		System.out.println("6. 주문 도서");
		System.out.println("0. 종료");
	}
	
	public static void showCRUDMenu() {
		System.out.println("1. 추가하기");
		System.out.println("2. 삭제하기");
		System.out.println("3. 수정하기");
		System.out.println("4. 조회하기");
		System.out.println("0. 목록으로");
	}
	
	public static MemberVO login(){
		System.out.print("아이디 입력: ");
		String id = scan2.nextLine();
		System.out.print("비밀번호 입력: ");
		String pw = scan2.nextLine();
		MemberDAO m_dao = new MemberDAO();
		MemberVO m_vo = m_dao.loginMember(id, pw);
		return m_vo;
	}
	
	public static void bookMain(){
		int num = 0;
		boolean flag2 = true;
		
		while (flag2) {
			showCRUDMenu();
			num = scan.nextInt();
			BookDAO b_dao = new BookDAO();
			BookVO b_vo;
			int bookNo = 0;
			int cost = 0;
			switch (num) {
			case 1:
				System.out.println("* 상품 추가하기 *");
				System.out.print("배송받을 주소지 입력: ");
				//address = scan2.nextLine();
				//b_vo = new OrderVO(m_vo, costSum, address);
			//	if (b_dao.insertBook(b_vo)) {
				//	System.out.println("주문 추가 성공");
				//}
				break;
			case 2:
				System.out.println("* 상품 삭제하기 *");
				System.out.print("삭제할 도서 번호 입력: ");
				bookNo = scan.nextInt();
				if (b_dao.deleteBook(bookNo)) {
					System.out.println("주문 삭제 성공");
				}
				break;
			case 3:
				System.out.println("* 상품 수정하기 *");
				System.out.print("수정할 도서 번호 입력: ");
				bookNo = scan.nextInt();
				System.out.print("변경될 가격 입력: ");
				cost = scan.nextInt();
				b_vo = new BookVO();
				b_vo.setBookNo(bookNo);
				b_vo.setCost(cost);
				if (b_dao.updateBook(b_vo)) {
					System.out.println("상품 수정 성공");
				}
				break;
			case 4:
				System.out.println("* 상품 조회하기 *");
				System.out.print("조회할 도서 번호 입력: ");
				bookNo = scan.nextInt();
				b_vo = b_dao.selectBook(bookNo);/*
				System.out.println("이름: "+o_vo.getName());
				System.out.println("주소: "+o_vo.getAddress());
				System.out.println("총금액: "+o_vo.getCostSum());*/
				break;
			case 0:
				flag2 = false;
				break;
			}
		}
	}
	
	public static void orderMain(){
		int num = 0;
		boolean flag2 = true;
		
		while (flag2) {
			showCRUDMenu();
			num = scan.nextInt();
			OrderDAO o_dao = new OrderDAO();
			System.out.println("먼저 로그인하세요.");
			MemberVO m_vo = login();
			OrderVO o_vo;
			int orderNo = 0;
			String address = null;
			switch (num) {
			case 1:
				System.out.println("* 주문 추가하기 *");
				System.out.print("배송받을 주소지 입력: ");
				address = scan2.nextLine();
				int costSum = 0; //calculateCostSum();
				o_vo = new OrderVO(m_vo, costSum, address);
				if (o_dao.insertOrder(o_vo)) {
					System.out.println("주문 추가 성공");
				}
				break;
			case 2:
				System.out.println("* 주문 삭제하기 *");
				System.out.print("삭제할 주문 번호 입력: ");
				orderNo = scan.nextInt();
				if (o_dao.deleteOrder(orderNo)) {
					System.out.println("주문 삭제 성공");
				}
				break;
			case 3:
				System.out.println("* 주문 수정하기 *");
				System.out.print("수정할 주문 번호 입력: ");
				orderNo = scan.nextInt();
				System.out.print("수정할 주소지 정보 입력: ");
				address = scan2.nextLine();
				o_vo = new OrderVO();
				//primary key
				o_vo.setOrderNo(orderNo);
				//not null 이라반드시 들어가야만 함
				//o_vo.setName(m_vo.getName());
			//	o_vo.setEmail(m_vo.getEmail());
				o_vo.setName("d");
				o_vo.setEmail("d");
				o_vo.setAddress(address);
				if (o_dao.updateOrder(o_vo)) {
					System.out.println("주문 수정 성공");
				}
				break;
			case 4:
				System.out.println("* 주문 조회하기 *");
				System.out.print("조회할 주문 번호 입력: ");
				orderNo = scan.nextInt();
				o_vo = o_dao.selectOrder(orderNo);
				System.out.println("이름: "+o_vo.getName());
				System.out.println("주소: "+o_vo.getAddress());
				System.out.println("총금액: "+o_vo.getCostSum());
				break;
			case 0:
				flag2 = false;
				break;
			}
		}
	}
	
	public static void orderBookMain(){
		int num = 0;
		boolean flag2 = true;
		
		while (flag2) {
			showCRUDMenu();
			num = scan.nextInt();
			OrderBookDAO ob_dao = new OrderBookDAO();
			System.out.println("먼저 로그인하세요.");
			MemberVO m_vo = login();
			String id = m_vo.getId();
			
			//id -> order -> orderbook의 orderno 구하기
			
			OrderDAO o_dao = new OrderDAO();
			OrderVO o_vo;
			BookVO b_vo;
			OrderBookVO ob_vo;
			int orderNo = 0; 
			String address = null;
			int bookNo = 0;
			int amount = 0;
			
			switch (num) {
			case 1:
				System.out.println("* 주문 도서 추가하기 *");
				//책 목록 뷰
				System.out.print("추가할 도서 번호 입력: ");
				bookNo = scan.nextInt();
				System.out.print("주문할 수량 입력: ");
				amount = scan.nextInt();
				ob_vo = new OrderBookVO();
				ob_vo.setBookNo(bookNo);
				ob_vo.setAmount(amount);
				ob_vo.setOrderNo(orderNo);
				if (ob_dao.insertOrderBook(ob_vo)) {
					System.out.println("주문 도서 추가 성공");
				}
				break;
			case 2:
				System.out.println("* 주문 도서 삭제하기 *");
				System.out.print("삭제할 주문 도서 번호 입력: ");
				bookNo = scan.nextInt();
				ob_vo = new OrderBookVO();
				ob_vo.setBookNo(bookNo);
				ob_vo.setOrderNo(orderNo);
				if (ob_dao.deleteOrderBook(ob_vo)) {
					System.out.println("주문 도서 삭제 성공");
				}
				break;
			case 3:
				System.out.println("* 주문 도서 수정하기 *");
				System.out.print("수정할 주문 도서 번호 입력: ");
				bookNo = scan.nextInt();
				System.out.print("해당 도서의 수정할 수량 입력: ");
				amount = scan.nextInt();
				ob_vo = new OrderBookVO();
				ob_vo.setOrderNo(orderNo);
				ob_vo.setBookNo(bookNo);
				ob_vo.setAmount(amount);
				if (ob_dao.updateOrderBook(ob_vo)) {
					System.out.println("주문 도서 수정 성공");
				}
				break;
			case 4:
				System.out.println("* 주문 도서 조회하기 *");
				orderNo = scan.nextInt();
				ArrayList<OrderBookVO> list = ob_dao.selectOrderBook(orderNo);
				System.out.println("제목	수량	금액");
				System.out.println("---------------------------");
				Iterator<OrderBookVO> i = list.iterator();
				BookDAO b_dao = new BookDAO();
				while (i.hasNext()) {
					ob_vo = i.next();
					b_vo = b_dao.selectBook(ob_vo.getBookNo());
					System.out.println(b_vo.getTitle());
					System.out.print(ob_vo.getAmount());
					System.out.println(b_vo.getCost()*ob_vo.getAmount());
				}
				break;
			case 0:
				flag2 = false;
				break;
			}
		}
	}
	
	public static void main(String[] args) {

		boolean flag = true;
		
		while (flag) {
			showBookMallMenu();
			int num = scan.nextInt();
			switch (num) {
			case 3:
				bookMain();
				break;
			case 5:
				orderMain();
				break;
			case 6:
				orderBookMain();
				break;
			case 0:
				flag = false;
				break;
			}
			if (!flag) break;
		}
	}
}
