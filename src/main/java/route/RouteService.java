package route;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dao.RouteInfoDao;
import vo.RouteFilter;
import vo.Routes;

public class RouteService {
	public boolean isAlreadyId(int id) {
		RouteInfoDao dao = new RouteInfoDao();
		Routes route = dao.selectRouteById(id);
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
	
	public static String createWHERE(RouteFilter filter) {		
		int gymId = filter.getGymId();
		int sector = filter.getSectorId();
		String hold = filter.getHoldColor();
		String level = filter.getLevelColor();
		LocalDate fromDate = filter.getFromDate();
		LocalDate toDate = filter.getToDate();
		String order = filter.getOrder();
		
		String where = "WHERE G.gymId=" + gymId;
		if (sector != 0) where = where + " AND `S.sectorId`="+ sector;
		if (hold != "all") where = where + " AND `R.holdColor`="+ hold;
		if (level != "all") where = where + " AND `R.levelColor`="+ level;
		if (fromDate != null || toDate != null) {
			// settingId 들고오기
			RouteInfoDao dao = new RouteInfoDao();
			List<Integer> settingIds = dao.getSettingIdByDate(fromDate, toDate, gymId);
			String settingIdQuery = null;
			// settingId를 이용한 쿼리 만들기
			for (int id : settingIds) settingIdQuery = settingIdQuery + " OR S.settingId="+id;
			settingIdQuery = settingIdQuery.substring(4);
			// 이어 붙이기
			where = where + " AND (" + settingIdQuery + ")";
		}
		if (order != null) {
			String[] orders = order.split("_");
			where = where + " ORDER BY " + orders[0] + " " + orders[1];
		}		
		return where;
	}
	
	public String loadRouteListToJson (RouteFilter filter) {
		RouteInfoDao dao = new RouteInfoDao();
		List<Routes> routeList = dao.selectRouteListInfo(filter);
		List<String> tempList = new ArrayList<String>();
		int amount = dao.getAmountOfRoute(filter);
		
		for(Routes route : routeList) {
			String routeJson = "{\"routeId\":\"(1)\", \"routeName\":\"(2)\", \"holdColor\":\"(3)\", \"levelColor\":\"(4)\", "
					+ "\"img\":\"(5)\", \"sectorName\":\"(6)\", \"settingDate\":\"(7)\"}";
			routeJson = routeJson.replace("(1)",route.getRouteId()+"");
			routeJson = routeJson.replace("(2)",route.getRouteName());
			routeJson = routeJson.replace("(3)",route.getHoldColor());
			routeJson = routeJson.replace("(4)",route.getLevelColor());
			if(route.getImg()==null) routeJson = routeJson.replace("(5)","");
			else routeJson = routeJson.replace("(5)",route.getImg());
			routeJson = routeJson.replace("(6)",route.getSectorName());
			routeJson = routeJson.replace("(7)",route.getDateString());
			tempList.add(routeJson);			
		}		
		String jsonData = "{\"routeList\":" + tempList + ", \"amount\":" + amount + "}";
		return jsonData;
	}

	public String loadRouteByIdToJson(int id) {
		RouteInfoDao dao = new RouteInfoDao();
		Routes route = dao.selectRouteById(id);
		String jsonData = null;
		
		if(route != null) {
			jsonData = "{\"routeId\":\"(1)\", \"routeName\":\"(2)\", \"levelScore-avg\":\"(3)\", \"funScore\":\"(4)\", "
					+ "\"img\":\"(5)\", \"sectorName\":\"(6)\", \"settingDate\":\"(7)\", \"comment\":\"(8)\"}";
			jsonData = jsonData.replace("(1)",route.getRouteId()+"");
			jsonData = jsonData.replace("(2)",route.getRouteName());
			jsonData = jsonData.replace("(3)",route.getLevelScoreAvg()+"");
			jsonData = jsonData.replace("(4)",route.getFunScoreAvg()+"");
			if(route.getImg()==null) jsonData = jsonData.replace("(5)","");
			else jsonData = jsonData.replace("(5)",route.getImg());
			jsonData = jsonData.replace("(6)",route.getSectorName());
			jsonData = jsonData.replace("(7)",route.getDateString());
		}
		return jsonData;
	}
}
