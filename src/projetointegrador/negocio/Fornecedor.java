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
@Table(name="fornecedor")
public class Fornecedor  implements java.io.Serializable {


     private Long idFornecedor;
     private Contato contato;
     private Endereco endereco;
     private String nomeFornecedor;
     private Date criacaoFornecedor;
     private Date atualizacaoFornecedor;
     private String CNPJ;
     private Set<Compra> compras = new HashSet<Compra>(0);
     private Set<Produto> produtos = new HashSet<Produto>(0);

    public Fornecedor() {
    }

    public Fornecedor(Contato contato, Endereco endereco, String nomeFornecedor, Date criacaoFornecedor, Date atualizacaoFornecedor, Set<Compra> compras, Set<Produto> produtos, String cnpj) {
       this.contato = contato;
       this.endereco = endereco;
       this.nomeFornecedor = nomeFornecedor;
       this.criacaoFornecedor = criacaoFornecedor;
       this.atualizacaoFornecedor = atualizacaoFornecedor;
       this.compras = compras;
       this.produtos = produtos;
       this.CNPJ = cnpj;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idFornecedor", unique=true, nullable=false)
    public Long getIdFornecedor() {
        return this.idFornecedor;
    }
    
    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="contatoFornecedor")
    public Contato getContato() {
        return this.contato;
    }
    
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="enderecoFornecedor")
    public Endereco getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Column(name="nomeFornecedor", length=50)
    public String getNomeFornecedor() {
        return this.nomeFornecedor;
    }
    
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoFornecedor", length=19)
    public Date getCriacaoFornecedor() {
        return this.criacaoFornecedor;
    }
    
    public void setCriacaoFornecedor(Date criacaoFornecedor) {
        this.criacaoFornecedor = criacaoFornecedor;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaoFornecedor", length=19)
    public Date getAtualizacaoFornecedor() {
        return this.atualizacaoFornecedor;
    }
    
    public void setAtualizacaoFornecedor(Date atualizacaoFornecedor) {
        this.atualizacaoFornecedor = atualizacaoFornecedor;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="fornecedor")
    public Set<Compra> getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="fornecedor")
    public Set<Produto> getProdutos() {
        return this.produtos;
    }
    
    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
    @Column(name="cnpj", length=50)
    public String getCnpjFornecedor() {
        return this.CNPJ;
    }
     public void setCnpjFornecedor(String cnpj) {
        this.CNPJ = cnpj;
    }




}


