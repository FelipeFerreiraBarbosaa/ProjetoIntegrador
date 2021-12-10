package projetointegrador.negocio;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Itemcompra.class)
public abstract class Itemcompra_ {

	public static volatile SingularAttribute<Itemcompra, Compra> compra;
	public static volatile SingularAttribute<Itemcompra, BigDecimal> valorItemCompra;
	public static volatile SingularAttribute<Itemcompra, Integer> quantidadeItemCompra;
	public static volatile SingularAttribute<Itemcompra, Long> idItemCompra;
	public static volatile SingularAttribute<Itemcompra, Produto> produto;
	public static volatile SingularAttribute<Itemcompra, Date> criacaoItemCompra;
	public static volatile SingularAttribute<Itemcompra, Date> atualizacaoItemCompra;

}

