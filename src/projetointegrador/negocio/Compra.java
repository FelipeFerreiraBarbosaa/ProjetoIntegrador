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
@Table(name="compra")
public class Compra  implements java.io.Serializable {


     private Long idCompra;
     private Fornecedor fornecedor;
     private BigDecimal valorCompra;
     private Integer parcelasCompra;
     private Date vencimentoCompra;
     private Date criacaoCompra;
     private Date atualizacaoCompra;
     private Set<Itemcompra> itemcompras = new HashSet<Itemcompra>(0);
     private Set<Pagamento> pagamentos = new HashSet<Pagamento>(0);

    public Compra() {
    }

    public Compra(Fornecedor fornecedor, BigDecimal valorCompra, Integer parcelasCompra, Date vencimentoCompra, Date criacaoCompra, Date atualizacaoCompra, Set<Itemcompra> itemcompras, Set<Pagamento> pagamentos) {
       this.fornecedor = fornecedor;
       this.valorCompra = valorCompra;
       this.parcelasCompra = parcelasCompra;
       this.vencimentoCompra = vencimentoCompra;
       this.criacaoCompra = criacaoCompra;
       this.atualizacaoCompra = atualizacaoCompra;
       this.itemcompras = itemcompras;
       this.pagamentos = pagamentos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCompra", unique=true, nullable=false)
    public Long getIdCompra() {
        return this.idCompra;
    }
    
    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fornecedorCompra")
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Column(name="valorCompra", precision=10)
    public BigDecimal getValorCompra() {
        return this.valorCompra;
    }
    
    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    
    @Column(name="parcelasCompra")
    public Integer getParcelasCompra() {
        return this.parcelasCompra;
    }
    
    public void setParcelasCompra(Integer parcelasCompra) {
        this.parcelasCompra = parcelasCompra;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="vencimentoCompra", length=10)
    public Date getVencimentoCompra() {
        return this.vencimentoCompra;
    }
    
    public void setVencimentoCompra(Date vencimentoCompra) {
        this.vencimentoCompra = vencimentoCompra;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoCompra", length=19)
    public Date getCriacaoCompra() {
        return this.criacaoCompra;
    }
    
    public void setCriacaoCompra(Date criacaoCompra) {
        this.criacaoCompra = criacaoCompra;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaoCompra", length=19)
    public Date getAtualizacaoCompra() {
        return this.atualizacaoCompra;
    }
    
    public void setAtualizacaoCompra(Date atualizacaoCompra) {
        this.atualizacaoCompra = atualizacaoCompra;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="compra")
    public Set<Itemcompra> getItemcompras() {
        return this.itemcompras;
    }
    
    public void setItemcompras(Set<Itemcompra> itemcompras) {
        this.itemcompras = itemcompras;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="compra")
    public Set<Pagamento> getPagamentos() {
        return this.pagamentos;
    }
    
    public void setPagamentos(Set<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }




}


