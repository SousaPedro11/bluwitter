package br.pa.gov.iec.bluwitter;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.pa.gov.iec.bluwitter.domain.mensagem.Mensagem;
import br.pa.gov.iec.bluwitter.domain.mensagem.MensagemRepository;
import br.pa.gov.iec.bluwitter.domain.usuario.Usuario;
import br.pa.gov.iec.bluwitter.domain.usuario.UsuarioRepository;

@Component
public class StartupApplicationListener {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MensagemRepository mensagemRepository;

    @EventListener
    public void onApplicatioEvent(final ContextRefreshedEvent contextRefreshedEvent) {

        final Usuario u1 = new Usuario("ctosin", "Carlos");
        this.usuarioRepository.save(u1);

        final Usuario u2 = new Usuario("milani", "Andre");
        this.usuarioRepository.save(u2);

        final Usuario u3 = new Usuario("t800", "Arnold");
        this.usuarioRepository.save(u3);

        final Mensagem m1_u1 = new Mensagem();
        m1_u1.setDataHora(LocalDateTime.now().minusMinutes(45));
        m1_u1.setTexto("O Java ainda tem vida longa, apesar de alguns dizerem que não...");
        m1_u1.setUsuario(u1);
        this.mensagemRepository.save(m1_u1);

        final Mensagem m2_u1 = new Mensagem();
        m2_u1.setDataHora(LocalDateTime.now().minusMinutes(42));
        m2_u1.setTexto("FATO: No mercado de trabalho o que mais tem é vaga pra trabalhar com JAVA!");
        m2_u1.setUsuario(u1);
        this.mensagemRepository.save(m2_u1);

        final Mensagem m1_u2 = new Mensagem();
        m1_u2.setDataHora(LocalDateTime.now().minusMinutes(27));
        m1_u2.setTexto("Olha que sistema show esse, e simples de fazer!");
        m1_u2.setUsuario(u2);
        this.mensagemRepository.save(m1_u2);

        final Mensagem m2_u2 = new Mensagem();
        m2_u2.setDataHora(LocalDateTime.now().minusMinutes(22));
        m2_u2.setTexto("Estou tão impressionado que estou com vontade de contar uma piada!");
        m2_u2.setUsuario(u2);
        this.mensagemRepository.save(m2_u2);

        final Mensagem m3_u1 = new Mensagem();
        m3_u1.setDataHora(LocalDateTime.now().minusMinutes(20));
        m3_u1.setTexto("Puuttzz :|");
        m3_u1.setUsuario(u1);
        this.mensagemRepository.save(m3_u1);

        final Mensagem m1_u3 = new Mensagem();
        m1_u3.setDataHora(LocalDateTime.now().minusMinutes(18));
        m1_u3.setTexto("Hasta la vista! Baby!");
        m1_u3.setUsuario(u3);
        this.mensagemRepository.save(m1_u3);
    }
}
