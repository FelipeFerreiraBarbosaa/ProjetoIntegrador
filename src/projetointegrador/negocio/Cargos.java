
package projetointegrador.negocio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cargos")

public class Cargos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_id")
    private int cargo_id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "descricao")
    private String desc;
    
    @Column(name = "nivelPerm")
    private int nivelPerm;

    public Cargos(String nome, String desc, int nivelPerm) {
        this.nome = nome;
        this.desc = desc;
        this.nivelPerm = nivelPerm;
    }

    public Cargos() {
        
    }
    
    
    public int getId() {
        return cargo_id;
    }

    public void setId(int id) {
        this.cargo_id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNivelPerm() {
        return nivelPerm;
    }

    public void setNivelPerm(int nivelPerm) {
        this.nivelPerm = nivelPerm;
    }
    
    @Override
        public String toString() {
            return getNome();
        }  
    
    
    
}
