package list;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.RouteFilter;

@WebServlet("/list")
public class RouteListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		int gymId = Integer.parseInt(request.getParameter("gymId"));
		int sectorId = Integer.parseInt(request.getParameter("sectorId"));
		String holdColor = request.getParameter("holdColor");
		String levelColor = request.getParameter("levelColor");
		LocalDate fromDate = LocalDate.parse(request.getParameter("fromDate"));
		LocalDate toDate = LocalDate.parse(request.getParameter("toDate"));
		String order = request.getParameter("order");
		
		RouteFilter filter = new RouteFilter(pageNumber, gymId, sectorId, holdColor, levelColor, fromDate, toDate, order);
		
	}


}
