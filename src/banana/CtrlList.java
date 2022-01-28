package banana;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apple.Controller;
import apple.ModelAndView;

public class CtrlList implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Bang07DAO dao = new Bang07DAO_MariaImpl();
		List<Bang07VO> rl = dao.findAll();
			
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("/WEB-INF/jsp/list");
		mnv.addObject("rlist", rl);
	
		return mnv;
	}

}
