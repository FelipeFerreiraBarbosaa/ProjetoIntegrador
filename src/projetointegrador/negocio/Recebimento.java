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
@Table(name="recebimento")
public class Recebimento  implements java.io.Serializable {


     private Long idRecebimento;
     private Lancamento lancamento;
     private Venda venda;
     private String descricaoRecebimento;
     private BigDecimal valorRecebimento;
     private Date dataRecebimento;
     private Boolean statusRecebimento;
     private Date criacaoRecebimento;
     private Date atualizacaoRecebimento;

    public Recebimento() {
    }

    public Recebimento(Lancamento lancamento, Venda venda, String descricaoRecebimento, BigDecimal valorRecebimento, Date dataRecebimento, Boolean statusRecebimento, Date criacaoRecebimento, Date atualizacaoRecebimento) {
       this.lancamento = lancamento;
       this.venda = venda;
       this.descricaoRecebimento = descricaoRecebimento;
       this.valorRecebimento = valorRecebimento;
       this.dataRecebimento = dataRecebimento;
       this.statusRecebimento = statusRecebimento;
       this.criacaoRecebimento = criacaoRecebimento;
       this.atualizacaoRecebimento = atualizacaoRecebimento;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idRecebimento", unique=true, nullable=false)
    public Long getIdRecebimento() {
        return this.idRecebimento;
    }
    
    public void setIdRecebimento(Long idRecebimento) {
        this.idRecebimento = idRecebimento;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="lancamentoRecebimento")
    public Lancamento getLancamento() {
        return this.lancamento;
    }
    
    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vendaRecebimento")
    public Venda getVenda() {
        return this.venda;
    }
    
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    
    @Column(name="descricaoRecebimento", length=50)
    public String getDescricaoRecebimento() {
        return this.descricaoRecebimento;
    }
    
    public void setDescricaoRecebimento(String descricaoRecebimento) {
        this.descricaoRecebimento = descricaoRecebimento;
    }

    
    @Column(name="valorRecebimento", precision=10)
    public BigDecimal getValorRecebimento() {
        return this.valorRecebimento;
    }
    
    public void setValorRecebimento(BigDecimal valorRecebimento) {
        this.valorRecebimento = valorRecebimento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dataRecebimento", length=10)
    public Date getDataRecebimento() {
        return this.dataRecebimento;
    }
    
    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    
    @Column(name="statusRecebimento")
    public Boolean getStatusRecebimento() {
        return this.statusRecebimento;
    }
    
    public void setStatusRecebimento(Boolean statusRecebimento) {
        this.statusRecebimento = statusRecebimento;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoRecebimento", length=19)
    public Date getCriacaoRecebimento() {
        return this.criacaoRecebimento;
    }
    
    public void setCriacaoRecebimento(Date criacaoRecebimento) {
        this.criacaoRecebimento = criacaoRecebimento;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaoRecebimento", length=19)
    public Date getAtualizacaoRecebimento() {
        return this.atualizacaoRecebimento;
    }
    
    public void setAtualizacaoRecebimento(Date atualizacaoRecebimento) {
        this.atualizacaoRecebimento = atualizacaoRecebimento;
    }




}

