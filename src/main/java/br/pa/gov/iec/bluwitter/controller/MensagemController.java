package br.pa.gov.iec.bluwitter.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.pa.gov.iec.bluwitter.domain.mensagem.Mensagem;
import br.pa.gov.iec.bluwitter.domain.mensagem.MensagemRepository;
import br.pa.gov.iec.bluwitter.domain.usuario.Usuario;
import br.pa.gov.iec.bluwitter.domain.usuario.UsuarioRepository;

@Controller
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(path = "/nova")
    public String nova(final Model model) {

        final Mensagem mensagem = new Mensagem();
        model.addAttribute("mensagem", mensagem);

        final List<Usuario> usuarios = this.usuarioRepository.findAll(new Sort(Direction.ASC, "nome"));
        model.addAttribute("usuarios", usuarios);

        return "mensagem-criar";
    }

    @PostMapping(path = "criar")
    public String criar(final Mensagem mensagem) {

        if (!mensagem.getTexto().isEmpty()) {
            mensagem.setDataHora(LocalDateTime.now());
            this.mensagemRepository.save(mensagem);
        }

        return "redirect:/mensagem/listar";
    }

    @GetMapping(path = "/listar")
    public String listar(final Model model) {

        final List<Mensagem> mensagens = this.mensagemRepository.findAll(new Sort(Direction.DESC, "dataHora"));
        model.addAttribute("mensagens", mensagens);

        return "mensagem-listar";
    }

    @GetMapping(path = "/curtir")
    public String curtir(@RequestParam("msgId") final Integer msgId) {

        final Mensagem mensagem = this.mensagemRepository.findById(msgId).orElseThrow();
        mensagem.curtir();
        this.mensagemRepository.save(mensagem);

        return "redirect:/mensagem/listar";
    }
}
