package org.comstudy21.myapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	ModelAndView requestMap(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}