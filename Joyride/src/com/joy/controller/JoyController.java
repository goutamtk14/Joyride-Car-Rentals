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
import com.joy.entity.User;
import com.joy.service.JoyService;

@Controller
public class JoyController {

	@RequestMapping("/searchcars")
	public static ModelAndView searchCars(HttpServletRequest request, HttpServletResponse response) {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		HttpSession session = request.getSession();
		session.setAttribute("from", from);
		String fromdate0 = request.getParameter("fromdate");
		String todate0 = request.getParameter("todate");

		int seater = Integer.parseInt(request.getParameter("seater"));
		session.setAttribute("seater", seater);
		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date newfromdate = formatter1.parse(fromdate0);
			Date newtodate = formatter1.parse(todate0);
			long diff = newtodate.getTime() - newfromdate.getTime();
			float days = (diff / (1000 * 60 * 60 * 24));
			days = days + 1;
			session.setAttribute("days", days);
			String displayfromdate = formatter3.format(newfromdate);
			String displaytodate = formatter3.format(newtodate);

			fromdate0 = formatter2.format(newfromdate);
			todate0 = formatter2.format(newtodate);

			int fromdate = Integer.parseInt(fromdate0);
			int todate = Integer.parseInt(todate0);
			ArrayList<Cars> car = JoyService.searchCars(from, to, fromdate, todate, seater);
			session.setAttribute("fromdate", displayfromdate);
			session.setAttribute("todate", displaytodate);
			session.setAttribute("fromdatedb", fromdate);
			session.setAttribute("todatedb", todate);

			ModelAndView mv = new ModelAndView();
			mv.addObject("car", car);
			mv.setViewName("cars.jsp");
			return mv;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/login")
	public static ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String carselected = request.getParameter("carselected");
		System.out.println(carselected);
		String cab[] = carselected.split(",");
		String photo = "";
		Cars car = new Cars();
		car.setSource(cab[0]);
		car.setRegistrationnumber(cab[1]);
		car.setModel(cab[2]);
		car.setSeater(Integer.parseInt(cab[3]));

		car.setPrice(Double.parseDouble(cab[4]));
		for (int i = 5; i < cab.length; i++) {
			photo += cab[i];
		}
		car.setPhoto(photo);
		HttpSession session = request.getSession();
		session.setAttribute("carselected", car);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.jsp");
		return mv;

	}

	@RequestMapping("/signin")
	public static ModelAndView signin(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String check = JoyService.getPassword(email);
		if (check.equals(password)) {
			ModelAndView mv = new ModelAndView();
			HttpSession session = request.getSession();
			Cars carselected = (Cars) session.getAttribute("carselected");
			double amount = (float) session.getAttribute("days") * carselected.getPrice();
			mv.addObject("amount", amount);
			session.setAttribute("email", email);
			session.setAttribute("user", JoyService.getUserdata(email));
			mv.setViewName("payment.jsp");
			return mv;
		} else if (check.equals("invalid")) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("error", "Invalid Username");
			mv.setViewName("login.jsp");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.addObject("error", "Invalid Password");
			mv.setViewName("login.jsp");
			return mv;
		}

	}

	@RequestMapping("/register")
	public static ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		long dlnumber = Long.parseLong(request.getParameter("dlnumber"));
		String dlvalidity = request.getParameter("dlvalidity");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(name + " " + dob + " " + dlnumber + " " + dlvalidity + " " + email + " " + password);
		JoyService.registerUser(name, dob, dlnumber, dlvalidity, email, password, mobile);
		ModelAndView mv = new ModelAndView();
		mv.addObject("success", "Registration Successful, Please Log In to continue.");
		mv.setViewName("login.jsp");
		return mv;

	}

	@RequestMapping("/book")
	public static ModelAndView bookCar(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Cars carselected = (Cars) session.getAttribute("carselected");
		String registrationnumber = carselected.getRegistrationnumber();
		User userdata = (User) session.getAttribute("user");
		int id = userdata.getId();
		int fromdate = (int) session.getAttribute("fromdatedb");
		int todate = (int) session.getAttribute("todatedb");
		JoyService.bookCar(registrationnumber, id, fromdate, todate);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("booked.jsp");
		return mv;

	}
	
	@RequestMapping("/logout")
	public static ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.invalidate();
		ModelAndView mv=new ModelAndView();
		mv.addObject("success","You have been successfully logged out.");
		mv.setViewName("index.jsp");
		return mv;
	}

}
