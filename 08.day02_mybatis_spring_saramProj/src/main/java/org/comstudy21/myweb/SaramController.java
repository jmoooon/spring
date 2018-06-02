package org.comstudy21.myweb;

import java.util.List;

import org.comstudy21.myweb.dao.SaramDAO;
import org.comstudy21.myweb.dto.SaramDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaramController {
	private static final Logger logger = LoggerFactory.getLogger(SaramController.class);
	
	@Autowired
	private SaramDAO saramDao;
	
	@RequestMapping(value = "/saram/saram.do", method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		logger.info("Welcome list!");
		
		String viewName = "saram/saram_list";
		ModelAndView mav = new ModelAndView(viewName);
		
		//saramDAO에서 사람 list를 받아서 mav에 담는다
		saramDao.getById("HONG");
		List<SaramDTO> list = saramDao.selectAll();
		mav.addObject("list", list);
		
		return mav;
	}
	
	/*
	 * 바로 페이지명을 string으로 넘겨도 된다.
	@RequestMapping(value = "/saram/saram.do", method = RequestMethod.GET)
	public String list(Model model) {
		logger.info("Welcome list!");
		
		return "saram/saram_list";
	}
	*/
}
