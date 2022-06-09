package vo;

import java.time.LocalDateTime;

public class MemberInfo {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String nickname;
	private String imgPath;
	private LocalDateTime regDate;
	
	// 모두 포함
	public MemberInfo(String id, String pw, String name, String email, String nickname, String imgPath,
			LocalDateTime regDate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.nickname = nickname;
		this.imgPath = imgPath;
		this.regDate = regDate;
	}	
	
	// 닉네임, 이미지 제외 (회원 가입용)
	public MemberInfo(String id, String pw, String name, String email, LocalDateTime regDate) {
		super();
		this.id = id;
		this.nickname = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.imgPath = "default.png";
		this.regDate = regDate;
	}


	public MemberInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
	
}
