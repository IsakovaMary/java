package com.fox.links.Controllers;

import com.fox.links.Models.Links;
import com.fox.links.Repo.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;



@Validated
@Controller
@RequestMapping("/")
public class MainController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    @Autowired
    LinkRepository linkRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Links> links = linkRepository.findAll();
        model.addAttribute("links", links);
        return "index";
    }

    @GetMapping("/new")
    public String newLink(Model model) {
        model.addAttribute("links", new Links());

        return "new";
    }

    @PostMapping("/new")
    public String add( @ModelAttribute("links")  Links links,
                      Model model){
        model.addAttribute("links", links);
        Links oneLinks = linkRepository.findByShortLink(links.getShortLink());

            if(oneLinks != null){
                model.addAttribute("message1", "Такое сокращение уже существует, используйте другое!");
            }
       else if(links.getLong_link() == null && links.getShortLink() != null){
        model.addAttribute("message", "Заполните поле с оригинальной ссылкой!");
    }
    else if(links.getShortLink() == null && links.getLong_link() != null){
        model.addAttribute("message1", "Заполните поле с краткой ссылкой!");
    }
    else if(links.getShortLink() == null && links.getLong_link() == null){
        model.addAttribute("message1", "Заполните поле с краткой ссылкой!");
        model.addAttribute("message", "Заполните поле с оригинальной ссылкой!");
    }

     else {
                model.addAttribute("message1", "Готово :)");

                linkRepository.save(links);
        return "redirect:/";
    } return "new";
    }
}
