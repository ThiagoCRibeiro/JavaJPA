
package br.com.thiago.model.bean;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

//@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Length(max = 100, message = "O nome não pode ter mais de {max} caracteres")
    @NotBlank(message = "O nome deve ser informado")
    @NotNull(message = "O nome não deve ser nulo")
    @Column(nullable = false)
    private String nome;
    @Length(max = 20, message = "O login não pode ter mais de {max} caracteres")
    @NotBlank(message = "O login deve ser informado")
    @NotNull(message = "O login não deve ser nulo")
    @Column(nullable = false)
    private String login;
    @Length(max = 8, message = "A senha não pode ter mais de {max} caracteres")
    @NotBlank(message = "A senha deve ser informado")
    @NotNull(message = "A senha não deve ser nulo")
    @Column(nullable = false)
    private String senha;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataCad", nullable = false)
    private  Date dataCad;
    @ManyToOne
    private NivelUsuario nivelUsuario;
    @ManyToOne
    private SituacaoUsuario situacaoUsuario;

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCad() {
        return dataCad;
    }

    public void setDataCad(Date dataCad) {
        this.dataCad = dataCad;
    }

    public NivelUsuario getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(NivelUsuario nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public SituacaoUsuario getSituacaoUsuario() {
        return situacaoUsuario;
    }

    public void setSituacaoUsuario(SituacaoUsuario situacaoUsuario) {
        this.situacaoUsuario = situacaoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
