package br.pa.gov.iec.bluwitter.domain.usuario;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    private String id;

    private String nome;

    public Usuario() {

    }

    public Usuario(final String id, final String nome) {

        this.id = id;
        this.nome = nome;
    }

    public String getFormattedId() {

        return "@" + this.id;
    }

    public String getId() {

        return this.id;
    }

    public void setId(final String id) {

        this.id = id;
    }

    public String getNome() {

        return this.nome;
    }

    public void setNome(final String nome) {

        this.nome = nome;
    }

}
