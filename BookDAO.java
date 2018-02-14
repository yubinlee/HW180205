import java.sql.*;

public class BookDAO extends DAO{
	
	public BookDAO(){
		super();
	}
	
	public boolean insertBook(BookVO vo) {
		String sql = "INSERT INTO BOOK (BOOKNO, TITLE, COST, GENRE) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, vo.getBookNo());
			ps.setString(2, vo.getTitle());
			ps.setInt(3, vo.getCost());
			ps.setString(4, vo.getGenre());
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
	
	public boolean deleteBook(int bookNo) {
		String sql = "DELETE FROM BOOK WHERE BOOKNO=?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, bookNo);
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
	
	public boolean updateBook(BookVO vo) {
		String sql = "UPDATE BOOK SET COST=? WHERE BOOKNO=?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, vo.getCost());
			ps.setInt(2, vo.getBookNo());
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

	public BookVO selectBook(int bookNo) {
		Statement st = null; ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM BOOK WHERE BOOKNO='"+bookNo+"'");
			BookVO vo = new BookVO();
			rs.next();
			vo.setBookNo(rs.getInt("bookNo"));
			vo.setTitle(rs.getString("title"));
			vo.setCost(rs.getInt("cost"));
			vo.setGenre(rs.getString("genre"));
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
}
