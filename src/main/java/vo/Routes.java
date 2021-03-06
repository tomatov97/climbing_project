package vo;

public class Routes extends Settings{
	private int routeId;
	private String routeName;
	private String holdColor;
	private String levelColor;
	private String comment;
	private String img;
	private int levelScoreAvg;
	private int funScoreAvg;

	// 문제 상세 정보
	public Routes(int routeId, String routeName, String holdColor, String levelColor, String img, String comment, String sectorName, String dateString) {
		super();
		this.routeId = routeId;
		this.routeName = routeName;
		this.holdColor = holdColor;
		this.levelColor = levelColor;
		this.comment = comment;
		this.img = img;
		this.setSectorName(sectorName);
		this.setDateString(dateString);
	}
	
	public Routes(int routeId, String routeName, String holdColor, String levelColor, String comment, String img, String sectorName, String dateString, int levelScoreAvg, int funScoreAvg) {
		super();
		this.routeId = routeId;
		this.routeName = routeName;
		this.holdColor = holdColor;
		this.levelColor = levelColor;
		this.img = img;
		this.setComment(comment);
		this.setSectorName(sectorName);
		this.setDateString(dateString);
		this.levelScoreAvg = levelScoreAvg;
		this.funScoreAvg = funScoreAvg;		
	}
	
	// 문제 리스트
	public Routes(int routeId, String routeName, String holdColor, String levelColor, String img, String sectorName, String dateString, int levelScoreAvg, int funScoreAvg) {
		super();
		this.routeId = routeId;
		this.routeName = routeName;
		this.holdColor = holdColor;
		this.levelColor = levelColor;
		this.img = img;
		this.setSectorName(sectorName);
		this.setDateString(dateString);
		this.levelScoreAvg = levelScoreAvg;
		this.funScoreAvg = funScoreAvg;		
	}
			
	public Routes(int routeId, int settingId, String routeName, String holdColor, String levelColor, String comment, String img) {
		super();
		this.routeId = routeId;
		this.setSettingId(settingId);
		this.routeName = routeName;
		this.holdColor = holdColor;
		this.levelColor = levelColor;
		this.comment = comment;
		this.img = img;
	}
	public Routes(int settingId, String routeName, String holdColor, String levelColor, String comment, String img) {
		super();
		this.setSettingId(settingId);
		this.routeName = routeName;
		this.holdColor = holdColor;
		this.levelColor = levelColor;
		this.comment = comment;
		this.img = img;
	}
	public Routes(int routeId, int settingId, String routeName, String holdColor, String levelColor, String comment,
			String img, int levelScoreAvg, int funScoreAvg) {
		super();
		this.routeId = routeId;
		this.setSettingId(settingId);
		this.routeName = routeName;
		this.holdColor = holdColor;
		this.levelColor = levelColor;
		this.comment = comment;
		this.img = img;
		this.levelScoreAvg = levelScoreAvg;
		this.funScoreAvg = funScoreAvg;
	}

	public Routes() {
		// TODO Auto-generated constructor stub
	}
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
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
