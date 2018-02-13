package bigdata.board.dao;

import java.sql.*;
import java.util.*;

import bigdata.board.vo.MemVO;
import bigdata.board.vo.PostVO;

public class MemDAO {
	private Connection conn;
	private static final String dburl = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String userid = "scott";
	private static final String userpw = "tiger";

	public MemDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			this.conn = DriverManager.getConnection(dburl, userid, userpw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
	
	public boolean insertMem(MemVO vo) {
		String sql = "INSERT INTO MEM (MEMID, MEMPW) VALUES (?, ?)";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, vo.getMemid());
			ps.setString(2, vo.getMempw());
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
	
	public boolean deleteMem(String id) {
		String sql = "DELETE FROM MEM WHERE MEMID=?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, id);
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
	
	public boolean updateMem(MemVO vo) {
		String sql = "UPDATE MEM SET MEMPW=? WHERE MEMID=?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, vo.getMempw());
			ps.setString(2, vo.getMemid());
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
	
	//1명의 회원 조회
	public MemVO selectMem(String id) {
		Statement st = null; ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from mem where memid='"+id+"'");
			MemVO vo = new MemVO();
			rs.next();
			vo.setMemid(rs.getString(1));
			vo.setMempw(rs.getString(2));
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
	
	public boolean loginMem(MemVO vo) {
		String sql = "SELECT * FROM MEM WHERE MEMID=? AND MEMPW=?";
		PreparedStatement ps = null;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, vo.getMemid());
			ps.setString(2, vo.getMempw());
			if (ps.execute()==true) return true;
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
}
