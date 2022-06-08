package member;

import dao.MemberInfoDao;
import vo.MemberInfo;

public class MemberService {
	private boolean isAlreadyId(String id) {
		MemberInfoDao dao = new MemberInfoDao();
		MemberInfo memberInfo = dao.selectMemberById(id);
		if (memberInfo == null) return false;
		else return true;		
	}
	
	private boolean isAlreadyEmail(String email) {
		MemberInfoDao dao = new MemberInfoDao();
		MemberInfo memberInfo = dao.selectMemberByEmail(email);
		if (memberInfo == null) return false;
		else return true;		
	}
	
	public boolean isAlreadyIdOrEmail(MemberInfo memberInfo) {
		String id = memberInfo.getId();
		String email = memberInfo.getEmail();
		
		if 		(isAlreadyId(id)) 		return true;
		else if (isAlreadyEmail(email)) return true;
		else 							return false;
	}

	public MemberInfo selectLoginInfo(MemberInfo loginInfo) {
		MemberInfoDao dao = new MemberInfoDao();
		MemberInfo memberInfo = dao.selectMemberById(loginInfo.getId());
		
		if (memberInfo == null) {
			return null;
		} else {
			if (!loginInfo.getPw().equals(memberInfo.getPw())) {
				return null;
			} else return memberInfo;
		}
	}
	
	
}
