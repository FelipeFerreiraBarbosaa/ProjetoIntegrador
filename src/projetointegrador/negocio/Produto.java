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
@Table(name="produto")
public class Produto  implements java.io.Serializable {


     private Long idProduto;
     private Categoria categoria;
     private Fornecedor fornecedor;
     private String descricaoProduto;
     private String codigoProduto;
     private BigDecimal custoProduto;
     private BigDecimal vendaProduto;
     private Long minimoProduto;
     private Long maximoProduto;
     private Long estoqueProduto;
     private Date criacaoProduto;
     private Date atualizacaoProduto;
     private Set<Itemcompra> itemcompras = new HashSet<Itemcompra>(0);
     private Set<Itemvenda> itemvendas = new HashSet<Itemvenda>(0);

    public Produto() {
    }

    public Produto(Categoria categoria, Fornecedor fornecedor, String descricaoProduto, String codigoProduto, BigDecimal custoProduto, BigDecimal vendaProduto, Long minimoProduto, Long maximoProduto, Long estoqueProduto, Date criacaoProduto, Date atualizacaoProduto, Set<Itemcompra> itemcompras, Set<Itemvenda> itemvendas) {
       this.categoria = categoria;
       this.fornecedor = fornecedor;
       this.descricaoProduto = descricaoProduto;
       this.codigoProduto = codigoProduto;
       this.custoProduto = custoProduto;
       this.vendaProduto = vendaProduto;
       this.minimoProduto = minimoProduto;
       this.maximoProduto = maximoProduto;
       this.estoqueProduto = estoqueProduto;
       this.criacaoProduto = criacaoProduto;
       this.atualizacaoProduto = atualizacaoProduto;
       this.itemcompras = itemcompras;
       this.itemvendas = itemvendas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idProduto", unique=true, nullable=false)
    public Long getIdProduto() {
        return this.idProduto;
    }
    
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoriaProduto")
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fornecedorProduto")
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    
    @Column(name="descricaoProduto", length=50)
    public String getDescricaoProduto() {
        return this.descricaoProduto;
    }
    
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    
    @Column(name="codigoProduto", length=20)
    public String getCodigoProduto() {
        return this.codigoProduto;
    }
    
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    
    @Column(name="custoProduto", precision=10)
    public BigDecimal getCustoProduto() {
        return this.custoProduto;
    }
    
    public void setCustoProduto(BigDecimal custoProduto) {
        this.custoProduto = custoProduto;
    }

    
    @Column(name="vendaProduto", precision=10)
    public BigDecimal getVendaProduto() {
        return this.vendaProduto;
    }
    
    public void setVendaProduto(BigDecimal vendaProduto) {
        this.vendaProduto = vendaProduto;
    }

    
    @Column(name="minimoProduto")
    public Long getMinimoProduto() {
        return this.minimoProduto;
    }
    
    public void setMinimoProduto(Long minimoProduto) {
        this.minimoProduto = minimoProduto;
    }

    
    @Column(name="maximoProduto")
    public Long getMaximoProduto() {
        return this.maximoProduto;
    }
    
    public void setMaximoProduto(Long maximoProduto) {
        this.maximoProduto = maximoProduto;
    }

    
    @Column(name="estoqueProduto")
    public Long getEstoqueProduto() {
        return this.estoqueProduto;
    }
    
    public void setEstoqueProduto(Long estoqueProduto) {
        this.estoqueProduto = estoqueProduto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoProduto", length=19)
    public Date getCriacaoProduto() {
        return this.criacaoProduto;
    }
    
    public void setCriacaoProduto(Date criacaoProduto) {
        this.criacaoProduto = criacaoProduto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaoProduto", length=19)
    public Date getAtualizacaoProduto() {
        return this.atualizacaoProduto;
    }
    
    public void setAtualizacaoProduto(Date atualizacaoProduto) {
        this.atualizacaoProduto = atualizacaoProduto;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="produto")
    public Set<Itemcompra> getItemcompras() {
        return this.itemcompras;
    }
    
    public void setItemcompras(Set<Itemcompra> itemcompras) {
        this.itemcompras = itemcompras;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="produto")
    public Set<Itemvenda> getItemvendas() {
        return this.itemvendas;
    }
    
    public void setItemvendas(Set<Itemvenda> itemvendas) {
        this.itemvendas = itemvendas;
    }




}


