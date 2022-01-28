package banana;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apple.Controller;
import apple.ModelAndView;

public class CtrlAdd implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Bang07DAO dao = new Bang07DAO_MariaImpl();
		ModelAndView mnv = new ModelAndView();
		
		String content = request.getParameter("content");
		System.out.println(content);
		if (content==null || content.equals("")) {
			mnv.setViewName("redirect:list.do?ecode=invalid_content");
			return mnv;
		}
		
		Bang07VO po = new Bang07VO();
		po.setContent(content);
		dao.add(po);
		
		mnv.setViewName("redirect:list.do"); //¿©±â¹Ù²Þ
		return mnv;
	}

}
