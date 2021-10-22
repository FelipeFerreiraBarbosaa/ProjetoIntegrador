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
@Table(name="itemcompra")
public class Itemcompra  implements java.io.Serializable {


     private Long idItemCompra;
     private Compra compra;
     private Produto produto;
     private Integer quantidadeItemCompra;
     private BigDecimal valorItemCompra;
     private Date criacaoItemCompra;
     private Date atualizacaoItemCompra;

    public Itemcompra() {
    }

    public Itemcompra(Compra compra, Produto produto, Integer quantidadeItemCompra, BigDecimal valorItemCompra, Date criacaoItemCompra, Date atualizacaoItemCompra) {
       this.compra = compra;
       this.produto = produto;
       this.quantidadeItemCompra = quantidadeItemCompra;
       this.valorItemCompra = valorItemCompra;
       this.criacaoItemCompra = criacaoItemCompra;
       this.atualizacaoItemCompra = atualizacaoItemCompra;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idItemCompra", unique=true, nullable=false)
    public Long getIdItemCompra() {
        return this.idItemCompra;
    }
    
    public void setIdItemCompra(Long idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="compraItemCompra")
    public Compra getCompra() {
        return this.compra;
    }
    
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="produtoItemCompra")
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    @Column(name="quantidadeItemCompra")
    public Integer getQuantidadeItemCompra() {
        return this.quantidadeItemCompra;
    }
    
    public void setQuantidadeItemCompra(Integer quantidadeItemCompra) {
        this.quantidadeItemCompra = quantidadeItemCompra;
    }

    
    @Column(name="valorItemCompra", precision=10)
    public BigDecimal getValorItemCompra() {
        return this.valorItemCompra;
    }
    
    public void setValorItemCompra(BigDecimal valorItemCompra) {
        this.valorItemCompra = valorItemCompra;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoItemCompra", length=19)
    public Date getCriacaoItemCompra() {
        return this.criacaoItemCompra;
    }
    
    public void setCriacaoItemCompra(Date criacaoItemCompra) {
        this.criacaoItemCompra = criacaoItemCompra;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaoItemCompra", length=19)
    public Date getAtualizacaoItemCompra() {
        return this.atualizacaoItemCompra;
    }
    
    public void setAtualizacaoItemCompra(Date atualizacaoItemCompra) {
        this.atualizacaoItemCompra = atualizacaoItemCompra;
    }




}


