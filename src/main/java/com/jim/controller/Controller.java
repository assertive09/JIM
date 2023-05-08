package com.jim.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jim.model.Admin;
import com.jim.model.Event;
import com.jim.model.Msg;
import com.jim.model.Student;
import com.jim.repository.AdminRepo;
import com.jim.repository.EventRepo;
import com.jim.repository.StudentRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private EventRepo eventRepo;

	@RequestMapping("/student-login")
	public String studentLogin() {
		return "student-login";
	}

	@RequestMapping("/forget-password")
	public String forgetPasswordHandeler() {
		return "forget-password";
	}

	@RequestMapping("/checkValidStudent")
	public ModelAndView checkValidStudent(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		Student student = this.studentRepo.getStudentByNameandPassword(email, password);
		if (student != null) {
			mv.setViewName("student-home");
			mv.addObject("student", student);

		} else {
			mv.setViewName("student-login");
		}
		return mv;
	}

	@RequestMapping("/signup-student")
	public String signupHandler() {
		return "signup-student";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String createAccountHandler(@ModelAttribute("student") Student student) {
		this.studentRepo.save(student);
		return "student-login";
	}

	@RequestMapping("/admin-login")
	public String adminLogin() {
		return "admin-login";
	}

	@RequestMapping("/checkValidAdmin")
	public ModelAndView checkValidAdmin(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest r) {
		ModelAndView mv = new ModelAndView();
		Admin admin = adminRepo.getAdminByNameandPassword(email, password);
		if (admin != null) {
			HttpSession session = r.getSession();
			session.setAttribute("admin", admin);
			mv.setViewName("redirect:admin-dashboard");
		} else {
			mv.setViewName("adminlogin");
			mv.addObject("msg", new Msg("Invalid email or password"));
		}
		return mv;
	}

	@RequestMapping("/admin-dashboard")
	public String adminDashboard() {
		return "admin-dashboard";
	}

	@RequestMapping("/all-student")
	public ModelAndView showAllStudent() {
		ModelAndView mv = new ModelAndView();
		List<Student> students = this.studentRepo.getAllStudent();
		mv.addObject("students", students);
		mv.setViewName("all-student");
		return mv;
	}

	@RequestMapping("/logout-admin")
	public String logoutAdmin(HttpServletRequest r) {
		r.getSession().invalidate();
		return "admin-login";
	}

	@RequestMapping("/delete-student/{sId}")
	public ModelAndView deleteStudent(@PathVariable("sId") int sid) {
		this.studentRepo.deleteById(sid);
		return showAllStudent();
	}

	@RequestMapping("/edit-student/{sId}")
	public String editStudent(@PathVariable("sId") int sid, Model model) {
		Optional<Student> s = this.studentRepo.findById(sid);
		Student student = s.get();
		model.addAttribute("student", student);
		return "edit-student";
	}

	@RequestMapping("/update-student")
	public ModelAndView updateStudent(@ModelAttribute("student") Student student) {
		this.studentRepo.save(student);
		return showAllStudent();
	}

	@RequestMapping("/event-dashboard")
	public ModelAndView eventDashboard() {
			List<Event> events =(List<Event>) this.eventRepo.findAll();
            ModelAndView mv= new ModelAndView().addObject("events", events);
			mv.setViewName("event-dashboard");
			return mv;
	}

	@RequestMapping("/add-event-page")
	public String addEventPage() {
		return "add-event";
	}
	
	@RequestMapping(value ="/add_event", method = RequestMethod.POST)
	public String addEvent(@ModelAttribute("event") Event event) {
		System.out.println(event);
		this.eventRepo.save(event);
		return "redirect:event-dashboard";
	}
	@RequestMapping("/delete-event/{eId}")
	public ModelAndView deleteEvent(@PathVariable("eId") int eId,HttpServletRequest r) {
		this.eventRepo.deleteById(eId);
		return eventDashboard() ;
	}
	
	@RequestMapping(value = "/edit-event/{eId}")
	public String editEvent(@PathVariable int eId , Model m) {
	Optional<Event> optional=this.eventRepo.findById(eId);
	Event e=optional.get();
	System.out.println(e);
	m.addAttribute("event", e);
	return "edit-event";
	}
	
	@RequestMapping(value ="/update-event", method = RequestMethod.POST)
	public ModelAndView updateEvent(@ModelAttribute("event") Event e) {
		this.eventRepo.save(e);
		return eventDashboard();
	}
	
}