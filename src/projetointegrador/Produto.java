package projetointegrador;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")

public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "Nome")
    private String Nome;
    
    @Column(name = "pCusto")
    private Double pCusto;
    
    @Column(name = "pVenda")
    private Double pVenda;
    
    @Column(name = "quantidade")
    private int quantidade;
    
    @Column(name = "descricao")
    private String descricao;

    public Produto() {
        this.id = 0;
        this.Nome = "";
        this.pCusto = 0.0;
        this.pVenda = 0.0;
        this.quantidade = 0;
        this.descricao = "";
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Nome;
    }

    public void setName(String name) {
        this.Nome = name;
    }

    public Double getpCusto() {
        return pCusto;
    }

    public void setpCusto(Double preCusto) {
        this.pCusto = preCusto;
    }

    public Double getpVenda() {
        return pVenda;
    }

    public void setpVenda(Double preVenda) {
        this.pVenda = preVenda;
    }
}
