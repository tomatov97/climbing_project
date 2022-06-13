package vo;

import java.time.LocalDate;

public class RouteInfo {
	private int routeId;
	private int settingId;
	private String RouteName;
	private String holdColor;
	private String levelColor;
	private String comment;
	private String img;
	private int levelScoreAvg;
	private int funScoreAvg;
		
	public RouteInfo(int settingId, String routeName, String holdColor, String levelColor, String comment, String img) {
		super();
		this.settingId = settingId;
		RouteName = routeName;
		this.holdColor = holdColor;
		this.levelColor = levelColor;
		this.comment = comment;
		this.img = img;
	}
	public RouteInfo(int routeId, int settingId, String routeName, String holdColor, String levelColor, String comment,
			String img, int levelScoreAvg, int funScoreAvg) {
		super();
		this.routeId = routeId;
		this.settingId = settingId;
		RouteName = routeName;
		this.holdColor = holdColor;
		this.levelColor = levelColor;
		this.comment = comment;
		this.img = img;
		this.levelScoreAvg = levelScoreAvg;
		this.funScoreAvg = funScoreAvg;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getSettingId() {
		return settingId;
	}
	public void setSettingId(int settingId) {
		this.settingId = settingId;
	}
	public String getRouteName() {
		return RouteName;
	}
	public void setRouteName(String routeName) {
		RouteName = routeName;
	}
	public String getHoldColor() {
		return holdColor;
	}
	public void setHoldColor(String holdColor) {
		this.holdColor = holdColor;
	}
	public String getLevelColor() {
		return levelColor;
	}
	public void setLevelColor(String levelColor) {
		this.levelColor = levelColor;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getLevelScoreAvg() {
		return levelScoreAvg;
	}
	public void setLevelScoreAvg(int levelScoreAvg) {
		this.levelScoreAvg = levelScoreAvg;
	}
	public int getFunScoreAvg() {
		return funScoreAvg;
	}
	public void setFunScoreAvg(int funScoreAvg) {
		this.funScoreAvg = funScoreAvg;
	}	

}
