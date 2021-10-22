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
@Table(name="categoria")
public class Categoria  implements java.io.Serializable {


     private Long idCategoria;
     private String descricaoCategoria;
     private Date criacaoCategoria;
     private Date atualizacaoCategoria;
     private Set<Produto> produtos = new HashSet<Produto>(0);

    public Categoria() {
    }

    public Categoria(String descricaoCategoria, Date criacaoCategoria, Date atualizacaoCategoria, Set<Produto> produtos) {
       this.descricaoCategoria = descricaoCategoria;
       this.criacaoCategoria = criacaoCategoria;
       this.atualizacaoCategoria = atualizacaoCategoria;
       this.produtos = produtos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idCategoria", unique=true, nullable=false)
    public Long getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    
    @Column(name="descricaoCategoria", length=50)
    public String getDescricaoCategoria() {
        return this.descricaoCategoria;
    }
    
    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="criacaoCategoria", length=19)
    public Date getCriacaoCategoria() {
        return this.criacaoCategoria;
    }
    
    public void setCriacaoCategoria(Date criacaoCategoria) {
        this.criacaoCategoria = criacaoCategoria;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="atualizacaoCategoria", length=19)
    public Date getAtualizacaoCategoria() {
        return this.atualizacaoCategoria;
    }
    
    public void setAtualizacaoCategoria(Date atualizacaoCategoria) {
        this.atualizacaoCategoria = atualizacaoCategoria;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="categoria")
    public Set<Produto> getProdutos() {
        return this.produtos;
    }
    
    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }




}


