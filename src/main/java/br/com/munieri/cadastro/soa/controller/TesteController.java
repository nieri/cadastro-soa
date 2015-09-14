package br.com.munieri.cadastro.soa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesteController {

    @RequestMapping("/ola")
    public String index() {
        return "index";
    }
}
