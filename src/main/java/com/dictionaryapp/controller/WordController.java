package com.dictionaryapp.controller;

import com.dictionaryapp.model.DTo.WordAddDTO;
import com.dictionaryapp.service.WordService;
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
public class WordController {
    private final WordService wordService;
    private final LoginUser loginUser;

    @Autowired
    public WordController(WordService wordService, LoginUser loginUser) {
        this.wordService = wordService;
        this.loginUser = loginUser;
    }
    @ModelAttribute("wordAddDTO")
    public WordAddDTO initForm(){
        return new WordAddDTO();
    }
    @GetMapping("/word-add")
    public ModelAndView add(){
        if (!this.loginUser.isLogin()) {
            return new ModelAndView("redirect:/login");
        }
        return new ModelAndView("word-add");
    }
    @PostMapping("/word-add")
    public String add (@Valid WordAddDTO wordAddDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (!loginUser.isLogin()) {
            return "redirect:/login";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.wordAddDTO",bindingResult);
            redirectAttributes.addFlashAttribute("wordAddDTO", wordAddDTO);
            return "redirect:/word-add";
        }
        this.wordService.viewAll(wordAddDTO);

        return "redirect:/home";
    }


}
