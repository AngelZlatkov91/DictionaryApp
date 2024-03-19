package com.dictionaryapp.controller;

import com.dictionaryapp.model.DTo.UserLoginDTO;
import com.dictionaryapp.model.DTo.UserRegistrationDTO;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.LoginUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserRegisterController {
    private final UserService userService;
    private final LoginUser loginUser;
    @Autowired
    public UserRegisterController(UserService userService, LoginUser loginUser) {
        this.userService = userService;
        this.loginUser = loginUser;
    }

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initForm() {
        return new UserRegistrationDTO();
    }
    @ModelAttribute("userLoginDTO")
    public UserLoginDTO initLogin() {
        return new UserLoginDTO();
    }

    @GetMapping("/login")
    public String login(){
        if (loginUser.isLogin()) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        if (loginUser.isLogin()) {
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String register( @Valid UserRegistrationDTO userRegistrationDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){
        if (loginUser.isLogin()) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO",bindingResult);
            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            return "redirect:/register";
        }
        boolean isRegister = this.userService.register(userRegistrationDTO);
        if(!isRegister) {
            return "redirect:/register";
        }
        return "redirect:/login";
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid UserLoginDTO userLoginDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (loginUser.isLogin()) {
            return new ModelAndView("redirect:/home");
        }
        boolean isLog = this.userService.login(userLoginDTO);

        if (bindingResult.hasErrors() || !isLog) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO",bindingResult);
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/logout")
    public String logout(){
        if(!loginUser.isLogin()) {
            return "redirect:/login";
        }
        this.userService.logout();
        return "redirect:/";
    }

}
