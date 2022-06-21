package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberInfoDao;
import exception.BadParameterException;
import util.MemberValidator;
import vo.Member;

/**
 * Servlet implementation class MemberPasswordUpdateController
 */
@WebServlet("/member/pwupdate")
public class MemberPasswordUpdateController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idx = Integer.parseInt(request.getParameter("idx"));
			String oldPw = request.getParameter("oldPassword");
			String newPw = request.getParameter("newPassword");
			String newPwChk = request.getParameter("newPasswordChk");
			
			MemberValidator validator = new MemberValidator();
			if 		(!validator.pwValidator(oldPw)) 	 	throw new BadParameterException();
			else if (!validator.pwValidator(newPw)) 	 	throw new BadParameterException();
			else if (!validator.pwValidator(newPwChk)) 	 	throw new BadParameterException();
			
			HttpSession session = request.getSession();	
			Member loginUserInfo = (Member) session.getAttribute("loginUserInfo");
			if (loginUserInfo.getPw().equals(oldPw)) {
				if (newPw.equals(newPwChk)) {
					MemberInfoDao dao = new MemberInfoDao();
					dao.updatePasswordByIdx(idx, newPw);
				} else throw new BadParameterException();			
			} else throw new BadParameterException();
		} catch (BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}

}
