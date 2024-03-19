package com.dictionaryapp.controller;

import com.dictionaryapp.model.DTo.AllWordsDTO;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final WordService wordService;
    private final LoginUser loginUser;

    public HomeController(WordService wordService, LoginUser loginUser) {
        this.wordService = wordService;
        this.loginUser = loginUser;
    }
    @GetMapping("/")
    public ModelAndView index(){
        if (loginUser.isLogin()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(){
        if (!loginUser.isLogin()) {
            return new ModelAndView("redirect:/login");
        }
        AllWordsDTO allWordsDTO = this.wordService.viewAll();
        return new ModelAndView("home","words",allWordsDTO);
    }

    @GetMapping("/home/remove-all")
   public String removeAll() {
        if (!loginUser.isLogin()) {
            return "redirect:/login";
        }
        this.wordService.removeAll();
        return "redirect:/home";
    };

    @GetMapping("/remove/word-by-id/{id}")
   public String removeById(@PathVariable("id")Long id) {
        this.wordService.remove(id);
        return "redirect:/home";
    };


}
