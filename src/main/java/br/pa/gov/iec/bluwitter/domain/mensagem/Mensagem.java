package br.pa.gov.iec.bluwitter.domain.mensagem;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mensagem {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime dataHora;

    private String texto;

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

}
