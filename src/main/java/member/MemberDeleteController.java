package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberInfoDao;
import vo.Member;

@WebServlet("/member/delete")
public class MemberDeleteController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberInfoDao dao = new MemberInfoDao();
		String loginMemberId = (String) session.getAttribute("loginMemberId");
		int idx = dao.selectMemberIdxById(loginMemberId);
		dao.deleteMemberInfo(idx);
		session.invalidate();
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
