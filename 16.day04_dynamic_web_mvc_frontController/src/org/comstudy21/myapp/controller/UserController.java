package org.comstudy21.myapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController implements Controller {

	@Override
	public ModelAndView requestMap(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String path = (String) req.getAttribute("path");
		//현재 패스가 /로 시작하지 않아서 클릭할 때마다 URL 패스가 추가되는 형식으로 되어 있어 아래 조건을 만족하지 못하고 에러가 난다.
		
		ModelAndView modelAndView = null;
		
		if("/user/login".equals(path)){
			modelAndView = new ModelAndView(false, "/WEB-INF/views/user/user_list.jsp");
		}
		else if("/user/insert".equals(path)){
			modelAndView = new ModelAndView(false, "/WEB-INF/views/user/user_insert.jsp");
		}
		else if("/user/detail".equals(path)){
			modelAndView = new ModelAndView(false, "/WEB-INF/views/user/user_detail.jsp");
		}
		
		//return new ModelAndView(false, "/WEB-INF/views/user/user_list.jsp");
		
		return modelAndView;
	}

}
