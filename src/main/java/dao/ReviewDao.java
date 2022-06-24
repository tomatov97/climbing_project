package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import etc.Database;
import route.RouteService;
import vo.Review;
import vo.Routes;

public class ReviewDao {
	public int insertReview(Review review) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;		
		try {
			String sql = "INSERT INTO review(`routeId`, `memberIdx`, `levelScore`, `funScore`,`solved`,`solvedDate`,`comment`,`reviewDate`) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
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
	
	public int updateReview(Review review) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;	
		try {
			String sql = "UPDATE review SET funScore=?, levelScore=?, solved=?, solvedDate=?, comment=? WHERE routeId=? AND memberIdx=?";
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt	(1, review.getLevelScore());
			pstmt.setInt	(2, review.getFunScore());
			pstmt.setBoolean(3, review.isSolved());
			pstmt.setString	(4, review.getSolvedDate().toString());
			pstmt.setString	(5, review.getComment());
			pstmt.setInt	(6, review.getRouteId());
			pstmt.setInt	(7, review.getMemberIdx());
			
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
	
	public int insertLike(Review review) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;		
		try {
			String sql = "INSERT INTO like VALUES(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review.getRouteId());
			pstmt.setInt(2, review.getMemberIdx());

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
	
	public void deleteLike(Review review) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;		
		try {
			String sql = "DELETE * FROM like WHERE routeId=? AND memberIdx=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review.getRouteId());
			pstmt.setInt(2, review.getMemberIdx());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}
	}
	
	public List<Review> selectReviewByRoute(int routeId, int pageNumber) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		List<Review> reviewList = null;
		ResultSet rs = null;
		int amountPerPage = 20;
		int startIndex = (pageNumber-1)*amountPerPage;
		
		try {
			String sql = "SELECT * FROM review WHERE `routeId`=? LIMIT ?, ?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, routeId);
			pstmt.setInt(2, startIndex);
			pstmt.setInt(3, amountPerPage);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int levelScore = rs.getInt("levelScore");
				int funScore = rs.getInt("funScore");
				boolean solved = rs.getBoolean("solved");
				String comment = rs.getString("comment");
				LocalDateTime reviewDate = LocalDateTime.parse(rs.getString("reviewDate"));
				
				Review review = new Review(levelScore, funScore,solved,comment,reviewDate);
				reviewList.add(review);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(rs);
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}
		return reviewList;
	}
	
	public int getAmountOfReview(int routeId) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;		
		ResultSet rs = null;		
		int amount = 0;
		try {
			String sql = "SELECT COUNT(*) AS `amount` FROM review WHERE routeId=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, routeId);
			rs = pstmt.executeQuery();			
			rs.next();
			amount = rs.getInt("amount");			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(rs);
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}		
		return amount;
		
	}
}
