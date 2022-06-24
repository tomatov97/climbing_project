package list;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import vo.Review;

@WebServlet("/review/list")
public class ReviewListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		int routeId = Integer.parseInt(request.getParameter("routeId"));
	
		ReviewDao dao = new ReviewDao();
		int amount = dao.getAmountOfReview(routeId);
		int amountPerPage = 20;
		int startIndex = (pageNumber-1)*amountPerPage;
		if (startIndex >= amount) response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		
		List<Review> reviewList = dao.selectReviewByRoute(routeId, pageNumber);
		request.setAttribute("reviewList", reviewList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/climbing/detail.jsp");
		rd.forward(request, response);
	}


}
