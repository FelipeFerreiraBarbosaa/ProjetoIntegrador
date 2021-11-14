package projetointegrador.negocio;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Itemvenda.class)
public abstract class Itemvenda_ {

	public static volatile SingularAttribute<Itemvenda, Venda> venda;
	public static volatile SingularAttribute<Itemvenda, Long> idItemVenda;
	public static volatile SingularAttribute<Itemvenda, Produto> produto;
	public static volatile SingularAttribute<Itemvenda, Date> criacaoItemVenda;
	public static volatile SingularAttribute<Itemvenda, Date> atualizacaoItemVenda;
	public static volatile SingularAttribute<Itemvenda, BigDecimal> valorItemVenda;
	public static volatile SingularAttribute<Itemvenda, Integer> quantidadeItemVenda;

}

