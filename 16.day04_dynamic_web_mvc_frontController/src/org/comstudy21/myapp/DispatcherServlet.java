package org.comstudy21.myapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.myapp.controller.BoardController;
import org.comstudy21.myapp.controller.Controller;
import org.comstudy21.myapp.controller.HandlerMapping;
import org.comstudy21.myapp.controller.ModelAndView;


public class DispatcherServlet extends HttpServlet {
	
	private HandlerMapping handlerMapping = new HandlerMapping();
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("doProcess 호출");
		
		/*
		String viewName="/WEB-INF/views/home.jsp";
		RequestDispatcher view = req.getRequestDispatcher(viewName);
		
		view.forward(req, resp);
		*/
		
		
		/*
		Controller boardController = new BoardController();
		ModelAndView modelAndView = boardController.requestMap(req, resp);
		
		modelAndView.forward(req, resp);
		*/
		
		String reqUri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		
		//String path = "/board/list";
				
		System.out.println(reqUri);System.out.println(ctxPath);
		
		ModelAndView modelAndView = null;
		
		if(reqUri.equals(ctxPath + "/")){
			/*
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
			view.forward(req, resp);
			*/
			modelAndView = new ModelAndView(false, "/WEB-INF/views/home.jsp");
			
		}
		else{
			String path = reqUri.substring(ctxPath.length(), reqUri.lastIndexOf("."));
			Controller boardController = handlerMapping.getController(path);
			req.setAttribute("path", path.replace(ctxPath, ""));
			System.out.println(path);
			modelAndView = boardController.requestMap(req, resp);
			
		}
		
		modelAndView.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doProcess(req, resp);
	}

}
