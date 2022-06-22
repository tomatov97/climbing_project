package reviewAndLike;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import vo.Review;

@WebServlet("/like/delete")
public class LikeDeleteController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int routeId = Integer.parseInt(request.getParameter("routeId"));
		int memberIdx = Integer.parseInt(request.getParameter("memberIdx"));
		
		Review review = new Review(routeId, memberIdx);
		ReviewDao dao = new ReviewDao();
		dao.deleteLike(review);
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
