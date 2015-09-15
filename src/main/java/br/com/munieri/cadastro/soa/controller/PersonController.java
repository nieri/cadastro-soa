package br.com.munieri.cadastro.soa.controller;

import br.com.munieri.cadastro.soa.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/pessoas")
public class PersonController {

    @Autowired
    PersonDAO personDAO;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/listar")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject(personDAO.listar());
        return modelAndView;
    }
}
