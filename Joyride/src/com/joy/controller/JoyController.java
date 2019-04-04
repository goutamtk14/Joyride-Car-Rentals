package com.joy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.joy.entity.Cars;
import com.joy.service.JoyService;

@Controller
public class JoyController {

	@RequestMapping("/searchcars")
	public static ModelAndView searchCars(HttpServletRequest request, HttpServletResponse response) {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String fromdate0 = request.getParameter("fromdate");
		String todate0 = request.getParameter("todate");
		int seater = Integer.parseInt(request.getParameter("seater"));
		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");

		try {
			Date newfromdate = formatter1.parse(fromdate0);
			Date newtodate = formatter1.parse(todate0);
			fromdate0 = formatter2.format(newfromdate);
			todate0 = formatter2.format(newtodate);
			int fromdate = Integer.parseInt(fromdate0);
			int todate = Integer.parseInt(todate0);
			ArrayList<Cars> car=JoyService.searchCars(from, to, fromdate, todate, seater);
			ModelAndView mv=new ModelAndView();
			mv.addObject("car",car);
			mv.setViewName("cars.jsp");
			return mv;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		

	}
	
	@RequestMapping("/login")
	public static ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String carselected=request.getParameter("carselected");
		String cab[]=carselected.split(",");
		Cars car=new Cars();
		car.setSource(cab[0]);
		car.setRegistrationnumber(cab[1]);
		car.setModel(cab[2]);
		car.setSeater(Integer.parseInt(cab[3]));
		car.setPhoto(cab[4]);
		car.setPrice(Double.parseDouble(cab[5]));
		
		HttpSession session=request.getSession();
		session.setAttribute("carselected",car);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;
		
	}
	
	@RequestMapping("/signin")
	public static ModelAndView signin(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email+" "+password);
		return null;
		
	}
	
	@RequestMapping("/register")
	public static ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email+" "+password);
		return null;
		
	}

}
