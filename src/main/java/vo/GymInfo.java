package vo;

import java.time.LocalDateTime;

public class GymInfo {
	private int gymId;
	private String gymName;
	private String gymAddr;
	private String gymTel;
	private String gymImgPath;
	private String managerId;
	private LocalDateTime regDate;
	
	// 모두 포함
	public GymInfo(int gymId, String gymName, String gymAddr, String gymTel, String gymImgPath, String managerId, LocalDateTime regDate) {
		super();
		this.gymId = gymId;
		this.gymName = gymName;
		this.gymAddr = gymAddr;
		this.gymTel = gymTel;
		this.gymImgPath = gymImgPath;
		this.managerId = managerId;
		this.regDate = regDate;
	}
	
	// 관리자 아이디 제외
	public GymInfo(int gymId, String gymName, String gymAddr, String gymTel, String gymImgPath, String managerId) {
		super();
		this.gymId = gymId;
		this.gymName = gymName;
		this.gymAddr = gymAddr;
		this.gymTel = gymTel;
		this.gymImgPath = gymImgPath;
		this.managerId = managerId;
	}	
	
	// gymId 제외 (정보 등록용)
	public GymInfo(String gymName, String gymAddr, String gymTel, String gymImgPath, String managerId,
			LocalDateTime regDate) {
		super();
		this.gymName = gymName;
		this.gymAddr = gymAddr;
		this.gymTel = gymTel;
		this.gymImgPath = gymImgPath;
		this.managerId = managerId;
		this.regDate = regDate;
	}

	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public LocalDateTime getregDate() {
		return regDate;
	}
	public void setregDate(LocalDateTime regDate) {
		this.regDate = regDate;
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
