package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoderController {

    @Autowired
    CoderRepository repository;

    @RequestMapping("/")
    public String home() {

        return "main.jsp";

    }

    @RequestMapping("/addCoder")
    public String addProgrammer(Coder coder) {

        repository.save(coder);
        return "main.jsp";

    }

    @RequestMapping("/getCoder")
    public ModelAndView getCoder(@RequestParam int id) {

        ModelAndView mv = new ModelAndView("getCoder.jsp");
        Coder coder = repository.findById(id).orElse(new Coder());
        mv.addObject(coder);

        System.out.println(repository.findByProgLanguage("Java"));
        System.out.println(repository.findByIdGreaterThan(3));
        System.out.println(repository.findByProgLanguageSorted("Java"));

        return mv;

    }

    @RequestMapping("/getCoders")
    @ResponseBody
    public String getCoders() {

        return repository.findAll().toString();

    }

    @RequestMapping("/coder/{id}")
    @ResponseBody
    public String coderById(@PathVariable("id") int id) {

        return repository.findById(id).toString();

    }

}
