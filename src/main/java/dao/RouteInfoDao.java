package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import etc.Database;
import vo.RouteInfo;

public class RouteInfoDao {
	public int insertRouteInfo(RouteInfo newRouteInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			// 3. 쿼리 작성
			String sql = "INSERT INTO routes(`settingId`, `name`, `holdColor`, `levelColor`, `comment`, `img`, `routeId`) VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newRouteInfo.getSettingId());
			pstmt.setString(2, newRouteInfo.getRouteName());
			pstmt.setString(3, newRouteInfo.getHoldColor());
			pstmt.setString(4, newRouteInfo.getLevelColor());
			pstmt.setString(5, newRouteInfo.getComment());
			pstmt.setString(6, newRouteInfo.getImg());
			pstmt.setInt(7, newRouteInfo.getRouteId());
			
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
	public RouteInfo selectRouteById(int id) {
		Database db = new Database();		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		RouteInfo RouteInfo = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT R.name, R.holdColor, R.levelColor, R.comment, R.img, SC.name AS `sectorName`, `sectorName`, CONCAT_WS(~,S.setDate,S.removeDate) AS `date`,"
					+ "AVG(RV.levelScore) AS `levelScore-avg`, AVG(RV.funScore) AS `funScore-avg` FROM routes R"
					+ "JOIN settings S ON S.settingId=R.settingId"
					+ "JOIN sectors SC ON SC.sectorId=S.sectorId"
					+ "JOIN gyms G ON G.id=SC.gymId"
					+ "JOIN review RV ON RV.routeId=R.routeId WHERE `routeId`=?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String routeName = rs.getString("name");
				String holdColor = rs.getString("holdColor");
				String levelColor = rs.getString("levelColor");
				String comment = rs.getString("comment");
				String img = rs.getString("img");
				String sectorName = rs.getString("sectorName");
				String dateString = rs.getString("date");
				int levelScoreAvg = rs.getInt("levelScore-avg");
				int funScoreAvg = rs.getInt("funScore-avg");
				
				RouteInfo = new RouteInfo(id, routeName, holdColor, levelColor, comment, img, sectorName, dateString, levelScoreAvg, funScoreAvg);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		return RouteInfo;
	}
	
	public RouteInfo selectRouteBySettingAndName(int id, String name) {
		Database db = new Database();		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		RouteInfo RouteInfo = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM routes WHERE `settingId`=? AND `name`=?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int routeId = rs.getInt("routeId");
				String holdColor = rs.getString("hold-color");
				String levelColor = rs.getString("level-color");
				String comment = rs.getString("comment");
				String img = rs.getString("img");
				
				RouteInfo = new RouteInfo(routeId, id, name, holdColor, levelColor, comment, img);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		return RouteInfo;
	}
	
	public int countRoutesByColors(int settingId, String holdColor, String levelColor) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		
		int amount = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM routes WHERE `settingId`=? AND `holdColor`=? AND `levelColor`=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, settingId);
			pstmt.setString(2, holdColor);
			pstmt.setString(3, levelColor);
			rs = pstmt.executeQuery();
			
			rs.next();
			amount = rs.getInt("amount");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
		return amount;		
	}

	public int updateById(RouteInfo routeInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE routes SET `settingId`=?, `name`=?, `holdColor`=?, `levelColor`=?, `comment`=?, `img`=? WHERE `routeId`=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, routeInfo.getSettingId());
			pstmt.setString(2, routeInfo.getRouteName());
			pstmt.setString(3, routeInfo.getHoldColor());
			pstmt.setString(4, routeInfo.getLevelColor());
			pstmt.setString(5, routeInfo.getComment());
			pstmt.setString(6, routeInfo.getImg());
			pstmt.setInt(7, routeInfo.getRouteId());

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
	
	public int getAmountOfRoute(String filter) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		
		int amount = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM routes R"
					+ "JOIN settings S ON S.settingId=R.settingId"
					+ "JOIN sectors SC ON SC.sectorId=S.sectorId"
					+ "JOIN gyms G ON G.id=SC.gymId " + filter;
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			amount = rs.getInt("amount");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
		return amount;	
	}
	
	public int deleteImg(int id) {
		Database db = new Database();		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE routes SET img=? WHERE routeId=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, null);
			pstmt.setInt(2, id);

			int count = pstmt.executeUpdate();
			if (count == 1) return 200;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}	
		return 400;
	}

	public List<Integer> getSettingIdByDate(LocalDate from, LocalDate to, int gymId) {
		Database db = new Database();		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;		
		ResultSet rs = null;		
		List<Integer> settingIds = new ArrayList<>();
		
		try {
			String sql = "SELECT settingId FROM settings WHERE (`set-date`<=? OR `remove-date>=?) AND `gymId`=?`";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.toString());
			pstmt.setString(2, from.toString());
			pstmt.setInt(3, gymId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				settingIds.add(rs.getInt("settingId"));
			};
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConnection(conn);
		}
		
		return settingIds;
	}
	
	public List<RouteInfo> selectRouteListInfo(int pageNumber, String filter) {
		Database db = new Database(); 	
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null; ResultSet rs = null; List<RouteInfo> routeInfoList = null;	
		try {
			String sql = "SELECT R.routeId, R.name AS `routeName`, R.holdColor, R.levelColor, R.img, SC.name AS `sectorName`, CONCAT_WS(~,S.setDate,S.removeDate) AS `date`"
					+ "FROM routes R"
					+ "JOIN settings S ON S.settingId=R.settingId"
					+ "JOIN sectors SC ON SC.sectorId=S.sectorId"
					+ "JOIN gyms G ON G.id=SC.gymId " + filter + " LIMIT ?, ? ";
			int amountPerPage = 15;
			int startIndex = (pageNumber-1)*amountPerPage;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, amountPerPage);		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int routeId = rs.getInt("routeId");
				String routeName = rs.getString("routeName");
				String holdColor = rs.getString("holdColor");
				String levelColor = rs.getString("levelColor");
				String img = rs.getString("img");
				String sectorName = rs.getString("sectorName");
				String dateString = rs.getString("date");
				
				RouteInfo nthRouteInfo = new RouteInfo(routeId, routeName, holdColor, levelColor, img, sectorName, dateString);			
				routeInfoList.add(nthRouteInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs); db.closePstmt(pstmt); db.closeConnection(conn);			
			
		}	
		return routeInfoList;	
	}	

	public 
}

