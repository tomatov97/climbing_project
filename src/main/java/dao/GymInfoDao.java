package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import etc.Database;
import vo.Gyms;
import vo.Sectors;
import vo.Settings;

public class GymInfoDao {
	public int insertGymInfo(Gyms newGymInfo) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO gyms(`name`, `addr`, `tel`, `img`, `manager`,`regDate`) VALUES(?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newGymInfo.getGymName());
			pstmt.setString(2, newGymInfo.getGymAddr());
			pstmt.setString(3, newGymInfo.getGymTel());
			pstmt.setString(4, newGymInfo.getGymImgPath());
			pstmt.setString(5, newGymInfo.getManagerId());
			pstmt.setString(6, newGymInfo.getregDate().toString());
			
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

	public int updateGymByIdx(Gyms gymInfo) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE gyms SET name=?, addr=?, tel=?, img=?, manager=? WHERE gymId=?";
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, gymInfo.getGymName());
			pstmt.setString(2, gymInfo.getGymAddr());
			pstmt.setString(3, gymInfo.getGymTel());
			pstmt.setString(4, gymInfo.getGymImgPath());
			pstmt.setString(5, gymInfo.getManagerId());
			pstmt.setInt   (6, gymInfo.getGymId());
			
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
	
	public int insertSectorInfo(Sectors newSectorInfo) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO sectors(`gymId`, `name`) VALUES(?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newSectorInfo.getGymId());
			pstmt.setString(2, newSectorInfo.getSectorName());

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

	public int updateSectorById(Sectors sector) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE sectors SET gymId=?, sectorName=? WHERE sectorId=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sector.getGymId());
			pstmt.setString(2, sector.getSectorName());
			pstmt.setInt(3, sector.getSectorId());

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
	
	public int insertSettingInfo(Settings newSettingInfo) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO settings(`sectorId`, `setDate`, `removeDate`) VALUES(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt	(1, newSettingInfo.getSectorId());
			pstmt.setString (2, newSettingInfo.getSetDate().toString());
			if (newSettingInfo.getRemoveDate()==null) pstmt.setString (3, null);
			else pstmt.setString (3, newSettingInfo.getRemoveDate().toString());

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
	
	public int updateSettingById(Settings setting) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE settings SET sectorId=?, setDate=?, removeDate WHERE settingId=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt	(1, setting.getSectorId());
			pstmt.setString (2, setting.getSetDate().toString());
			pstmt.setString (2, setting.getRemoveDate().toString());
			pstmt.setInt	(3, setting.getSettingId());

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
	
	public String selectGymNameById(int id) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		String name = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT name FROM gyms WHERE gymId=?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				name = rs.getString("name");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}
		return name;
	}

}
