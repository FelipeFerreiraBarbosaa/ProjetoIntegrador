
package projetointegrador.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")

public class Cargos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
}
