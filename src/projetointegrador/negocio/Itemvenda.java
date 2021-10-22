package projetointegrador.negocio;
// Generated 25/06/2015 16:48:08 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe
 */

@Entity
@Table(name="itemvenda")
public class Itemvenda  implements java.io.Serializable {


     private Long idItemVenda;
     private Produto produto;
     private Venda venda;
     private Integer quantidadeItemVenda;
     private BigDecimal valorItemVenda;
     private Date criacaoItemVenda;
     private Date atualizacaoItemVenda;

    public Itemvenda() {
    }

    public Itemvenda(Produto produto, Venda venda, Integer quantidadeItemVenda, BigDecimal valorItemVenda, Date criacaoItemVenda, Date atualizacaoItemVenda) {
       this.produto = produto;
       this.venda = venda;
       this.quantidadeItemVenda = quantidadeItemVenda;
       this.valorItemVenda = valorItemVenda;
       this.criacaoItemVenda = criacaoItemVenda;
       this.atualizacaoItemVenda = atualizacaoItemVenda;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idItemVenda", unique=true, nullable=false)
    public Long getIdItemVenda() {
        return this.idItemVenda;
    }
    
    public void setIdItemVenda(Long idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="produtoItemVenda")
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vendaItemVenda")
    public Venda getVenda() {
        return this.venda;
    }
    
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    
    @Column(name="quantidadeItemVenda")
    public Integer getQuantidadeItemVenda() {
        return this.quantidadeItemVenda;
    }
    
    public void setQuantidadeItemVenda(Integer quantidadeItemVenda) {
        this.quantidadeItemVenda = quantidadeItemVenda;
    }

    
    @Column(name="valorItemVenda", precision=10)
    public BigDecimal getValorItemVenda() {
        return this.valorItemVenda;
    }
    
    public void setValorItemVenda(BigDecimal valorItemVenda) {
        this.valorItemVenda = valorItemVenda;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoItemVenda", length=19)
    public Date getCriacaoItemVenda() {
        return this.criacaoItemVenda;
    }
    
    public void setCriacaoItemVenda(Date criacaoItemVenda) {
        this.criacaoItemVenda = criacaoItemVenda;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaoItemVenda", length=19)
    public Date getAtualizacaoItemVenda() {
        return this.atualizacaoItemVenda;
    }
    
    public void setAtualizacaoItemVenda(Date atualizacaoItemVenda) {
        this.atualizacaoItemVenda = atualizacaoItemVenda;
    }




}


