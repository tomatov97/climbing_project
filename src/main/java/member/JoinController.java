package member;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.MemberInfo;

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
		
		// 유효성 검증은 jsp에서 바로 할 수 있게 만들기!!!!
		
		MemberInfo newMember = new MemberInfo(id,pw,name,email,regDate);
	}

}
