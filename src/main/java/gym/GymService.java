package gym;

import java.util.ArrayList;
import java.util.List;

import dao.GymInfoDao;
import vo.Gyms;
import vo.Sectors;
import vo.Settings;

public class GymService {
	
	public String loadGymListToJson(String key) {
		GymInfoDao dao = new GymInfoDao();
		List<Gyms> gymList = dao.selectGymsByKeywrd(key);		
		if(gymList == null) {return "NO CONTENTS";}
		
		List<String> tempList = new ArrayList<>();		
		for(Gyms gym : gymList) {
			String gymJson = "{\"gymId\":\"(1)\", \"name\":\"(2)\", \"addr\":\"(3)\"}";
			gymJson = gymJson.replace("(1)",gym.getGymId()+"");
			gymJson = gymJson.replace("(2)",gym.getGymName());
			gymJson = gymJson.replace("(3)",gym.getGymAddr());
			tempList.add(gymJson);			
		}		
		String jsonData = "{\"gymList\":" + tempList + "}";
		return jsonData;
	}
	
	public String loadSectorToJson(int gymId) {
		GymInfoDao dao = new GymInfoDao();
		List<Sectors> sectorList = dao.selectSectorsByGymId(gymId);		
		if(sectorList == null) {return "NO CONTENTS";}		
		List<String> tempList = new ArrayList<>();		
		for(Sectors sector : sectorList) {
			String sectorJson = "{\"sectorId\":\"(1)\", \"name\":\"(2)\"}";
			sectorJson = sectorJson.replace("(1)",sector.getSectorId()+"");
			sectorJson = sectorJson.replace("(2)",sector.getSectorName());
			tempList.add(sectorJson);			
		}		
		String jsonData = "{\"sectorList\":" + tempList + "}";
		return jsonData;
	}

	public String loadSettingToJson(int sectorId) {
		GymInfoDao dao = new GymInfoDao();
		List<Settings> settingList = dao.selectSettingsBySectorId(sectorId);		
		if(settingList == null) {return "NO CONTENTS";}		
		List<String> tempList = new ArrayList<>();		
		for(Settings setting : settingList) {
			String sectorJson = "{\"settingId\":\"(1)\", \"date\":\"(2)\"}";
			sectorJson = sectorJson.replace("(1)",setting.getSettingId()+"");
			sectorJson = sectorJson.replace("(2)",setting.getDateString());
			tempList.add(sectorJson);			
		}		
		String jsonData = "{\"settingList\":" + tempList + "}";
		return jsonData;
	}
	
}
