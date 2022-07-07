package list;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RouteInfoDao;
import route.RouteService;
import vo.RouteFilter;

@WebServlet("/list")
public class RouteListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		int gymId = Integer.parseInt(request.getParameter("gymId"));
		int sectorId = 0;
		if (request.getParameter("sectorId")!=null) sectorId = Integer.parseInt(request.getParameter("sectorId"));
		String holdColor = request.getParameter("holdColor");
		String levelColor = request.getParameter("levelColor");
		LocalDate fromDate = null;
		LocalDate toDate = null;
		if (request.getParameter("fromDate")!=null) fromDate = LocalDate.parse(request.getParameter("fromDate"));
		if (request.getParameter("toDate")!=null) toDate = LocalDate.parse(request.getParameter("toDate"));
		String order = request.getParameter("order");
		
		RouteFilter filter = new RouteFilter(pageNumber, gymId, sectorId, holdColor, levelColor, fromDate, toDate, order);
		RouteInfoDao dao = new RouteInfoDao();
		RouteService service = new RouteService();
		
		int amount = dao.getAmountOfRoute(filter);
		int amountPerPage = 15;
		int startIndex = (pageNumber-1)*amountPerPage;
		if (startIndex >= amount) response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		
		String data = service.loadRouteListToJson(filter);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(data);
		
		out.close();
	}


}
