package vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Review {
	private int routeId;
	private int memberIdx;
	private int levelScore;
	private int funScore;
	private boolean solved;
	private LocalDate solvedDate;
	private String comment;
	private LocalDateTime reviewDate;
	
	public Review(int levelScore, int funScore, boolean solved, String comment, LocalDateTime reviewDate) {
		super();
		this.levelScore = levelScore;
		this.funScore = funScore;
		this.solved = solved;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}

	public Review(int routeId, int memberIdx) {
		super();
		this.routeId = routeId;
		this.memberIdx = memberIdx;
	}

	public Review(int routeId, int memberIdx, int levelScore, int funScore, boolean solved, LocalDate solvedDate,
			String comment, LocalDateTime reviewDate) {
		super();
		this.routeId = routeId;
		this.memberIdx = memberIdx;
		this.levelScore = levelScore;
		this.funScore = funScore;
		this.solved = solved;
		this.solvedDate = solvedDate;
		this.comment = comment;
		this.reviewDate = reviewDate;
	}
	
	public Review(int routeId, int memberIdx, int levelScore, int funScore, boolean solved, LocalDate solvedDate,
			String comment) {
		super();
		this.routeId = routeId;
		this.memberIdx = memberIdx;
		this.levelScore = levelScore;
		this.funScore = funScore;
		this.solved = solved;
		this.solvedDate = solvedDate;
		this.comment = comment;
	}

	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getMemberIdx() {
		return memberIdx;
	}
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public int getLevelScore() {
		return levelScore;
	}
	public void setLevelScore(int levelScore) {
		this.levelScore = levelScore;
	}
	public int getFunScore() {
		return funScore;
	}
	public void setFunScore(int funScore) {
		this.funScore = funScore;
	}
	public boolean isSolved() {
		return solved;
	}
	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	public LocalDate getSolvedDate() {
		return solvedDate;
	}
	public void setSolvedDate(LocalDate solvedDate) {
		this.solvedDate = solvedDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(LocalDateTime reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	
}
