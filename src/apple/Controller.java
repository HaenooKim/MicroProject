package apple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
