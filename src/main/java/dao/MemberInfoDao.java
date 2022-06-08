package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import etc.Database;
import vo.MemberInfo;

public class MemberInfoDao {
	public int insertMemberInfo(MemberInfo newMemberInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			// 3. 쿼리 작성
			String sql = "INSERT INTO memberInfo(`id`, `pw`, `name`, `email`,`regDate`) VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newMemberInfo.getId());
			pstmt.setString(2, newMemberInfo.getPw());
			pstmt.setString(3, newMemberInfo.getName());
			pstmt.setString(4, newMemberInfo.getEmail());
			pstmt.setString(5, newMemberInfo.getRegDate().toString());
			
			// 4. stmt 를 통해서 쿼리 실행 및 결과 전달
			int count = pstmt.executeUpdate();
			
			if (count == 1) return 200;
			else return 400;
		} catch (SQLException e) {
			e.printStackTrace();
			
			return 409;
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
	}
	
	public MemberInfo selectMemberById(String id) {
		Database db = new Database();		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		MemberInfo memberInfo = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE id=?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String t_regDate = rs.getString("regDate");
				System.out.println("regDate => " + t_regDate);
				// t_regDate에서 밀리초를 떼기
				t_regDate = t_regDate.substring(0, 19);
				System.out.println("regDate => " + t_regDate);
				
				t_regDate = t_regDate.replace(' ', 'T');
				System.out.println("regDate => " + t_regDate);
				LocalDateTime regDate = LocalDateTime.parse(t_regDate);
				
				memberInfo = new MemberInfo(id, pw, name, email, regDate);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		return memberInfo;
	}
	
	public MemberInfo selectMemberByEmail(String email) {
		Database db = new Database();		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		MemberInfo memberInfo = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM memberInfo WHERE email=?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String id = rs.getString("id");
				String t_regDate = rs.getString("regDate");
				LocalDateTime regDate = LocalDateTime.parse(t_regDate);
				
				memberInfo = new MemberInfo(id, pw, name, email, regDate);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		return memberInfo;
	}
}
