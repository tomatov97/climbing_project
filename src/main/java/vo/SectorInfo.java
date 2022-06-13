package vo;

public class SectorInfo {
	private int gymId;
	private int sectorId;
	private String sectorName;	
	
	public SectorInfo(int gymId, String sectorName) {
		super();
		this.gymId = gymId;
		this.sectorName = sectorName;
	}

	public SectorInfo(int gymId, int sectorId, String sectorName) {
		super();
		this.gymId = gymId;
		this.sectorId = sectorId;
		this.sectorName = sectorName;
	}
	
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public int getSectorId() {
		return sectorId;
	}
	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	
	
}
