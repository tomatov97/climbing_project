package util;

public class MemberValidator {
/*	아이디 : 4자 이상 12자 이하. 영어 소문자, 대문자, 숫자, 언더바(_)만 가능. 영어 포함되어야함
	비밀번호 : 6자 이상 20자 이하. 영어 소문자, 대문자, 숫자, 특수문자 (!@#$%^*-_=+/?) 가능. 각 하나 이상 포함
	이름 : 한글 혹은 영어 소문자, 대문자만 가능. 2자 이상 15자 이하
	이메일 : @과 @이후 . 포함
	닉네임 : 1자 이상 20자 이하. 한글, 영어 소문자, 대문자, 숫자, 특수문자(!@#$%^*-_=+/?) 가능.
	프로필 이미지 : 용량 제한 (미정)
*/

	public boolean idValidator(String id) {
		String regId = "^[a-zA-Z0-9_]{4,12}$";
		boolean correctId = id.matches(regId);
		if (!correctId) return false;

		if 		(id.matches(".*[a-z].*") || id.matches(".*[A-Z].*")) 	return true;
		else return false;
	}
	
	public boolean pwValidator(String pw) {
		String regPw = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^*-_=+/?]).{8,16}$";
		return pw.matches(regPw);
	}
	
	public boolean nameValidator(String name) {
		String regName = "^[가-힣a-zA-Z]{2,15}$";
		return name.matches(regName);
	}
	
	public boolean emailValidator(String email) {
		String regEmail = "\\w+@\\w+\\.\\w+(\\.\\w+)​?";		
		return email.matches(regEmail);
	}
	
	public boolean nicknameValidator(String nickname) {
		String regName = "^[가-힣a-zA-Z0-9!@#$%^*-_=+/?]{2,15}$";
		return nickname.matches(regName);
	}
	
}
