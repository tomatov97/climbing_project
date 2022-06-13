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
		String[] colors = {"red/빨강", "orange/주황", "yellow/노랑", "yellow-green/연두", "green/초록", "mint/민트", "skyblue/하늘", "blue/파랑", "navy/남색", "purple/보라", "pink/분홍", "brown/갈색", "white/흰색", "gray/회색", "black/검정", "wood/나무"};
		Map<String, String> colorMap = new HashMap<>();
		for(String color : colors) {
			String[] splitColor = color.split("/");
			colorMap.put(splitColor[0], splitColor[1]);
		}
		String hold = colorMap.get(holdColor) + " 홀드 ";
		String level = colorMap.get(levelColor) + " 레벨";
		String name = hold + level;
		
		int amount = isAlreadyColors(settingId, holdColor, levelColor);
		if(amount != 0) name = name + (amount+1);
		return name;
	}
}
