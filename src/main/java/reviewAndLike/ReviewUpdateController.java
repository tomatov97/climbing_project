package reviewAndLike;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberInfoDao;
import dao.ReviewDao;
import vo.Member;
import vo.Review;

@WebServlet("/review/update")
public class ReviewUpdateController extends HttpServlet {	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MemberInfoDao memberDao = new MemberInfoDao();
		
		String loginMemberId = (String) request.getAttribute("loginMemberId");
		int routeId = Integer.parseInt(request.getParameter("routeId"));
		int memberIdx = memberDao.selectMemberIdxById(loginMemberId);
		int levelScore = Integer.parseInt(request.getParameter("levelScore"));
		int funScore = Integer.parseInt(request.getParameter("funScore"));
		boolean solved = Boolean.parseBoolean(request.getParameter("solved"));
		LocalDate solvedDate = null;
		if (solved == true) solvedDate = LocalDate.parse(request.getParameter("solvedDate"));
		String comment = request.getParameter("comment");
		
		Review review = new Review(routeId, memberIdx, levelScore, funScore, solved, solvedDate, comment);
		ReviewDao ReviewDao = new ReviewDao();
		int status = ReviewDao.updateReview(review);
		response.setStatus(status);
	}

}
