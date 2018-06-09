package org.comstudy21.myapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController implements Controller {
	@Override
	public ModelAndView requestMap(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String path = (String) req.getAttribute("path");
		//현재 패스가 /로 시작하지 않아서 클릭할 때마다 URL 패스가 추가되는 형식으로 되어 있어 아래 조건을 만족하지 못하고 에러가 난다.
		
		ModelAndView modelAndView = null;
		
		if("/board/list".equals(path)){
			modelAndView = new ModelAndView(false, "/WEB-INF/views/board/board_list.jsp");
		}
		else if("/board/insert".equals(path)){
			modelAndView = new ModelAndView(false, "/WEB-INF/views/board/board_insert.jsp");
		}
		else if("/board/detail".equals(path)){
			modelAndView = new ModelAndView(false, "/WEB-INF/views/board/board_detail.jsp");
		}
		
		//return new ModelAndView(false, "/WEB-INF/views/board/board_list.jsp");
		
		return modelAndView;
	}
}
