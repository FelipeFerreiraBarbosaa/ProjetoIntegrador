package projetointegrador.negocio;
// Generated 25/06/2015 16:48:08 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe
 */
    
@Entity
@Table(name="contato")
public class Contato  implements java.io.Serializable {


     private Long idContato;
     private String nomeContato;
     private String emailContato;
     private String telefoneContato;
     private String celularContato;
     private Date criacaoContato;
     private Date atualizacaoContato;
     private Set<Fornecedor> fornecedors = new HashSet<Fornecedor>(0);
     private Set<Cliente> clientes = new HashSet<Cliente>(0);

    public Contato() {
    }

    public Contato(String nomeContato, String emailContato, String telefoneContato, String celularContato, Date criacaoContato, Date atualizacaoContato, Set<Fornecedor> fornecedors,  Set<Cliente> clientes) {
       this.nomeContato = nomeContato;
       this.emailContato = emailContato;
       this.telefoneContato = telefoneContato;
       this.celularContato = celularContato;
       this.criacaoContato = criacaoContato;
       this.atualizacaoContato = atualizacaoContato;
       this.fornecedors = fornecedors;
       this.clientes = clientes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idContato", unique=true, nullable=false)
    public Long getIdContato() {
        return this.idContato;
    }
    
    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    
    @Column(name="nomeContato", length=50)
    public String getNomeContato() {
        return this.nomeContato;
    }
    
    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    
    @Column(name="emailContato", length=30)
    public String getEmailContato() {
        return this.emailContato;
    }
    
    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    
    @Column(name="telefoneContato", length=20)
    public String getTelefoneContato() {
        return this.telefoneContato;
    }
    
    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    
    @Column(name="celularContato", length=20)
    public String getCelularContato() {
        return this.celularContato;
    }
    
    public void setCelularContato(String celularContato) {
        this.celularContato = celularContato;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoContato", length=19)
    public Date getCriacaoContato() {
        return this.criacaoContato;
    }
    
    public void setCriacaoContato(Date criacaoContato) {
        this.criacaoContato = criacaoContato;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaoContato", length=19)
    public Date getAtualizacaoContato() {
        return this.atualizacaoContato;
    }
    
    public void setAtualizacaoContato(Date atualizacaoContato) {
        this.atualizacaoContato = atualizacaoContato;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="contato")
    public Set<Fornecedor> getFornecedors() {
        return this.fornecedors;
    }
    
    public void setFornecedors(Set<Fornecedor> fornecedors) {
        this.fornecedors = fornecedors;
    }



    @OneToMany(fetch=FetchType.LAZY, mappedBy="contato")
    public Set<Cliente> getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }




}


