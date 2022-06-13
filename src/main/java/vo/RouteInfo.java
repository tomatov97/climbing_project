package vo;

import java.time.LocalDate;

public class RouteInfo {
	private int routeId;
	private int sectorId;
	private LocalDate setDate;
	private String RouteName;
	private String holdColor;
	private String levelColor;
	private String comment;
	private String img;
	private int levelScoreAvg;
	private int funScoreAvg;	
	
	public RouteInfo(int routeId, int sectorId, LocalDate setDate, String routeName, String holdColor,
			String levelColor, String comment, String img, int levelScoreAvg, int funScoreAvg) {
		super();
		this.routeId = routeId;
		this.sectorId = sectorId;
		this.setDate = setDate;
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
	public int getSectorId() {
		return sectorId;
	}
	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}
	public LocalDate getSetDate() {
		return setDate;
	}
	public void setSetDate(LocalDate setDate) {
		this.setDate = setDate;
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
