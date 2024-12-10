package AWS.PROJECT.demo.controller;

import AWS.PROJECT.demo.entity.Login;
import AWS.PROJECT.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
 private LoginService loginService;

     @GetMapping("/")
    public String showForm(){
         return "index";

    }

    @PostMapping("/")
    public ModelAndView handleLogin(Login login) { // Spring automatically binds form data to the User object
        // Log the email and password for demonstration
        System.out.println("Email: " + login.getEmail());
        System.out.println("Password: " + login.getPassword());

        // Pass the email to the success page
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("email", login.getEmail());
        loginService.getAttendence(login);
        return modelAndView;
    }

}
