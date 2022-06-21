package member;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberInfoDao;
import vo.Member;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/member/join")
public class JoinController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwChk = request.getParameter("pwChk");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		LocalDateTime regDate = LocalDateTime.now();
		
		Member newMember = new Member(id,pw,name,email,regDate);
		
		MemberInfoDao dao = new MemberInfoDao();
		MemberService service = new MemberService();
		if (service.isAlreadyIdOrEmail(newMember)) response.setStatus(HttpServletResponse.SC_CONFLICT);
		else {
			int status = dao.insertMemberInfo(newMember);
			response.setStatus(status);
		}
	
	}

}
