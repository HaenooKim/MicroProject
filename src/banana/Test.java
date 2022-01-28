package banana;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apple.Controller;
import apple.ModelAndView;

public class Test extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		//System.out.println(uri); // /p0126_1/*.do
		String cp = request.getContextPath();
		//System.out.println(cp); // /p0126_1
		
		String uri2 = uri.substring(cp.length());
		System.out.println(uri2); // /bangmyung
		
		Controller ctrl = null;
		if (uri2.equals("/list.do")) {
			ctrl = new CtrlList();
		}
		else if (uri2.equals("/add.do")) {
			ctrl = new CtrlAdd();
		}
		else if (uri2.equals("/del.do")) {
			ctrl = new CtrlDel();
		}
		
		if (ctrl==null) {
			System.out.println("해당 컨트롤러가 없습니다.");
		}
		else {
			try {
				ModelAndView mnv = ctrl.handleRequest(request, response);
				if (mnv!=null) {
					String viewName = mnv.getViewName();
					if (viewName.startsWith("redirect:")) {
						response.sendRedirect(viewName.substring(9));
					}
					else {
						mnv.plant(request);
						RequestDispatcher rd = request.getRequestDispatcher(viewName+".jsp");
						rd.forward(request, response);
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
