package projetointegrador.negocio;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Categoria.class)
public abstract class Categoria_ {

	public static volatile SingularAttribute<Categoria, String> descricaoCategoria;
	public static volatile SetAttribute<Categoria, Produto> produtos;
	public static volatile SingularAttribute<Categoria, Long> idCategoria;
	public static volatile SingularAttribute<Categoria, Date> criacaoCategoria;
	public static volatile SingularAttribute<Categoria, Date> atualizacaoCategoria;

}

