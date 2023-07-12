package com.shankar.schoolmanagementapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.shankar.schoolmanagementapp.dao.UserAccountRepository;
import com.shankar.schoolmanagementapp.entities.UserAccount;

@Controller
public class SecurityController {

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    @Autowired
    UserAccountRepository userAccountRepository;

    // @GetMapping("/")
    // public String loginPage(){
    //     return "security/login";
    // }

    @GetMapping("/register")
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount",userAccount);
        return "security/register";
        
    }

    @PostMapping("/register/save")
    public  String saveUser(Model model,UserAccount user){
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        userAccountRepository.save(user);
        return "redirect:/";

    }

    // @GetMapping("/logout")
    // public  String userLoggingOut(){
    //     return "security/logout";
    // }

    //  @GetMapping("/logout-success")
    // public  String userLoggingOut1(){
    //     return "security/logout";
    // }
    
}
