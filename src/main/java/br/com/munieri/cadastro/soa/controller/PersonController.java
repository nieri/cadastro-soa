package br.com.munieri.cadastro.soa.controller;

import br.com.munieri.cadastro.soa.model.Person;
import br.com.munieri.cadastro.soa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/pessoas")
public class PersonController {

    @Autowired
    PersonService service;

    @RequestMapping("/index")
    public String index() {
        return "pessoas/index";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("pessoas/listar");
        modelAndView.addObject(service.list());
        return modelAndView;
    }

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public ModelAndView mostrar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("pessoas/mostrar");
        modelAndView.addObject(service.findById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(){
        return "pessoas/form";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvar(Person person){
        service.save(person);
        return "redirect:listar";
    }

    @RequestMapping(value = "/alterar", method = RequestMethod.POST)
    public String alterar(Person person){
        service.update(person);
        return "redirect:listar";
    }

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public ModelAndView editar(Long id) {
        Person person = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("pessoas/editar");
        modelAndView.addObject(person);
        return modelAndView;
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.GET)
    public String deletar(Long id){
        service.delete(id);
        return "redirect:listar";
    }
}
