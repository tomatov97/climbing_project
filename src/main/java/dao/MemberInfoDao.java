package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import etc.Database;
import vo.Member;

public class MemberInfoDao {
	public int insertMemberInfo(Member newMemberInfo) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;		
		try {
			String sql = "INSERT INTO member(`id`, `pw`, `name`, `nickname`, `email`, `img`, `regDate`) VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newMemberInfo.getId());
			pstmt.setString(2, newMemberInfo.getPw());
			pstmt.setString(3, newMemberInfo.getName());
			pstmt.setString(4, newMemberInfo.getNickname());
			pstmt.setString(5, newMemberInfo.getEmail());
			pstmt.setString(6, newMemberInfo.getImgPath());
			pstmt.setString(7, newMemberInfo.getRegDate().toString());

			int count = pstmt.executeUpdate();
			
			if (count == 1) return 200;
			else 			return 400;
		} catch (SQLException e) {
			e.printStackTrace();					
			return 409;
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}
	}
	
	public Member selectMemberById(String id) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		Member memberInfo = null;
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
				
				memberInfo = new Member(id, pw, name, email, regDate);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}
		return memberInfo;
	}
	
	public Member selectMemberByEmail(String email) {	
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		Member memberInfo = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM member WHERE email=?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String id = rs.getString("id");
				String t_regDate = rs.getString("regDate");
				LocalDateTime regDate = LocalDateTime.parse(t_regDate);
				
				memberInfo = new Member(id, pw, name, email, regDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}
		return memberInfo;
	}
	
	public int updateByIdx(Member memberInfo) {	
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE member SET name=?, email=?, nickname=?, img=? WHERE idx=?";
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, memberInfo.getName());
			pstmt.setString(2, memberInfo.getEmail());
			pstmt.setString(3, memberInfo.getNickname());
			pstmt.setString(4, memberInfo.getImgPath());
			pstmt.setInt(5, memberInfo.getIdx());

			int count = pstmt.executeUpdate();
			if (count == 1) return 200;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}	
		return 400;
	}
	
	public void updatePasswordByIdx(int idx, String newPw) {	
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE member SET pw=? WHERE idx=?";			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, newPw);
			pstmt.setInt(2, idx);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}		
	}
	
	public void deleteMemberInfo(int idx) {		
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;		
		try {
			String sql = "DELETE * FROM member WHERE idx=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}
	}
}
