package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import etc.Database;
import vo.Review;

public class ReviewDao {
	public int insertReview(Review review) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;		
		try {
			String sql = "INSERT INTO review(`routeId`, `memberIdx`, `levelScore`, `funScore`,`solved`,`solvedDate`,`comment`,`reviewDate`) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review.getRouteId());
			pstmt.setInt(2, review.getMemberIdx());
			pstmt.setInt(3, review.getLevelScore());
			pstmt.setInt(4, review.getFunScore());
			pstmt.setBoolean(5, review.isSolved());
			pstmt.setString(6, review.getSolvedDate().toString());
			pstmt.setString(7, review.getComment());
			pstmt.setString(8, review.getReviewDate().toString());

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
}
