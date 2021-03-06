package vo;

import java.time.LocalDate;

public class Settings extends Sectors{
	private int settingId;
	private int sectorId;
	private LocalDate setDate;
	private LocalDate removeDate;
	private String dateString;	
	
	public Settings(int settingId, String dateString) {
		this.settingId = settingId;
		this.dateString = dateString;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public Settings(int sectorId, LocalDate setDate, LocalDate removeDate) {
		super();
		this.sectorId = sectorId;
		this.setDate = setDate;
		this.removeDate = removeDate;
	}
	public Settings(int settingId, int sectorId, LocalDate setDate, LocalDate removeDate) {
		super();
		this.settingId = settingId;
		this.sectorId = sectorId;
		this.setDate = setDate;
		this.removeDate = removeDate;
	}
	
	public Settings() {}
	
	public int getSettingId() {
		return settingId;
	}
	public void setSettingId(int settingId) {
		this.settingId = settingId;
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
	public LocalDate getRemoveDate() {
		return removeDate;
	}
	public void setRemoveDate(LocalDate removeDate) {
		this.removeDate = removeDate;
	}
	
	
}
