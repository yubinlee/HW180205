import java.sql.*;

public class OrderDAO extends DAO{
	
	public OrderDAO(){
		super();
	}
	
	public boolean insertOrder(OrderVO vo) {
		String sql = "INSERT INTO ORDER (ORDERNO, ID, COSTSUM, ADDRESS) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, vo.getOrderNo());
			ps.setString(2, vo.getId());
			ps.setInt(3, vo.getCostSum());
			ps.setString(4, vo.getAddress());
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
	
	public boolean deleteOrder(int orderNo) {
		String sql = "DELETE FROM ORDER WHERE ORDERNO = ?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, orderNo);
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
	
	// 주소
	public boolean updateOrder(OrderVO vo) {
		String sql = "UPDATE ORDER SET ADDRESS = ? WHERE ORDERNO = ?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, vo.getAddress());
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

	public OrderVO selectOrder(int orderNo) {
		Statement st = null; ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM ORDER WHERE ORDERNO = "+orderNo);
			OrderVO vo = new OrderVO();
			rs.next();
			vo.setOrderNo(rs.getInt("orderNo"));
			vo.setName(rs.getString("name"));
			vo.setEmail(rs.getString("email"));
			vo.setCostSum(rs.getInt("costSum"));
			vo.setAddress(rs.getString("address"));
			//order_book
			return vo;
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
	//
	public int calculateCostSum(){
		int costSum = 0;
		return costSum;
	}

}
