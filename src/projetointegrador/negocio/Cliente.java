package projetointegrador.negocio;
// Generated 25/06/2015 16:48:08 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe
 */

@Entity
@Table(name="cliente")

public class Cliente  implements java.io.Serializable {


     private Long idCliente;
     private Contato contato;
     private Endereco endereco;
     private String nomeCliente;
     private String cpf;
     private BigDecimal limiteCliente;
     private BigDecimal descontoCliente;
     private Date criacaoCliente;
     private Date atualizacaoCliente;
     private Set<Venda> vendas = new HashSet<Venda>(0);

    public Cliente() {
    }

    public Cliente(Contato contato, Endereco endereco, String nomeCliente, BigDecimal salarioCliente, BigDecimal limiteCliente, BigDecimal descontoCliente, Date criacaoCliente, Date atualizacaoCliente, Set<Venda> vendas) {
       this.contato = contato;
       this.endereco = endereco;
       this.nomeCliente = nomeCliente;
       this.limiteCliente = limiteCliente;
       this.descontoCliente = descontoCliente;
       this.criacaoCliente = criacaoCliente;
       this.atualizacaoCliente = atualizacaoCliente;
       this.vendas = vendas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCliente", unique=true, nullable=false)
    public Long getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="contatoCliente")
    public Contato getContato() {
        return this.contato;
    }
    
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="enderecoCliente")
    public Endereco getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    @Column(name="nomeCliente", length=50)
    public String getNomeCliente() {
        return this.nomeCliente;
    }
    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Column(name="limiteCliente", precision=10)
    public BigDecimal getLimiteCliente() {
        return this.limiteCliente;
    }
    
    public void setLimiteCliente(BigDecimal limiteCliente) {
        this.limiteCliente = limiteCliente;
    }

    
    @Column(name="descontoCliente", precision=10)
    public BigDecimal getDescontoCliente() {
        return this.descontoCliente;
    }
    
    public void setDescontoCliente(BigDecimal descontoCliente) {
        this.descontoCliente = descontoCliente;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoCliente", length=19)
    public Date getCriacaoCliente() {
        return this.criacaoCliente;
    }
    
    public void setCriacaoCliente(Date criacaoCliente) {
        this.criacaoCliente = criacaoCliente;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaoCliente", length=19)
    public Date getAtualizacaoCliente() {
        return this.atualizacaoCliente;
    }
    
    public void setAtualizacaoCliente(Date atualizacaoCliente) {
        this.atualizacaoCliente = atualizacaoCliente;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<Venda> getVendas() {
        return this.vendas;
    }
    
    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }
    @Column(name="Cpf", length=50)
    public String getCpfCliente() {
        return this.cpf;
    }
    
    public void setCpfCliente(String cpf) {
        this.cpf = cpf;
    }




}


