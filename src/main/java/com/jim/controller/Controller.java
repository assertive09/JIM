package com.jim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jim.model.Admin;
import com.jim.model.Msg;
import com.jim.model.Student;
import com.jim.repository.AdminRepo;
import com.jim.repository.StudentRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;import jakarta.websocket.Session;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private AdminRepo adminRepo;

    @RequestMapping("/studentlogin")
    public String studentLogin() {
        return "studentlogin";
    }

    @RequestMapping("/forget_password")
    public String forgetPasswordHandeler() {
        return "forget_password";
    }

    @RequestMapping("/checkValidStudent")
    public ModelAndView checkValidStudent(@RequestParam("email") String email,
            @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView();
        Student student = this.studentRepo.getStudentByNameandPassword(email, password);
        if (student != null) {
            mv.setViewName("student_home");
            mv.addObject("student", student);

        } else {
            mv.setViewName("studentlogin");
        }
        return mv;
    }

    @RequestMapping("/signup_student")
    public String signupHandler() {
        return "signup_student";
    }

    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public String createAccountHandler(@ModelAttribute("student") Student student) {
        this.studentRepo.save(student);
        return "studentlogin";
    }

    @RequestMapping("/adminlogin")
    public String adminLogin() {
        return "adminlogin";
    }

    @RequestMapping("/checkValidAdmin")
    public ModelAndView checkValidAdmin(@RequestParam("email") String email,
            @RequestParam("password") String password ,HttpServletRequest r) {
        ModelAndView mv = new ModelAndView();
        Admin admin = adminRepo.getAdminByNameandPassword(email, password);
        if (admin != null) {
            HttpSession session =r.getSession();
            session.setAttribute("admin", admin);
            mv.setViewName("redirect:admin_dashboard");
        } else {
            mv.setViewName("adminlogin");
            mv.addObject("msg", new Msg("Invalid email or password"));
        }
        return mv;
    }
    @RequestMapping("/admin_dashboard")
    public String adminDashboard() {
    	
    	return "admin_dashboard";
    }
    
@RequestMapping("/all_student")
public ModelAndView showAllStudent(HttpServletRequest r) {
	ModelAndView mv=new ModelAndView();
	List<Student> students=this.studentRepo.getAllStudent();
	mv.addObject("students",students);
	mv.setViewName("all_student");
	return mv;
}

@RequestMapping("/logout-admin")
public String logoutAdmin(HttpServletRequest r) {
	r.getSession().invalidate();
	return "adminlogin";
}

@RequestMapping("deleteStudent/{sId}")
public String deleteStudent(@PathVariable ("sId") int sid) {
	this.studentRepo.deleteById(sid);
	return "all_student";
} 

}