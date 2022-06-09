package vo;

public class GymInfo {
	private String gymName;
	private String gymAddr;
	private String gymTel;
	private String gymImgPath;
	private String managerId;		
	
	// 모두 포함
	public GymInfo(String gymName, String gymAddr, String gymTel, String gymImgPath, String managerId) {
		super();
		this.gymName = gymName;
		this.gymAddr = gymAddr;
		this.gymTel = gymTel;
		this.gymImgPath = gymImgPath;
		this.managerId = managerId;
	}
	
	
	public String getGymImgPath() {
		return gymImgPath;
	}
	public void setGymImgPath(String gymImgPath) {
		this.gymImgPath = gymImgPath;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymTel() {
		return gymTel;
	}
	public void setGymTel(String gymTel) {
		this.gymTel = gymTel;
	}
	public String getGymAddr() {
		return gymAddr;
	}
	public void setGymAddr(String gymAddr) {
		this.gymAddr = gymAddr;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
}
