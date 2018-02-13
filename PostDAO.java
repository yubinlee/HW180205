package bigdata.board.dao;

import java.sql.*;
import java.util.*;

import bigdata.board.vo.PostVO;

public class PostDAO {
	private Connection conn;
	private static final String dburl = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String userid = "scott";
	private static final String userpw = "tiger";

	public PostDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				this.conn = DriverManager.getConnection(dburl, userid, userpw);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
	
	public boolean insertPost(PostVO vo) {
		String sql = "INSERT INTO POST (POSTNO, TITLE, CONTENT, MEMID) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, vo.getPostno());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getMemid());
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
	
	public boolean deletePost(int postno) {
		String sql = "DELETE FROM POST WHERE POSTNO=?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, postno);
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
	
	public boolean updatePost(PostVO vo) {
		String sql = "UPDATE POST SET TITLE=?, CONTENT=? WHERE POSTNO=?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getPostno());
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
	
	//±Û¸ñ·Ï
	public ArrayList<PostVO> selectPost() {
		ArrayList<PostVO> list = new ArrayList<>();
		Statement st = null; ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from post");
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setPostno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setMemid(rs.getString(5));
				list.add(vo);
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
