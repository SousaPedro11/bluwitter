package br.pa.gov.iec.bluwitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.pa.gov.iec.bluwitter.domain.mensagem.Mensagem;

@Controller
@RequestMapping("/mensagem")
public class MensagemController {

    @GetMapping(path = "/nova")
    public String nova(final Model model) {

        final Mensagem mensagem = new Mensagem();
        model.addAttribute("mensagem", mensagem);

        return "create-message";
    }
}
