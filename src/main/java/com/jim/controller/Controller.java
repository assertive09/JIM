package com.jim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jim.model.Student;
import com.jim.repository.StudentRepo;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private StudentRepo studentRepo;

    @RequestMapping("/studentlogin")
    public String homeHandeler() {
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
        Student student=this.studentRepo.getStudentByNameandPassword(email,password);
        mv.addObject("student", student);
        if (student != null) {
            mv.setViewName("studentdashboard");
        } else {
            mv.setViewName("studentlogin");
        }
        System.out.println(student);
        return mv;
    }

    @RequestMapping("/signup")
    public String signupHandler(){
        return "signup";
    }

    @RequestMapping(value="/createaccount" ,method = RequestMethod.POST)
    public String createAccountHandler(@ModelAttribute ("student") Student student){
        this.studentRepo.save(student);
        return "/studentlogin";
    }

}