package list;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RouteInfoDao;
import vo.Routes;

@WebServlet("/route/detail")
public class RouteDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int routeId = Integer.parseInt(request.getParameter("routeId"));
		
		RouteInfoDao dao = new RouteInfoDao();
		Routes route = dao.selectRouteById(routeId);
		
		request.setAttribute("route", route);
		RequestDispatcher rd = request.getRequestDispatcher("/rockmate/main/routeDetail.jsp");
		rd.forward(request, response);
	}

}
