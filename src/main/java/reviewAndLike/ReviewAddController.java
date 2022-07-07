package reviewAndLike;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberInfoDao;
import dao.ReviewDao;
import vo.Review;

@WebServlet("/review/add")
public class ReviewAddController extends HttpServlet {	
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
		LocalDateTime reviewDate = LocalDateTime.now();
		
		Review newReview = new Review(routeId, memberIdx, levelScore, funScore, solved, solvedDate, comment, reviewDate);
		ReviewDao dao = new ReviewDao();
		int status = dao.insertReview(newReview);
		response.setStatus(status);
	}

}
