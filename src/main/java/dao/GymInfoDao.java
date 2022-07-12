package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import etc.Database;
import route.RouteService;
import vo.Gyms;
import vo.Routes;
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
	
	public List<Gyms> selectGymsByKeywrd(String key) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		List<Gyms> GymList = new ArrayList<>();	
		try {
			String sql = "SELECT gymId, name, addr FROM gyms WHERE name LIKE ? LIMIT 15 ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+key+"%");	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int gymId = rs.getInt("gymId");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				
				Gyms nthGym = new Gyms(gymId, name, addr);			
				GymList.add(nthGym);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(rs); 
			Database.closePstmt(pstmt); 
			Database.closeConnection(conn);			
		}	
		return GymList;
	}

	public List<Sectors> selectSectorsByGymId(int gymId) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		List<Sectors> sectorList = new ArrayList<>();	
		try {
			String sql = "SELECT sectorId, name FROM sectors WHERE gymId=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gymId);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int sectorId = rs.getInt("sectorId");
				String name = rs.getString("name");
				
				Sectors nthSector = new Sectors(gymId, sectorId, name);			
				sectorList.add(nthSector);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(rs); 
			Database.closePstmt(pstmt); 
			Database.closeConnection(conn);			
		}	
		return sectorList;
	}
	
	public List<Settings> selectSettingsBySectorId(int sectorId) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		List<Settings> settingList = new ArrayList<>();	
		try {
			String sql = "SELECT `settingId`, CONCAT_WS('~',`setDate`,`removeDate`) AS `date` FROM settings WHERE sectorId=? ORDER BY setDate DESC";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sectorId);	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int settingId = rs.getInt("settingId");
				String dateString = rs.getString("date");
				
				Settings nthSetting = new Settings(settingId, dateString);			
				settingList.add(nthSetting);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.closeResultSet(rs); 
			Database.closePstmt(pstmt); 
			Database.closeConnection(conn);			
		}	
		return settingList;
	}
}
