package route;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MemberInfoDao;
import dao.RouteInfoDao;
import exception.BadParameterException;
import vo.MemberInfo;
import vo.RouteInfo;


@WebServlet("/route/update")
public class RouteUpdateController extends HttpServlet {
	private static final int MAXIMUM_FILE_SIZE = 1 * 1024 * 1024;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("images/route");
		MultipartRequest mr = new MultipartRequest(request, path, MAXIMUM_FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy());
		if (mr.getParameter("routeId") == null) throw new BadParameterException();
		
		int id = Integer.parseInt(mr.getParameter("routeId"));
		int settingId = Integer.parseInt(mr.getParameter("settingId"));
		String name = mr.getParameter("name");
		String hold = mr.getParameter("holdColor");
		String level = mr.getParameter("levelColor");
		String comment = mr.getParameter("comment");
		String img = mr.getFilesystemName("img");
		if (img == null) {
			img = mr.getParameter("img");
		}
		
		RouteInfo routeInfo = new RouteInfo(id, settingId, name, hold, level, comment, img);
		RouteInfoDao dao = new RouteInfoDao();
		int status = dao.updateById(routeInfo);
		
		response.setStatus(status);
		
	
	}

}
