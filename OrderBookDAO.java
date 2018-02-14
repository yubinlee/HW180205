import java.sql.*;
import java.util.ArrayList;

public class OrderBookDAO extends DAO{
	
	public OrderBookDAO(){
		super();
	}
	
	public boolean insertOrderBook(OrderBookVO vo) {
		String sql = "INSERT INTO ORDER_BOOK (BOOKNO, AMOUNT, ORDERNO) VALUES (?, ?, ?)";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, vo.getBookNo());
			ps.setInt(2, vo.getAmount());
			ps.setInt(3, vo.getOrderNo());
			if (ps.executeUpdate() == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}
	
	public boolean deleteOrderBook(OrderBookVO vo) {
		String sql = "DELETE FROM ORDER_BOOK WHERE BOOKNO = ? AND ORDERNO = ?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, vo.getBookNo());
			ps.setInt(2, vo.getOrderNo());
			if (ps.executeUpdate() == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}
	
	public boolean updateOrderBook(OrderBookVO vo) {
		String sql = "UPDATE ORDER_BOOK SET AMOUNT = ? WHERE BOOKNO = ? AND ORDERNO = ?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, vo.getAmount());
			ps.setInt(2, vo.getBookNo());
			ps.setInt(3, vo.getOrderNo());
			if (ps.executeUpdate() == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

	public ArrayList<OrderBookVO> selectOrderBook(int orderNo) {
		ArrayList<OrderBookVO> list = new ArrayList<>();
		Statement st = null; ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM ORDER_BOOK WHERE ORDERNO = '"+orderNo+"'");
			while(rs.next()) {
				OrderBookVO vo = new OrderBookVO();
				vo.setOrderNo(rs.getInt("orderNo"));
				vo.setBookNo(rs.getInt("bookNo"));
				vo.setAmount(rs.getInt("amount"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
}
