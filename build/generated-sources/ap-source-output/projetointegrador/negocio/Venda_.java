package projetointegrador.negocio;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Venda.class)
public abstract class Venda_ {

	public static volatile SingularAttribute<Venda, Cliente> cliente;
	public static volatile SetAttribute<Venda, Itemvenda> itemvendas;
	public static volatile SingularAttribute<Venda, Integer> parcelasVenda;
	public static volatile SingularAttribute<Venda, BigDecimal> valorVenda;
	public static volatile SingularAttribute<Venda, Date> atualizacaoVenda;
	public static volatile SingularAttribute<Venda, Date> criacaoVenda;
	public static volatile SingularAttribute<Venda, Long> idVenda;
	public static volatile SingularAttribute<Venda, Date> vencimentoVenda;
	public static volatile SetAttribute<Venda, Recebimento> recebimentos;

}

