package vo;

import java.time.LocalDate;

public class RouteFilter extends RouteInfo {
	private int pageNumber;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String order;	
	
	public RouteFilter(int pageNumber, int gymId) {
		super();
		this.pageNumber = pageNumber;
		this.gymId = gymId;
	}
	
	public RouteFilter(int pageNumber, int gymId, int sectorId, String holdColor, String leveColor, LocalDate fromDate,
			LocalDate toDate, String order) {
		super();
		this.pageNumber = pageNumber;
		this.gymId = gymId;
		this.sectorId = sectorId;
		this.holdColor = holdColor;
		this.levelColor = leveColor;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.order = order;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
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
	public String getHoldColor() {
		return holdColor;
	}
	public void setHoldColor(String holdColor) {
		this.holdColor = holdColor;
	}
	public String getLeveColor() {
		return levelColor;
	}
	public void setLeveColor(String leveColor) {
		this.levelColor = leveColor;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
	
}
