package vo;

public class GymInfo {
	private String gymName;
	private String gymTel;
	private String gymAddr;
	private String managerId;	
	
	public GymInfo(String gymName, String gymTel, String gymAddr) {
		super();
		this.gymName = gymName;
		this.gymTel = gymTel;
		this.gymAddr = gymAddr;
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
