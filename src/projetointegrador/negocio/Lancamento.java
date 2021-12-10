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
@Table(name="lancamento")
public class Lancamento  implements java.io.Serializable {


     private Long idLancamento;
     private String tipoLancamento;
     private Date criacaoLancamento;
     private Date atualizacaLancamento;
     private Set<Pagamento> pagamentos = new HashSet<Pagamento>(0);
     private Set<Recebimento> recebimentos = new HashSet<Recebimento>(0);

    public Lancamento() {
    }

    public Lancamento(String tipoLancamento, Date criacaoLancamento, Date atualizacaLancamento, Set<Pagamento> pagamentos, Set<Recebimento> recebimentos) {
       this.tipoLancamento = tipoLancamento;
       this.criacaoLancamento = criacaoLancamento;
       this.atualizacaLancamento = atualizacaLancamento;
       this.pagamentos = pagamentos;
       this.recebimentos = recebimentos;

    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idLancamento", unique=true, nullable=false)
    public Long getIdLancamento() {
        return this.idLancamento;
    }
    
    public void setIdLancamento(Long idLancamento) {
        this.idLancamento = idLancamento;
    }

    
    @Column(name="tipoLancamento", length=50)
    public String getTipoLancamento() {
        return this.tipoLancamento;
    }
    
    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoLancamento", length=19)
    public Date getCriacaoLancamento() {
        return this.criacaoLancamento;
    }
    
    public void setCriacaoLancamento(Date criacaoLancamento) {
        this.criacaoLancamento = criacaoLancamento;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaLancamento", length=19)
    public Date getAtualizacaLancamento() {
        return this.atualizacaLancamento;
    }
    
    public void setAtualizacaLancamento(Date atualizacaLancamento) {
        this.atualizacaLancamento = atualizacaLancamento;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="lancamento")
    public Set<Pagamento> getPagamentos() {
        return this.pagamentos;
    }
    
    public void setPagamentos(Set<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="lancamento")
    public Set<Recebimento> getRecebimentos() {
        return this.recebimentos;
    }
    
    public void setRecebimentos(Set<Recebimento> recebimentos) {
        this.recebimentos = recebimentos;
    }

}


