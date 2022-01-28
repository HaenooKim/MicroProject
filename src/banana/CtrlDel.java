package banana;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apple.Controller;
import apple.ModelAndView;

public class CtrlDel implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Bang07DAO dao = new Bang07DAO_MariaImpl();
		Bang07VO po = new Bang07VO();
		
		int no= Integer.parseInt(request.getParameter("no"));
		
		po.setNo(no);
		dao.delByPK(po);
		
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("redirect:list.do");
		
		return mnv;
	}


}
