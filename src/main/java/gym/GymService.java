package gym;

import java.util.ArrayList;
import java.util.List;

import dao.GymInfoDao;
import vo.Gyms;

public class GymService {
	
	public String loadGymListToJson(String key) {
		GymInfoDao dao = new GymInfoDao();
		List<Gyms> gymList = dao.selectGymsByKeywrd(key);		
		if(gymList == null) {return "NO CONTENTS";}
		
		List<String> tempList = new ArrayList<>();		
		for(Gyms gym : gymList) {
			String gymJson = "{\"GymId\":\"(1)\", \"name\":\"(2)\", \"addr\":\"(3)\"}";
			gymJson = gymJson.replace("(1)",gym.getGymId()+"");
			gymJson = gymJson.replace("(2)",gym.getGymName());
			gymJson = gymJson.replace("(3)",gym.getGymAddr());
			tempList.add(gymJson);			
		}		
		String jsonData = "{\"gymList\":" + tempList + "}";
		return jsonData;
	}
	
}
