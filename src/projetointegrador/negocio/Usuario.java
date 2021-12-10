package projetointegrador.negocio;

import java.util.Calendar;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Usuario")

public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "nomecompleto")
    private String nomeCompleto;
    
    @Column(name = "datanasc")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataNasc;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "fone")
    private String fone;
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "senha")
    private String senha;
    
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name = "cargo_id")
    //@Column(name = "cargo_id")
    private Cargos cargo_id;

    public Usuario() {
    }

    public Usuario(String usuario, String nomeCompleto, Calendar dataNasc, String email, String fone, String Cpf, String senha, Cargos cargo_id) {
        this.usuario = usuario;
        this.nomeCompleto = nomeCompleto;
        this.dataNasc = dataNasc;
        this.email = email;
        this.fone = fone;
        this.cpf = Cpf;
        this.senha = senha;
        this.cargo_id = cargo_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Calendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Calendar dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String Cpf) {
        this.cpf = Cpf;
    }

    public Cargos getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(Cargos cargo_id) {
        this.cargo_id = cargo_id;
    }
    
    
    
    
}
