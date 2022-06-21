package vo;

import java.time.LocalDate;

public class RouteFilter extends Routes {
	private int pageNumber;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String order;	
	
	public RouteFilter(int pageNumber, int gymId) {
		super();
		this.pageNumber = pageNumber;
		this.setGymId(gymId);
	}
	
	public RouteFilter(int pageNumber, int gymId, int sectorId, String holdColor, String levelColor, LocalDate fromDate,
			LocalDate toDate, String order) {
		super();
		this.pageNumber = pageNumber;
		this.setGymId(gymId);
		this.setSectorId(sectorId);
		this.setHoldColor(holdColor);
		this.setLevelColor(levelColor);
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
