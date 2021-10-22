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
@Table(name="venda")
public class Venda  implements java.io.Serializable {


     private Long idVenda;
     private Cliente cliente;
     private BigDecimal valorVenda;
     private Integer parcelasVenda;
     private Date vencimentoVenda;
     private Date criacaoVenda;
     private Date atualizacaoVenda;
     private Set<Itemvenda> itemvendas = new HashSet<Itemvenda>(0);
     private Set<Recebimento> recebimentos = new HashSet<Recebimento>(0);

    public Venda() {
    }

    public Venda(Cliente cliente, BigDecimal valorVenda, Integer parcelasVenda, Date vencimentoVenda, Date criacaoVenda, Date atualizacaoVenda, Set<Itemvenda> itemvendas, Set<Recebimento> recebimentos) {
       this.cliente = cliente;
       this.valorVenda = valorVenda;
       this.parcelasVenda = parcelasVenda;
       this.vencimentoVenda = vencimentoVenda;
       this.criacaoVenda = criacaoVenda;
       this.atualizacaoVenda = atualizacaoVenda;
       this.itemvendas = itemvendas;
       this.recebimentos = recebimentos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idVenda", unique=true, nullable=false)
    public Long getIdVenda() {
        return this.idVenda;
    }
    
    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="clienteVenda")
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    
    @Column(name="valorVenda", precision=10)
    public BigDecimal getValorVenda() {
        return this.valorVenda;
    }
    
    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    
    @Column(name="parcelasVenda")
    public Integer getParcelasVenda() {
        return this.parcelasVenda;
    }
    
    public void setParcelasVenda(Integer parcelasVenda) {
        this.parcelasVenda = parcelasVenda;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="vencimentoVenda", length=10)
    public Date getVencimentoVenda() {
        return this.vencimentoVenda;
    }
    
    public void setVencimentoVenda(Date vencimentoVenda) {
        this.vencimentoVenda = vencimentoVenda;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoVenda", length=19)
    public Date getCriacaoVenda() {
        return this.criacaoVenda;
    }
    
    public void setCriacaoVenda(Date criacaoVenda) {
        this.criacaoVenda = criacaoVenda;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaoVenda", length=19)
    public Date getAtualizacaoVenda() {
        return this.atualizacaoVenda;
    }
    
    public void setAtualizacaoVenda(Date atualizacaoVenda) {
        this.atualizacaoVenda = atualizacaoVenda;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="venda")
    public Set<Itemvenda> getItemvendas() {
        return this.itemvendas;
    }
    
    public void setItemvendas(Set<Itemvenda> itemvendas) {
        this.itemvendas = itemvendas;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="venda")
    public Set<Recebimento> getRecebimentos() {
        return this.recebimentos;
    }
    
    public void setRecebimentos(Set<Recebimento> recebimentos) {
        this.recebimentos = recebimentos;
    }




}


