package br.pa.gov.iec.bluwitter.domain.mensagem;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.pa.gov.iec.bluwitter.domain.usuario.Usuario;

@Entity
public class Mensagem {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime dataHora;

    private String texto;

    @ManyToOne
    private Usuario usuario;

    private int curtidas;

    public Integer getId() {

        return this.id;
    }

    public void setId(final Integer id) {

        this.id = id;
    }

    public LocalDateTime getDataHora() {

        return this.dataHora;
    }

    public void setDataHora(final LocalDateTime dataHora) {

        this.dataHora = dataHora;
    }

    public String getTexto() {

        return this.texto;
    }

    public void setTexto(final String texto) {

        this.texto = texto;
    }

    public Usuario getUsuario() {

        return this.usuario;
    }

    public void setUsuario(final Usuario usuario) {

        this.usuario = usuario;
    }

    public long calcularTempoMinutos() {

        return ChronoUnit.MINUTES.between(this.dataHora, LocalDateTime.now());
    }

    public void curtir() {

        if (this.getCurtidas() > 0) {
            this.curtidas--;

        } else {

            this.curtidas++;
        }
    }

    public int getCurtidas() {

        return this.curtidas;
    }

    public void setCurtidas(final int curtidas) {

        this.curtidas = curtidas;
    }
}
