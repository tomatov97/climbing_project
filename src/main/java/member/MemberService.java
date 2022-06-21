package member;

import dao.MemberInfoDao;
import vo.Member;

public class MemberService {
	private boolean isAlreadyId(String id) {
		MemberInfoDao dao = new MemberInfoDao();
		Member memberInfo = dao.selectMemberById(id);
		if (memberInfo == null) return false;
		else return true;		
	}
	
	private boolean isAlreadyEmail(String email) {
		MemberInfoDao dao = new MemberInfoDao();
		Member memberInfo = dao.selectMemberByEmail(email);
		if (memberInfo == null) return false;
		else return true;		
	}
	
	public boolean isAlreadyIdOrEmail(Member memberInfo) {
		String id = memberInfo.getId();
		String email = memberInfo.getEmail();
		
		if 		(isAlreadyId(id)) 		return true;
		else if (isAlreadyEmail(email)) return true;
		else 							return false;
	}

	public Member selectLoginInfo(Member loginInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		Member memberInfo = dao.selectMemberById(loginInfo.getId());
		
		if (memberInfo == null) {
			return null;
		} else {
			if (!loginInfo.getPw().equals(memberInfo.getPw())) {
				return null;
			} else return memberInfo;
		}
	}
	
	
}
