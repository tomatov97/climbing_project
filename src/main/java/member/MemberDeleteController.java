package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberInfoDao;
import vo.MemberInfo;

/**
 * Servlet implementation class MemberInfoDeleteController
 */
@WebServlet("/member/delete")
public class MemberDeleteController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에 저장된 로그인 정보에서 id를 꺼낸다
		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		int idx = memberInfo.getIdx();
		
		// 회원 탈퇴
		MemberInfoDao dao = new MemberInfoDao();
		dao.deleteMemberInfo(idx);
		
		// 로그인 상태 정보 삭제
		session.invalidate();
		
		// 상태 코드 200 설정
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
