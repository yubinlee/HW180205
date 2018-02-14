import java.sql.*;

public class MemberDAO extends DAO{
	
	public MemberDAO(){
		super();
	}
	
	//CRUD
	
	public MemberVO loginMember(String id, String pw) {
		Statement st = null; ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM MEMBER WHERE ID='"+id+"' AND PASSWORD='"+pw+"'");
			MemberVO vo = new MemberVO();
			rs.next();
			vo.setId(rs.getString("id"));
			vo.setName(rs.getString("name"));
			vo.setPhone(rs.getString("phone"));
			vo.setEmail(rs.getString("email"));
			vo.setPassword(rs.getString("password"));
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
