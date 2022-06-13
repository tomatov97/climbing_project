package route;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.RouteInfoDao;
import vo.RouteInfo;

/**
 * Servlet implementation class RouteAddController
 */
@WebServlet("/route/add")
public class RouteAddController extends HttpServlet {
	private static final int MAXIMUM_FILE_SIZE = 1 * 1024 * 1024; // 1MB	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("images/route");
		
		MultipartRequest mr = new MultipartRequest(request, path, MAXIMUM_FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy());
		
		int settingId = Integer.parseInt(mr.getParameter("settingId"));
		String name = mr.getParameter("routeName");
		String hold = mr.getParameter("holdColor");
		String level = mr.getParameter("levelColor");
		String comment = mr.getParameter("comment");
		String img = mr.getFilesystemName("img");
		
		RouteInfo newRoute = new RouteInfo(settingId, name, hold, level, comment, img);
		
		RouteInfoDao dao = new RouteInfoDao();
		int status = dao.insertRouteInfo(newRoute);
		response.setStatus(status);	
		response.sendRedirect("/climbing/main/problemList.jsp");
	}

}
