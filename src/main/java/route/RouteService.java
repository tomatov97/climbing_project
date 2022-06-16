package route;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import dao.RouteInfoDao;
import vo.RouteFilter;
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
	
	public String createWHERE(RouteFilter filter) {		
		int gymId = filter.getGymId();
		int sector = filter.getSectorId();
		String hold = filter.getHoldColor();
		String level = filter.getLeveColor();
		LocalDate fromDate = filter.getFromDate();
		LocalDate toDate = filter.getToDate();
		String order = filter.getOrder();
		
		String where = "WHERE gymId=" + gymId;
		if (sector != 0) where = where + " AND `sectorId`="+ sector;
		if (hold != null) where = where + " AND `holdColor`="+ hold;
		if (level != null) where = where + " AND `levelColor`="+ level;
		if (fromDate != null || toDate != null) {
			// settingId 들고오기
			RouteInfoDao dao = new RouteInfoDao();
			List<Integer> settingIds = dao.getSettingIdByDate(fromDate, toDate, gymId);
			String settingIdQuery = null;
			// settingId를 이용한 쿼리 만들기
			for (int id : settingIds) settingIdQuery = settingIdQuery + " OR settingId="+id;
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
	
	public int getAmountOfRoute(RouteFilter filter) {
		RouteInfoDao dao = new RouteInfoDao();
		String where = createWHERE(filter);
		int amount = dao.getAmountOfRoute(where);
		return amount;
	}
}
