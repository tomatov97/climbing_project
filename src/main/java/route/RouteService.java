package route;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import dao.RouteInfoDao;
import vo.RouteInfo;

public class RouteService {
	public boolean isAlreadyId(int id) {
		RouteInfoDao dao = new RouteInfoDao();
		RouteInfo route = dao.selectRouteById(id);
		if(route == null) 	return false;
		else 				return true;
	}
	
	public int isAlreadyColors(int settingId, String holdColor, String levelColor) {
		RouteInfoDao dao = new RouteInfoDao();
		int amount = dao.countRoutesByColors(settingId, holdColor, levelColor);
		return amount;
	}
	
	public int createId() {
		Random random = new Random();
		int id = random.nextInt(10000, 99999);
		while(isAlreadyId(id)) {
			id = random.nextInt(10000, 99999);
		}
		return id;
	}
	
	public String createName(int settingId, String holdColor, String levelColor) {
		String hold = holdColor + " 홀드 ";
		String level = levelColor + " 레벨";
		String name = hold + level;
		
		int amount = isAlreadyColors(settingId, holdColor, levelColor);
		if(amount != 0) name = name + (amount+1);
		return name;
	}
}
